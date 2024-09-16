package repository;

import model.Inventariosave;

import java.sql.*;

public class InventarioDAO {
    public static Inventariosave inventario() throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO inventariosave(id_itens) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Inventariosave inventario = new Inventariosave();
        if(generatedKeys.next()){
            inventario.setId_inventory(generatedKeys.getInt(1));
            inventario.setId_itens(InventarioDAO.inventario().getId_itens());
        }
        return inventario();
    }
}
