package FunctionLayer;

public class Order {

    private int height;
    private int width;
    private int length;
    private int totalBrick;
    private int User_ID;

    public Order(int height, int width, int length, int totalBrick, int User_ID) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.totalBrick = totalBrick;
        this.User_ID = User_ID;
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

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

 
    
}

 