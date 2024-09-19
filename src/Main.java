import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection conn;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/facul", "root", ""); // Substitua com suas credenciais
            int cenaAtual = carregarJogo();

            while (true) {
                exibirCena(cenaAtual);
                System.out.println("Digite um comando (ou HELP para ajuda):");
                String comando = scanner.nextLine().toUpperCase();

                if (comando.equals("HELP")) {
                    exibirAjuda();
                    continue;  // Volta ao loop após exibir ajuda
                }

                int proximaCena = processarComando(comando, cenaAtual);

                if (proximaCena == -1) {
                    System.out.println("Game Over! Deseja recomeçar? (S/N)");
                    String resposta = scanner.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        cenaAtual = 1;
                        limparInventario();
                    } else {
                        break;
                    }
                } else if (proximaCena == 0) {
                    System.out.println("Jogo salvo e saindo.");
                    break;
                } else {
                    cenaAtual = proximaCena;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static int carregarJogo() throws SQLException {
        System.out.println("Deseja carregar o jogo salvo? (S/N)");
        String resposta = scanner.nextLine();
        if (resposta.equalsIgnoreCase("S")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT cenaAtual FROM save ORDER BY id_save DESC LIMIT 1");
            if (rs.next()) {
                return rs.getInt("cenaAtual");
            }
        }
        return 1; // Começa do início se não houver save
    }

    private static void exibirCena(int idCena) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT nomeTitulo, descricaoCenas FROM cenas WHERE id_cenas = ?");
        stmt.setInt(1, idCena);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println(rs.getString("nomeTitulo"));
            System.out.println(rs.getString("descricaoCenas"));
        }
        exibirInventario();
    }

    private static int processarComando(String comando, int cenaAtual) throws SQLException {
        if (comando.startsWith("GET")) {
            return pegarItem(comando.substring(4).trim(), cenaAtual);
        } else if (comando.startsWith("USE")) {
            return usarItem(comando, cenaAtual);
        } else if (comando.equals("SAVE")) {
            salvarJogo(cenaAtual);
            return 0; // Retorna 0 para indicar que o jogo foi salvo
        } else {
            System.out.println("Comando inválido.");
            return cenaAtual;
        }
    }

    private static int pegarItem(String itemNome, int cenaAtual) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM itens WHERE nome = ? AND cena_Atual = ?");
        stmt.setString(1, itemNome);
        stmt.setInt(2, cenaAtual);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("Você pegou: " + rs.getString("nome"));
            salvarInventario(rs.getInt("id_itens"));
            return cenaAtual; // Fica na mesma cena após pegar o item
        } else {
            System.out.println("Esse item não está disponível aqui.");
            return cenaAtual;
        }
    }

    private static int usarItem(String comando, int cenaAtual) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM itens WHERE comando_correto = ? AND cena_Atual = ?");
        stmt.setString(1, comando);
        stmt.setInt(2, cenaAtual);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println(rs.getString("descricao_Positiva"));
            int proximaCena = rs.getInt("proxima_Cena");

            if (proximaCena == 7) { // Se a próxima cena for 7, que é Game Over
                System.out.println("Game Over!");
                return -1; // Retorna -1 para indicar Game Over
            }

            salvarJogo(cenaAtual); // Salva o progresso automaticamente
            return proximaCena;
        } else {
            System.out.println("Comando incorreto ou você morreu.");
            return -1; // Cena de game over
        }
    }

    private static void salvarInventario(int idItem) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO inventarioSave (id_itens) VALUES (?)");
        stmt.setInt(1, idItem);
        stmt.executeUpdate();
        System.out.println("Item salvo no inventário.");
    }

    private static void exibirInventario() throws SQLException {
        System.out.println("Inventário Atual:");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(
                "SELECT i.nome FROM itens i INNER JOIN inventarioSave iv ON i.id_itens = iv.id_itens");
        while (rs.next()) {
            System.out.println("- " + rs.getString("nome"));
        }
    }

    private static void salvarJogo(int cenaAtual) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO save (cenaAtual, inventarioAtual) VALUES (?, ?)");
        stmt.setInt(1, cenaAtual);
        stmt.setInt(2, recuperarUltimoInventario());
        stmt.executeUpdate();
        System.out.println("Jogo salvo.");
    }

    private static int recuperarUltimoInventario() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id_inventory FROM inventarioSave ORDER BY id_inventory DESC LIMIT 1");
        if (rs.next()) {
            return rs.getInt("id_inventory");
        }
        return 0; // Retorna 0 se não houver itens
    }

    private static void limparInventario() throws SQLException {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM inventarioSave");
        System.out.println("Inventário limpo.");
    }

    private static void exibirAjuda() {
        System.out.println("==== AJUDA ====");
        System.out.println("Comandos disponíveis:");
        System.out.println("- GET <NOME_DO_ITEM>: Pega um item disponível na cena atual.");
        System.out.println("- USE <NOME_DO_ITEM>: Usa um item disponível na cena atual.");
        System.out.println("- SAVE: Salva o progresso do jogo (cena atual e itens no inventário).");
        System.out.println("- HELP: Exibe esta mensagem de ajuda.");
        System.out.println("- Para continuar, use os comandos corretamente de acordo com o cenário descrito.");
    }
}
