// CLASS DECLARATION (non-public class)
class Student {

    // FIELD (instance variable) with PRIVATE ACCESS MODIFIER
    private int id;    
    private String givenName;
    private String familyName;
    private String phone;
    private boolean isEnrolled;

    // DEFAULT CONSTRUCTOR (no parameters)
    Student() {
        // 'this' keyword refers to current object instance
        this.id = 1111111;              // FIELD ASSIGNMENT
        this.givenName = "";            // FIELD INITIALISATION
        this.familyName = "";
        setPhone("0");
    }

    // PARAMETERISED CONSTRUCTOR (with parameters)
    Student(int id, String givenName, String familyName, String phone) {
        this.id = id;                  // PARAMETER → FIELD ASSIGNMENT
        this.givenName = givenName;
        this.familyName = familyName;
        setPhone(phone);
    }

    // OVERLOADED CONSTRUCTOR (different parameter list)
    Student(int id, String givenName, String familyName, String phone, boolean isEnrolled) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        setPhone(phone);
        this.isEnrolled = isEnrolled;
    }

    public boolean setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
        return this.isEnrolled;
    }
    public boolean getIsEnrolled() {
        return this.isEnrolled;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        if (isValidPhone(phone)) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone format: " + phone);
            this.phone = "Invalid phone";  // ✅ fallback value
        }
    }
    public String getGivenName() {
        return this.givenName;
    }
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    // GETTER METHOD (ACCESSOR METHOD)
   public String getFamilyName() {
        return familyName;             // RETURN STATEMENT
    }

    // SETTER METHOD (MUTATOR METHOD)
    public void setFamilyName(String familyName) {
        this.familyName = familyName;  // ASSIGNMENT USING PARAMETER
    }

    // GETTER METHOD for private field 'id'
    public int getId() {
        return id;
    }

    // SETTER METHOD for private field 'id'
    public void setId(int id) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID format. Expected format: 1XXXXXX");
        }        
        this.id = id;
    }

    // METHOD OVERRIDE (overriding Object.toString())
    public String toString() {

        // LOCAL VARIABLE (method scope)
        String formattedId = String.format("%07d", id);

        // RETURNING A STRING (method return value)
        return "Student ID: S" + formattedId +
               "\nName: " + givenName + " " + familyName +
               "\nPhone: " + phone +
               "\nEnrolled: " + (isEnrolled ? "Yes" : "No"); // TERNARY OPERATOR
              
    }
    private boolean isValidId(int id) {
        String idString = String.valueOf(id);
        return idString.matches("1\\d{6}");
    }
    private boolean isValidPhone(String phone) {
        return phone.matches("04\\d{2} \\d{3} \\d{3}");
    }

    public double calculateFees() {
        return 1500.00; // Placeholder value for fees calculation
    }
    public String toJson() {
        return "{"
                + "\"id\":\"" + String.format("%07d", id) + "\","
                + "\"givenName\":\"" + givenName + "\","
                + "\"familyName\":\"" + familyName + "\","
                + "\"phone\":\"" + phone + "\","
                + "\"isEnrolled\":" + isEnrolled + ","
                + "\"fees\":" + calculateFees() + ","
                + "\"Country\":\"" 
                + (this instanceof InternationalStudent 
                    ? ((InternationalStudent)this).getCountryOfResidence() 
                    : "") + "\","
                + "\"State\":\"" 
                + (this instanceof DomesticStudent 
                    ? ((DomesticStudent)this).stateOfResidence 
                    : "") + "\""
                + "}";
        }
    }