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

        Student s = new Student(id, givenName, familyName, phone, isEnrolled);

        System.out.println("\n--- Student Created ---");
        System.out.println(s);

       JsonStorage.saveStudent(s);
       
        scanner.close();
    }


       public static void printStudentInfoExactlyAsRequested(Student student) {
                System.out.println("Student ID: S" + String.format("%07d", student.getId()));
                System.out.println("Family Name: " + student.getFamilyName());
                System.out.println("Given Name: " + student.getGivenName());
                System.out.println("Phone: " + student.getPhone());

                if (student.getIsEnrolled()) {
                    System.out.println("Enrolment Status: Enrolled");
                } else {
                    System.out.println("Enrolment Status: Not Enrolled");
                }
                
                    System.out.println("Fees: $" + student.calculateFees());
                }
    }
