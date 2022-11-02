package Database.Base;

import Database.Connect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseQuery<Entity extends BaseEntity> implements IBaseQuery<Entity> {
    private Statement statement;
    private String tableName;
    public BaseQuery(String tableName){
        try {
            this.statement = Connect.DataManager().getConnection().createStatement();
            this.tableName = tableName;
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public Statement getStatement(){
        return statement;
    }
    public abstract String querySearch(Entity entity);
    public abstract String queryUpdate(Entity entity);
    public abstract String queryCreate(Entity entity);
    public abstract Entity convertToEntity(ResultSet resultSet) throws SQLException;

    public Entity convertToEntityNext(ResultSet resultSet) throws  SQLException{
        if(!resultSet.next()) return null;
        return convertToEntity(resultSet);
    }
    public List<Entity> convertToEntities(ResultSet resultSet) throws SQLException {
        List<Entity> entities = new ArrayList<>();
        while (resultSet.next()){
            entities.add(convertToEntity(resultSet));
        }
        return entities;
    }
    @Override
    public List<Entity> search (Entity entity) throws SQLException{
        String s = querySearch(entity);
        System.out.println(s);
        return convertToEntities(statement.executeQuery(s));
    }
    @Override
    public int create(Entity entity) throws  SQLException{
        String s = queryCreate(entity);
        System.out.println(s);
        return getStatement().executeUpdate(s);
    }
    @Override
    public int update(Entity entity) throws SQLException {
        String s = queryUpdate(entity);
        System.out.println(s);
        return getStatement().executeUpdate(s);
    }
    @Override
    public List<Entity> findAll() throws SQLException{
        return convertToEntities(statement.executeQuery("select * from " + tableName));
    }
    @Override
    public Entity getById(Integer id) throws SQLException{
        return convertToEntityNext(statement.executeQuery("select * from " + tableName + " where id=" + id));
    }
    @Override
    public void deleteAll() throws SQLException{
        statement.executeUpdate("delete * FROM " + tableName);
    }
    @Override
    public void delete(Integer id) throws SQLException{
        statement.executeUpdate("delete FROM "+ tableName + " where id=" + id);
    }
}
