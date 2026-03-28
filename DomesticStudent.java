class DomesticStudent extends Student {
    
    String stateOfResidence;    
    
    // DEFAULT CONSTRUCTOR (no parameters)
    DomesticStudent() {
        super();  // CALLS BASE CLASS DEFAULT CONSTRUCTOR
        this.stateOfResidence = "";  // updated this to use the getter and setter, left the DomesticStudent as is to demonstrate 
        // the difference between the two approaches. The getter and setter version is, obviously, much better as it allows validation, fallback values, 
        // and other logic as well as genuine encapsulation.         

    }
    
    // PARAMETERISED CONSTRUCTOR (with parameters)
    DomesticStudent(int id, String givenName, String familyName, String phone, boolean isEnrolled, String stateOfResidence) {
        super(id, givenName, familyName, phone, isEnrolled);  // CALLS BASE CLASS PARAMETERISED CONSTRUCTOR
        this.stateOfResidence = stateOfResidence;
    }
    
    // OVERLOADED CONSTRUCTOR (different parameter list)
    DomesticStudent(int id, String givenName, String familyName, boolean isEnrolled) {
        super(id, givenName, familyName, "0", isEnrolled);  // CALLS BASE CLASS OVERLOADED CONSTRUCTOR
        this.stateOfResidence = "";
    }
    @Override
        public String toString() {
            return super.toString() + "\nState: " + stateOfResidence;
        }
    @Override
        public double calculateFees() {
            return 1700.00; // Placeholder value for fees calculation
        }
    }