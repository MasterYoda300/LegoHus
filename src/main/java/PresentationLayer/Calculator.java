package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends Command {

    public int calculater(int height, int width, int length)
    {
      
       int bricks = ((length*2)+((width-4)*2))*height;
       return bricks;
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        Calculator calc= new Calculator();
        int height = Integer.parseInt(request.getParameter("Height"));
        int width = Integer.parseInt(request.getParameter("Width"));
        int length = Integer.parseInt(request.getParameter("Length"));
        int bricks = calc.calculater(height, width, length);
        Order Order1 = new Order(height,width,length,bricks);
        
        request.setAttribute("Order", Order1);
        return "placeOrder";
    }

}
