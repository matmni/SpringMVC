package sda.workshop.MvcApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.workshop.MvcApp.entity.User;
import sda.workshop.MvcApp.model.UserDto;
import sda.workshop.MvcApp.repository.UserRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public void deleteUser(UserDto userDto) {
        User user = userRepository
                .findUserByNameAndSurname(userDto.getName(), userDto.getSurname())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        userRepository.delete(user);
    }


    public void saveUser(UserDto userDto) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newDateFormat = sdf.format(new Date());
        userDto.setJoinDate(sdf.parse(newDateFormat));

        User userToSave = modelMapper.map(userDto, User.class);
        userRepository.save(userToSave);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
//        List<UserDto> usersDto = new ArrayList<>();
//        for(User user : users) {
//            usersDto.add(modelMapper.map(user, UserDto.class));
//        }

        return users.stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }
}
