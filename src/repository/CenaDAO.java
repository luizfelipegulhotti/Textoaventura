package repository;

import model.Cena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Data Access Object
public class CenaDAO {


    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cenas WHERE id_cenas = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()) {
            cena.setId_cenas(
                    rs.getInt("id_cenas")
            );
            cena.setDescricaoCenas(rs.getString("descricaoCenas"));
        }
        return cena;
    }
    public static Cena findNextCenaById(Integer getCena_Atual) throws SQLException {
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cenas WHERE id_cenas = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, getCena_Atual);
        ResultSet rs = stmt.executeQuery();
        Cena cena = new Cena();

        if (rs.next()) {
            cena.setId_cenas(
                    rs.getInt("id_cenas")
            );
            cena.setDescricaoCenas(rs.getString("descricaoCenas"));
        }
        return cena;
    }

    public static void insertCena(Cena cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cenas(descricaoCenas) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, cena.getDescricaoCenas());
        ps.execute();
    }

    public static List<Cena> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cenas;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cena> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cena cena = new Cena();
            cena.setId_cenas(resultSet.getInt("id_cenas"));
            cena.setDescricaoCenas(resultSet.getString("descricaoCenas"));

            cenas.add(cena);
        }
        return cenas;
    }

}
