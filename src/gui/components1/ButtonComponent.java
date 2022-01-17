/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components1;

import gui.GuiApp;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonComponent extends JPanel{
    private JButton button;
    
    public ButtonComponent(String text, int widthWindow, int heightPanel, int widthButton, int heightButton) {
        initComponents(text, widthWindow, heightPanel, widthButton, heightButton);
    }

    private void initComponents(String text, int widthWindow, int heightPanel, int widthButton, int heightButton) {
       this.setPreferredSize(new Dimension(widthWindow, heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());
       this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
       
       this.add(Box.createRigidArea(new Dimension((widthWindow/2) - (widthButton/2), 0)));
       
       button = new JButton(text);
       button.setPreferredSize(new Dimension(widthButton, 27));
       button.setMinimumSize(button.getPreferredSize());
       button.setMaximumSize(button.getPreferredSize());
       this.add(button);
    }

    public JButton getButton() {
        return button;
    }
    
}
