/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 有背景图片的Panel类
 */
public class BackgroundPanel extends JPanel {

    /**
     *
     *
     */
    private Image image;

    public BackgroundPanel(ImageIcon imageIcon) {

        image = imageIcon.getImage();
    }

    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件  
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
