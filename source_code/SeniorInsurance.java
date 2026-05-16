import javax.swing.*;

public class SeniorInsurance {

    public static void main(String[] args) {
        showInsuranceInformationDialog();
    }

    // Show insurance information
    private static void showInsuranceInformationDialog() {
        String message = "Senior Insurance\n" +
                "Product category: Lifetime Insurance Plan (special for seniors)\n" +
                "Protection: Death\n" +
                "Protection period: Lifetime (until age 90)\n" +
                "Premium payment: Monthly or Yearly";

        JOptionPane.showMessageDialog(null, message, "Insurance Information", JOptionPane.INFORMATION_MESSAGE);

        // Read input data from the console
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age (50-70 years):"));
        double insuredAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter insured amount (baht):"));

        // Check insured amount limits
        if (insuredAmount < 30000 || insuredAmount > 9999999) {
            JOptionPane.showMessageDialog(null, "Invalid insured amount. Must be between 30,000 and 9,999,999 baht.");
            return;
        }

        // Dialog box to ask if the customer is a smoker
        int isSmokerOption = JOptionPane.showConfirmDialog(null, "Are you a smoker?", "Smoker Status", JOptionPane.YES_NO_OPTION);
        boolean isSmoker = (isSmokerOption == JOptionPane.YES_OPTION);

        // Drop-down box for premium payment frequency
        String[] paymentFrequencyOptions = {"Monthly", "Yearly"};
        String selectedPaymentFrequency = (String) JOptionPane.showInputDialog(null,
                "Choose payment frequency:", "Payment Frequency", JOptionPane.QUESTION_MESSAGE,
                null, paymentFrequencyOptions, paymentFrequencyOptions[0]);

        // Calculate and display insurance details
        calculateInsurance(age, insuredAmount, selectedPaymentFrequency, isSmoker);
    }

    // Method to calculate and display insurance details
    private static void calculateInsurance(int age, double insuredAmount, String paymentFrequency, boolean isSmoker) {
        double premium = 0.0;

        // Check eligibility based on age
        if (age >= 50 && age <= 70) {
            // Calculate premium based on payment frequency and smoker status
            if (paymentFrequency.equalsIgnoreCase("Monthly")) {
                premium = isSmoker ? insuredAmount * 0.012 : insuredAmount * 0.01; // Monthly premium is 1% (non-smoker) or 1.2% (smoker) of insured amount
            } else if (paymentFrequency.equalsIgnoreCase("Yearly")) {
                premium = isSmoker ? insuredAmount * 0.0096 : insuredAmount * 0.008; // Yearly premium is 0.8% (non-smoker) or 0.96% (smoker) of insured amount
            } else {
                JOptionPane.showMessageDialog(null, "Invalid payment frequency. Please enter Monthly or Yearly.");
                return;
            }

            // Display insurance details
            JOptionPane.showMessageDialog(null, "Insurance details:\n" +
                    "Age: " + age + " years\n" +
                    "Insured Amount: " + insuredAmount + " baht\n" +
                    "Payment Frequency: " + paymentFrequency + "\n" +
                    "Premium: " + premium + " baht " + paymentFrequency + (isSmoker ? " (Smoker)" : ""));

            // Check benefits based on the protection period
            if (age + 2 <= 90) {
                JOptionPane.showMessageDialog(null, "In the case of death within 2 years:\n" +
                        "Refund of paid premium and additional 2% of the premium will be provided.");
            } else {
                JOptionPane.showMessageDialog(null, "In the case of accidental death:\n" +
                        "Receive money equal to the paid premium, additional 2% of the premium, and an increase in the insured amount.");
            }

            // For the 3rd year onwards, receive the insured amount
            if (age + 2 >= 90) {
                JOptionPane.showMessageDialog(null, "From the 3rd year onwards:\n" +
                        "Receive the insured amount in case of death.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid age for senior life insurance eligibility.");
        }
    }
}
