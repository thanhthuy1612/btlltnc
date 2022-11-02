package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomManager extends BaseQuery<RoomEntity> {
    public RoomManager() throws ClassNotFoundException, SQLException{
        super("room");
    }
    @Override
    public RoomEntity convertToEntity(ResultSet resultSet) throws SQLException{
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(resultSet.getInt(1));
        roomEntity.setName(resultSet.getString(2));
        return roomEntity;
    }
    public void createWithId(Integer id, String name) throws SQLException{
        getStatement().executeUpdate("INSERT INTO room (id, name)\n   VALUES ("+ id +", '"+ name + "');");
    }
    @Override
    public String querySearch(RoomEntity entity){
        return "select * from room where name like '%" + entity.textSearch + "%'";
    }
    @Override
    public String queryCreate(RoomEntity entity){
        return "INSERT INTO room (id, name)\n   VALUES ("+ entity.getId() +", '"+ entity.getName() + "');";
    }
    @Override
    public String queryUpdate(RoomEntity entity){
        return "UPDATE room\nSET name = '" + entity.getName() +"'\nWHERE id = "+entity.getId();
    }
}
