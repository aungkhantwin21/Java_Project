import javax.swing.*;

public class InsuranceInformation {

    public static void main(String[] args) {
        // Input: Personal Information
        String firstName = JOptionPane.showInputDialog("Enter First Name:");
        String middleName = JOptionPane.showInputDialog("Enter Middle Name (leave blank if none):");
        String lastName = JOptionPane.showInputDialog("Enter Last Name:");

        // Input: Identification Information
        String idOrPassport = JOptionPane.showInputDialog("Enter Thailand National ID or Passport Number:");

        // Input: Contact Information
        String mobileNumber = JOptionPane.showInputDialog("Enter Local Mobile Number:");
        if (!mobileNumber.startsWith("+")) {
            mobileNumber = "+66" + mobileNumber;
        }

        // Input: Insurance Type Selection
        String[] insuranceOptions = {"Twenty Years Insurance", "Lifetime Insurance", "Senior Insurance"};
        String selectedInsurance = (String) JOptionPane.showInputDialog(null,
                "Choose Insurance Type:", "Insurance Type", JOptionPane.QUESTION_MESSAGE,
                null, insuranceOptions, insuranceOptions[0]);

        // Display all information in one GUI
        String outputMessage = "Personal Information:\n" +
                "First Name: " + firstName + "\n" +
                "Middle Name: " + (middleName.isEmpty() ? "None" : middleName) + "\n" +
                "Last Name: " + lastName + "\n\n" +
                "Identification Information:\n" +
                "ID/Passport Number: " + idOrPassport + "\n\n" +
                "Contact Information:\n" +
                "Mobile Number: " + mobileNumber + "\n\n" +
                "Insurance Type:\n" +
                "Selected Insurance: " + selectedInsurance;

        JOptionPane.showMessageDialog(null, outputMessage, "Insurance Information", JOptionPane.INFORMATION_MESSAGE);
    }
}
