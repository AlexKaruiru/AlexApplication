/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.alex.app.AlexApp.Repo;

import com.alex.app.AlexApp.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USER
 */
public interface UserRepo extends JpaRepository<User, Long>{
    
}
