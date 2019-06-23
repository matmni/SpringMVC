package sda.workshop.MvcApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.workshop.MvcApp.entity.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    Long countByUsername(String username);
}
