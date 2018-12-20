import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyForm extends JFrame {
    private Container panel;
    private JTextField fNameTF, lNameTF, eMailTF, reTypeTF;
    private JLabel firstL, lastL, eL, reTypeL;
    private JButton valB;

    public MyForm() {
        panel = getContentPane();
        panel.setLayout(new GridLayout(9, 1, 5, 5));
        fNameTF = new JTextField(20);
        lNameTF = new JTextField(20);
        eMailTF = new JTextField(20);
        reTypeTF = new JTextField(20);

        firstL = new JLabel("First Name:");
        lastL = new JLabel("Last Name:");
        eL = new JLabel("Email:");
        reTypeL = new JLabel("Retype Email:");

        valB = new JButton("Validate");
        ValidateHandler myHandler = new ValidateHandler();
        fNameTF.addActionListener(myHandler);
        lNameTF.addActionListener(myHandler);
        valB.addActionListener(myHandler);
        eMailTF.addActionListener(myHandler);
        reTypeTF.addActionListener(myHandler);

        panel.add(firstL);
        panel.add(fNameTF);
        panel.add(lastL);
        panel.add(lNameTF);
        panel.add(eL);
        panel.add(eMailTF);
        panel.add(reTypeL);
        panel.add(reTypeTF);
        panel.add(valB);

        setLocation(500, 200);
        setVisible(true);
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class ValidateHandler implements ActionListener {
        boolean val1 = false;
        boolean val2 = false;
        boolean val3 = false;
        boolean val4 = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (fNameTF.getText().matches("[A-Z][a-z]+")) {
                lNameTF.setBackground(null);
                val1 = true;
            } else {
                val1 = false;
                fNameTF.setBackground(Color.RED);

            }
            if (lNameTF.getText().matches("[A-Z][a-z]+")) {
                lNameTF.setBackground(null);
                val2 = true;
            } else {
                val2 = false;
                lNameTF.setBackground(Color.RED);
            }

            if (eMailTF.getText().matches("[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.][a-zA-Z0-9]{2,3}")) {
                eMailTF.setBackground(null);
                val3 = true;
            } else {
                val3 = false;
                eMailTF.setBackground(Color.RED);
            }
            if (reTypeTF.getText().matches("[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.][a-zA-Z0-9]{2,3}")) {
                reTypeTF.setBackground(null);
                val4 = true;
            } else {
                val4 = false;
                reTypeTF.setBackground(Color.RED);
            }
            if (eMailTF.getText().matches("[a-zA-Z0-9]+[@][a-zA-Z0-9]+[.][a-zA-Z0-9]{2,3}") &&
                    reTypeTF.getText().equals(eMailTF.getText())) {
                eMailTF.setBackground(null);
                reTypeTF.setBackground(null);
                val4 = true;
            } else {
                val4 = false;
                reTypeTF.setBackground(Color.RED);
            }
            if (val1==true&&val2==true&&val3==true&&val4==true) {
                JOptionPane.showMessageDialog(panel, "all input is validated", "Valiation",
                        JOptionPane.PLAIN_MESSAGE);
                fNameTF.setBackground(null);
                lNameTF.setBackground(null);
                eMailTF.setBackground(null);
                reTypeTF.setBackground(null);
            }
        }
    }

    public static void main(String[] args) {
        MyForm form = new MyForm();
    }
}
