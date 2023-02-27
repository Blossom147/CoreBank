package com.example.core_bank.controller;

import com.example.core_bank.dto.APIReponse;
import com.example.core_bank.entity.AppUser;
import com.example.core_bank.repository.IAppUserRepository;
import com.example.core_bank.service.IUserService;
import com.example.core_bank.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAppUserRepository appUserRepository;

    @GetMapping(value = "/user")
    private APIReponse<List<AppUser>> getUsers(){
        List<AppUser> allUser = userService.getAllUser();
        return new APIReponse<>(allUser.size(),allUser);
    }

    @GetMapping(value = "/user/{field}")
    private APIReponse<List<AppUser>> getUserWithSort(@PathVariable String field){
        List<AppUser> allUser = userService.findUserWithSorting(field);
        return new APIReponse<>(allUser.size(),allUser);
    }

    @GetMapping(value = "/user/pagination/{offset}/{pageSize}")
    private APIReponse<Page<AppUser>> getUserWithPage(@PathVariable int offset, @PathVariable int pageSize){
        Page<AppUser> allUser = userService.findUserWithPagination(offset,pageSize);
        return new APIReponse<>(allUser.getSize(),allUser);
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}
