package element;

import java.awt.Image;
import java.util.TreeSet;
import javax.swing.ImageIcon;

import ranking.Player;

public class StaticElements {
    
    public static int allcount = 10;
    public static int allcol = 9;
    public static int allrow = 9;
    public static int timecount = 0;
    public static int bombCount = allcount;
    
    public static boolean isStart = false;
    
    public static ImageIcon[] num = new ImageIcon[7];
    public static ImageIcon[] time = new ImageIcon[10];
    
    public static ImageIcon imageIcon;
    public static ImageIcon blankIcon;
    public static ImageIcon bloodIcon;
    public static ImageIcon flagIcon;
    public static ImageIcon askIcon;
    public static ImageIcon errorBombIcon;
    public static ImageIcon bombIcon;
    
    public static ImageIcon[] button_1 = new ImageIcon[4];
    public static ImageIcon[] button_2 = new ImageIcon[4];
    public static ImageIcon confirm_1;
    public static ImageIcon confirm_2;
    
    public static ImageIcon background;
    public static ImageIcon defined;
    public static ImageIcon info;
    public static ImageIcon board;
    
    public StaticElements() {
        int n;
        if (allcol <= 9 && allrow <= 9) {
            n = 65;
        } else if (allcol <= 16 && allrow <= 16) {
            n = 45;
        } else {
            n = 26;
        }
        
        imageIcon = new ImageIcon("./image/icon.gif");
        
        blankIcon = new ImageIcon("./image/bricks/blank.png");
        blankIcon.setImage(blankIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        bloodIcon = new ImageIcon("./image/bricks/blood.png");
        bloodIcon.setImage(bloodIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        flagIcon = new ImageIcon("./image/bricks/flag.png");
        flagIcon.setImage(flagIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        askIcon = new ImageIcon("./image/bricks/ask.png");
        askIcon.setImage(askIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        bombIcon = new ImageIcon("./image/bricks/mine1.png");
        bombIcon.setImage(bombIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        errorBombIcon = new ImageIcon("./image/bricks/mine2.png");
        errorBombIcon.setImage(errorBombIcon.getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        
        confirm_1 = new ImageIcon("./image/buttons/confirm_1.png");
        //confirm_1.setImage(confirm_1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        confirm_2 = new ImageIcon("./image/buttons/confirm_2.png");
        //confirm_2.setImage(confirm_2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));

        background = new ImageIcon("./image/frames/background.png");
        //background.setImage(background.getImage());

        defined = new ImageIcon("./image/frames/defined.png");
        //defined.setImage(defined.getImage());

        info = new ImageIcon("./image/frames/info.png");
        //info.setImage(info.getImage());

        board = new ImageIcon("./image/frames/leaderboard.png");
        //board.setImage(board.getImage());

        for (int i = 0; i < button_1.length; i++) {
            button_1[i] = new ImageIcon("./image/buttons/button" + String.valueOf(i + 1) + "_1.png");
            //button_1[i].setImage(button_1[i].getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        }
        
        for (int i = 0; i < button_2.length; i++) {
            button_2[i] = new ImageIcon("./image/buttons/button" + String.valueOf(i + 1) + "_2.png");
            //button_2[i].setImage(button_2[i].getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        }
        
        for (int i = 0; i < num.length; i++) {
            num[i] = new ImageIcon("./image/bricks/" + i + ".png");
            num[i].setImage(num[i].getImage().getScaledInstance(n, n, Image.SCALE_DEFAULT));
        }
        for (int j = 0; j < time.length; j++) {
            time[j] = new ImageIcon("./image/bar/d" + j + ".png");
        }
    }
    
    public static TreeSet<Player> treeSetC = new TreeSet<Player>();
    public static TreeSet<Player> treeSetZ = new TreeSet<Player>();
    public static TreeSet<Player> treeSetG = new TreeSet<Player>();
    
    public static int getLevel() {
        if (allrow == 9 && allcol == 9 && allcount == 10) {
            return 1;
        } else if (allrow == 16 && allcol == 16 && allcount == 40) {
            return 2;
        } else if (allrow == 16 && allcol == 30 && allcount == 99) {
            return 3;
        } else {
            return 0;
        }
    }
    
}
