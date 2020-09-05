package game;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameFrame extends JFrame {
    
    JLabel scoreLabel;
    JLabel infoLabel;
    
    GameFrame() {
        scoreLabel = new JLabel("0");
        scoreLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        add(scoreLabel, BorderLayout.SOUTH);
        
        infoLabel = new JLabel("");
        infoLabel.setHorizontalAlignment(SwingConstants.LEFT);
        add(infoLabel, BorderLayout.NORTH);
        
        setTitle("Tetris");
        setSize(200, 400);
        setVisible(true);        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Board board = new Board(this);        
        add(board);
        board.start();
    }    
    
    public static void main(String[] args) {
        GameFrame game = new GameFrame();        
    }
}
