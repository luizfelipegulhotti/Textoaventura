import model.Cena;
import model.Inventariosave;
import model.Item;
import repository.CenaDAO;
import repository.InventariosaveDAO;
import repository.ItemDAO;
import repository.Mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public static void main(String[] args) {
    CenaDAO CenaDAO = new CenaDAO();
    InventariosaveDAO InventariosaveDAO = new InventariosaveDAO();
    ItemDAO ItemDAO = new ItemDAO();


    try {
        Cena cena = CenaDAO.findCenaById(1);
        System.out.println(cena.toString());

        List<Item> itens = ItemDAO.findItensByScene(cena);
        System.out.println("Itens: " + itens);


        Scanner sc = new Scanner(System.in);
        boolean jogoAtivo = true;

        String escolha = null;
        if (jogoAtivo == true) {
            String[] comandos = {"HELP", "SAVE", "CHECK", "GET"};


            while (jogoAtivo) {
                System.out.println("Digite um comando");
                escolha = sc.nextLine();

                String transformada = escolha.toUpperCase();
                String[] CortandoFrase = transformada.split(" ");


                if (CortandoFrase.length > 1) {
                    String indice = CortandoFrase[1];
                    if (CortandoFrase[0].equals("GET")) {
                        repository.InventariosaveDAO.GuardarItem(validacao(indice).getId_itens(), validacao(indice).getCena_Atual());
                    } else if (CortandoFrase[0].equals("USE")) {
                            Integer idProximaCena = proxima_Cena(indice, cena.getId_cenas());

                            if (idProximaCena != null) {
                                Cena proximaCena = repository.CenaDAO.findCenaById(idProximaCena);
                                System.out.println(proximaCena.toString());

                                cena = proximaCena;
                            } else {
                                System.out.println("O item não pode ser usado nesta cena.");
                            }
                        } else if (CortandoFrase[0].equals("CHECK")) {
                        System.out.println(repository.ItemDAO.CHECK(indice));
                    }else {
                        System.out.println("Comando Invalido");
                    }
                    } if(CortandoFrase.length == 1) {
                    if (CortandoFrase[0].equals("LOAD"))   {
                        System.out.println("Escolha o seu save, e digite: 'NUMERO-DO-SAVE'");
                        System.out.println(repository.InventariosaveDAO.loadSaveIds());
                        int Ns = sc.nextInt();
                        repository.InventariosaveDAO.Load(Ns);
                        System.out.println(repository.CenaDAO.findCenaById(repository.InventariosaveDAO.Load(Ns)));
                    } else if (CortandoFrase[0].equals("HELP")) {
                        System.out.println("Os comandos disponiveis são: 'USE NOME-DO-ITEM', 'LOAD', 'GET NOME-DO-ITEM','CHECK','INVENTARIO");
                    } else if (CortandoFrase[0].equals("INVENTARIO")) {
                        System.out.println(repository.InventariosaveDAO.quantosItensTem());
                    } else if (CortandoFrase[0].equals("RESTART")) {
                        resetInventario();
                        System.out.println(repository.CenaDAO.findNextCenaById(1));
                    }else {
                            System.out.println("Comando Invalido");
                        }
                    }
                }
            }
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }

//String IndiceItem = C

public static Item validacao(String indice) throws SQLException {
    Connection conn = Mysql.getConnection();
    String sql = "select * from itens i where nome like ?;";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, "%" + indice + "%");
    ResultSet rs = stmt.executeQuery();
    Item itensId = new Item();
    if (rs.next()) {
        itensId.setId_itens(rs.getInt("id_itens"));
        itensId.setCena_Atual(rs.getInt("cena_Atual"));
    }
    return itensId;
}

public static Integer proxima_Cena(String nomeItem, int idCenaAtual) throws SQLException {
    Connection conn = Mysql.getConnection();
    String sql = "SELECT proxima_Cena FROM itens WHERE nome = ? AND cena_Atual = ?;";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, nomeItem);
    stmt.setInt(2, idCenaAtual);
    ResultSet rs = stmt.executeQuery();

    if (rs.next()) {
        return rs.getInt("proxima_Cena");  // Retorna o ID da próxima cena
    } else {
        System.out.println("Item não encontrado na cena atual.");
        return null;  // Retorna null se o item não estiver na cena
    }
}
public static void resetInventario() throws SQLException {
    Connection conn = Mysql.getConnection();

    String deleteSql = "DELETE FROM inventariosave;";
    PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
    deleteStmt.executeUpdate();


    System.out.println("Jogo resetado. Todos os itens foram removidos do inventário e o progresso foi reiniciado.");
}

//
//public static Item puxandoCenas
////            sql = "select * itens where noem like "