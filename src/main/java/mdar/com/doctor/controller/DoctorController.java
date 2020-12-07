package mdar.com.doctor.controller;

import lombok.AllArgsConstructor;
import mdar.com.doctor.dto.ClinicDTO;
import mdar.com.doctor.dto.PrescriptionDTO;
import mdar.com.doctor.service.DoctorService;
import mdar.com.user.dto.UserDTO;
import mdar.com.util.NextPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @GetMapping( "/main")
    public String dispDoctorMain(Principal principal, Model model){
        String name = principal.getName();
        List<ClinicDTO> clinicDTOList = this.doctorService.selectPatientListByUserID(name);
        model.addAttribute("clinicDTOList", clinicDTOList);
        return "/doctor/main";
    }

    @GetMapping("/searchPatient")
    public String searchPatient(NextPageDTO page, HttpServletRequest request, Model model){
        String patientName = request.getParameter("pateintName");
        List<UserDTO> userDTOList = this.doctorService.selectPatientListByUserName(patientName, page);
        model.addAttribute("patientList",userDTOList);
        return "/doctor/searchPatient";
    }

    @PostMapping("/createClinic")
    public String createClinic(Principal principal, Model model, HttpServletRequest request){
        String patientID = request.getParameter("patientID");
        this.doctorService.createClinic(patientID, principal.getName());
        return "redirect:/doctor/main";
    }

    @GetMapping("/selectClinic")
    public String selectClinic(Principal principal, HttpServletRequest request){
        String patientID = request.getParameter("patientID");
        ClinicDTO clinicDTO = this.doctorService.selectClinic(principal.getName(), patientID);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("clinicDTO",clinicDTO);
        return "redirect:/doctor/prescription";
    }

    @GetMapping("/prescription")
    public String dispPrescription(Principal principal, Model model, HttpServletRequest request, NextPageDTO page){
        HttpSession httpSession = request.getSession();
        ClinicDTO clinicDTO = (ClinicDTO)httpSession.getAttribute("clinicDTO");
        List<PrescriptionDTO> prescriptionDTOList = doctorService.selectPrescriptionListByClinic(clinicDTO, page);
        model.addAttribute("prescriptionDTOList", prescriptionDTOList);
        return "/doctor/prescription";
    }
}
