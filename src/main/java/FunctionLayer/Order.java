package FunctionLayer;

public class Order {

    private int height;
    private int width;
    private int length;
    private int totalBrick;
    private int Order_ID;

    public Order(int height, int width, int length, int totalBrick, int Order_ID) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.totalBrick = totalBrick;
        this.Order_ID = Order_ID;
    }
    

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTotalBrick() {
        return totalBrick;
    }

    public void setTotalBrick(int totalBrick) {
        this.totalBrick = totalBrick;
    }

    public int getOrder_ID() {
        return Order_ID;
    }

    public void setOrder_ID(int Order_ID) {
        this.Order_ID = Order_ID;
    }
    
    
}

 