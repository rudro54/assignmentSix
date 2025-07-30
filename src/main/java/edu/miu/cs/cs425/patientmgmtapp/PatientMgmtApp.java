package edu.miu.cs.cs425.patientmgmtapp;
import edu.miu.cs.cs425.patientmgmtapp.model.Patient;
import edu.miu.cs.cs425.patientmgmtapp.repository.PatientRepository;

import java.util.Arrays;
import java.util.Comparator;

public class PatientMgmtApp {
    private final PatientRepository patientRepository;

    public PatientMgmtApp() {
        this.patientRepository = PatientRepository.getInstance();
    }
    public static void main(String[] args) {
        System.out.println("Professor I am Zayed and this is my assignment");

        var app = new PatientMgmtApp();
        var patients = app.patientRepository.getAllPatients();
         var sortedPatients = Arrays.stream(patients)
                .sorted(Comparator.comparing(Patient::getAge).reversed()).toList();

        System.out.println(app.patientRepository.toJSONByHand((sortedPatients)));

    }
}
