package mdar.com.doctor.service.impl;

import java.util.ArrayList;
import java.util.List;

import mdar.com.doctor.dto.ClinicDTO;
import mdar.com.doctor.dto.PrescriptionDTO;
import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.doctor.Entity.PrescriptionEntity;
import mdar.com.doctor.repository.ClinicRepository;
import mdar.com.doctor.repository.PrescriptionRepository;
import mdar.com.doctor.service.DoctorService;
import mdar.com.user.controller.service.UserService;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.util.NextPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {
    @Autowired
    UserService userService;

    @Autowired
    ClinicRepository clinicRepository;

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Override
    public List<ClinicDTO> selectPatientListByUserID(String userID) {
        UserDTO userDTO = userService.selectByUserID(userID);
        List<ClinicEntity> clinicEntityList = clinicRepository.findByDoctor(UserEntity.toEntity(userDTO));
        List<ClinicDTO> result = new ArrayList<>();
        for(ClinicEntity clinicEntity : clinicEntityList){
            result.add(ClinicDTO.toDTO(clinicEntity));
        }
        return result;
    }

    @Override
    public List<UserDTO> selectPatientListByUserName(String patientName, NextPageDTO page) {
        List<UserDTO> result = null;
        if(patientName == null) result = this.userService.selectAllByUserName(page.getPage(), page.getMax());
        else result = this.userService.selectByUserName(patientName);
        return result;
    }

    @Override
    public void createClinic(String patientID, String name) {
        UserDTO doctor = userService.selectByUserID(name);
        UserDTO patient = userService.selectByUserID(patientID);
        ClinicDTO clinicDTO = ClinicDTO.builder().doctor(doctor).patient(patient).build();
        clinicRepository.save(ClinicEntity.toEntity(clinicDTO));
    }

    @Override
    public ClinicDTO selectClinic(String name, String patientID) {
        UserDTO doctor = userService.selectByUserID(name);
        UserDTO patient = userService.selectByUserID(patientID);
        ClinicEntity clinicEntity = clinicRepository.findByDoctorAndPatient(UserEntity.toEntity(doctor), UserEntity.toEntity(patient));
        return ClinicDTO.toDTO(clinicEntity);
    }

    @Override
    public List<PrescriptionDTO> selectPrescriptionListByClinic(ClinicDTO clinicDTO, NextPageDTO page) {
        Page<PrescriptionEntity> prescriptionEntities = prescriptionRepository.findByClinicEntity(ClinicEntity.toEntity(clinicDTO), PageRequest.of(page.getPage()-1, page.getMax()));
        List<PrescriptionDTO> result = new ArrayList<>();
        for(PrescriptionEntity prescriptionEntity : prescriptionEntities){
            result.add(PrescriptionDTO.toDTO(prescriptionEntities));
        }
        return result;
    }

}
