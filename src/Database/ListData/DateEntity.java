package Database.ListData;

import Database.Base.BaseEntity;

import java.util.Date;

public class DateEntity extends BaseEntity {
    private Integer id;
    private Integer roomId;
    private Integer filmId;
    private String time;
    private Date date;
    private Integer soldOut;
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
    public void setDate(Date date){
        this.date =date;
    }
    public void setSoldOut(Integer soldOut){
        this.soldOut = soldOut;
    }
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
    public Date getDate(){
        return date;
    }
    public Integer getSoldOut(){
        return soldOut;
    }
}
