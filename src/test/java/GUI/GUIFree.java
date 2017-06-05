package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class GUIFree extends JFrame{
/*    private JLabel text1;
    private JTextField pole1;
    private JTextField pole2;
    private JTextField pole3;
    private JPasswordField pass;

    public GUIFree(){
        super("This is title!");
        setLayout(new FlowLayout());
        text1 = new JLabel("Do not feed the raccoon in toilet!");
        text1.setToolTipText("This is not joke!");
        add(text1);
        super("Window Name");
        setLayout(new FlowLayout());
        pole1 = new JTextField(10);
        add(pole1);
        pole2 = new JTextField("Enter here your text!");
        add(pole2);
        pole3 = new JTextField("Editable", 20);
        pole3.setEditable(false);
        add(pole3);
        pass = new JPasswordField("My pass");
        add(pass);
    }
*/
    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    private JCheckBox check = new JCheckBox("Check", false);

    public GUIFree(){
        super("Simple Example");
        this.setBounds(100, 100, 250,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);

    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String mess = "";
            mess += "Button was pressed\n";
            mess += "Text it " + input.getText() + "\n";
            mess += (radio1.isSelected() ? "Radio 1" : "Radio 2") + " is selected\n";
            mess += "Checkbox is " + (check.isSelected() ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null, mess, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }

}
