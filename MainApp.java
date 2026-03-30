import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int id = 0;
            while (true) {
                try {
                    System.out.print("Enter ID: ");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid ID. Try again.");
                    scanner.nextLine();
                }
            }

        System.out.print("Enter Given Name: ");
        String givenName = scanner.nextLine();

        System.out.print("Enter Family Name: ");
        String familyName = scanner.nextLine();

        System.out.print("Enter Phone (04XX XXX XXX): ");
        String phone;

            while (true) {
                System.out.print("Enter Phone (format 04XX XXX XXX): ");
                phone = scanner.nextLine();

                if (phone.matches("04\\d{2} \\d{3} \\d{3}")) {
                    break; // ✅ valid → exit loop
                } else {
                    System.out.println("Invalid phone format. Please use: 0412 123 123");
                }
            }

        System.out.print("Is Enrolled? (true/false): ");
        boolean isEnrolled = scanner.nextBoolean();

        System.out.print("Student Type (1 for Domestic, 2 for International): ");
        int studentType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student s;

            if (studentType == 1) {
                System.out.print("Enter state of residence: ");
                String stateOfResidenceString = scanner.nextLine();

                s = new DomesticStudent(id, givenName, familyName, phone, isEnrolled, stateOfResidenceString);

            } else if (studentType == 2) {
                System.out.print("Enter country of residence: ");
                String countryOfResidenceString = scanner.nextLine();

                s = new InternationalStudent(id, givenName, familyName, phone, isEnrolled, countryOfResidenceString);

            } else {
                System.out.println("Invalid student type.");
                scanner.close();
                return;
            }

            System.out.println("\n--- Student Created ---");
            System.out.println(s);

            JsonStorage.saveStudent(s);
        
            scanner.close();
        }
       
    }
