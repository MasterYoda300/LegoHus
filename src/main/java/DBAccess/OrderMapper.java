/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author artin
 */
public class OrderMapper {
    // tester nye metoede view order virker ikke!
public static void createOrder( Order order) throws SQLException, ClassNotFoundException, Exception {
            try {
                //Connector connect = new Connector();
                Connection connect = Connector.connection();

                String addOrder
                        = "INSERT INTO legoDB.Orders (`User_ID`, `Length`, `Width`, `Height`) "
                        + "VALUES(?,?,?,?);";

                PreparedStatement ps = connect.prepareStatement(addOrder);
                ps.setInt(1, order.getUser_ID());
                ps.setInt(2, order.getLength());
                ps.setInt(3, order.getWidth());
                ps.setInt(4, order.getHeight());
                
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

   
    public static List<Order> getOrders(User user) {
        List<Order> orders = new ArrayList<>();
        
        
        
        return orders;
    }
}
