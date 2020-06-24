package operation;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import main.MainFrame;
import panel.OptionJPanel;

import element.StaticElements;

import ranking.Player;
import element.Brick;

public class BricksListener implements MouseListener {

    Brick[][] mineLable;
    MainFrame mainFrame;
    private boolean isDoublePress = false;

    public BricksListener(Brick[][] mineLable, MainFrame mainFrame) {
        this.mineLable = mineLable;
        this.mainFrame = mainFrame;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Brick mineLable = (Brick) e.getSource();

        int row = mineLable.getRowx();
        int col = mineLable.getColy();

        if (e.getModifiers() == InputEvent.BUTTON1_MASK
                && mineLable.isFlagTag() == false) {
            if (mineLable.isExpendTag() == false) {
                mineLable.setIcon(StaticElements.num[0]);

            }
            /*mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticElements.clickIcon);*/
        } else if (e.getModifiers() == InputEvent.BUTTON3_MASK
                && mineLable.isExpendTag() == false) {
            if (mineLable.getRightClickCount() == 0) {
                mineLable.setIcon(StaticElements.flagIcon);
                mineLable.setRightClickCount(1);
                mineLable.setFlagTag(true);
                StaticElements.bombCount--;
                mainFrame.getFaceJPanel().setNumber(StaticElements.bombCount);

            } else if (mineLable.getRightClickCount() == 1) {
                mineLable.setIcon(StaticElements.askIcon);
                mineLable.setRightClickCount(2);
                mineLable.setFlagTag(false);
                StaticElements.bombCount++;
                mainFrame.getFaceJPanel().setNumber(StaticElements.bombCount);

            } else {
                mineLable.setIcon(StaticElements.blankIcon);
                mineLable.setRightClickCount(0);
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        Brick mineLable = (Brick) e.getSource();
        int row = mineLable.getRowx();
        int col = mineLable.getColy();
        if (isDoublePress) {
            isDoublePress = false;
            if (mineLable.isExpendTag() == false
                    && mineLable.isFlagTag() == false) {
                backIcon(row, col);
            } else {

                boolean isEquals = isEquals(row, col);
                if (isEquals) {
                    doubleExpend(row, col);
                } else {
                    backIcon(row, col);

                }

            }
            /*mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticElements.smileIcon);*/

        } else if (e.getModifiers() == InputEvent.BUTTON1_MASK
                && mineLable.isFlagTag() == false) {
            if (StaticElements.isStart == false) {
                LayBomb.lay(this.mineLable, row, col);

                StaticElements.isStart = true;

            }
            

            if (mineLable.isMineTag() == true) {

                bombAction(row, col);

                mineLable.setIcon(StaticElements.bloodIcon);
                /*mainFrame.getFaceJPanel().getLabelFace()
						.setIcon(StaticElements.faultFaceIcon);*/
            } else {
                /*mainFrame.getFaceJPanel().getLabelFace()
						.setIcon(StaticElements.smileIcon);*/
                expand(row, col);

            }

        }
        mainFrame.getTimer().start();
        isWin();
    }

    private void bombAction(int row, int col) {

        for (int i = 0; i < mineLable.length; i++) {
            for (int j = 0; j < mineLable[i].length; j++) {
                if (mineLable[i][j].isMineTag()) {
                    if (mineLable[i][j].isFlagTag() == false) {
                        mineLable[i][j].setIcon(StaticElements.bombIcon);
                    }
                } else {
                    if (mineLable[i][j].isFlagTag()) {
                        mineLable[i][j].setIcon(StaticElements.errorBombIcon);
                    }
                }
            }

        }

        mainFrame.getTimer().stop();

        for (int i = 0; i < mineLable.length; i++) {
            for (int j = 0; j < mineLable[i].length; j++) {
                mineLable[i][j].removeMouseListener(this);

            }
        }

    }

    private void expand(int x, int y) {

        int count = mineLable[x][y].getCounAround();

        if (mineLable[x][y].isExpendTag() == false
                && mineLable[x][y].isFlagTag() == false) {

            if (count == 0) {
                mineLable[x][y].setIcon(StaticElements.num[count]);
                mineLable[x][y].setExpendTag(true);
                for (int i = Math.max(0, x - 1); i <= Math.min(
                        mineLable.length - 1, x + 1); i++) {
                    for (int j = Math.max(0, y - 1); j <= Math.min(
                            mineLable[x].length - 1, y + 1); j++) {
                        expand(i, j);

                    }

                }

            } else {

                mineLable[x][y].setIcon(StaticElements.num[count]);
                mineLable[x][y].setExpendTag(true);

            }

        }

    }

    private void backIcon(int i, int j) {
        for (int x = Math.max(0, i - 1); x <= Math.min(StaticElements.allrow - 1,
                i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(StaticElements.allcol - 1, j + 1); y++) {
                if (mineLable[x][y].isFlagTag() == false
                        && mineLable[x][y].isExpendTag() == false) {
                    int rightClickCount = mineLable[x][y].getRightClickCount();
                    if (rightClickCount == 2) {
                        mineLable[x][y].setIcon(StaticElements.askIcon);
                    } else {
                        mineLable[x][y].setIcon(StaticElements.blankIcon);

                    }
                }
            }
        }

    }

    private boolean isEquals(int i, int j) {
        int count = mineLable[i][j].getCounAround();
        int flagCount = 0;
        for (int x = Math.max(0, i - 1); x <= Math.min(StaticElements.allrow - 1,
                i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(StaticElements.allcol - 1, j + 1); y++) {
                if (mineLable[x][y].isFlagTag()) {
                    flagCount++;
                }
            }
        }
        if (count == flagCount) {
            return true;
        }
        return false;
    }

    private void doublePress(int i, int j) {
        for (int x = Math.max(0, i - 1); x <= Math.min(StaticElements.allrow - 1,
                i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(StaticElements.allcol - 1, j + 1); y++) {
                if (mineLable[x][y].isExpendTag() == false
                        && mineLable[x][y].isFlagTag() == false) {
                    int rightClickCount = mineLable[x][y].getRightClickCount();
                    if (rightClickCount == 1) {
                        //mineLable[x][y].setIcon(StaticElements.askPressIcon);

                    } else {
                        mineLable[x][y].setIcon(StaticElements.num[0]);

                    }
                }
            }
        }
    }

    private void doubleExpend(int i, int j) {
        for (int x = Math.max(0, i - 1); x <= Math.min(StaticElements.allrow - 1,
                i + 1); x++) {
            for (int y = Math.max(0, j - 1); y <= Math.min(StaticElements.allcol - 1, j + 1); y++) {
                if (mineLable[x][y].isMineTag()) {
                    if (mineLable[x][y].isFlagTag() == false) {
                        bombAction(x, y);

                    }
                } else {

                    if (mineLable[x][y].isFlagTag() == false) {
                        expand(x, y);
                    }

                }

            }
        }

    }

    private void isWin() {

        int needCount = StaticElements.allrow * StaticElements.allcol
                - StaticElements.allcount;
        int expendCount = 0;
        for (int i = 0; i < mineLable.length; i++) {
            for (int j = 0; j < mineLable[i].length; j++) {
                if (mineLable[i][j].isExpendTag()) {
                    expendCount++;
                }

            }

        }
        if (needCount == expendCount) {
            for (int i = 0; i < mineLable.length; i++) {
                for (int j = 0; j < mineLable[i].length; j++) {
                    if (mineLable[i][j].isMineTag()
                            && mineLable[i][j].isFlagTag() == false) {
                        mineLable[i][j].setIcon(StaticElements.flagIcon);
                        mineLable[i][j].setFlagTag(true);
                    }

                }

            }

            mainFrame.getFaceJPanel().setNumber(0);
            mainFrame.getTimer().stop();
            for (int i = 0; i < mineLable.length; i++) {
                for (int j = 0; j < mineLable[i].length; j++) {
                    mineLable[i][j].removeMouseListener(this);

                }
            }

            /*mainFrame.getFaceJPanel().getLabelFace()
					.setIcon(StaticElements.winFaceIcon);*/
            int level = StaticElements.getLevel();
            if (level != 0) {
                if (level == 1) {
                    String name = JOptionPane.showInputDialog(mainFrame,
                            "好厉害！初级扫雷完成，请留下大名！");
                    if (name != null) {
                        StaticElements.treeSetC.add(new Player(
                                StaticElements.timecount, name));
                    }
                } else if (level == 2) {
                    String name = JOptionPane.showInputDialog(mainFrame,
                            "好厉害！中级扫雷完成，请留下大名！");
                    if (name != null) {
                        StaticElements.treeSetZ.add(new Player(
                                StaticElements.timecount, name));
                    }
                } else if (level == 3) {
                    String name = JOptionPane.showInputDialog(mainFrame,
                            "好厉害！高级扫雷完成，请留下大名！");
                    if (name != null) {
                        StaticElements.treeSetG.add(new Player(
                                StaticElements.timecount, name));
                    }
                }

            }

        }

    }

}
