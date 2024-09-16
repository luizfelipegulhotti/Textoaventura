import model.Cena;
import model.Item;
import model.Save;
import repository.CenaDAO;
import repository.ItemDAO;
import repository.SaveDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        do {
            System.out.println("Digite um comando ('start', 'help', 'exit', 'load','static'):");
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
                        System.out.println("Digite um comando ('help','exit','USE MAPA','save','load','static'.):");
                        subCommand = scanner.nextLine();

                        if ("help".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comandos disponíveis:");
                            System.out.println("get item: pega o item e adiciona ao inventário");
                            System.out.println("save: salva o jogo");
                            System.out.println("descrição : mostra a descrição do item");
                            System.out.println("use item: te faz usar o item");
                            System.out.println("USE MAPA: busca a cena 2 do banco de dados");
                        } else if ("USE MAPA".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando 'USE MAPA' recebido no loop interno.");
                            useMapa();
                        } else if ("save".equalsIgnoreCase(subCommand)) {
                        System.out.println("iniciando salvamento do jogo");
                        save();
                        }else if (!"exit".equalsIgnoreCase(subCommand)) {
                            System.out.println("Comando não reconhecido.");
                        }

                    } while (!"exit".equalsIgnoreCase(subCommand));

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } else if ("USE MAPA".equalsIgnoreCase(command)) {
                System.out.println("Comando 'USE MAPA' recebido no loop principal.");
                useMapa();
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
    private static void save() {
        System.out.println("Salvando o jogo");
        try {
            Save save = SaveDAO.novoJogo(1);
        } catch (SQLException e) {
            System.out.println("Erro ao tentar salvar");
            throw new RuntimeException(e);
        }
    }

}
