import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class HelpCommand {
    public static void getHelpText() {
        String url = "jdbc:mysql://localhost:3306/facul";
        String user = "facul";
        String password = " ";

        String query = "SELECT texto FROM comandos WHERE comando = 'HELP'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String helpText = rs.getString("texto");
                System.out.println("Texto de ajuda: " + helpText);
            } else {
                System.out.println("Nenhum texto de ajuda encontrado para o comando HELP.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}