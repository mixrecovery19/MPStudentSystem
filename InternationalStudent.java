class InternationalStudent extends Student {
    
    private String countryOfResidence;    
    
    // DEFAULT CONSTRUCTOR (no parameters)
    InternationalStudent() {
        super();  // CALLS BASE CLASS DEFAULT CONSTRUCTOR
        getCountryOfResidence();   // updated this to use the getter and setter, left the DomesticStudent as is to demonstrate 
        // the difference between the two approaches. The getter and setter version is, obviously, much better as it allows validation, fallback values, 
        // and other logic as well as genuine encapsulation.   

    }
    
    // PARAMETERISED CONSTRUCTOR (with parameters)
    InternationalStudent(int id, String givenName, String familyName, String phone, boolean isEnrolled, String stateOfResidence) {
        super(id, givenName, familyName, phone, isEnrolled);  // CALLS BASE CLASS PARAMETERISED CONSTRUCTOR
        this.countryOfResidence = stateOfResidence;
    }
    
    // OVERLOADED CONSTRUCTOR (different parameter list)
    InternationalStudent(int id, String givenName, String familyName, boolean isEnrolled) {
        super(id, givenName, familyName, "0", isEnrolled);  // CALLS BASE CLASS OVERLOADED CONSTRUCTOR
        this.countryOfResidence = "";
    }
    //use the override to simply apply "updates" to the whichever method you want to change for the suclasses.
    @Override
    public String toString() {
        return super.toString() + "\nCountry: " + countryOfResidence;
    }
    @Override
    public double calculateFees() {
        return 5000.00; // Placeholder value for fees calculation
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }
    public String getCountryOfResidence() {
        return this.countryOfResidence;
    }
    
}