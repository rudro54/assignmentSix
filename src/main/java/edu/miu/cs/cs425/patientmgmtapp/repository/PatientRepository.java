package edu.miu.cs.cs425.patientmgmtapp.repository;
import edu.miu.cs.cs425.patientmgmtapp.model.Patient;

import java.time.LocalDate;
import java.util.List;


public class PatientRepository {
    private static PatientRepository instance;
    private PatientRepository() {}
    public static synchronized PatientRepository getInstance() {
        if (instance == null) {
            instance = new PatientRepository();
        }
        return instance;
    }
    public Patient[] getAllPatients(){
        return new Patient[]{
                new Patient(1, "Daniel", "Agar", "(641) 123-0009", "dagar@m.as", "1 N Street", LocalDate.of(1987, 1, 19)),
                new Patient(2, "Ana", "Smith", null, "amsith@te.edu", null, LocalDate.of(1948, 12, 5)),
                new Patient(3, "Marcus", "Garvey", "(123) 292-0018", null, "4 East Ave", LocalDate.of(2001, 9, 18)),
                new Patient(4, "Jeff", "Goldbloom", "(999) 165-1192", "jgold@es.co.za", null, LocalDate.of(1995, 2, 28)),
                new Patient(5, "Mary", "Washington", null, null, "30 W Burlington", LocalDate.of(1932, 5, 31))
        };
    }

    public String toJSONByHand(List<Patient> patients) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");

        for (int i = 0; i < patients.size(); i++) {
            Patient p = patients.get(i);
            sb.append(String.format("""
            {
              "id": %d,
              "firstName": "%s",
              "lastName": "%s",
              "phone": "%s",
              "email": "%s",
              "address": "%s",
              "dateOfBirth": "%s",
              "age": %d
            }%s
            """,
                    p.getId(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.getPhone() != null ? p.getPhone() : "",
                    p.getEmail() != null ? p.getEmail() : "",
                    p.getAddress() != null ? p.getAddress() : "",
                    p.getDateOfBirth().toString(),
                    p.getAge(),
                    (i < patients.size() - 1) ? "," : ""  // comma except after last item
            ));
        }

        sb.append("]");
        return sb.toString();
    }
}
