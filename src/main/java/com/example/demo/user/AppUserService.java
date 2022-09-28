// This is where controlling the repository is set

package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AppUserService {


    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> userList(){
        return appUserRepository.findAll();
    }

    // Adding a new AppUser to the repository
    public void addNewUser(AppUser appUser){
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(appUser.getEmail());
        if (optionalAppUser.isPresent()){
            throw new IllegalStateException(String.format("user with email %s already exists", appUser.getEmail()));
        }
        appUserRepository.save(appUser);

    }

    // Deleting a AppUser from the repository by id
    public void deleteUser(Long userId){
        boolean exists = appUserRepository.existsById(userId); // check if the user id exists
        if (!exists){
            throw new IllegalStateException(String.format("user with id " + userId + " doesn't exists"));
        }
        appUserRepository.deleteById(userId);

    }

    public void updateUser(Long userId, String firstName, String lastName, String email) {

        AppUser user = appUserRepository.findById(userId).orElseThrow( () -> new IllegalStateException("user " + userId + " does not exist"));

        if (firstName != null && firstName.length() > 0 && !Objects.equals(user.getFirstName(), firstName)){
            user.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 && !Objects.equals(user.getLastName(), lastName)){
            user.setFirstName(firstName);
        }

        // check if the newEmail to be updated is already taken
        if (email != null && email.length() > 0 && !Objects.equals(user.getEmail(), email)){
            Optional<AppUser> appUser = appUserRepository.findByEmail(email);
            if (appUser.isPresent()){
                throw new IllegalStateException("email taken");
            }
        }



        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);


    }
}
