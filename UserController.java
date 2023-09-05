package com.example.springassesment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestContorller
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        User u =new User();
        u.setUserId(u.getUserId());
        u.setUserName(u.getUserName());
        u.setUserEmail(u.getUserEmail());
        u.setGender(u.getGender());
        u.setNationality(u.getNationality());
        return u;
    }
    @GetMapping("/viewAll")
    public @ResponseBody Iterable<User> getAllUsers() {
                return userRepository.findAll();
    }

    @PutMapping("/edit/{id}")
    public String update(@RequestBody final User updateUser, @PathVariable Integer id) {
                return userRepository.findById(id)
                        .map(User -> {
                            User.setUserId(updateUser.getUserId());
                            User.setUserName(updateUser.getUserName());
                            User.setUserEmail(updateUser.getUserEmail());
                            User.setAge(updateUser.getAge());
                            User.setGender(updateUser.getGender());
                            User.setNationality(updateUser.getNationality());
                            userRepository.save(User);
                            return " User details have been successfully updated";
                        }).orElseGet(() -> {
                            return "Invalid user !!!!";
                        });
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
                    userRepository.deleteById(id);
                    return "User deleted !!!!";

    }



}
