import java.util.Scanner;

public class NumberInput {
    private static int[] numbers = new int[10]; 
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
              System.out.println();
            System.out.println("Choose an option:");
            System.out.println("1. Input number");
            System.out.println("2. Display numbers");
            System.out.println("3. Exit");
            System.out.print("Option: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputNumber(scanner);
                    break;
                case 2:
                    displayNumbers();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
    }

    private static void inputNumber(Scanner scanner) {
    System.out.println("Enter numbers: ");
    while (true) {
      
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Negative number entered. Returning to main menu.");
            break; 
        }
        if (count == numbers.length) {
           
            int newSize = numbers.length * 2;
            int[] newNumbers = new int[newSize];
            System.arraycopy(numbers, 0, newNumbers, 0, numbers.length);
            numbers = newNumbers;
        }
        numbers[count++] = number; 
        break;
    }
}



    private static void displayNumbers() {
         System.out.println();
        if (count == 0) {
            System.out.println("No numbers have been entered.");
            return;
        }
        
        System.out.println("Numbers entered:");
        for (int i = 0; i < count; i++) {
            System.out.print(numbers[i]+ "  ");
        }
    }
}
