package Database.ListData;

import Database.Base.BaseEntity;

import java.sql.Date;

public class UserEntity extends BaseEntity {
    private Integer id;
    private String username;
    private String password;
    private String fullname;
    private Integer gender;
    private Date bithday;
    private Integer type;
    public void setId(Integer id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFullname(String fullname){
        this.fullname = fullname;
    }
    public void setGender(Integer gender){
        this.gender = gender;
    }
    public void setBithday(Date bithday){
        this.bithday = bithday;
    }
    public void setType(Integer type){
        this.type = type;
    }

    @Override
    public Integer getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getFullname() {
        return fullname;
    }
    public Date getBithday() {
        return bithday;
    }
    public Integer getGender() {
        return gender;
    }
    public Integer getType() {
        return type;
    }
}
