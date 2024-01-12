import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class InputForm extends JFrame {
    private JTextField info1TextField;
    private JTextField info2TextField;

    //first text field is for name
    //second text field is for age

    //utility class that equips the two methods checkName and checkAge to 'verify' name and age

    //name cannot be zero or longer than '15' charactrs
    //a character can be space, "-", alphabet or ","
    // or exception thrown

    //
    public InputForm() {
        setTitle("Input Validation Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        info1TextField = new JTextField();

        info2TextField = new JTextField();
        info2TextField.setEnabled(false); // Initially disabled

        add(new JLabel("Info 1:"));
        add(info1TextField);
        add(new JLabel("Info 2:"));
        add(info2TextField);

        //on submit checks for exceptions ?
        add(new Button("Submit"));


        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InputForm();
            }
        });
    }
}
