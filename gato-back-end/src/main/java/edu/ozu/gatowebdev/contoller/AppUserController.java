package edu.ozu.gatowebdev.contoller;

import edu.ozu.gatowebdev.entities.AppUser;
import edu.ozu.gatowebdev.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")


public class AppUserController {

    @Autowired
    AppUserService service;

    @GetMapping("/test")
    public ResponseEntity<String> Test() {
        String str = "tst";
        return ResponseEntity.ok().body(str);
    }

    @PostMapping("/save-user")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser user) {
            AppUser createdUser = service.createUser(user);
            System.out.println("User created. \n" + user.toString());
            return ResponseEntity.ok().body(createdUser);
    }

    @GetMapping("/get-user-by-name/{name}")
    public ResponseEntity<Optional<AppUser>> getUserByUsername(@PathVariable String name){
        return ResponseEntity.ok().body(service.getUserByUsername(name));
    }


}