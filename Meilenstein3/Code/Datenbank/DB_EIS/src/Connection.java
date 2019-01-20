import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection
{
    java.sql.Connection db;
    Statement query;
    ResultSet res;
    private String dbName;

    public Connection(String dbName,String url,String user, String pswd)
    {
        this.dbName=dbName;
        try
        {
           Class.forName("com.mysql.cj.jdbc.Driver");
           db=DriverManager.getConnection(url, user, pswd);
           query=db.createStatement();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void createTable()
    {
        try
        {
            String sql="CREATE TABLE IF NOT EXISTS `Users`" +
                    "\n"+"(\n"+" `adminID`  smallint PRIMARY KEY NOT NULL AUTO_INCREMENT," +
                    "\n"+" `username` varchar(255) NOT NULL UNIQUE," +
                    "\n"+" `password` varchar(255)," +
                    "\n"+"`vorname`     varchar(255)," +
                    "\n"+"`nachname`     varchar(255)," +
                    "\n"+"`systemID` smallint);";
            query.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    ResultSet getUsers()
    {
        try {
            String sql="SELECT vorname,nachname,username,systemID FROM Users";
            res=query.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void addUser(User usr)
    {
        try
        {
            String sql=usr.getSQL();
            query.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteUser(User usr)
    {
        try
        {
            String sql="DELETE FROM `Users` WHERE `username`='"+usr.username+"'";
            query.executeUpdate(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
