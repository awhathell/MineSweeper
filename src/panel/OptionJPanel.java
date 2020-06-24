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
	//JMenu menuGame = new JMenu("��Ϸ(G)");

	//JMenu menuHelp = new JMenu("����(H)");

	JButton btStart = new JButton("��ʼ��Ϸ");
        JButton btMode = new JButton("�Ѷ�����");
        JButton btScore = new JButton("���а�");
        JButton btAbout = new JButton("����");
	//JMenuItem menuItemC = new JMenuItem("����");

	//JMenuItem menuItemZ = new JMenuItem("�м�");

	//JMenuItem menuItemG = new JMenuItem("�߼�");

	//JMenuItem menuHeroC = new JMenuItem("����Ӣ�۰�");
	//JMenuItem menuHeroZ = new JMenuItem("�м�Ӣ�۰�");
	//JMenuItem menuHeroG = new JMenuItem("�߼�Ӣ�۰�");
	//JMenuItem menuItemCustom = new JMenuItem("�Զ���");
	//JMenuItem menuItemExit = new JMenuItem("�˳�");

	
        
	//JMenuItem menuItemHole = new JMenuItem("���Ž���");

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
		//menuGame.setMnemonic('G');// ���ÿ�ݼ� alt+ G �Ż���Ч��
		//menuHelp.setMnemonic('H');
		// �˵�����뵽�˵�
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

		//menuGame.addSeparator();// �˵�����ָ���

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
		menuGame.addSeparator();// �˵�����ָ���
		menuGame.add(menuItemCustom);
		menuItemCustom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DefinedJDialog(mainFrame);

			}
		});

		menuGame.addSeparator();// �˵�����ָ���
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

		//menuGame.addSeparator();// �˵�����ָ���
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
		// �˵����뵽�˵���
               // this.add(faceJPanel);
		this.add(btStart);
                this.add(btMode);
                this.add(btScore);
		this.add(btAbout);

	}


}
