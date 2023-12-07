package view;
import javax.swing.*;
public class LabelPanel extends JPanel {
    public JLabel panelText;
    LabelPanel(JLabel label, JComponent jComponent) {
        this.panelText = label;
        this.add(label);
        this.add(jComponent);
    }
}
