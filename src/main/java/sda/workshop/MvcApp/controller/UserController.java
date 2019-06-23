package sda.workshop.MvcApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import sda.workshop.MvcApp.model.UserDto;
import sda.workshop.MvcApp.service.UserService;

import java.text.ParseException;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/adduser")
    public ModelAndView addUser() {
        return new ModelAndView("userForm", "userToInsert",
                new UserDto());
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute UserDto userDto) throws ParseException {
        System.out.println(userDto.getName() + " " + userDto.getSurname());
        userService.saveUser(userDto);

        return "userSaveResult";
    }

    @GetMapping("/users")
    public String showAllUsers(Model model) {
        List<UserDto> users = userService.getAllUsers();
        model.addAttribute("allUsers", users);
        return "userList";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(@ModelAttribute("user") UserDto userDto) {
        userService.deleteUser(userDto);
        return "userDeleteResult";
    }
}
