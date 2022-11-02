package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmManager extends BaseQuery<FilmEntity> {
    public FilmManager() throws ClassNotFoundException, SQLException{
        super("film");
    }
    @Override
    public FilmEntity convertToEntity(ResultSet resultSet) throws SQLException{
        FilmEntity filmEntity = new FilmEntity();
        filmEntity.setId(resultSet.getInt(1));
        filmEntity.setName(resultSet.getString(2));
        filmEntity.setTime(resultSet.getInt(3));
        return filmEntity;
    }
    public void createWithId(Integer id, String name, Integer time) throws SQLException{
        getStatement().executeUpdate("INSERT INTO film (id, name, time)\n   VALUES ("+ id +", '"+ name + "', " + time+ ");");
    }
    @Override
    public String querySearch(FilmEntity entity){
        return "select * from film where ten like '%" + entity.textSearch + "%'";
    }
    @Override
    public String queryCreate(FilmEntity entity){
        return "INSERT INTO film (id, name, time)\n   VALUES ("+ entity.getId() +", '"+ entity.getName() + "', " + entity.getTime()+ ");";
    }
    @Override
    public String queryUpdate(FilmEntity entity){
        return "UPDATE film\nSET name = '" + entity.getName() +"', time = "+ entity.getTime()+"\nWHERE id = "+entity.getId();
    }
}
