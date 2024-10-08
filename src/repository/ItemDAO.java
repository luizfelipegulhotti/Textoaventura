package repository;




import model.Cena;
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
        String sql = "select * from itens  where id_itens = ?;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getIdCena());
        ResultSet resultSet = ps.executeQuery();


        List<Item> itens = new ArrayList<>();
        while (resultSet.next()) {
            Item item = new Item();
            item.setIdItem(resultSet.getInt("id_itens"));
            item.setNome(resultSet.getString("nome"));
            // preencher o restante das propriedades


            Integer idCenaAtual = resultSet.getInt("id_itens");
            Cena cenaAtual = repository.CenaDAO.findCenaById(idCenaAtual);


            item.setCenaAtual(cenaAtual);


            itens.add(item);
        }


        return itens;
    }
}