package sample;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements DatabaseInterface{
    java.sql.Connection con;

    public DatabaseService(Connection con) {
        this.con = con;
    }

    @Override
    public void add(savingstable data) throws ClassNotFoundException, SQLException {
        String quer1 = "INSERT INTO savingstable VALUES ( ?, ?, ?, ?, ?)";
        PreparedStatement query = con.prepareStatement(quer1);


        query.setString(1, data.getCustno());
        query.setString(2, data.getCustname());
        query.setDouble(3, data.getCdep());
        query.setInt(4, data.getNyears());
        query.setString(5, data.getSavtype());



        query.executeUpdate();
    }

    @Override
    public savingstable edit(savingstable data, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update savingstable set custno=?, custname=?, cdep=?,nyears=?,savtype=? where custno = ?");
        query.setString(1, data.getCustno());
        query.setString(2, data.getCustname());
        query.setDouble(3, data.getCdep());
        query.setInt(4, data.getNyears());
        query.setString(5, data.getSavtype());
        query.setString(6, custno);

        query.executeUpdate();




        return data;

    }

    @Override
    public void delete(String custno) throws SQLException {
        String quer1 = "Delete from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();

    }

    @Override
    public List<savingstable> display() throws ClassNotFoundException, SQLException {
        List<savingstable> savingstableList = new ArrayList<savingstable>();

        String quer1 = "Select * from savingstable";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        savingstable obj1;



        while (rs.next()) {

            obj1 = new savingstable(rs.getString("custno"), rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));

            savingstableList.add(obj1);
        }


        return savingstableList;
    }

    public savingstable search(String custno) throws SQLException,ClassNotFoundException {



        String quer1 = "Select * from savingstable where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);



        ResultSet rs = query.executeQuery();



        if(!rs.first()){

            System.out.print("Record not existing");
            return null;
        }


        savingstable obj1=null;




        obj1 = new savingstable(rs.getString("custno"), rs.getString("custname"),rs.getDouble("cdep"),rs.getInt("nyears"),rs.getString("savtype"));

        return obj1;






    }
    public List<Items> display2(String custno) throws ClassNotFoundException, SQLException {

        List<Items> Itemlist = new ArrayList<Items>();

        String quer1 = "Select itemcustno,itemcustname,itemcdep,itemnyears,itemnyears,itemsavtype from items where custno=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        ResultSet rs = query.executeQuery();

        Items obj2;



        while (rs.next()) {


            obj2 = new Items(rs.getString("itemcustno"),rs.getString("itemcustname"),rs.getDouble("itemcdep"),rs.getInt("itemnyears"),rs.getString("itemsavtype"));





            Itemlist.add(obj2);
        }


        return Itemlist;



    }
}
