package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TicketManager extends BaseQuery<TicketEntity> {
    private DateManager dateManager;
    public TicketManager() throws ClassNotFoundException, SQLException{
        super("ticket");
        dateManager = new DateManager();
    }
    public TicketEntity convertToEntity(ResultSet resultSet) throws SQLException{
        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
