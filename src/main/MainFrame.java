package main;

//import java.awt.BorderLayout;
//import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
//import panel.optionJPanel2;
import panel.OptionJPanel;
//import panel.BombJPanel;
//import panel.FaceJPanel;
import timer.TimerListener;
import element.StaticElements;
import java.awt.Image;
import java.awt.Color;
//import javafx.scene.paint.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import panel.BombJPanel;
import panel.FaceJPanel;

public class MainFrame extends JFrame {

    /**
     * main
     *
     */
    private static final long serialVersionUID = 1L;

    //private ImageIcon image = new ImageIcon("./image/bg.png");
    // private JLabel jp=new JLabel(image);
    public OptionJPanel optionJPanel;

    private FaceJPanel faceJPanel;

    private BombJPanel bombJPanel;

    private TimerListener timerListener = new TimerListener(this);

    private Timer timer = new Timer(1000, timerListener);

    public MainFrame() {

        new StaticElements();
        // this.getLayeredPane().add(jp, new Integer(Integer.MIN_VALUE));
        this.setIconImage(StaticElements.imageIcon.getImage());
        this.setTitle("É¨À×");

        //this.setSize(new Dimension(1000, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setResizable(false);

        this.setSize(1300, 1000);
        // this.setBackground(Color.yellow);
        this.setLayout(null);
        init();

        //this.setIconImage(new Image("./image/bg.png"));
        optionJPanel.setSize(305, 375);
        faceJPanel.setSize(200, 60);
        bombJPanel.setSize(StaticElements.allcol * 65, StaticElements.allrow * 65);
        faceJPanel.setLocation(60, 270);
        // faceJPanel.setBackground(new Color(28, 60, 44));
        optionJPanel.setLocation(0, 330);
        bombJPanel.setLocation(400 + 450 - StaticElements.allcol * 65 / 2, 500 - StaticElements.allrow * 65 / 2);
        //this.pack();
        this.getContentPane().setBackground(new Color(28, 60, 44));
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void init() {
        optionJPanel = new OptionJPanel(this);
        faceJPanel = new FaceJPanel(this);
        bombJPanel = new BombJPanel(this);
        this.add(faceJPanel);
        this.add(optionJPanel);
        this.add(bombJPanel);

    }

    public void reStartGame() {

        this.remove(faceJPanel);
        this.remove(bombJPanel);
        new StaticElements();
        StaticElements.bombCount = StaticElements.allcount;
        StaticElements.timecount = 0;
        StaticElements.isStart = false;
        bombJPanel = new BombJPanel(this);
        faceJPanel = new FaceJPanel(this);
        faceJPanel.setSize(200, 60);
        faceJPanel.setLocation(60, 270);
        if (StaticElements.allcol <= 9 && StaticElements.allrow <= 9) {
            int w = StaticElements.allcol * 65;
            int l = StaticElements.allrow * 65;
            bombJPanel.setSize(w, l);
            bombJPanel.setLocation(400 + 450 - w / 2, 500 - l / 2);
        } else if (StaticElements.allcol <= 16 && StaticElements.allrow <= 16) {
            int w = StaticElements.allcol * 45;
            int l = StaticElements.allrow * 45;
            bombJPanel.setSize(w, l);
            bombJPanel.setLocation(400 + 450 - w / 2, 500 - l / 2);
        } else {
            int w = StaticElements.allcol * 26;
            int l = StaticElements.allrow * 26;
            bombJPanel.setSize(w, l);
            bombJPanel.setLocation(400 + 450 - w / 2, 500 - l / 2);
        }
        this.add(faceJPanel);
        this.add(bombJPanel);
        //this.pack();
        this.revalidate();
        this.repaint();

        getTimer().stop();

    }

    public FaceJPanel getFaceJPanel() {
        return faceJPanel;
    }

    public BombJPanel getBombJPanel() {
        return bombJPanel;
    }

    public Timer getTimer() {
        return timer;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

        new MainFrame();

    }
}
