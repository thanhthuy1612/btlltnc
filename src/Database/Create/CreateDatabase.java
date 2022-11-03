package Database.Create;

import Database.ListData.*;

public class CreateDatabase {
    public static void CreateDB(){
        try {
            FilmManager filmManager = new FilmManager();
            filmManager.createWithId(1,"Tom and Jenny", 120);
            RoomManager roomManager = new RoomManager();
            roomManager.createWithId(1,"hello");
            DateManager dateManager = new DateManager();
            dateManager.create(1,1,1,1,"12","2000-01-01");
            UserManager userManager = new UserManager();
            userManager.createWithId(1,"latiah","1234", "thanhthuy",1,"2001-12-16",0);
            TicketManager ticketManager = new TicketManager();
            ticketManager.create(1,1,1,1,10);
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
