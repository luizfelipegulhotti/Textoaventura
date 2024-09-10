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
            else if ("cena5".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena5' recebido no loop principal.");
                cena5();
            } else if ("cena6".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena6' recebido no loop principal.");
                cena6();
            }
            else if ("cena7".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena7' recebido no loop principal.");
                cena7();
            }
            else if ("cena8".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena8' recebido no loop principal.");
                cena8();
            }
            else if ("cena9".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena9' recebido no loop principal.");
                cena9();
            }
            else if ("cena10".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena10' recebido no loop principal.");
                cena10();
            }
            else if ("cena11".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena11' recebido no loop principal.");
                cena11();
            }
            else if ("cena12".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena12' recebido no loop principal.");
                cena12();
            }
            else if ("cena13".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena13' recebido no loop principal.");
                cena13();
            }
            else if ("cena14".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena14' recebido no loop principal.");
                cena14();
            }
            else if ("cena15".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena15' recebido no loop principal.");
                cena15();
            }
            else if ("cena16".equalsIgnoreCase(command)) {
                System.out.println("Comando 'cena16' recebido no loop principal.");
                cena16();
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
            Cena cena = CenaDAO.findCenaById(17);
            if (cena != null) {
                System.out.println("Cena 17 encontrada: " + cena.toString());




                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 17 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 17: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }




    private static void caminho2() {
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
    private static void caminho1() {
        System.out.println("Método caminho1() chamado.");
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
    private static void cena5() {
        System.out.println("Método cena5() chamado.");
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
    private static void cena6() {
        System.out.println("Método cena6() chamado.");
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
    private static void cena7() {
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
    private static void cena8() {
        System.out.println("Método cena8() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(8);
            if (cena != null) {
                System.out.println("Cena 8 encontrada: " + cena.toString());




                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 8 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 8: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void cena9() {
        System.out.println("Método cena9() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(9);
            if (cena != null) {
                System.out.println("Cena 9 encontrada: " + cena.toString());




                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 9 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 9: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void cena10() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(10);
            if (cena != null) {
                System.out.println("Cena 10 encontrada: " + cena.toString());




                List<Item> itens = ItemDAO.findItensByScene(cena);
                System.out.println("Itens: " + itens);
            } else {
                System.out.println("Cena 10 não encontrada.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar a Cena 10: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
    private static void cena11() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(11);
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
    private static void cena12() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(12);
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
    private static void cena13() {
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
    private static void cena14() {
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
    private static void cena15() {
        System.out.println("Método cena7() chamado.");
        try {
            Cena cena = CenaDAO.findCenaById(15);
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
    private static void cena16() {
        System.out.println("Método cena7() chamado.");
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
}

