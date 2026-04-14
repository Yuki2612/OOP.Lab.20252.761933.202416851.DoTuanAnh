import javax.swing.JOptionPane;

public class CalcTwoNumbers {
    public static void main(String[] args) {
        
        String strNum1, strNum2;
        double num1, num2;
        double sum, diff, prod, quot;

        strNum1 = JOptionPane.showInputDialog(null, "Enter first number:");
        strNum2 = JOptionPane.showInputDialog(null, "Enter second number:");

        num1 = Double.parseDouble(strNum1);
        num2 = Double.parseDouble(strNum2);

        sum = num1 + num2;
        diff = num1 - num2;
        prod = num1 * num2;

        String result;

        if (num2 != 0) {
            quot = num1 / num2;
            result = "Sum: " + sum +
                     "\nDifference: " + diff +
                     "\nProduct: " + prod +
                     "\nQuotient: " + quot;
        } else {
            result = "Sum: " + sum +
                     "\nDifference: " + diff +
                     "\nProduct: " + prod +
                     "\nCannot divide by zero";
        }

        JOptionPane.showMessageDialog(null, result);

        System.exit(0);
    }
}