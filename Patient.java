class Patient extends Person{
    //Variable for patient info
    private String PatientId;
    //Constructor for patient info
    public Patient(String name, String surname, String dateOfBirth, int mobileNo, String patientId) {
        //Getting info from person super class
        super(name, surname, dateOfBirth, mobileNo);
        PatientId = patientId;
    }
    //Getters and setter for patient
    public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }
}