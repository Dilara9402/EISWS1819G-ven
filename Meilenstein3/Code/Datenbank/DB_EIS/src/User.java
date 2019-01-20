public class User
{
    String name,vorname,username,passwd;
    int systemID;

    public User(String name, String vorname, String username, String passwd, int systemID) {
        this.name = name;
        this.vorname = vorname;
        this.username = username;
        this.passwd = passwd;
        this.systemID = systemID;
    }

    String getSQL()
    {
        return "INSERT INTO Users (vorname,nachname,username,password,systemID) VALUES ('"+vorname+"','"+name+"','"+username+"','"+passwd+"',"+systemID+")";
    }
}
