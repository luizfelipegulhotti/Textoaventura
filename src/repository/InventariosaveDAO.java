package repository;

import model.Inventariosave;

import java.awt.*;
import java.sql.*;
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
    public static void Load(int getId_itens) throws SQLException {
        Connection conn = Mysql.getConnection();
        // Verifica se o item já está no inventário
        String sql = "SELECT id_cena_atual FROM inventariosave;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, getId_itens);
        ResultSet rs = stmt.executeQuery();
        System.out.println("Qual jogo deseja carregar?");

    }


}

