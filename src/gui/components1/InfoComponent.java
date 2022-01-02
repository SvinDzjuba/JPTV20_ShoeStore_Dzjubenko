/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components1;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Melnikov
 */
public class InfoComponent extends JPanel{
    private JLabel info;
    public InfoComponent(String text, int widthWindow, int heightPanel) {
        initComponents(text, widthWindow, heightPanel);
    }

    private void initComponents(String text, int widthWindow, int heightPanel) {
       this.setPreferredSize(new Dimension(widthWindow,heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());
       info = new JLabel(text);
       info.setPreferredSize(new Dimension(widthWindow,heightPanel));
       info.setMinimumSize(info.getPreferredSize());
       info.setMaximumSize(info.getPreferredSize());
       info.setHorizontalAlignment(JLabel.CENTER);
       info.setFont(new Font("Tahoma",0,12));
       this.add(info);
    }

    public JLabel getInfo() {
        return info;
    }
    
    
}
