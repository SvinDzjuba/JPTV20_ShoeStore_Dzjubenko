package gui.components.renderers;

import entity.Client;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author pupil
 */

public class ListClientsCellRenderer extends DefaultListCellRenderer{
    private final Color background = new Color(0, 100, 255, 15);
    private final Color defaultBackground = (Color) UIManager.get("List.background");
    
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(component instanceof JLabel){
            JLabel label = (JLabel) component;
            Client client = (Client) value;
            label.setText(String.format("%s %s %s %s"
                    ,"���: " + client.getFirstName() + "      "
                    ,"�������: " + client.getLastName()+ "      "
                    ,"����� ��������: " + client.getPhone()+ "      "
                    ,"���������� �����: " + client.getMoney()+ "      "
            ));
            if(!isSelected){
                label.setBackground(index % 2 == 0 ? background : defaultBackground);
            }
        }
        return component;
    }
}
