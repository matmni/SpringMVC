package sda.workshop.MvcApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import sda.workshop.MvcApp.entity.ApplicationUser;
import sda.workshop.MvcApp.model.ApplicationUserDto;
import sda.workshop.MvcApp.repository.ApplicationUserRepository;
import sda.workshop.MvcApp.service.validation.Validator;

@Service
public class ApplicationUserService {

    private ApplicationUserRepository repository;
    private ModelMapper mapper;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void addNewApplicationUser(ApplicationUserDto applicationUserDto,
                                      BindingResult result) {
        Validator.validateExceptions(result);
        if (repository.countByUsername(applicationUserDto.getUsername()) > 0) {
            throw new RuntimeException("User exist");
        }
        checkUserRole(applicationUserDto);

        ApplicationUser applicationUser = mapper.map(applicationUserDto, ApplicationUser.class);
        repository.save(applicationUser);
    }

    private void checkUserRole(ApplicationUserDto applicationUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loggedUserRole = authentication.getAuthorities().toArray()[0].toString();

        switch (loggedUserRole) {
            case "ROLE_ADMIN":
                break;

            case "ROLE_USER":
                if ("ROLE_ADMIN".equals(applicationUserDto.getRole())) {
                    throw new RuntimeException("Invalid Role!");
                }
                break;

            default:
                throw new RuntimeException("Invalid Role!");
        }
    }
}
