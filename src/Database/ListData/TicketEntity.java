package Database.ListData;

import Database.Base.BaseEntity;

public class TicketEntity extends BaseEntity {
    private Integer id;
    private Integer userId;
    private Integer timeId;
    private Integer rowTicket;
    private Integer columnTicket;
    private DateEntity dateEntity;
    public void setId(Integer id){
        this.id = id;
    }
    public void setUserId(Integer userId){
        this.userId = userId;
    }
    public void setTimeId(Integer timeId){
        this.timeId = timeId;
    }
    public void setRowTicket(Integer rowTicket){
        this.rowTicket = rowTicket;
    }
    public void setColumnTicket(Integer columnTicket){
        this.columnTicket = columnTicket;
    }
    public void setDateEntity(DateEntity dateEntity){ this.dateEntity = dateEntity;}
    @Override
    public Integer getId(){
        return id;
    }
    public Integer getUserId(){
        return userId;
    }
    public Integer getTimeId(){
        return timeId;
    }
    public Integer getRowTicket(){
        return rowTicket;
    }
    public Integer getColumnTicket(){
        return columnTicket;
    }
    public DateEntity getDateEntity(){ return dateEntity;}
}
