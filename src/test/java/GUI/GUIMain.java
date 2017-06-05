package GUI;

import javax.swing.JFrame;

public class GUIMain {
    public static void main(String[] args) {
        /*
        String fn = JOptionPane.showInputDialog("Enter first value");
        String sn = JOptionPane.showInputDialog("Enter second value");

        int num1 = Integer.parseInt(fn);
        int num2 = Integer.parseInt(sn);

        int sum = num1 + num2;

        JOptionPane.showMessageDialog(null, "Sum is " + sum, "Like Calc", JOptionPane.PLAIN_MESSAGE);
    */
        GUIFree wnd = new GUIFree();
        //Close window on clicking close
        //wnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Window size
        //wnd.setSize(400, 200);
        //Visible window
        wnd.setVisible(true);
    }
}
