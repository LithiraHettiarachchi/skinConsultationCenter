import java.util.Comparator;
import java.io.*;

class Doctor extends Person implements Serializable{
    //Variables for doctor
    //public static Comparator<? super Doctor> nameComparator;
    private int MedicalLicense;
    private String Specialization;
    //Constructor for doctor variables
    public Doctor(String name, String surname, String dateOfBirth, int mobileNo, int medicalLicense, String specialization) {
        //Getting info from person super class
        super(name, surname, dateOfBirth, mobileNo);
        MedicalLicense = medicalLicense;
        Specialization = specialization;
    }
    @Serial
    //Getters and setters for doctor class
    private static final long serialVersionUID=1L;
    public int getMedicalLicense() {
        return MedicalLicense;
    }

    public void setMedicalLicense(int medicalLicense) {
        MedicalLicense = medicalLicense;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    //public static  Comparator<Doctor> nameCompatator = new Comparator<Doctor>() {
        //@Override
        //public int compare(Doctor o1, Doctor o2) {
            //String docName1 = o1.getSurname().toUpperCase();
            //String docName2 = o2.getSurname().toUpperCase();

            //return docName1.compareTo(docName2);
      // }
   // };

    //@Override
   // public String toString() {
        //return "Doctor{" +
                //"MedicalLicense=" + MedicalLicense +
               //",\n Specialization='" + Specialization + '\'' +
               // ",\n Surname="+ this.getSurname()+",\n Name="+this.getName()+",\nDate of Birth="+this.getDateOfBirth()
               // +",\nMobile="+this.getMobileNo()+
               // '}';
    //}
}


//References
//https://www.geeksforgeeks.org/collections-sort-java-examples/
//https://www.geeksforgeeks.org/comparator-interface-java/
//https://www.tutorialspoint.com/java/java_serialization.htm

