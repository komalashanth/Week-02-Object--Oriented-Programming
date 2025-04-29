interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    abstract double calculateBill();
}

class InPatient extends Patient implements MedicalRecord {
    private double dailyRate;
    private int daysAdmitted;
    private String medicalHistory;

    InPatient(String patientId, String name, int age, double dailyRate, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRate = dailyRate;
        this.daysAdmitted = daysAdmitted;
        this.medicalHistory = "";
    }

    @Override
    double calculateBill() {
        return dailyRate * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        this.medicalHistory += record + "\n";
    }

    @Override
    public void viewRecords() {
        if (medicalHistory.isEmpty()) {
            System.out.println("No medical records available.");
        } else {
            System.out.println("Medical History:\n" + medicalHistory);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String treatmentDetails;

    OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.treatmentDetails = "";
    }

    @Override
    double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.treatmentDetails += record + "\n";
    }

    @Override
    public void viewRecords() {
        if (treatmentDetails.isEmpty()) {
            System.out.println("No treatment records available.");
        } else {
            System.out.println("Treatment Details:\n" + treatmentDetails);
        }
    }
}

public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = new Patient[4];
        patients[0] = new InPatient("IP123", "John Doe", 45, 200, 5);
        patients[1] = new OutPatient("OP456", "Jane Smith", 30, 150);
        patients[2] = new InPatient("IP789", "Alice Johnson", 60, 250, 7);
        patients[3] = new OutPatient("OP101", "Bob Brown", 35, 100);

        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + patient.calculateBill());

            if (patient instanceof MedicalRecord) {
                MedicalRecord recordPatient = (MedicalRecord) patient;
                recordPatient.addRecord("Diagnosis: Common cold");
                recordPatient.viewRecords();
            }

            System.out.println();
        }
    }
}

