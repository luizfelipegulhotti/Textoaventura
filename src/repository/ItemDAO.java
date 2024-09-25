package repository;

import model.Cena;
import model.Inventariosave;
import model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
    public static Item findItemById(Integer id) {
        return new Item();
    }

    public static List<Item> findItensByScene(Cena cena) throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from itens i where cena_Atual = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getId_cenas());
        ResultSet resultSet = ps.executeQuery();

        List<Item> itens = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setId_itens(resultSet.getInt("id_itens"));
            item.setNome(resultSet.getString("nome"));
            // preencher o restante das propriedades

            Integer idCenaAtual = resultSet.getInt("cena_Atual");

            item.setCena_Atual(idCenaAtual);

            itens.add(item);
        }

        return itens;
    }
    public static String CHECK(String indice) throws SQLException{
        Connection conn = Mysql.getConnection();
        String sql = "SELECT descricaoItens FROM itens i WHERE nome LIKE ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + indice + "%");
        ResultSet rs = stmt.executeQuery();
        String descricaoItens = new String();
        if(rs.next()) {
             descricaoItens = rs.getString("descricaoItens");
        }
        return descricaoItens;
    }
}
//    public static String buscarComandoCerto(int item) throws SQLException {
//        Connection connection = Mysql.getConnection();
//        String sql = "select * from itens i where comando_correto = ?;";
//        PreparedStatement stmt = connection.prepareStatement(sql);
//
//    }


