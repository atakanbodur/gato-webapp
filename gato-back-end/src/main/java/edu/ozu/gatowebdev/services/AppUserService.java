package edu.ozu.gatowebdev.services;

import edu.ozu.gatowebdev.entities.AppUser;
import edu.ozu.gatowebdev.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository repo;
    public AppUser createUser(AppUser user){
        AppUser userCheck = new AppUser();
        try {
             userCheck = repo.findByUserName(user.getUserName()).get();

        } catch (Exception e) {
            userCheck = repo.save(user);
            return userCheck;
        }
        if(userCheck!=null)
            throw new RuntimeException("User registered");
        return userCheck;
    }
    public Optional<AppUser> getUserByUsername(String name){
        return repo.findByUserName(name);
    }
    public Optional<AppUser> getUserByEmail(String email) { return repo.findByEmail(email); }
    public List<AppUser> getAll(){ return repo.findAll(); }
}
