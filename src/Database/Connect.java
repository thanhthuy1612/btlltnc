package Database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.Connection;
import java.sql.SQLException;

import static Database.Create.CreateTable.CreateTableDB;

public class Connect {
    public static SQLServerDataSource DataManager(){
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("16122001");
        ds.setServerName("DESKTOP-NCS7J0S\\LATIAH");
        ds.setPortNumber(1433);
        ds.setDatabaseName("CinemaDB");
        ds.setTrustServerCertificate(true);
        ds.setSSLProtocol("TLSv1.2");
        return ds;
    }
    public static void ConnectDB(){
        try(Connection conn = DataManager().getConnection()){
            System.out.println("Connection success!");
            //System.out.println(conn.getMetaData());
            CreateTableDB(conn);
        } catch (SQLServerException throwables) {
            throwables.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
