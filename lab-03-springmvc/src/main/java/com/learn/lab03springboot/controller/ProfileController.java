package com.learn.lab03springboot.controller;

import com.learn.lab03springboot.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
    public class ProfileController {
        @RequestMapping("/profile") //http://localhost:8080/profile
        public String profile(Model model){
            Profile profile=new Profile();
            profile.setName("Oleksandra");
            profile.setSurname("Slobodian");
            profile.setPhoneNumber("+8005422856");
            profile.setEmail("slobodian@gmail.com");
            profile.setCreatedDate(LocalDateTime.now());
            model.addAttribute("profile",profile);
            return "profile/profile-info";
        }

    }
