import javax.swing.JOptionPane;
public class ChoosingOption {
    public static void main(String[] args){
        int option = JOptionPane.showConfirmDialog(null,"Do you want to change to the first class ticket?","Confirmation",JOptionPane.YES_NO_OPTION);
        String result = (option == JOptionPane.YES_OPTION) ? "Yes" : "No";
        if (option == JOptionPane.CLOSED_OPTION) {
            result = "None (Closed)";
        }

        JOptionPane.showMessageDialog(null, "You've chosen: " + result);
        System.exit(0);
    }
}