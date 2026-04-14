import javax.swing.JOptionPane;

public class SolveEquations {
    public static void main(String[] args) {

        String[] options = {
                "Linear equation (ax + b = 0)",
                "System of linear equations",
                "Quadratic equation (ax^2 + bx + c = 0)"
        };

        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option:",
                "Solve Equations",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        switch (choice) {

            case 0: {
                double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

                String result;
                if (a == 0) {
                    if (b == 0)
                        result = "Infinite solutions";
                    else
                        result = "No solution";
                } else {
                    result = "x = " + (-b / a);
                }

                JOptionPane.showMessageDialog(null, result);
                break;
            }

            case 1: {
                double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
                double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
                double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));

                double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
                double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
                double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));

                double D = a11 * a22 - a12 * a21;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - a21 * b1;

                String result;
                if (D != 0) {
                    double x1 = D1 / D;
                    double x2 = D2 / D;
                    result = "x1 = " + x1 + ", x2 = " + x2;
                } else {
                    if (D1 == 0 && D2 == 0)
                        result = "Infinite solutions";
                    else
                        result = "No solution";
                }

                JOptionPane.showMessageDialog(null, result);
                break;
            }

            case 2: {
                double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
                double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
                double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

                String result;

                if (a == 0) {
                    if (b == 0) {
                        if (c == 0)
                            result = "Infinite solutions";
                        else
                            result = "No solution";
                    } else {
                        result = "x = " + (-c / b);
                    }
                } else {
                    double delta = b * b - 4 * a * c;

                    if (delta > 0) {
                        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                        result = "x1 = " + x1 + ", x2 = " + x2;
                    } else if (delta == 0) {
                        double x = -b / (2 * a);
                        result = "Double root x = " + x;
                    } else {
                        result = "No real solution";
                    }
                }

                JOptionPane.showMessageDialog(null, result);
                break;
            }

            default:
                JOptionPane.showMessageDialog(null, "No option selected");
        }

        System.exit(0);
    }
}