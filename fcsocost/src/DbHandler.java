import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbHandler implements DataStorage {
    private Connection connection;

    public DbHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/costdatabase", "username",
                    "password");
        } catch (SQLException e) {
            System.err.println("Hiba a kapcsolat létrehozásában!");
            System.err.println(e.getMessage());
        }
    }

    public void writeData(Cost cost) {
        try {
            tryWriteData(cost);
        } catch (SQLException e) {
            System.err.println("Hiba a kapcsolatban!");
            System.err.println(e.getMessage());
        }
    }

    public void tryWriteData(Cost cost) throws SQLException {
        String query = "INSERT INTO cost_table (transport, business, repair) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setDouble(1, cost.transport);
        preparedStatement.setDouble(2, cost.business);
        preparedStatement.setDouble(3, cost.repair);
        preparedStatement.executeUpdate();

    }
}
