package Database.ListData;

import Database.Base.BaseEntity;

public class DateEntity extends BaseEntity {
    private Integer id;
    private Integer roomId;
    private Integer filmId;
    private String time;
    private String date;
    private Integer soldOut;
    private String nameFilm;
    private String nameRoom;
    public void setId(Integer id){
        this.id = id;
    }
    public void setRoomId(Integer roomId){
        this.roomId = roomId;
    }
    public void setFilmId(Integer filmId){
        this.filmId = filmId;
    }
    public void setTime(String time){
        this.time = time;
    }
    public void setDate(String date){
        this.date =date;
    }
    public void setSoldOut(Integer soldOut){
        this.soldOut = soldOut;
    }
    public void setNameFilm(String nameFilm){ this.nameFilm =  nameFilm; }
    public void setNameRoom(String nameRoom){ this.nameRoom = nameRoom; }
    @Override
    public Integer getId(){
        return id;
    }
    public Integer getRoomId(){
        return roomId;
    }
    public Integer getFilmId(){
        return filmId;
    }
    public String getTime(){
        return time;
    }
    public String getDate(){
        return date;
    }
    public Integer getSoldOut(){
        return soldOut;
    }
    public String getNameFilm(){ return nameFilm; }
    public String getNameRoom(){ return nameRoom; }
}
