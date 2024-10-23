import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
public class Game extends JPanel implements MouseMotionListener  {
    static final int WINDOW_WIDTH = 640;
    static final int WINDOW_HEIGHT = 480;
    private Ball gameBall;
    private Paddle userPaddle, pcPaddle;
    private int userMouseY;
    private int userScore, pcScore;
    private int bounceCount=0;
    public Game(){
        gameBall = new Ball(300, 200, 3, 3, 4, 10, Color.YELLOW);
        userPaddle = new Paddle(10, 200, 75, 4, Color.BLUE);
        pcPaddle = new Paddle(610, 200, 75, 4, Color.RED);
        userMouseY = 0;
        userScore = 0; pcScore = 0;
        addMouseMotionListener(this);

    }
    public void paintComponent(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        gameBall.paint(g);
        userPaddle.paint(g);
        pcPaddle.paint(g);
        g.setColor(Color.WHITE);
        g.drawString("Score - User [ " + userScore + " ]   PC [ " + pcScore + " ]", 250, 20   );
    }
    public void reset(){
        try{
            Thread.sleep(1000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        gameBall.setX(300);
        gameBall.setY(200);
        gameBall.setXC(3);
        gameBall.setYC(3);
        gameBall.setSpeed(3);
        bounceCount = 0;
    }

    public void gameLogic(){
        gameBall.moveBall();
        gameBall.bounceOffEdges(0, WINDOW_HEIGHT);
        userPaddle.moveTowards(userMouseY);
        pcPaddle.moveTowards(gameBall.getY());
        if (pcPaddle.checkCollision(gameBall)) {
            gameBall.reverseX();
            bounceCount++;

        }
        if (userPaddle.checkCollision(gameBall)) {
            gameBall.reverseX();
            bounceCount++;

        }
        if (bounceCount == 5){
            bounceCount = 0;
            gameBall.increaseSpeed();
        }
        if(gameBall.getX() < 0){
            pcScore++;
            reset();
        }
        else if(gameBall.getX() > WINDOW_WIDTH){
            userScore++;
            reset();
        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }
}
