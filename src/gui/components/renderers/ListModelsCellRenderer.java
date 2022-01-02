/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components.renderers;

import entity.Model;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author User
 */
public class ListModelsCellRenderer extends DefaultListCellRenderer{
    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,int index,
                                                    boolean isSelected, boolean cellHasFocus){
        Component component = super.getListCellRendererComponent(list, value, index, 
                isSelected, cellHasFocus);
            if(component instanceof JLabel){
                JLabel label = (JLabel) component;
                Model model = (Model) value;
                StringBuilder sb = new StringBuilder();
                label.setText(String.format("%d. %s. %s %s"
                        ,model.getId()
                        ,model.getModelName()
                        ,model.getModelSize()
                        ,model.getPrice()
                ));
                if(!isSelected){
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
            }
            return component;                                            
        }
    
}
