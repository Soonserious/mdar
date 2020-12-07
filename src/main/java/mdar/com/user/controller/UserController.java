package mdar.com.user.controller;

import lombok.AllArgsConstructor;
import mdar.com.user.controller.bug.StatusEnum;
import mdar.com.user.controller.service.UserService;
import mdar.com.user.dto.UserDTO;
import mdar.com.user.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String home(){
        return "/main/main";
    }

    @GetMapping("/signup")
    public String dispSignUp(){
        return "/user/signup";
    }

    @PostMapping(value = "/signup")
    public String execSignup(UserDTO userDTO, HttpServletRequest request){
        StatusEnum status = this.userService.singup(userDTO, request.getParameterValues("userRole"));
        switch (status){
            case FailSignUp:
                return "";
        }
        return "/user/signup";
    }

    @GetMapping("/login")
    public String disLogin(){ return "/user/signup";}

    @PostMapping("/login")
    public String execSignIn(@RequestBody UserDTO userDTO, HttpServletRequest request){
        StatusEnum status = this.userService.login(userDTO, request);
        switch (status){
            case FailSignIn:
                return "user/denied";
        }
        return "template/user/main";
    }

    @GetMapping("/successLogin")
    public String successLogin(){
        return "/user/successLogin";
    }

}
