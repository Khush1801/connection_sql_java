import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionExample {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            System.out.println(connection.isClosed());
            Statement st=connection.createStatement();
//            String query="select * from customers order by desc";
//            st.executeQuery("use mysql");
            st.executeQuery(" set sql_mode = \"STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION\";");
//            st.executeQuery("use imdbapp.classicmodels");
            String query="select avg(creditLimit) as max_lim, customerName, City from customers";
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("customerName")+" "+rs.getString("City"));
            }
//            boolean result=st.execute("create table testx(id int not null primary key, name varchar(50));");
//            System.out.println(result);
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
