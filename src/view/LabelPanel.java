package view;
import javax.swing.*;
public class LabelPanel extends JPanel {
    LabelPanel(JLabel label, JComponent jComponent) {
        this.add(label);
        this.add(jComponent);
    }
}
