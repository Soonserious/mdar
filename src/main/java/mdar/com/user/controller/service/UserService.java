package mdar.com.user.controller.service;

import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.user.controller.bug.StatusEnum;
import mdar.com.user.dto.UserDTO;
import mdar.com.springbootConfigure.userSession.UserSession;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    StatusEnum singup(UserDTO userDTO, String[] userRoles);
    StatusEnum accessPatientMain(UserSession userSession);
    StatusEnum accessDoctorMain(UserSession userSession);
    StatusEnum login(UserDTO userDTO, HttpServletRequest request);
    UserDTO selectByUserID(String name);
    List<UserDTO> selectByUserName(String patientName);
    List<UserDTO> selectAllByUserName(int page, int max);
}
