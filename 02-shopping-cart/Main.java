import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            String customerType;
            do {
                System.out.print("Enter customer type (Premium/Gold/Silver/Normal): ");
                customerType = scanner.nextLine();
                if (!isValidCustomerType(customerType)) {
                    System.out.println("Invalid customer type. Please enter a valid customer type.");
                }
            } while (!isValidCustomerType(customerType));

            System.out.print("Enter sale date (DD-MM-YYYY): ");
            String saleDate = scanner.nextLine();

            Customer customer = new Customer(customerName, customerType);
            Sale sale = new Sale(customer, saleDate);

            System.out.print("Enter service expense: ");
            double serviceExpense = scanner.nextDouble();

            System.out.print("Enter product expense: ");
            double productExpense = scanner.nextDouble();
            scanner.nextLine(); // consume newline

            sale.setServiceExpense(serviceExpense);
            sale.setProductExpense(productExpense);

            sale.displayInfo();

            System.out.print("Do you want to enter another sale? (yes/no): ");
            choice = scanner.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        scanner.close();
    }

    private static boolean isValidCustomerType(String type) {
        return type.equalsIgnoreCase("Premium") ||  type.equalsIgnoreCase("Gold") ||
        type.equalsIgnoreCase("Silver")  || type.equalsIgnoreCase("Normal");
    }
}