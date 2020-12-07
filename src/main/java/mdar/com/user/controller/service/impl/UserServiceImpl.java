package mdar.com.user.controller.service.impl;

import lombok.AllArgsConstructor;
import mdar.com.doctor.Entity.ClinicEntity;
import mdar.com.user.controller.bug.StatusEnum;
import mdar.com.user.controller.service.UserService;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.dto.UserRoleDTO;
import mdar.com.user.entity.UserEntity;
import mdar.com.user.entity.UserRoleEntity;
import mdar.com.user.repository.UserRepositroy;
import mdar.com.springbootConfigure.userSession.UserSession;
import mdar.com.user.repository.UserRoleRepository;
import mdar.com.user.security.SecurityUser;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired private UserRepositroy userRepository;
    @Autowired private UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public StatusEnum singup(UserDTO userDTO, String[] userRoles) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserEntity userEntity = UserEntity.toEntity(userDTO);
        List<UserRoleDTO> userRoleDTOS = UserRoleDTO.makingUserRoleDTOs(userRoles);
        StatusEnum statusEnum = null;
        try {
            userRepository.save(userEntity);
            for(UserRoleDTO userRoleDTO : userRoleDTOS){
                userRoleDTO.setUserEntity(userEntity);
                userRoleRepository.save(UserRoleEntity.toEntity(userRoleDTO));
            }
            statusEnum = StatusEnum.SuccessSignUp;
        }catch (Exception e){
            e.printStackTrace();
            statusEnum = StatusEnum.FailSignUp;
        }
        return statusEnum;
    }


    @Override
    public StatusEnum accessPatientMain(UserSession userSession) {
        return null;
    }

    @Override
    public StatusEnum accessDoctorMain(UserSession userSession) {
        return null;
    }

    @Override
    public StatusEnum login(UserDTO userDTO, HttpServletRequest request) {
        StatusEnum statusEnum = null;
        try{
//            userDTO = UserDTO.toDTO(this.userRepository.findByUserID(UserEntity.toEntity(userDTO)));
            List<GrantedAuthority> authorities = new ArrayList<>();
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",userDTO);
            statusEnum = StatusEnum.SuccessSignIn;
        }catch (Exception e){
            statusEnum = StatusEnum.FailSignIn;
        }
        return statusEnum;
    }

    @Override
    public UserDTO selectByUserID(String name) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserID(name);
        UserEntity userEntity = optionalUserEntity.get();
        return UserDTO.toDTO(userEntity);
    }

    @Override
    public List<UserDTO> selectByUserName(String patientName) {
        List<UserDTO> result = new ArrayList<>();
        List<UserEntity> userEntityList = userRepository.findByName(patientName);
        for(UserEntity userEntity : userEntityList){
            result.add(UserDTO.toDTO(userEntity));
        }
        return result;
    }

    @Override
    public List<UserDTO> selectAllByUserName(int page, int max) {
        Page<UserEntity> userEntityPage = userRepository.findAll(PageRequest.of(page-1, max));
        List<UserDTO> userDTOList = new ArrayList<>();
        for(UserEntity userEntity: userEntityPage){
            userDTOList.add(UserDTO.toDTO(userEntity));
        }
        return userDTOList;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntitys = this.userRepository.findByUserID(username);
        UserEntity userEntity = userEntitys.get();
        List<UserRoleEntity> userRoles = this.userRoleRepository.findByUserEntity(userEntity);
        List<GrantedAuthority> roles = SecurityUser.makingGrantedAuthority(userRoles);
        return new SecurityUser(userEntity.getUserID(), userEntity.getPassword(), roles);
    }
}
