package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User( email, password, role );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


public List<Order> getOrder() throws ClassNotFoundException  {
        ArrayList<Order> orders = new ArrayList<>();
        String SQL = "SELECT * FROM ORDER";

       
        int height = 0;
        int length = 0;
        int width = 0;
        int totalBrick = 0;
        int Order_ID =0;

        try {
           Connection con = Connector.connection();
           PreparedStatement ps = con.prepareStatement( SQL );
           ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                totalBrick = rs.getInt("totalBrick");
                height = rs.getInt("Height");
                length = rs.getInt("Length");
                width = rs.getInt("Width");
                Order_ID = rs.getInt("Order_ID");

                orders.add(new Order(Order_ID,totalBrick, height, length, width));
            }
        } catch (SQLException ex) {

        }
        return orders;
    }

}




    
