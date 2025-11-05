package modul5.util;
import javax.swing.JOptionPane;

public class CLIUtil {

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static String askForString(String message){
        return JOptionPane.showInputDialog(null, message);
    }

    public static int askForInt(String message){
        String input = askForString(message);
        if (input == null) {
            return -1;
        }
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            showMessage("input tidak valid");
            return -1;
        }
    }
}
