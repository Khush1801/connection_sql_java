import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class groupby {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            System.out.println(connection.isClosed());
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery("select count(1), customerNumber from orders o group by o.customerNumber");
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
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