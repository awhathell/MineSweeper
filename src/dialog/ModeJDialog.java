/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import element.StaticElements;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
//import test1.MainFrame;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import operation.RadioButtonListener;
import operation.UserDefinedListener;
import main.MainFrame;
import panel.BackgroundPanel;

/**
 *
 * @author Administrator
 */
public class ModeJDialog extends JDialog {

    private BackgroundPanel panel = null;
    private JLabel JLabelMessage = new JLabel("");

    private ButtonGroup group = new ButtonGroup();
    private JRadioButton JBchu;
    private JRadioButton JBzhong;
    private JRadioButton JBgao;
    private JRadioButton JBself;

    private JTextField TFLength;
    private JTextField TFWidth;
    private JTextField TFBomb;

    private JLabel confirm;
    MainFrame mainFrame;

    public ModeJDialog(final MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        this.setTitle("难度设置");
        this.add(getPanel());
        this.setSize(new Dimension(1116, 750));

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDeactivated(WindowEvent e) {
                mainFrame.reStartGame();
            }

        });
        this.setModal(true);
        this.setVisible(true);
    }

    public JPanel getPanel() {
        RadioButtonListener radioButtonListener = new RadioButtonListener(this, mainFrame);
        group = new ButtonGroup();
        JBchu = new JRadioButton();
        JBzhong = new JRadioButton();
        JBgao = new JRadioButton();
        JBself = new JRadioButton();
        JBchu.setOpaque(false);
        JBzhong.setOpaque(false);
        JBgao.setOpaque(false);
        JBself.setOpaque(false);
        group.add(JBchu);
        group.add(JBzhong);
        group.add(JBgao);
        group.add(JBself);

        TFLength = new JTextField("");
        TFWidth = new JTextField("");
        TFBomb = new JTextField("");

        switch (StaticElements.getLevel()) {
            case 1:
                JBchu.setSelected(true);
                break;
            case 2:
                JBzhong.setSelected(true);
                break;
            case 3:
                JBgao.setSelected(true);
                break;
            default:
                JBself.setSelected(true);
                TFLength.setText(String.valueOf(StaticElements.allcol));
                TFWidth.setText(String.valueOf(StaticElements.allrow));
                TFBomb.setText(String.valueOf(StaticElements.allcount));
        }

        confirm = new JLabel();
        TFLength.setOpaque(false);
        TFLength.setFont(new Font("黑体", Font.BOLD, 20));
        TFLength.setForeground(Color.white);
        TFWidth.setOpaque(false);
        TFWidth.setFont(new Font("黑体", Font.BOLD, 20));
        TFWidth.setForeground(Color.white);
        TFBomb.setOpaque(false);
        TFBomb.setFont(new Font("黑体", Font.BOLD, 20));
        TFBomb.setForeground(Color.white);

        panel = new BackgroundPanel(StaticElements.defined);
        panel.setOpaque(false);
        panel.setLayout(null);

        JBchu.setBounds(80, 210, 22, 30);
        panel.add(JBchu);

        JBzhong.setBounds(80, 340, 22, 30);
        panel.add(JBzhong);
        JBgao.setBounds(80, 470, 22, 30);
        panel.add(JBgao);
        JBself.setBounds(600, 210, 22, 30);
        panel.add(JBself);
        JBself.addItemListener(radioButtonListener);
        JBchu.addItemListener(radioButtonListener);
        JBzhong.addItemListener(radioButtonListener);
        JBgao.addItemListener(radioButtonListener);

        TFLength.setBounds(720, 300, 150, 40);
        panel.add(TFLength);
        TFWidth.setBounds(720, 367, 150, 40);
        panel.add(TFWidth);
        TFBomb.setBounds(720, 435, 150, 40);
        panel.add(TFBomb);
        JLabelMessage.setBounds(590, 270, 600, 20);
        panel.add(JLabelMessage);

        confirm.setIcon(StaticElements.confirm_1);
        confirm.setBounds(270, 600, 600, 90);
        panel.add(confirm);

        UserDefinedListener definedListener = new UserDefinedListener(this, mainFrame);
        confirm.addMouseListener(definedListener);
        return panel;
    }

    public JLabel getJLabelMessage() {
        return JLabelMessage;
    }

    public JTextField getjTextFieldHigh() {
        return TFLength;
    }

    public JTextField getjTextFieldWide() {
        return TFWidth;
    }

    public JTextField getjTextFieldBomb() {
        return TFBomb;
    }

    public JLabel getButtonSure() {
        return confirm;
    }

    public JRadioButton getJRadioButtonSelf() {
        return JBself;
    }

    public JRadioButton getJRadioButtonChu() {
        return JBchu;
    }

    public JRadioButton getJRadioButtonZhong() {
        return JBzhong;
    }

    public JRadioButton getJRadioButtonGao() {
        return JBgao;
    }

}
