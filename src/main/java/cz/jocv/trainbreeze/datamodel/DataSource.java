package cz.jocv.trainbreeze.datamodel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static DataSource instance = new DataSource();
    private Connection connection;

    private DataSource() {

    }

    public static DataSource getInstance() {
        return instance;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close the connection: " + e.getMessage());
        }
    }

    public boolean open() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/home/vaclav/Desktop/Java-projekty/Trainbreeze/src/main/resources/cz/jocv/trainbreeze/database/trasy.db");
            return true;
        } catch (SQLException e) {
            System.out.println("Could not connect to the database: " + e.getMessage());
            return false;
        }
    }

    public List<Trasa> queryTrasy() {
        try {
            String query = "SELECT * FROM trasy;";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Trasa> trasy = new ArrayList<>();

            while (resultSet.next()) {
                String pocatecniStanice = resultSet.getString("pocatecni_stanice");
                String cilovaStanice = resultSet.getString("cilova_stanice");
                int pocetKilometru = resultSet.getInt("pocet_kilometru");
                int pocetJizd = resultSet.getInt("pocet_jizd");
                Trasa t = new Trasa(pocatecniStanice, cilovaStanice, pocetKilometru, pocetJizd);
                trasy.add(t);
            }
            return trasy;

        } catch (SQLException e) {
            System.out.println("Qiery failed: " + e.getMessage());
            return null;
        }
    }

    public void insertTrasa(String pocatecniStanice, String cilovaStanice, int pocetKilometru, int pocetJizd) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO trasy (pocatecni_stanice,cilova_stanice,pocet_jizd,pocet_kilometru) VALUES(?,?,?,?);");
            preparedStatement.setString(1, pocatecniStanice);
            preparedStatement.setString(2, cilovaStanice);
            preparedStatement.setInt(3, pocetKilometru);
            preparedStatement.setInt(4, pocetJizd);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Could not insert a record");
            }

        } catch (SQLException e) {
            System.out.println("Could not insert a record: " + e.getMessage());
        }
    }


}
