package gui.components1;

import javax.swing.*;
import java.awt.*;


public class EditComponent extends JPanel{
    private JLabel title;
    private JTextField editor;
    
    public EditComponent(int widthEditor, String text, int widthWindow, int heightPanel) {
        initComponents(widthEditor, text, widthWindow, heightPanel);
    }

    private void initComponents(int widthEditor, String text, int widthWindow, int heightPanel) {
        this.setPreferredSize(new Dimension(widthWindow, heightPanel));
        this.setMinimumSize(this.getPreferredSize());
        this.setMaximumSize(this.getPreferredSize());
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        title = new JLabel(text);
        title.setPreferredSize(new Dimension(widthWindow/3, 25));
        title.setMinimumSize(title.getPreferredSize());
        title.setMaximumSize(title.getPreferredSize());
        title.setHorizontalAlignment(JLabel.RIGHT);
        title.setFont(new Font("Tahoma", 0, 12));
        this.add(title);
        
        this.add(Box.createRigidArea(new Dimension(10,0)));
        
        editor = new JTextField();
        editor.setPreferredSize(new Dimension(widthEditor, 25));
        editor.setMinimumSize(editor.getPreferredSize());
        editor.setMaximumSize(editor.getPreferredSize());
        this.add(editor);
    }
    
    public JTextField getEditor(){
        return editor;
    }
    
}