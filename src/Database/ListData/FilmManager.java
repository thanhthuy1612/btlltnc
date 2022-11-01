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
        getStatement().executeUpdate("Insert into film (id, name, time) value ("+ id +", "+name+ ", " + time+ ")");
    }
}
