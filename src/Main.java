import Database.ListData.FilmManager;

import static Database.Connect.ConnectDB;

public class Main{
    public static void main(String[] args) {
        ConnectDB();
        FilmManager filmManager;

        {
            try {
                filmManager = new FilmManager();
                filmManager.createWithId(1,"hello", 10);
                System.out.println("hello");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}