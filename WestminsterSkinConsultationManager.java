import java.text.ParseException;
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;


public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    //Declaring arraylists
    public static ArrayList<Doctor> doctorlist = new ArrayList<Doctor>();
    public static ArrayList<Patient> patientlist = new ArrayList<>();

    //Pattern pattern = Pattern.compile("^[a-zA-Z]*$");
    String name;
    String surname;
    String specialization;
    String dateOfBirth;
    String patientId;

    //String nowname;
    Integer mobileNo = 0;
    Integer medicalLicense=0;


    public static void main(String[] args) {
        WestminsterSkinConsultationManager test = new WestminsterSkinConsultationManager();

        try {
            test.readData();
        } catch (IOException ignored) {

        }
        //Displaying the main menu for console
        while (true) {
            Scanner menu = new Scanner(System.in);
            System.out.println("-------MENU--------");
            System.out.println("Please chose option from below");
            System.out.println("1. Add doctor");
            System.out.println("2. Delete doctor");
            System.out.println("3. List of all doctors");
            System.out.println("4. Remove Consultation");
            System.out.println("5. Save to a file");
            System.out.println("6. GUI");
            System.out.println("7. Exit");
            System.out.println("------------------");

            int option = 0; //Getting user inputs for main menu
            try {
                System.out.println("Enter your option");
                option = menu.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Enter an integer");
                continue;
            }
            //Displaying data according to  the selection of the main menu
            switch (option) {
                case 1:
                    test.doctor();
                    break;
                case 2:
                    test.deletedoc();
                    break;
                case 3:
                    test.displaydocs();
                    break;
                case 4: consultationremove();break;

                case 5:
                    textfile();
                    break;
                case 6:
                    new GUI();
                    break;
                case 7:
                    return;

            }
        }


    }

    @Override
    //Method for getting new doctor
    public void doctor() {
        //Scanner docscan = new Scanner(System.in);

        do {
            //Object main = new Object();
            Scanner myObj = new Scanner(System.in);
            //String name = null;
            try {

                System.out.println("Enter first name: ");
                name = myObj.nextLine();


                //String surname;
                System.out.println("Enter Surname: ");
                surname = myObj.nextLine();
                //String specialization;
                System.out.println("Specialization: ");
                specialization = myObj.nextLine();
                //String dateOfBirth;
                System.out.println("Date of Birth: ");
                dateOfBirth = myObj.nextLine();
                //int mobileNo = 0;


                System.out.println("Enter mobile number: ");
                mobileNo = myObj.nextInt();

                //int medicalLicense;
                System.out.println("Enter medical license number: ");
                medicalLicense = myObj.nextInt();



                //Adding user inputs for new object
                Doctor p1 = new Doctor(name, surname, dateOfBirth, mobileNo, medicalLicense, specialization);
                doctorlist.add(p1);
                Scanner newObj = new Scanner(System.in);
                String end;
                //User input for loop
                System.out.println("Do you want to add another doctor?");
                end = newObj.nextLine();
                if (end.equals("yes")) {
                    continue;

                } else if (end.equals("no")) {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e);
            }


        } while (doctorlist.size() < 10);

    }

    //Method for displaying doctors
    private void displaydocs() {
        Collections.sort(doctorlist, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });//Sorting the doctor list
        String Table = "| %-14s | %-14s | %-14s | %-14s | %-14s | %-14s | %n";

        System.out.format("+-----------------------------------------------------------------------------------------------------+%n");
        System.out.format("| List Of The Doctors                                                                                 |%n");
        System.out.format("+----------------+----------------+----------------+----------------+----------------+----------------+%n");
        System.out.format("|  LicenceNumber |   First Name   |    Surname     | Specialisation |  DateOfBirth   |  MobileNumber  |%n");
        System.out.format("+----------------+----------------+----------------+----------------+----------------+----------------+%n");
        for (Doctor d : doctorlist) {
            System.out.format(Table,d.getMedicalLicense(),d.getName(),d.getSurname(),d.getSpecialization(),
                    d.getDateOfBirth(),d.getMobileNo());
        }


    }

    @Override
    //Method for delete doctor
    public void deletedoc() {
        Scanner deleteObj = new Scanner(System.in);
        int regno;
        System.out.println("Enter medical license number: ");
        regno = deleteObj.nextInt();

        for (int a = 0; a <= doctorlist.size(); a++)
            if (doctorlist.get(a).getMedicalLicense() == regno){

                //String removeName = doctorlist.get(a).getName();
                System.out.println("Name: " + doctorlist.get(a).getName());
                System.out.println("Surname: " + doctorlist.get(a).getSurname());
                System.out.println("Date of Birth: " + doctorlist.get(a).getDateOfBirth());
                System.out.println("Mobile No: " + doctorlist.get(a).getMobileNo());
                System.out.println("Medical License: " + doctorlist.get(a).getMedicalLicense());
                System.out.println("Specialisation: " + doctorlist.get(a).getSpecialization());
                doctorlist.remove(a);

                System.out.println("No of doctors: "+doctorlist.size());
                break;
            } else{
                System.out.println("Enter correct medical license.");
                break;
            }
        }




    //Method for text file data saving
    private static void textfile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("systemData.txt"))) {
            for (Doctor doc : doctorlist) {
                out.writeObject(doc);

                System.out.println("Doctor data saved to the file");
            }
            for (Patient pat:patientlist){
                out.writeObject(pat);
                System.out.println("Patient saved");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Method for text file data loading
    void readData() throws IOException {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("systemData.txt"))) {
            doctorlist.add((Doctor) in.readObject());
            patientlist.add((Patient) in.readObject());
        }catch (EOFException ignored){
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    static void consultationremove(){
        if (patientlist.isEmpty()){
            System.out.println("No consultations here.");
        } else{
            Scanner conremove = new Scanner(System.in);
            System.out.println("Enter patient ID: ");
            String patientId = conremove.nextLine();
            for (int b=0;b<patientlist.size();b++){
                if (patientlist.get(b).getPatientId()==patientId){
                    patientlist.remove(b);
                    break;
                }else {
                    System.out.println("Enter correct patient id.");
                }
            }

        }
    }



    @Override
    public void samemediId(Doctor p1) {
        for (Doctor o : doctorlist) {
            if (o.getMedicalLicense() == p1.getMedicalLicense()) {
                System.out.println("Same medical license in is in the list");
                return;

            }
        }
        doctorlist.add(p1);
        System.out.println("\nDoctor added successfully");
    }

}

//References
//https://www.geeksforgeeks.org/for-each-loop-in-java/
//https://www.javatpoint.com/method-overriding-in-java
//https://attacomsian.com/blog/java-write-object-to-file
//https://www.w3schools.com/java/java_regex.asp
//https://www.geeksforgeeks.org/collections-sort-java-examples/