package Database.ListData;

import Database.Base.BaseEntity;

public class FilmEntity extends BaseEntity {
    private Integer id;
    private String name;
    private Integer time;
    public void setId(Integer id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTime(Integer time){
        this.time = time;
    }
    @Override
    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Integer getTime(){
        return time;
    }
}
