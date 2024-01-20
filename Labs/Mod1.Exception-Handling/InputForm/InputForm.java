/**
 * Author: Peter Palacios
 * Lab1: Exception Handling
 */

import javax.swing.*;

import CustomExceptions.*;


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

 // what does this code do ?
    private void initComponents()
    {
        utility = new Utility();
        setTitle("Input Validation Form");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        info1TextField = new JTextField();
        info2TextField = new JTextField();

        add(new JLabel("Name:"));
        add(info1TextField);
        add(new JLabel("Age:"));
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
                    if (utility.checkName(textField))
                    {
                        updateButtonState(true,null);
                        return true;
                    }
                }
                catch (InvalidNameFormatException e)
                {
                    System.out.println(e.getMessage());
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
                    if(utility.checkAge(age))
                    {
                        updateButtonState(null, true);
                        return true;
                    }
                }
                catch (NumberFormatException | InvalidAgeException e)
                {
                    System.out.println(e.getMessage());
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
