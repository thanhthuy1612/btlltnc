package Database.Create;

import Database.ListData.DateManager;
import Database.ListData.FilmManager;
import Database.ListData.RoomManager;

public class CreateDatabase {
    public static void CreateDB(){
        try {
            FilmManager filmManager = new FilmManager();
            filmManager.createWithId(1,"Tom and Jenny", 120);
            RoomManager roomManager = new RoomManager();
            roomManager.createWithId(1,"hello");
            DateManager dateManager = new DateManager();
            dateManager.create(1,1,1,"12","2000-01-01");
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
