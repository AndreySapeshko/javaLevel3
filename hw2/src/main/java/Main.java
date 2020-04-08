import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException, IOException {
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String tableName = "students";
//        create(tableName, columnType, statement);
        String columnsName = "name, score";
//        for (int i = 0; i < 5; i++) {
//            insert(tableName, columnsName, String.format("'Tom %d', %d", i, 10+i*10), statement);
//        }
        String newValue = "score = 100";
        String where = "name = 'Tom 1'";
//        update(tableName, newValue, where, statement);
        String whereChange = "id";
        String whatChange = "name";

//        update(tableName,whatChange, " Gad", whereChange, "4",connection);
//        delete(tableName,whereChange,"3", connection);
//        statement.executeUpdate("DROP TABLE students");
        String columnsType = "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "name TEXT NOT NULL, score TEXT NOT NULL";
//        create(tableName, columnsType, statement);
//        for (int i = 1; i < 5; i++) {
//            insert(tableName, columnsName, "'Bob" + i + "', " + (10 + i * 10), statement);
//        }
        String columnName = "id, name, score";
        where = "ID > 0";
        System.out.println(select(tableName,columnName, where, statement));

        BufferedReader reader = new BufferedReader(new FileReader("C:\\GB\\java\\DZ_update.txt"));
        String strForUpdate = "";
        while (reader.ready()) {
            strForUpdate = reader.readLine();
            strForUpdate = strForUpdate.stripLeading();
            Matcher mat = Pattern.compile("\\b[\\d]{1,}\\b").matcher(strForUpdate);
            if (mat.find()) {
                if (mat.start() == 0) {
                    where = mat.group();
                    while (mat.find()) {
                        newValue = mat.group();
                    }
                }
            }
            update(tableName,"score", newValue, "id", where, connection);
        }
        System.out.println(select(tableName,columnName, where, statement));
        disconnect();
    }

    public static void delete(String tableName, String columnsName, String volue, Connection con) throws SQLException {
        String sqlDelete = String.format("DELETE FROM %s WHERE %s = ?", tableName, columnsName);
        System.out.println(sqlDelete);
        PreparedStatement pstmt = con.prepareStatement(sqlDelete);
        pstmt.setString(1, volue);
        pstmt.executeUpdate();
    }

    public static String select(String tableName, String columnsName, String where, Statement statement) throws SQLException {
        String textSelect = String.format("SELECT %s FROM %s WHERE %s", columnsName, tableName, where);
        ResultSet resultSet = statement.executeQuery(textSelect);
        String[] columns = columnsName.split(", ");
        String result = "";
        while (resultSet.next()) {
            for (int i = 0; i < columns.length; i++) {
                if (i == columns.length - 1) {
                    result += resultSet.getString(columns[i]) + "\n";
                } else {
                    result += resultSet.getString(columns[i]) + " ";
                }
            }
        }
        return result;
    }

    public static void update(String tableName, String whatChange, String newVolue, String whereColumn, String whereVolue,  Connection con) throws SQLException {
        String updateText = String.format("UPDATE %s SET %s = ? WHERE %s = ?;", tableName, whatChange, whereColumn);
        PreparedStatement pstmt = con.prepareStatement(updateText);
        pstmt.setString(1, newVolue);
        pstmt.setString(2, whereVolue);
        pstmt.executeUpdate();
    }

    public static void insert(String tableName, String columnsName, String columnsVolue, Statement statement) throws SQLException {
        String insertStudent = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, columnsName, columnsVolue);
        System.out.println(insertStudent);
        statement.executeUpdate(insertStudent);
    }

    public static void create(String nameTable, String columnType, Statement statement) throws SQLException {
        String createTable = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", nameTable, columnType);

        System.out.println(createTable);
        statement.executeUpdate(createTable);
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:courseDB.db");
        statement = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
