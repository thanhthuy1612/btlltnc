package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TicketManager extends BaseQuery<TicketEntity> {
    private DateManager dateManager;
    public TicketManager() throws ClassNotFoundException, SQLException{
        super("ticket");
        dateManager = new DateManager();
    }
    public TicketEntity convertToEntity(ResultSet resultSet) throws SQLException{
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setId(resultSet.getInt(1));
        ticketEntity.setUserId(resultSet.getInt(2));
        ticketEntity.setTimeId(resultSet.getInt(3));
        ticketEntity.setRowTicket(resultSet.getInt(4));
        ticketEntity.setColumnTicket(resultSet.getInt(5));
        ticketEntity.setDateEntity(dateManager.getById(resultSet.getInt(3)));
        return ticketEntity;
    }
    public List<TicketEntity> findByDateId(Integer dateId) throws SQLException{
        return convertToEntities(getStatement().executeQuery("select * from ticket where timeId = " + dateId));
    }
    public List<TicketEntity> findByUserId(Integer userId) throws SQLException{
        return convertToEntities(getStatement().executeQuery("select * from ticket where userId = " + userId));
    }
    public void create(int id, int userId, int timeId, int rowTicket, int columnTicket)throws SQLException{
        TicketEntity entity = new TicketEntity();
        entity.setId(id);
        entity.setUserId(userId);
        entity.setTimeId(timeId);
        entity.setRowTicket(rowTicket);
        entity.setColumnTicket(columnTicket);
        getStatement().executeUpdate(queryCreate(entity));
    }
    @Override
    public String queryCreate(TicketEntity entity) {
        return "INSERT INTO ticket (id, userId, timeId, rowTicket, columnTicket) \nVALUES ( "+ entity.getId()+", "+ entity.getUserId()+", "+entity.getTimeId()+", "+entity.getRowTicket()+", "+entity.getColumnTicket()+")";
    }
    @Override
    public String querySearch(TicketEntity entity){
        return "select * from ticket where userId like '%" + entity.textSearch + "%'";
    }
    @Override
    public String queryUpdate(TicketEntity entity){
        return "UPDATE ticket\nSET rowTicket= " + entity.getRowTicket() +", columnTicket = "+ entity.getColumnTicket()+"\nWHERE id = "+entity.getId();
    }
}
