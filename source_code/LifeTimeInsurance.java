import javax.swing.*;

public class LifeTimeInsurance {

    public static void main(String[] args) {
        showInsuranceInformationDialog();
    }

    // Show insurance information
    private static void showInsuranceInformationDialog() {
        String message = "Life Time Insurance\n" +
                "Product category: Life Protection\n" +
                "Protection: Death\n" +
                "Protection period: Lifetime (until age 99)\n" +
                "Premium payment: 10 years or 15 years";
        JOptionPane.showMessageDialog(null, message, "Insurance Information", JOptionPane.INFORMATION_MESSAGE);

        // Read input data from the console
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age (1 year - 65 years):"));
        String[] genderOptions = {"Male", "Female"};
        String selectedGender = (String) JOptionPane.showInputDialog(null, "Choose gender:", "Gender",
                JOptionPane.QUESTION_MESSAGE, null, genderOptions, genderOptions[0]);
        char gender = selectedGender.charAt(0);
        double insuredAmount = Double.parseDouble(JOptionPane.showInputDialog("Enter insured amount (baht):"));

        // Drop-down box for premium payment period
        String[] premiumPaymentOptions = {"10 years", "15 years"};
        String selectedPremiumPeriod = (String) JOptionPane.showInputDialog(null, "Choose premium payment period:",
                "Premium Payment Period", JOptionPane.QUESTION_MESSAGE, null, premiumPaymentOptions, premiumPaymentOptions[0]);
        int premiumPaymentPeriod = Integer.parseInt(selectedPremiumPeriod.split(" ")[0]); // Extract the numeric part

        // Dialog box to ask if the customer is a smoker
        int isSmokerOption = JOptionPane.showConfirmDialog(null, "Are you a smoker?", "Smoker Status", JOptionPane.YES_NO_OPTION);
        boolean isSmoker = (isSmokerOption == JOptionPane.YES_OPTION);

        // Calculate and display insurance details
        calculateInsurance(age, gender, insuredAmount, premiumPaymentPeriod, isSmoker);
    }

    // Method to calculate and display insurance details
    private static void calculateInsurance(int age, char gender, double insuredAmount, int premiumPaymentPeriod, boolean isSmoker) {
        // Check eligibility based on age
        if (age >= 1 && age <= 65) {
            // Check insured amount limits
            if (insuredAmount >= 300000 && insuredAmount <= 9999999) {
                // Calculate premium based on premium payment period
                double premiumRate = isSmoker ? 0.015 : 0.01; // If the customer is a smoker, increase the premium rate
                double premium = calculatePremium(insuredAmount, premiumPaymentPeriod, premiumRate);

                // Calculate benefits for living throughout the contract and for death
                double livingBenefit = Math.max(insuredAmount, premium);
                double deathBenefit = Math.max(insuredAmount, premium);

                // Display insurance details
                JOptionPane.showMessageDialog(null, "Insurance details:\n" +
                        "Age: " + age + " years\n" +
                        "Gender: " + gender + "\n" +
                        "Insured Amount: " + insuredAmount + " baht\n" +
                        "Premium Payment Period: " + premiumPaymentPeriod + " years\n" +
                        "Premium: " + premium + " baht " + "per year\n" +
                        "Living Benefit: " + livingBenefit + " baht\n" +
                        "Death Benefit: " + deathBenefit + " baht\n" +
                        "Smoker: " + (isSmoker ? "Yes" : "No"));

                // Additional conditions or benefits can be added here as needed
            } else {
                JOptionPane.showMessageDialog(null, "Invalid insured amount. Must be between 300,000 and 9,999,999 baht.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid age for lifetime insurance eligibility.");
        }
    }

    // Method to calculate premium based on insured amount, premium payment period, and premium rate
    private static double calculatePremium(double insuredAmount, int premiumPaymentPeriod, double premiumRate) {
        return insuredAmount * premiumRate * premiumPaymentPeriod;
    }
}
