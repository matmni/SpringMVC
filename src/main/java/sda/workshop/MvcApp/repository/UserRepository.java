package sda.workshop.MvcApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.workshop.MvcApp.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByNameAndSurname(String name, String surname);
}
