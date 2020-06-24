/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operation;

import dialog.ModeJDialog;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import main.MainFrame;
import element.StaticElements;

/**
 *
 * @author Administrator
 */
public class RadioButtonListener implements ItemListener {

    ModeJDialog settingDialog;

    MainFrame mainFrame;

    public RadioButtonListener(ModeJDialog settingDialog, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.settingDialog = settingDialog;

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getItemSelectable() == settingDialog.getJRadioButtonSelf()) {
            settingDialog.getjTextFieldHigh().setEditable(true);
            settingDialog.getjTextFieldHigh().setText(String.valueOf(StaticElements.allcol));
            settingDialog.getjTextFieldWide().setEditable(true);
            settingDialog.getjTextFieldWide().setText(String.valueOf(StaticElements.allrow));
            settingDialog.getjTextFieldBomb().setEditable(true);
            settingDialog.getjTextFieldBomb().setText(String.valueOf(StaticElements.allcount));
        } else {
            settingDialog.getjTextFieldHigh().setEditable(false);
            settingDialog.getjTextFieldHigh().setText("");
            settingDialog.getjTextFieldWide().setEditable(false);
            settingDialog.getjTextFieldWide().setText("");
            settingDialog.getjTextFieldBomb().setEditable(false);
            settingDialog.getjTextFieldBomb().setText("");
        }
    }
}
