package Database.ListData;

import Database.Base.BaseQuery;

import java.sql.SQLException;

public abstract class DateManager extends BaseQuery<DateEntity> {
    public DateManager() throws ClassNotFoundException, SQLException{
        super("date");
    }
}