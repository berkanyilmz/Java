package mp3player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

public class PlayerUI extends JFrame{
    
    private JFrame frame;
    private JPanel areaOfMusics, playingMusic;
    private JButton[] musicButtons;
    private JLabel musicNameLabel;
    private JScrollPane scrollPane;
    String path;
    String musicFiles[];
    String status;
    AudioInputStream audioInputStream;
    Clip clip;
    
    public PlayerUI() {
        super("MP3 Player");
        path = "Your path of files of music";
        status = "not play";
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 1));
        this.setBounds(500, 100, 500, 500);
        this.setResizable(false);
        this.setVisible(true);
    }
    
    public void initComponents() {
        areaOfMusics = new JPanel();
        playingMusic = new JPanel();
        
        playingMusic.setLayout(new GridLayout(1, 2));

        //playingMusic.setBackground(Color.BLUE);
        //areaOfMusics.setBackground(Color.red);

        add(playingMusic);

        musicNameLabel = new JLabel("Playing sound : ");
        playingMusic.add(musicNameLabel);

        musicFiles = FileHelper.getFile(path).list();
        areaOfMusics.setLayout(new GridLayout(musicFiles.length, 1));
        musicButtons = new JButton[musicFiles.length];
        for (int i = 0; i < musicFiles.length; i++) {
            musicButtons[i] = new JButton(musicFiles[i]);
            areaOfMusics.add(musicButtons[i]);
            int temp = i;
            musicButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    musicNameLabel.setText("Playing Sound : " + musicFiles[temp]);
                    play(musicFiles[temp]);
                }
            });
        }

        scrollPane = new JScrollPane(areaOfMusics);
        add(scrollPane);

    }

    public void playButtonActionPerformed(ActionEvent event) {
        musicNameLabel.setText("Playing Sound : " + musicFiles[0]);
        play(musicFiles[0]);
    }

    public void play(String musicName) {
        try {
            if (clip != null) {
                clip.stop();
                clip.close();
                audioInputStream = AudioSystem.getAudioInputStream(new File(path + musicName));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                audioInputStream = AudioSystem.getAudioInputStream(new File(path + musicName));
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }

        } catch (Exception e) {
            System.out.println("Error Message : " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        PlayerUI player = new PlayerUI();
    }
    
}
