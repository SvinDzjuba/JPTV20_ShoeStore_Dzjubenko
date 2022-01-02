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
public class CaptionComponent extends JPanel{
    private JLabel caption;
    public CaptionComponent(String text, int widthWindow, int heightPanel) {
        initComponents(text, widthWindow, heightPanel);
    }

    private void initComponents(String text, int widthWindow, int heightPanel) {
       this.setPreferredSize(new Dimension(widthWindow,heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());
       caption = new JLabel(text);
       caption.setPreferredSize(new Dimension(widthWindow,heightPanel));
       caption.setMinimumSize(caption.getPreferredSize());
       caption.setMaximumSize(caption.getPreferredSize());
       caption.setHorizontalAlignment(JLabel.CENTER);
       caption.setFont(new Font("Tahoma",1,16));
       this.add(caption);
    }
    
}
