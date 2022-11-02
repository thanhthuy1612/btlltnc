import Database.ListData.DateManager;

import static Database.Connect.ConnectDB;

public class Main{
    public static void main(String[] args) {
        ConnectDB();
        DateManager filmManager;
        {
            try {
                filmManager = new DateManager();
                //filmManager.create(1,1,1,"1","2000-12-16");
                System.out.println("success");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}