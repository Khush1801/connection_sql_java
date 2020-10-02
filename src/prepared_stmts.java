import java.sql.*;

public class prepared_stmts {
    public static void main(String[] args) {
        Connection connection=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "");
            PreparedStatement ps=connection.prepareStatement("select * from customers where customerName=?  && contactFirstName=?");;
            ps.setString(1, "Atelier graphique");
            ps.setString(2, "Carine");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("City"));
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
