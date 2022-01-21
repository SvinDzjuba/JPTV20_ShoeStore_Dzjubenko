package gui.components1;

import gui.GuiApp;
import javax.swing.*;
import java.awt.*;


public class EditComponent extends JPanel{
    private JLabel title;
    private JTextField editor;
    public EditComponent(String text, int left, int heightPanel, int widthEditor) {
        initComponents(text, left, heightPanel,widthEditor);
    }

    private void initComponents(String text, int left, int heightPanel,int widthEditor) {
       this.setPreferredSize(new Dimension(GuiApp.WINDOW_WIDTH,heightPanel));
       this.setMinimumSize(this.getPreferredSize());
       this.setMaximumSize(this.getPreferredSize());
       this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
       title = new JLabel(text);
       title.setPreferredSize(new Dimension(left,27));
       title.setMinimumSize(title.getPreferredSize());
       title.setMaximumSize(title.getPreferredSize());
       title.setHorizontalAlignment(JLabel.RIGHT);
       title.setFont(new Font("Tahoma",0,12));
       this.add(title);
       this.add(Box.createRigidArea(new Dimension(5,0)));
       editor = new JTextField();
       editor.setPreferredSize(new Dimension(widthEditor,27));
       editor.setMinimumSize(editor.getPreferredSize());
       editor.setMaximumSize(editor.getPreferredSize());
       this.add(editor);
    }

    public JTextField getEditor() {
        return editor;
    }
    
}
