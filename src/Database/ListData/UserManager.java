package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserManager extends BaseQuery<UserEntity> {
    public UserManager() throws ClassNotFoundException, SQLException{
        super("userSystem");
    }
    @Override
    public UserEntity convertToEntity(ResultSet resultSet) throws SQLException{
        UserEntity userEntity = new UserEntity();
        userEntity.setId(resultSet.getInt(1));
        userEntity.setUsername(resultSet.getString(2));
        userEntity.setPassword(resultSet.getString(3));
        userEntity.setFullname(resultSet.getString(4));
        userEntity.setGender(resultSet.getInt(5));
        userEntity.setBithday(resultSet.getString(6));
        userEntity.setType(resultSet.getInt(7));
        return userEntity;
    }
    public void createWithId(Integer id, String userName, String password, String fullname, Integer gender, String birthday, Integer type) throws SQLException{
        getStatement().executeUpdate("Insert into userSystem (id, username, password, fullname, gender, birthday, type) values (" +id+", '"+userName+"', '"+password+"', '"+fullname+"', "+gender+", '"+birthday+"', "+type+")");
    }
    public void create(String userName, String password, String fullname, Integer gender, String birthday, Integer type) throws SQLException{
        getStatement().executeUpdate("Insert into userSystem (username, password, fullname, gender, birthday, type) values ('"+userName+"', '"+password+"', '"+fullname+"', "+gender+", '"+birthday+"', "+type+")");
    }
    @Override
    public String queryCreate(UserEntity entity){
        return "Insert into userSystem (id, username, password, fullname, gender, birthday, type) values (" +entity.getId()+", '"+entity.getUsername()+"', '"+entity.getPassword()+"', '"+entity.getFullname()+"', "+entity.getGender()+", '"+entity.getBithday()+"', "+entity.getType()+")";
    }
    @Override
    public String querySearch(UserEntity entity){
        return "select * from userSystem where fullname like '%" + entity.textSearch + "%'";
    }
    @Override
    public String queryUpdate(UserEntity entity){
        return "update userSystem set username ='"+entity.getUsername()+"', password = '"+entity.getPassword()+"', fullname ='"+entity.getFullname()+"', gender="+entity.getGender()+", birthday ='"+entity.getBithday()+"', type = "+ entity.getType()+" where id="+entity.getId();
    }
    public UserEntity findByUsername(String username) {
        try {
            return convertToEntityNext(
                    getStatement()
                            .executeQuery("select * from userSystem" +
                                    " where username='" + username + "'"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
