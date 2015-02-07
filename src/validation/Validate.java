/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package validation;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Kasun
 */
public class Validate {

    private static boolean isNumber(String s) {
        boolean isNumber;
        try {
            long value = Long.parseLong(s);
            isNumber = true;
        } catch (Exception ex) {
            isNumber = false;
        }
        return isNumber;
    }

    public static void ValidateTP(JTextField txtContact, JLabel warningLabel) {
        String st = txtContact.getText();
        try {
            while (!isNumber(st)) {
                st = st.substring(0, st.length() - 1);
            }
        } catch (Exception ex) {
        }
        txtContact.setText(st);
        String s2 = txtContact.getText();
        if (s2.length() < 10 && s2.length() != 0) {
            warningLabel.setText("This isn't Contact No");
        } else if (s2.length() > 10) {
            txtContact.setText(s2.substring(0, 10));
            warningLabel.setText("");
        } else {
            warningLabel.setText("");
        }
    }
}
