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
                        System.out.println(repository.CenaDAO.findNextCenaById(proxima_Cena(indice).getProxima_Cena(cena.getId_cenas())));
                    } else if (CortandoFrase[0].equals("CHECK")) {
                        System.out.println(repository.ItemDAO.CHECK(indice));
                    }else {
                        System.out.println("Comando Invalido");
                    }
                    } if(CortandoFrase.length == 1) {
                    if (CortandoFrase[0].equals("LOAD")) {
                        System.out.println("Escolha o seu save, e digite: 'NUMERO-DO-SAVE'");
                        System.out.println(repository.InventariosaveDAO.loadSaveIds());
                        int Ns = sc.nextInt();
                        repository.InventariosaveDAO.Load(Ns);
                        System.out.println(repository.CenaDAO.findCenaById(repository.InventariosaveDAO.Load(Ns)));
                    } else if (CortandoFrase[0].equals("HELP")) {
                        System.out.println("Os comandos disponiveis são: 'USE NOME-DO-ITEM', 'LOAD', 'GET NOME-DO-ITEM','CHECK','INVENTARIO");
                    } else if(CortandoFrase[0].equals("INVENTARIO")) {
                        System.out.println(repository.InventariosaveDAO.quantosItensTem());
                    }else {
                            System.out.println("COMANDO FUDIDO");
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

public static Item proxima_Cena(String indice) throws SQLException{
    Connection conn = Mysql.getConnection();
    String sql = "select * from itens i where nome like ?;";
    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setString(1, "%" + indice + "%");
    ResultSet rs = stmt.executeQuery();
    Item idProximaCena = new Item();
    if(rs.next()) {
        idProximaCena.setProxima_Cena(rs.getInt("proxima_Cena"));
}
        return idProximaCena;
}

//
//public static Item puxandoCenas
////            sql = "select * itens where noem like "