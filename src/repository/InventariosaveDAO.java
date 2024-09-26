package repository;

import model.Inventariosave;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class InventariosaveDAO {
    Scanner sc = new Scanner(System.in);
    public static Inventariosave novoJogo() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO inventariosave(id_cena_atual) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Inventariosave save = new Inventariosave();
        if(generatedKeys.next()){
            save.setId_inventory(generatedKeys.getInt(1));
            save.setId_cena_atual(CenaDAO.findCenaById(1));
        }
        return save;
    }
    public static void GuardarItem(int id_itens, int id_cena_atual) throws SQLException {
        Connection conn = Mysql.getConnection();

        // Verifica se o item já está no inventário
        String sql = "SELECT id_itens FROM inventariosave WHERE id_itens = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id_itens);
        ResultSet rs = stmt.executeQuery();

        // Se o item já está no inventário, não o insere novamente
        if (rs.next()) {
            System.out.println("Item já está no inventário.");
        } else {
            // Insere o item no inventário
            String sql2 = "INSERT INTO inventariosave(id_itens, id_cena_atual) VALUES (?, ?)";
            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setInt(1, id_itens);
            stmt2.setInt(2, id_cena_atual);
            stmt2.executeUpdate();
            System.out.println("Item guardado com sucesso.");
        }
    }
    public static int Load(int Ns) throws SQLException {
        Connection conn = Mysql.getConnection();
        // Verifica se o item já está no inventário
        String sql = "select * from inventariosave i where id_cena_atual = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Ns);
        ResultSet rs = stmt.executeQuery();
        int carregarSave = 0;
        if(rs.next()) {
           carregarSave = rs.getInt("id_cena_atual");
        }
        return carregarSave;
    }

    public static List<Integer> loadSaveIds() throws SQLException {
        Connection conn = Mysql.getConnection();
        List<Integer> saveIds = new ArrayList<>();

        try {
            // Consulta SQL para obter os IDs dos saves
            String sql = "SELECT id_cena_atual FROM inventariosave;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            // Adiciona cada ID encontrado na lista
            while (rs.next()) {
                int idSave = rs.getInt("id_cena_atual");
                saveIds.add(idSave);
            }
        } catch (SQLException e) {
            // Exibe mensagem de erro para depuração
            System.out.println("Erro ao carregar IDs dos saves: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Fecha a conexão para evitar vazamentos de recursos
            if (conn != null) {
                conn.close();
            }
        }

        return saveIds; // Retorna a lista de IDs dos saves
    }
    public static List<String> quantosItensTem() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT DISTINCT i.nome " +
                "FROM inventariosave isv " +
                "INNER JOIN itens i ON isv.id_itens = i.id_itens;";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<String> nomesItens = new ArrayList<>();

        while (rs.next()) {
            String nomeItem = rs.getString("nome");
            nomesItens.add(nomeItem);
        }

        return nomesItens;
    }
}



