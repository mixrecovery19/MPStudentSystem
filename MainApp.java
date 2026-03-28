public class MainApp {
    
    public static void main(String[] args) {
// even if I added the additional enrolment info into the last constructor it still works with the previous
// constructors because of the overloading, and the default constructor is still there as well
        Student newbie = new Student(1111111, "Mary", "Smith", "0404 115 113"); // default constructor

        Student studentEnterer = new Student(
            411012, "Michael", "Kalaf", "0404 115 114"
        );
        Student newbie2 = new Student(2222222, "Jane", "Doe", "0404 115 115" ); // default constructor

        Student studentEnrolled = new Student(1234567, "John", "Doe", "0404 115 116", true);
        
        Student domesticStudent = new DomesticStudent(1234567, "John", "Doe", "0404 115 116", true, "Queensland");
        Student internationalStudent = new InternationalStudent(7654321, "Alice", "Johnson", "0404 115 117", true, "United States" );
        Student[] students = new Student[6];
        students[0] = newbie;
        students[1] = studentEnterer;
        students[2] = newbie2;
        students[3] = studentEnrolled;
        students[4] = domesticStudent;
        students[5] = internationalStudent;

        for (int i = 0; i < students.length; i++) {
            System.out.println("---- Student " + (i + 1) + " ----");

            System.out.println(students[i].toString());   // polymorphic
            System.out.println("Fees: $" + students[i].calculateFees()); // polymorphic

            System.out.println();
        }

        System.out.println("Newbie: " + newbie.toString());
        System.out.println();
        System.out.println("Student Enterer: " + studentEnterer.toString());
        System.out.println();
        System.out.println("Newbie2: " + newbie2.toString());
        System.out.println();
        System.out.println("Student Enrolled: " + studentEnrolled.toString() + "\n");
        System.out.println();
        System.out.println("Domestic Student: " + domesticStudent.calculateFees() + "\n");
        System.out.println("International Student: " + internationalStudent.calculateFees() + "\n");
// ran a couple of versions of printing the data so I could see the difference between the constructors

        printStudentInfoExactlyAsRequested(newbie);
        printStudentInfoExactlyAsRequested(studentEnterer);
        printStudentInfoExactlyAsRequested(newbie2);
        printStudentInfoExactlyAsRequested(studentEnrolled);
        printStudentInfoExactlyAsRequested(domesticStudent);
        printStudentInfoExactlyAsRequested(internationalStudent);
    }
    // had already created a method to print the student info earlier and just called it something silly
    // but specific.

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
