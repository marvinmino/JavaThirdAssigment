import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbReader {
        private Connection _connect = null;
        private Statement _statement = null;
        private ResultSet _resultSet = null;

        public DbReader() throws  ClassNotFoundException, SQLException {
            Class.forName("com.mysql.jdbc.Driver");
            _connect = DriverManager
                    .getConnection("jdbc:mysql://195.179.236.1:3306/u323045651_citta?"
                            + "user=u323045651_java&password=P3MYEx!,Q!d!");
            _statement = _connect.createStatement();
            _resultSet = _statement
                    .executeQuery("select * from u323045651_citta.citta");
        }

        boolean HasOtherPerson() throws SQLException {
            if(_resultSet.next()) {
               return true;
            }
            return false;
        }

        Person ReadNextPerson() throws SQLException {
            Integer id = _resultSet.getInt("id");
            String nome = _resultSet.getString("nome");
            String cognome = _resultSet.getString("cognome");
            String indirizzo = _resultSet.getString("indirizzo");
            String citta = _resultSet.getString("citta");

            return new Person(nome, cognome, citta, indirizzo);
        }
}
