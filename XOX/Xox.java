package my.xox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Xox extends JFrame{

    private JButton[][] buttons;
    private boolean[][] isFill;
    String player;

    public Xox() {
        super("XOX");
        player = "X";
        isFill = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                isFill[i][j] = false;
            }
        }
        initComponents();
        this.setBounds(100, 100, 600, 600);
        this.setLayout(new GridLayout(3, 3));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public void initComponents() {
        buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                add(buttons[i][j]);
                int tempi = i;
                int tempj = j;
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        play(tempi, tempj);
                    }
                });
            }
        }
    }

    public void play(int i, int j) {
        if (player.equals("X") && isFill[i][j] == false) {
            buttons[i][j].setText("X");
            control();
            isFill[i][j] = true;
            player = "O";
        } else if (isFill[i][j] == false){
            buttons[i][j].setText("O");
            control();
            isFill[i][j] = true;
            player = "X";
        }
    }

    public void control() {
        //control the column and rows
        for (int i = 0; i < 3; i++) {
            // for column
            if (buttons[i][0].getText().equals(player) && buttons[i][1].getText().equals(player) && buttons[i][2].getText().equals(player)) {
                buttons[i][0].setBackground(Color.RED);
                buttons[i][1].setBackground(Color.RED);
                buttons[i][2].setBackground(Color.RED);
                winnerPlayer(player);
            }
            // for rows
            if (buttons[0][i].getText().equals(player) && buttons[1][i].getText().equals(player) && buttons[2][i].getText().equals(player)) {
                buttons[0][i].setBackground(Color.RED);
                buttons[1][i].setBackground(Color.RED);
                buttons[2][i].setBackground(Color.RED);
                winnerPlayer(player);
            }
        }

        if (buttons[0][0].getText().equals(player) && buttons[1][1].getText().equals(player) && buttons[2][2].getText().equals(player)) {
            buttons[0][0].setBackground(Color.RED);
            buttons[1][1].setBackground(Color.RED);
            buttons[2][2].setBackground(Color.RED);
            winnerPlayer(player);
        }
    }

    public void winnerPlayer(String winner) {
        System.out.println("Winner player : " + player);
        JOptionPane.showMessageDialog(null, "Winner Player " + player, "Winner Player", JOptionPane.OK_OPTION);
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                isFill[i][j] = true;
            }
        }
    }

    public static void main(String[] args) {
        Xox xox = new Xox();
    }
}
