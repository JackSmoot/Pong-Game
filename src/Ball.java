import java.awt.*;
public class Ball {
    private int x, y, xc, yc, speed, size;
    private Color color;
    static final int MAX_SPEED = 7;

    public Ball (int x, int y, int xc, int yc, int speed, int size, Color color) {
        this.x = x;
        this.y = y;
        this.xc = xc;
        this.yc = yc;
        this.speed = speed;
        this.size = size;
        this.color = color;
    }
    public void paint(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }
    public void moveBall(){
        x += xc;
        y += yc;
    }
    public void bounceOffEdges(int top, int bottom){
        if (y > bottom - size){
            reverseY();
        }
        else if(y < top){
            reverseY();
        }

    }
    public void reverseX(){
        xc *= -1;
    }
    public void reverseY(){
        yc *= -1;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public int getSize() {
        return size;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y=y;
    }
    public void setXC(int xc) {
        this.xc=xc;
    }
    public void setYC(int yc) {
        this.yc=yc;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void increaseSpeed() {
        if(speed < MAX_SPEED){
            speed ++;

            xc = (xc / Math.abs(xc)*speed);
            yc = (yc / Math.abs(yc)*speed);

        }
    }
}
