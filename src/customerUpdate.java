import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class customerUpdate {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            System.out.println(connection.isClosed());
            Statement st=connection.createStatement();
            int rows=st.executeUpdate("update customers set creditLimit = 70000 where customerNumber=129");
            System.out.println(rows);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(connection != null && (!connection.isClosed())){
                    connection.close();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
