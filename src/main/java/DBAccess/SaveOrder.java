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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artin
 */
public class SaveOrder {
    
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
}
