import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        try{
            DbReader reader = new DbReader();
            HashSet<String> names = new HashSet<String>();
            HashSet<String> cities = new HashSet<String>();

            while(reader.HasOtherPerson()){
                Person person = reader.ReadNextPerson();
                names.add(person.get_name());
                cities.add(person.get_city());
            }

            System.out.println("The number of distinct names is: " + names.size());
            System.out.println("The number of distinct cities is: " + cities.size());
        } catch (SQLException e){
            System.out.println("There was an error with the database");
        }
        catch (Exception e){
            System.out.printf("There was an error with reading the file");
        }
    }
}
