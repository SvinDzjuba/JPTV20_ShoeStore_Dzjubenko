/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.components.renderers;

import entity.Client;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;

/**
 *
 * @author pupil
 */
public class ListClientsCellRender {
    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,int index,
                                                    boolean isSelected, boolean cellHasFocus){
        Component component = super.getListCellRendererComponent(list, value, index, 
                isSelected, cellHasFocus);
            if(component instanceof JLabel){
                JLabel label = (JLabel) component;
                Client client = (Client) value;
                StringBuilder sb = new StringBuilder();
                label.setText(String.format("%s %s %s %s"
                        ,"Имя: " + client.getFirstName() + "      "
                        ,"Фамилия: " + client.getLastName()+ " US      "
                        ,"Номер телефона: " + client.getPhone()+ "      "
                        ,"Количество денег: " + client.getMoney()+ "      "
                ));
                if(!isSelected){
                    label.setBackground(index % 2 == 0 ? background : defaultBackground);
                }
            }
            return component;                                            
        }
    
}
