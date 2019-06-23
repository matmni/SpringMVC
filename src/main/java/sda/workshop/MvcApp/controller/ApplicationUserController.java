package sda.workshop.MvcApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.workshop.MvcApp.model.ApplicationUserDto;
import sda.workshop.MvcApp.service.ApplicationUserService;

import javax.validation.Valid;

@Controller
public class ApplicationUserController {
    @Autowired
    private ApplicationUserService service;

    @GetMapping("/addapplicationuser")
    public ModelAndView addApplicationUser() {
        return new ModelAndView("userApplicationForm",
                "applicationUserToInsert", new ApplicationUserDto());
    }

    @PostMapping("/addapplicationuser")
    public String addApplicationUser(@ModelAttribute @Valid ApplicationUserDto applicationUserDto,
                                     BindingResult result) {
        service.addNewApplicationUser(applicationUserDto, result);
        return "userSaveResult";
    }
}
