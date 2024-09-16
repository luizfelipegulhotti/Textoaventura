package repository;

import model.Save;

import java.sql.*;

public class SaveDAO {
    public static Save novoJogo(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO save(cenaAtual) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();
        if(generatedKeys.next()){
            save.setId_save(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(1));
            save.setInventarioAtual(novoJogo(1).getInventarioAtual());
        }
        return save;
    }
}

