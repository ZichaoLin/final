package sample;



import java.sql.SQLException;
import java.util.List;

public interface DatabaseInterface {
    public void add(savingstable data) throws ClassNotFoundException, SQLException;
    public savingstable edit(savingstable data, String custno) throws SQLException, ClassNotFoundException;
    public void delete(String custno) throws SQLException;
    public List<savingstable> display() throws ClassNotFoundException, SQLException;
}
