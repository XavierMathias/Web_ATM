// Connecting to the AppUserService
package com.example.demo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api/v1/userapp")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> appUserList(){
        return appUserService.userList();
    }

    // Registering a new user
    @PostMapping
    public void registerNewUser(@RequestBody AppUser appUser){
        appUserService.addNewUser(appUser);
    }

    public void deletingUser(@PathVariable("userId") Long userId){
        appUserService.deleteUser(userId);
    }

    public void updateUser(@PathVariable("userId") Long userId, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName, @RequestParam(required = false) String email){
        appUserService.updateUser(userId, firstName, lastName, email);
    }





}
