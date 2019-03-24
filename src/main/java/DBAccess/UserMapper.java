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
    
    
public static List<Order> getOrders(User user)
      {
        List<Order> orders = new ArrayList<>();
         try
          {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM legohouse.Order WHERE User_id = ?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
              {
                int id = rs.getInt("id");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Order order = new Order(id, length, width, height);
                orders.add(order);
              }
            
          } catch (ClassNotFoundException | SQLException ex)
          {
            ex.printStackTrace();
          }
         return orders;
      }

    public static void createOrder(User user, int length, int width, int height)
      {
        try
          {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO legohouse.Order (length, width, height, User_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, length);
            ps.setInt(2, width);
            ps.setInt(3, height);
            ps.setInt(4, user.getId());
            ps.executeUpdate();
          } catch (ClassNotFoundException | SQLException ex)
          {
            ex.printStackTrace();
          }
      }

    }


