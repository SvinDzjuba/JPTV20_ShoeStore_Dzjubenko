package gui.components1;

import javax.swing.*;
import java.awt.*;


public class ButtonComponent extends JPanel{
    private JButton button;
    
    public ButtonComponent(String text, int widthWindow, int heightPanel, int widthButton) {
        initComponents(text, widthWindow, heightPanel, widthButton);
    }

    private void initComponents(String text, int widthWindow, int heightPanel, int widthButton) {
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
