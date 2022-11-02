import Database.ListData.DateManager;
import Database.ListData.FilmManager;
import Database.ListData.RoomManager;

import static Database.Connect.ConnectDB;

public class Main{
    public static void main(String[] args) {
        ConnectDB();
        FilmManager filmManager;
        {
            try{
                filmManager = new FilmManager();
                filmManager.createWithId(1,"hello 123", 4);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        RoomManager roomManager;
        {
            try{
                roomManager = new RoomManager();
                roomManager.createWithId(1,"hello 123");
            }catch (Exception e){
                System.out.println(e);
            }
        }
        DateManager dateManager;
        {
            try {
                dateManager = new DateManager();
                dateManager.create(1,1,1,"1", "2000-12-16");
                System.out.println("success");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}