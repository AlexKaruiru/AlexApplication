/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alex.app.AlexApp.Controller;

import com.alex.app.AlexApp.Models.User;
import com.alex.app.AlexApp.Repo.UserRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiControllers {
    @Autowired 
    private UserRepo userRepo;
    
    @GetMapping(value = "/")
     public String getPage () {
         return "Welcome";
     }
    
   // @GetMapping(value ="/users")
     @GetMapping(value = "/users", produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
     public List<User> getUsers(){
       return userRepo.findAll();
     }
     
     //@PostMapping(value ="/save")
     @PostMapping(value ="/save",  
             consumes = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
             produces = { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
     public User saveUser (@RequestBody User user){
         userRepo.save(user);
         System.out.print("Saved...");
         return  user;
       
     }
     
     @PutMapping(value="update/{id}")
     public User updateUser(@PathVariable long id, @RequestBody User user){
         User updatedUser = userRepo.findById(id).get();
         updatedUser.setFirstName(user.getFirstName());
         updatedUser.setLastName(user.getLastName());
         updatedUser.setAge(user.getAge());
         updatedUser.setOccupation(user.getOccupation());
         userRepo.save(updatedUser);
         //return "Updated......";
         return updatedUser;
         
     }
     
     @DeleteMapping(value = "/delete/{id}")
    public String deleteUser (@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id: "+id;
    }
}
