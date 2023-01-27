import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.io.*;

public class Consultation implements Serializable{
    @Serial
    private static final long serialVersionUID=1L;
    public static ArrayList<Consultation> consultation = new ArrayList<>();
    private Doctor doctor;
    private String DateTime;
    private int Cost;
    private String Notes;

    public Consultation(Doctor doctor, String dateTime, int cost, String notes) {
        this.doctor = doctor;
        DateTime = dateTime;
        Cost = cost;
        Notes = notes;
    }

    public static ArrayList<Consultation> getConsultation() {
        return consultation;
    }

    public static void setConsultation(ArrayList<Consultation> consultation) {
        Consultation.consultation = consultation;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
