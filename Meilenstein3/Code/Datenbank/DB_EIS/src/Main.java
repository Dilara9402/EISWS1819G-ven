import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args)
    {
        String dbName="eis";
        String url="jdbc:mysql://localhost:3306/"+dbName;
        String user="root";
        String pswd="";
        Connection db=new Connection(dbName,url,user,pswd);

        User test=new User("Güven","Dilara","DG","123",0);
        db.createTable();
        db.addUser(test);
        ResultSet users=db.getUsers();
        try {
            while (users.next())
            {
                System.out.println(users.getString("vorname"));

                System.out.println(users.getString("nachname"));

                System.out.println(users.getString("username"));

                System.out.println(users.getString("systemID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db.deleteUser(test);
    }
}
