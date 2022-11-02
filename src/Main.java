import static Database.Connect.ConnectDB;
import static Database.Create.CreateDatabase.CreateDB;

public class Main{
    public static void main(String[] args) {
        ConnectDB();
        CreateDB();
    }

}