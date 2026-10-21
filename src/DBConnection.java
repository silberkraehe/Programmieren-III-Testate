import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 CI TEST
 */


public class DBConnection {
    private static final String URL = "jdbc:h2:~/tierheim;AUTO_SERVER=TRUE";
    private final String user = "admin"; // vllt. können wir auch System.getenv("DB_USER") benutzen aber idk how
    private final String password = "geheim"; // System.getenv("DB_PASSWORD")

    /**
     * Allows us to save the data of each result row from an SQL-Query into an actual Java-Object, using directions specified
     * in the according Class via Interface-Implementation. "map" is the method for turning a ResultSet into an R-Object (Result) of the RowMapper
     */
    @FunctionalInterface
    public interface RowMapper<E> {
        E map(ResultSet resultSet) throws SQLException;
    }

    /**
     * Works only for SELECT-Statements.
     *
     * @param sql    SQL-Query to be executed.
     * @param mapper A RowMapper that includes the specification on how the SQL-ResultSet is to be extracted and saved.
     */
    public <E> List<E> executeQuery(String sql, RowMapper<E> mapper, Object... sqlParams) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, user, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setQueryTimeout(30);

            try (ResultSet resultSet = statement.executeQuery()) {
                List<E> result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(mapper.map(resultSet));
                }
                return result;
            }
        }
    }

    /**
     * Executes INSERT/UPDATE/DELETE-Statements. Object... allows any number of sqlParams.
     *
     * @param sql       SQL-Query to be executed.
     * @param sqlParams An object including a number of SQL Parameters given by the user.
     */
    public int executeUpdate(String sql, Object... sqlParams) throws SQLException {
        try (Connection connection = DriverManager.getConnection(URL, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setQueryTimeout(30);
            bind(preparedStatement, sqlParams);

            return preparedStatement.executeUpdate();
        }
    }

    private void bind(PreparedStatement statement, Object[] sqlParams) throws SQLException {
        for (int i = 0; i < sqlParams.length; i++) {
            statement.setObject(i + 1, sqlParams[i]);
        }
    }

}