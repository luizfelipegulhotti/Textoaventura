import model.Cena;
import model.Item;
import repository.CenaDAO;
import repository.ItemDAO;








import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;








public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;








        System.out.print("Digite um comando: ");
        command = scanner.nextLine();
        do {
            System.out.println("Digite um comando ('start', 'help', 'exit', 'caminho 2', etc.):");
            command = scanner.nextLine();








            if ("start".equalsIgnoreCase(command)) {
                try {
                    Cena cena = CenaDAO.findCenaById(1);
                    if (cena != null) {
                        System.out.println(cena.toString());








                        List<Item> itens = ItemDAO.findItensByScene(cena);
                        System.out.println("Itens: " + itens);




                    } else {
                        System.out.println("Cena não encontrada.");
                    }








                    // Loop interno para continuar aceitando comandos após "start"
                    String subCommand;
                    do {
                        System.out.println("Digite um comando ('help', 'exit', 'USE MAPA', 'caminho 2', etc.):");
                        subCommand = scanner.nextLine();








                        if ("help".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comandos disponíveis:");
                            System.out.println("get item: pega o item e adiciona ao inventário");
                            System.out.println("save: salva o jogo");
                            System.out.println("descrição : mostra a descrição do item");
                            System.out.println("use item: te faz usar o item");
                            System.out.println("USE MAPA: busca a cena 2 do banco de dados");
                            System.out.println("caminho 2: busca a cena 3 do banco de dados");
                        } else if ("USE MAPA".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'USE MAPA' recebido no loop interno.");
                            useMapa();
                        } else if ("caminho 2".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'caminho 2' recebido no loop interno.");
                            caminho2();}
                        else if ("caminho 1".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'caminho 1' recebido no loop interno.");
                            caminho1();
                        }
                        else if ("pé".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'pé' recebido no loop interno.");
                            pe();
                        }
                        else if ("raposo vai em bora".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'pé' recebido no loop interno.");
                            RaposoVaiEmbora();
                        }
                        else if ("USE FACA NO TROLL".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            usefaca();
                        }
                        else if ("USE REVOLVER NO TROLL".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            userevolvernotroll();
                        }
                        else if ("USE REVOLVER NO RAPOSO".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            userevolvernoraposo();
                        }
                        else if ("USE FACA NAS CABRAS".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            usefacanascabras();
                        }
                        else if ("USE FACA NO RAPOSO".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            usefacanoraposo();
                        }
                        else if ("USE REVOLVER NAS CABRAS".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'use faca' recebido no loop interno.");
                            userevolvernascabras();
                        }
                        else if ("nadar".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'nadar' recebido no loop interno.");
                           nadar();
                        }
                        else if ("pular".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'nadar' recebido no loop interno.");
                            pular();
                        }
                        else if ("correr".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'nadar' recebido no loop interno.");
                            correr();

                        }
                        else if ("usecipo".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'nadar' recebido no loop interno.");
                           usecipo();


                        } else if (!"exit".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando não reconhecido.");
                        }
                    } while (!"exit".equalsIgnoreCase(subCommand));








                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if ("USE MAPA".equalsIgnoreCase(command)) {
                System.out.println("Comando 'USE MAPA' recebido no loop principal.");
                useMapa();
            } else if ("caminho 2".equalsIgnoreCase(command)) {
                System.out.println("Comando 'caminho 2' recebido no loop principal.");
                caminho2();
            } else if ("caminho 1".equalsIgnoreCase(command)) {
                System.out.println("Comando 'caminho 1' recebido no loop principal.");
                caminho1();
            }
            else if ("pé".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena5' recebido no loop principal.");
                pe();
            }
            else if ("nadar".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena5' recebido no loop principal.");
                nadar();
            }
            else if ("pular".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena5' recebido no loop principal.");
                pular();


            }else if (command.equals("use faca no troll")) {
                System.out.println("TROLL TE MATOU");
                usefaca();




            } else if ("raposo vai em bora".equalsIgnoreCase(command)) {
                System.out.println("Comando 'raposo vai em bora' recebido no loop principal.");
                RaposoVaiEmbora();
            }
            else if ("use revolver no troll".equalsIgnoreCase(command)) {
                System.out.println("Comando 'use revolver no troll' recebido no loop principal.");
                userevolvernotroll();
            }
            else if ("use revolver no raposo".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena8' recebido no loop principal.");
                userevolvernoraposo();
            }
            else if ("use faca nas cabras".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena15' recebido no loop principal.");
                usefacanascabras();
            }
            else if ("use faca no raposo".equalsIgnoreCase(command)) {
                System.out.println("Comando 'use faca no raposo' recebido no loop principal.");
                usefacanoraposo();
            }
            else if ("use revolver nas cabras".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena11' recebido no loop principal.");
                userevolvernascabras();
            }
            else if ("nadar".equalsIgnoreCase(command)) {
                System.out.println("Comando 'nadar' recebido no loop principal.");
                nadar();
            }


            else if ("correr".equalsIgnoreCase(command)) {
            System.out.println("Comando 'cena13' recebido no loop principal.");
            correr();
        }




            else if ("use cipó".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena13' recebido no loop principal.");
                usecipo();
            }






        else {
                System.out.println("Comando não reconhecido no loop principal.");
            }
        } while (!"exit".equalsIgnoreCase(command));








        System.out.println("Programa encerrado.");
    }
























    private static void useMapa() {
        System.out.println("Método useMapa() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(2);
            if (cena != null) {
                System.out.println("Cena 2 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 2 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 2: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }








    private static void caminho1() {
        System.out.println("Método caminho2() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(3);
            if (cena != null) {
                System.out.println("Cena 3 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 3 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 3: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void caminho2() {
        System.out.println("Método caminho2() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(6);
            if (cena != null) {
                System.out.println("Cena 6 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 6 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 6: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void pe() {
        System.out.println("Método cena4() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(4);
            if (cena != null) {
                System.out.println("Cena 4 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 4 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 4: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void RaposoVaiEmbora() {
        System.out.println("Método cena6() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(5);
            if (cena != null) {
                System.out.println("Cena 5 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 5 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 5: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void usefaca() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(14);
            if (cena != null) {
                System.out.println("Cena 7 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 7 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 7: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void userevolvernotroll() {
        System.out.println("Método cena11() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(11);
            if (cena != null) {
                System.out.println("Cena 11 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 11 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 11: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void userevolvernoraposo() {
        System.out.println("Método cena12() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(12);
            if (cena != null) {
                System.out.println("Cena 12 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 12 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 12: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void usefacanascabras() {
        System.out.println("Método cena16() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(16);
            if (cena != null) {
                System.out.println("Cena 16 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 16 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 16: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void usefacanoraposo() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(13);
            if (cena != null) {
                System.out.println("Cena 7 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 7 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 7: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void userevolvernascabras() {
        System.out.println("Método cena15() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(15);
            if (cena != null) {
                System.out.println("Cena 15 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 15 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 15: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void nadar() {
        System.out.println("Método nadar() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(17);
            if (cena != null) {
                System.out.println("Cena 17 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena nadar não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena nadar: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void pular() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(7);
            if (cena != null) {
                System.out.println("Cena 7 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 7 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 7: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void correr() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(8);
            if (cena != null) {
                System.out.println("Cena 7 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 7 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 7: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void usecipo() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(9);
            if (cena != null) {
                System.out.println("Cena 16 encontrada: " + cena.toString());








                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 16 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 16: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}


