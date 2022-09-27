// This is where controlling the repository is set

package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    // Adding a new AppUser to the repository
    public void addNewUser(AppUser appUser){
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(appUser.getEmail());
        if (optionalAppUser.isPresent()){
            throw new IllegalStateException(String.format("user with email %s already exists", appUser.getEmail()));
        }
        appUserRepository.save(appUser);

    }

    // Deleting a AppUser from the repository
    public void deleteUser(AppUser appUser){
        Optional<AppUser> optionalAppUser = appUserRepository.findByEmail(appUser.getEmail());
        if (!optionalAppUser.isPresent()){
            throw new IllegalStateException(String.format("email %s does not exist", appUser.getEmail()));
        }
        appUserRepository.delete(appUser);

    }
}
