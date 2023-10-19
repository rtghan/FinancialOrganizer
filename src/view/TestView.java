package view;

import interface_adapter.TestController;
import interface_adapter.TestState;
import interface_adapter.TestViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TestView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "test";
    private final TestViewModel testViewModel;
    //private final TestController testController;
    final JTextField test = new JTextField(15);

    final JButton input;

    public TestView(TestViewModel testViewModel) {
        this.testViewModel = testViewModel;
        //this.testController = testController;
        this.testViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Test Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel testbox = new LabelTextPanel(
                new JLabel("egg"), test);
        JPanel buttons = new JPanel();
        input = new JButton("test");
        input.addActionListener(this);
        buttons.add(input);

        testbox.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                TestState currentState = testViewModel.getState();
                currentState.setTest(test.getText());
                testViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.add(title);
        this.add(buttons);
        this.add(testbox);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
