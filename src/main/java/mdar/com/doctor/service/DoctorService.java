package mdar.com.doctor.service;


import mdar.com.doctor.dto.ClinicDTO;
import mdar.com.doctor.dto.PrescriptionDTO;
import mdar.com.user.dto.UserDTO;
import mdar.com.util.NextPageDTO;

import java.util.List;

public interface DoctorService {
    List<ClinicDTO> selectPatientListByUserID(String userID);
    List<UserDTO> selectPatientListByUserName(String patientName, NextPageDTO page);
    void createClinic(String patientID, String name);
    ClinicDTO selectClinic(String name, String patientID);
    List<PrescriptionDTO> selectPrescriptionListByClinic(ClinicDTO clinicDTO, NextPageDTO page);
}
