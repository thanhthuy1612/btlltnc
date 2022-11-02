package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class DateManager extends BaseQuery<DateEntity> {
    private RoomManager roomManager;
    private FilmManager filmManager;
    public DateManager() throws ClassNotFoundException, SQLException{
        super("date");
        roomManager = new RoomManager();
        filmManager = new FilmManager();
    }
    public DateEntity convertToEntity(ResultSet resultSet) throws SQLException{
        DateEntity entity = new DateEntity();
        entity.setId(resultSet.getInt(1));
        entity.setRoomId(resultSet.getInt(2));
        entity.setFilmId(resultSet.getInt(3));
        entity.setSoldOut(resultSet.getInt(4));
        entity.setTime(resultSet.getString(5));
        entity.setDate(resultSet.getString(6));
        FilmEntity filmEntity = filmManager.getById(resultSet.getInt(3));
        RoomEntity roomEntity = roomManager.getById(resultSet.getInt(2));
        if(filmEntity != null){
            entity.setNameFilm(filmEntity.getName());
        }
        if (roomEntity != null){
            entity.setNameRoom(roomEntity.getName());
        }
        return entity;
    }
    @Override
    public String querySearch(DateEntity entity){
        return "select * from data join film f on date.filmId = f.id " +
                " join room r on date.roomId = r.id " +
                " where f.name like '%" + entity.textSearch + "%'" +
                " or r.name like '%" + entity.textSearch + "%'";
    }
    @Override
    public String queryCreate(DateEntity entity){
        return "Insert into date"
                + "(id, roomId, filmId, time, date)"
                + "values("+entity.getId()
                + "," + entity.getRoomId()
                + "," + entity.getFilmId()
                + ",'" + entity.getTime()
                + "','" + entity.getDate() + "')";
    }
    public void create(int id,int roomId, int filmId, String time, String date) throws SQLException{
        DateEntity entity = new DateEntity();
        entity.setId(id);
        entity.setFilmId(filmId);
        entity.setRoomId(roomId);
        entity.setTime(time);
        entity.setDate(date);
        getStatement().executeUpdate(queryCreate(entity));
    }
    @Override
    public String queryUpdate(DateEntity entity) {
        return "update date" +
                " set roomId=" + entity.getRoomId()
                + ", filmId=" + entity.getFilmId()
                + ", time= '" + entity.getTime()
                + "', date= '" + entity.getDate()
                + "' where id=" + entity.getId();
    }
    public List<DateEntity> findByFilmId(Integer filmId) throws SQLException{
        Date current = new Date(System.currentTimeMillis());
        return convertToEntities(getStatement().executeQuery("select * from date" + " where date >= '" + current + "' and filmId=" + filmId + " order by date"));
    }
    public boolean findByFilmId(DateEntity entity) throws SQLException{
        ResultSet r = getStatement().executeQuery("select case when exists(select 1 from film where roomId = "+ entity.getRoomId()+ " and time= '" + entity.getTime() +"' and date ='"+entity.getDate()+"' order by date) then true else false end");
        if (r.next()) {
            return r.getBoolean(1);
        }
        return false;
    }
}