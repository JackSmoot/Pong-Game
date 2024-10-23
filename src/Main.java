import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main {

    static JFrame j = new JFrame("Pong Game");

    public static void main(String[] args) {
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        j.setSize(650, 495);
        Game game = new Game();
        j.add(game);
        j.setVisible(true);
        Timer timer = new Timer(33, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.gameLogic();
                game.repaint();
            }
        });
        timer.start();
    }

}