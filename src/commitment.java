import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class commitment {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            connection.setAutoCommit(false); //by default it is true
            PreparedStatement ps=connection.prepareStatement("update customers set creditLimit = ? where customerNumber = ?");
            ps.setString(1, "21000");
            ps.setString(2, "103");
            ps.executeUpdate();
            connection.commit();
            connection.rollback();
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
