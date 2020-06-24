package panel;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JFrame;
/*import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;*/

import dialog.InfoJDialog;
import dialog.ListDialog;
//import dialog.ListDialog;
//import dialog.DefinedJDialog;
import dialog.ModeJDialog;
import dialog.ScoreJDialog;

import element.StaticElements;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
//import panel.FaceJPanel;

import main.MainFrame;

public class OptionJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        //public FaceJPanel faceJPanel = new FaceJPanel(this.mainFrame);
	//JMenu menuGame = new JMenu("游戏(G)");

	//JMenu menuHelp = new JMenu("帮助(H)");

	JButton btStart = new JButton("开始游戏");
        JButton btMode = new JButton("难度设置");
        JButton btScore = new JButton("排行榜");
        JButton btAbout = new JButton("关于");
	//JMenuItem menuItemC = new JMenuItem("初级");

	//JMenuItem menuItemZ = new JMenuItem("中级");

	//JMenuItem menuItemG = new JMenuItem("高级");

	//JMenuItem menuHeroC = new JMenuItem("初级英雄榜");
	//JMenuItem menuHeroZ = new JMenuItem("中级英雄榜");
	//JMenuItem menuHeroG = new JMenuItem("高级英雄榜");
	//JMenuItem menuItemCustom = new JMenuItem("自定义");
	//JMenuItem menuItemExit = new JMenuItem("退出");

	
        
	//JMenuItem menuItemHole = new JMenuItem("后门进入");

	MainFrame mainFrame;

	public OptionJPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
                this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                btStart.setSize(320,85);
                btMode.setSize(320,85);
                btScore.setSize(320,85);
                btAbout.setSize(320,85);
               /* faceJPanel.setSize(320,85);
                btStart.setLocation(0, 330);
                btMode.setLocation(0, 415);
                btScore.setLocation(0, 500);
                btAbout.setLocation(0, 585);
                faceJPanel.setLocation(0, 245);*/
                btStart.setIcon(StaticElements.button_1[0]);
                btMode.setIcon(StaticElements.button_1[1]);
                btScore.setIcon(StaticElements.button_1[2]);
                btAbout.setIcon(StaticElements.button_1[3]);
		init();
	}
        /*public FaceJPanel getFaceJPanel() {
		return faceJPanel;
	}*/
	private void init() {
		//menuGame.setMnemonic('G');// 设置快捷键 alt+ G 才会有效果
		//menuHelp.setMnemonic('H');
		// 菜单项加入到菜单
		//menuGame.add(menuItemStart);
                
		btStart.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        mainFrame.reStartGame();                   
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                       // btStart.setIcon(new ImageIcon("./image/button1_2.png"));//To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        btStart.setIcon(StaticElements.button_1[0]); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btStart.setIcon(StaticElements.button_2[0]);                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btStart.setIcon(StaticElements.button_1[0]);  //To change body of generated methods, choose Tools | Templates.
                    }
		});
                btMode.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new ModeJDialog(mainFrame);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                       // btMode.setIcon(new ImageIcon("./image/button2_2.png")); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        btMode.setIcon(StaticElements.button_1[1]); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btMode.setIcon(StaticElements.button_2[1]); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btMode.setIcon(StaticElements.button_1[1]); //To change body of generated methods, choose Tools | Templates.
                    }
                
                });
                btScore.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new ListDialog(mainFrame);                    
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                      //  btScore.setIcon(new ImageIcon("./image/button3_2.png")); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        btScore.setIcon(StaticElements.button_1[2]);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btScore.setIcon(StaticElements.button_2[2]); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        btScore.setIcon(StaticElements.button_1[2]);
                    }
		});

		//menuGame.addSeparator();// 菜单加入分割线

		/*menuGame.add(menuItemC);
		menuItemC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticElements.allrow = 9;
				StaticElements.allcol = 9;
				StaticElements.allcount = 10;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemZ);
		menuItemZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticElements.allrow = 16;
				StaticElements.allcol = 16;
				StaticElements.allcount = 40;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemG);
		menuItemG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticElements.allrow = 16;
				StaticElements.allcol = 30;
				StaticElements.allcount = 99;
				mainFrame.reStartGame();
			}
		});
		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuItemCustom);
		menuItemCustom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DefinedJDialog(mainFrame);

			}
		});

		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuHero);
		menuHero.add(menuHeroC);
		menuHeroC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListDialog(1, mainFrame);

			}
		});
		menuHero.add(menuHeroZ);
		menuHeroZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListDialog(2, mainFrame);

			}
		});
		menuHero.add(menuHeroG);
		menuHeroG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ListDialog(3, mainFrame);

			}
		});*/

		//menuGame.addSeparator();// 菜单加入分割线
		//menuGame.add(menuItemExit);
		/*menuItemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);

			}
		});*/

		//menuHelp.add(menuItemAbout);
		btAbout.addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new InfoJDialog(mainFrame);                    
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                       btAbout.setIcon(StaticElements.button_1[3]);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        btAbout.setIcon(StaticElements.button_2[3]); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        btAbout.setIcon(StaticElements.button_1[3]);
//   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
		});
		//menuHelp.add(menuItemHole);
		/*menuItemHole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StaticElements.isHole = true;

			}
		});*/
		// 菜单加入到菜单条
               // this.add(faceJPanel);
		this.add(btStart);
                this.add(btMode);
                this.add(btScore);
		this.add(btAbout);

	}


}
