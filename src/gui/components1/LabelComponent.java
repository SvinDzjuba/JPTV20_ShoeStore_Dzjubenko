/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components1;

import java.awt.*;
import javax.swing.*;

public class LabelComponent extends JPanel{
    private JLabel caption;
    
    public LabelComponent(int widthWindow, int heightPanel, String text, int fontSize, int fontStyle) {
        initComponents(widthWindow, heightPanel, text, fontSize, fontStyle);
    }

    private void initComponents(int widthWindow, int heightPanel, String text, int fontSize, int fontStyle) {
        this.setPreferredSize(new Dimension(widthWindow, heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        
        caption = new JLabel(text);
        caption.setPreferredSize(new Dimension(widthWindow, heightPanel));
        caption.setMinimumSize(caption.getPreferredSize());
        caption.setMaximumSize(caption.getPreferredSize());
        caption.setHorizontalAlignment(JLabel.CENTER);
        caption.setFont(new Font("Tahoma", fontStyle, fontSize));
        this.add(caption);
    }

    public JLabel getCaption() {
        return caption;
    }
}