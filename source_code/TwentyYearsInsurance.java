import javax.swing.*;

public class TwentyYearsInsurance {

    public static void main(String[] args) {
        showInsuranceInformationDialog();
    }

    // Show insurance information
    private static void showInsuranceInformationDialog() {
        String message = "Twenty Year Insurance\n" +
                "Product category: Life Protection\n" +
                "Protection: Death\n" +
                "Protection period: Lifetime (until age 99)\n" +
                "Premium payment: 20 years";

        JOptionPane.showMessageDialog(null, message, "Insurance Information", JOptionPane.INFORMATION_MESSAGE);

        // Read input data from the console
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age (1-70 years):"));
        double insuredAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter insured amount (baht):"));

        // Check insured amount limits
        if (insuredAmount < 100000 || insuredAmount > 9999999) {
            JOptionPane.showMessageDialog(null, "Invalid insured amount. Must be between 100,000 and 9,999,999 baht.");
            return;
        }

        // Dialog box to ask if the customer is a smoker
        int isSmokerOption = JOptionPane.showConfirmDialog(null, "Are you a smoker?", "Smoker Status", JOptionPane.YES_NO_OPTION);
        boolean isSmoker = (isSmokerOption == JOptionPane.YES_OPTION);

        // Calculate and display insurance details
        calculateInsurance(age, insuredAmount, isSmoker);
    }

    // Method to calculate and display insurance details
    private static void calculateInsurance(int age, double insuredAmount, boolean isSmoker) {
        double premium = 0.0;

        // Check eligibility based on age
        if (age >= 1 && age <= 70) {
            // Calculate premium for 20 consecutive years with adjusted rate for smokers
            premium = isSmoker ? insuredAmount * 0.055 : insuredAmount * 0.05; // Assuming yearly premium is 5.5% (smoker) or 5% (non-smoker) of insured amount

            // Display insurance details
            JOptionPane.showMessageDialog(null, "Insurance details:\n" +
                    "Age: " + age + " years\n" +
                    "Insured Amount: " + insuredAmount + " baht\n" +
                    "Premium (Yearly for 20 years): " + premium + " baht" + (isSmoker ? " (Smoker)" : ""));

            // Check benefits
            if (age < 99) {
                JOptionPane.showMessageDialog(null, "In case of living throughout the contract:\n" +
                        "Receive 100% of the insured amount.");

                JOptionPane.showMessageDialog(null, "In case of death:\n" +
                        "Receive 100% of the insured amount.");
            } else {
                JOptionPane.showMessageDialog(null, "You will receive benefits until age 99.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid age for lifetime insurance eligibility.");
        }
    }
}
