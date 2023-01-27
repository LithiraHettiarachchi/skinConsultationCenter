import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;


public class GUI extends WestminsterSkinConsultationManager implements ActionListener{
    JLabel l1, l2, l3, l6, l7, l8;
    JTextField tf1, tf2, tf5, tf6, tf7;
    JButton btn1;



    //Creating Main GUI Interface
    public GUI() {
        //Creating main gui
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();





        panel.setBackground(new Color(102,178,255));

        //Getting 4 buttons for main interface

        JButton checkDoctors = new JButton("Doctor List");
        checkDoctors.setMargin(new Insets(10,10,10,10));
        JButton sortButton = new JButton("Sorted Doctor List");
        sortButton.setMargin(new Insets(10,10,10,10));
        JButton consultationButton = new JButton("Consultation");
        consultationButton.setMargin(new Insets(10,10,10,10));
        JButton showConsultation = new JButton("Consultation Details");
        showConsultation.setMargin(new Insets(10,10,10,10));

        checkDoctors.getModel().addChangeListener(new ChangeListener() {
        //Changing colors of the buttons
            @Override
            public void stateChanged(ChangeEvent e) {
                ButtonModel model = (ButtonModel) e.getSource();

                if (model.isRollover()) {
                    checkDoctors.setBackground(new Color(204, 229, 255).darker());
                    sortButton.setBackground(new Color(204,229,255).darker());
                    consultationButton.setBackground(new Color(204,229,255).darker());
                    showConsultation.setBackground(new Color(204,229,255).darker());
                } else if (model.isPressed()) {
                    checkDoctors.setBackground(Color.BLUE);
                    sortButton.setBackground(Color.BLUE);
                    consultationButton.setBackground(Color.BLUE);
                    showConsultation.setBackground(Color.BLUE);
                } else {
                    checkDoctors.setBackground(new Color(204, 229, 255));
                    sortButton.setBackground(new Color(204,229,255));
                    consultationButton.setBackground(new Color(204,229,255));
                    showConsultation.setBackground(new Color(204,229,255));
                }
            }
        });
        //Defining action listeners for main interface buttons

        checkDoctors.addActionListener((ActionListener ) this);
        sortButton.addActionListener(e -> sortDoctors());


        consultationButton.addActionListener(e -> consultationform());





        showConsultation.addActionListener(e -> showConsultations());


        //Adding buttons to the panel
        panel.setBorder(BorderFactory.createEmptyBorder(100, 150, 150, 150));
        panel.setLayout(new GridLayout(0, 2));
        panel.add(checkDoctors);
        panel.add(consultationButton);
        panel.add(sortButton);
        panel.add(showConsultation);
        //Setting up the panel
        panel.setPreferredSize(new Dimension(500,500));
        frame.add(panel, BorderLayout.PAGE_START);//Adding panel to the jframe
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);
        frame.setTitle("Westminster Skin Consultation");
        frame.setSize(1000, 1000);
        frame.pack();
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        doctorListWindow();
    }

    public void doctorListWindow() {

        //Creating table for doctor list
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("Date of Birth");
        model.addColumn("Mobile Number");
        model.addColumn("Medical License");
        model.addColumn("Specialisation");

        //Getting information for doctor list table
        for (Doctor doctor : doctorlist) {
            model.addRow(new Object[]{doctor.getName(), doctor.getSurname(), doctor.getDateOfBirth(), doctor.getMobileNo(),
                    doctor.getMedicalLicense(), doctor.getSpecialization()});
        }

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame newF1 = new JFrame("Doctor List");

        table.setEnabled(false);
        newF1.add(scrollPane, BorderLayout.CENTER);
        newF1.setSize(1000, 720);
        newF1.setVisible(true);


    }
    public void sortDoctors() {

        //Creating table for sorted doctor list
        DefaultTableModel stable = new DefaultTableModel();
        stable.addColumn("First Name");
        stable.addColumn("Last Name");
        stable.addColumn("Date of Birth");
        stable.addColumn("Mobile Number");
        stable.addColumn("Specialisation");
        stable.addColumn("Medical License Number");

        //Adding data to sorted doctor list table
        Collections.sort(doctorlist, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor o1, Doctor o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });
        for (Doctor doctor : doctorlist) {
            stable.addRow(new Object[]{doctor.getName(), doctor.getSurname(), doctor.getDateOfBirth(), doctor.getMobileNo(),
                    doctor.getMedicalLicense(), doctor.getSpecialization()});
        }

        JTable table = new JTable(stable);

        table.getSelectedColumn();

        JScrollPane scrollPane = new JScrollPane(table);

        //New Jframe for sorted doctor list table
        JFrame f2 = new JFrame("Doctors with sorted surnames");
        table.setEnabled(false);
        f2.add(scrollPane, BorderLayout.CENTER);
        f2.setSize(1000, 720);
        f2.setVisible(true);
    }
    //Creating consultation form
    public void consultationform() {


                JFrame newF2 = new JFrame("Form");
                JComboBox<String> dropdown = new JComboBox<>();
                for (Doctor drp : doctorlist) {
                    dropdown.addItem(drp.getName());
                }
                newF2.setVisible(true);
                newF2.setEnabled(true);
                newF2.setSize(700, 700);
                newF2.setLayout(null);
                //newF2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                newF2.setTitle("Registration Form in Java");
                l1 = new JLabel("Patient Registration Form");
                l1.setForeground(Color.blue);
                l1.setFont(new Font("Serif", Font.BOLD, 20));
                l2 = new JLabel("Name:");
                l3 = new JLabel("Surname:");
                l6 = new JLabel("Date of Birth:");
                l7 = new JLabel("Mobile No:");
                l8 = new JLabel("Id:");
                tf1 = new JTextField();
                tf2 = new JTextField();
                tf5 = new JTextField();
                tf6 = new JTextField();
                tf7 = new JTextField();
                btn1 = new JButton("Submit");
                l1.setBounds(100, 30, 400, 30);
                l2.setBounds(80, 70, 200, 30);
                l3.setBounds(80, 110, 200, 30);
                l6.setBounds(80, 230, 200, 30);
                l7.setBounds(80, 270, 200, 30);
                l8.setBounds(80, 310, 200, 30);
                tf1.setBounds(300, 70, 200, 30);
                tf2.setBounds(300, 110, 200, 30);
                tf5.setBounds(300, 230, 200, 30);
                tf6.setBounds(300, 270, 200, 30);
                tf7.setBounds(300, 310, 200, 30);
                btn1.setBounds(50, 350, 100, 30);
                newF2.add(l1);
                newF2.add(l2);
                newF2.add(tf1);
                newF2.add(l3);
                newF2.add(tf2);
                newF2.add(l6);
                newF2.add(tf5);
                newF2.add(l7);
                newF2.add(tf6);
                newF2.add(l8);
                newF2.add(tf7);
                newF2.add(btn1);
                newF2.add(dropdown);

                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == btn1){
                            int d=0;
                            String s1 = tf1.getText();
                            String s2 = tf2.getText();
                            String s3 = tf5.getText();
                            String s4 = tf6.getText();
                            String s5 = tf7.getText();
                            //Adding form data to patient list
                            if (s5 != null){
                                Patient p2 = new Patient(name,surname,dateOfBirth,mobileNo,patientId);
                                p2.setName(s1);
                                p2.setSurname(s2);
                                p2.setDateOfBirth(s3);
                                p2.setMobileNo(Integer.parseInt(s4));
                                p2.setPatientId(s5);
                                patientlist.add(p2);
                                JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
                                //Cleaning form after submiting
                                tf1.setText("");
                                tf2.setText("");
                                tf5.setText("");
                                tf6.setText("");
                                tf7.setText("");
                            }
                        }
                    }
                });




    }
    //Method for consultation list table
    public void showConsultations(){
        DefaultTableModel ctable = new DefaultTableModel();
        ctable.addColumn("First Name");
        ctable.addColumn("Last Name");
        ctable.addColumn("Date of Birth");
        ctable.addColumn("Mobile Number");
        ctable.addColumn("PatientId");
        ctable.addColumn("Cost");
        for (Patient patient:patientlist){
            ctable.addRow(new Object[]{patient.getName(), patient.getSurname(), patient.getDateOfBirth(), patient.getMobileNo(),
                    patient.getPatientId()});
        }
        JTable table = new JTable(ctable);

        JScrollPane scrollPane = new JScrollPane(table);

        JFrame newF1 = new JFrame("Doctor List");

        table.setEnabled(false);
        newF1.add(scrollPane, BorderLayout.CENTER);
        newF1.setSize(1000, 720);
        newF1.setVisible(true);

    }

}





//References
//https://youtu.be/5o3fMLPY7qY
//https://youtu.be/0H9GLWajgTE
//https://stackoverflow.com/questions/35537615/how-to-align-buttons-in-the-middle-java
//https://www.c-sharpcorner.com/UploadFile/fd0172/registration-form-in-windows-form-using-swing-in-java/
//https://www.javatpoint.com/java-actionlistener