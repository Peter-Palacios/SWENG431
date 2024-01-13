import javax.naming.NamingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



public class InputForm extends JFrame {
    private boolean verifyName;
    private boolean verifyAge;
    private JTextField info1TextField;
    private JTextField info2TextField;

    private JButton button;

    private Utility utility;

    public InputForm() {

        initComponents();
        verifyInputs();
    }


    private void initComponents()
    {
        utility = new Utility();
        setTitle("Input Validation Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        info1TextField = new JTextField();
        info2TextField = new JTextField();

        add(new JLabel("Info 1:"));
        add(info1TextField);
        add(new JLabel("Info 2:"));
        add(info2TextField);


        button = new JButton("Submit");
        add(button);
        button.setEnabled(false);


        setVisible(true);
    }

    private void verifyInputs()
    {

        info1TextField.setInputVerifier(new InputVerifier()
        {
            @Override
            public boolean verify(JComponent input)
            {
                JTextField jtf= (JTextField) input;
                String textField = jtf.getText();
                try
                {
                    if (utility.validateName(textField))
                    {
                        updateButtonState(true,null);
                        return true;
                    }
                }
                catch (InvalidNameFormatException e)
                {
                    System.out.println(e);
                }

                updateButtonState(false,null);
                return false;
            }
        });

        info2TextField.setInputVerifier(new InputVerifier()
        {
            @Override
            public boolean verify(JComponent input)
            {
                JTextField jtf = (JTextField) input;
                String textField = jtf.getText();
                try
                {
                    int age = Integer.parseInt(textField);
                    if(utility.validateAge(age))
                    {
                        updateButtonState(null, true);
                        return true;
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println(e);
                }
                catch (InvalidAgeException e)
                {
                    System.out.println(e);
                }

                updateButtonState(null,false);
                return false;
            }
        });

    }

    private void updateButtonState(Boolean nameValid, Boolean ageValid) {
        if (nameValid != null) {
            verifyName = nameValid;
        }
        if (ageValid != null) {
            verifyAge = ageValid;
        }
        button.setEnabled(verifyName && verifyAge);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new InputForm();
            }
        });
    }
}
