
package practice2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author Миша Дунаев
 */
public class Practice2 {   
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/practice2";
            Properties authorization = new Properties();
            authorization.put("user", "Mishkakoalla");
            authorization.put("password", "IM@GEs222");
            Connection connection = DriverManager.getConnection(url, authorization);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet table = statement.executeQuery("SELECT * FROM phone");
             table.first();
             for (int j = 1; j <= table.getMetaData().getColumnCount(); j++) {
                System.out.print(table.getMetaData().getColumnName(j) + "\t\t");
        }
             System.out.println();
              table.beforeFirst();
             while (table.next()) {
                for (int j = 1; j <= table.getMetaData().getColumnCount(); j++) {
                    System.out.print(table.getString(j) + "\t\t");
                }
                System.out.println();
    }
    if (table != null) { table.close(); }
    if (statement != null) { statement.close();}
    if (connection != null) { connection.close();}
        }
        catch (Exception e){
            System.err.println("Error accessing database!");
            e.printStackTrace();
        }
}
        
    }
