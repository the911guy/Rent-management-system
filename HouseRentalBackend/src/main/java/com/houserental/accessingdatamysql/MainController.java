package com.houserental.accessingdatamysql;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/rent")
public class MainController {
    @Autowired
    private UserRepository userRepository;
    private HouseRepository houseRepository;

    @PostMapping(path = "/newuser")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody User addNewUser(@RequestBody User owner) {

        // User n = new User();
        // System.out.println(bj);
        // System.out.println(bj.name);
        // n.setName(bj.name);
        // n.setEmail(bj.email);
        // userRepository.save(bj);

        return userRepository.save(owner);
    }

    @GetMapping(path = "/showusers")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/allhouses")
    public @ResponseBody Iterable<Houses> getAllHouses() {
        return houseRepository.findAll();
    }

    @PostMapping("/newhouse")
    public @ResponseBody Houses addNewHouse(@RequestBody Houses newHouse) {
        return houseRepository.save(newHouse);
    }

    // byId User

    @GetMapping("/User/{id}")
    User one(@PathVariable int id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    // delete User
    @DeleteMapping("/User/{id}")
    void deleteUser(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    // byId house

    @GetMapping("/houses/{id}")
    Houses theHouse(@PathVariable int id) {

        return houseRepository.findById(id)
                .orElseThrow(() -> new HouseNotFoundException(id));
    }

    // putbyId house with owner

    // @PutMapping("/employees/{id}")
    // Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable
    // Long id) {

    // return repository.findById(id)
    // .map(employee -> {
    // employee.setName(newEmployee.getName());
    // employee.setRole(newEmployee.getRole());
    // return repository.save(employee);
    // })
    // .orElseGet(() -> {
    // newEmployee.setId(id);
    // return repository.save(newEmployee);
    // });
    // }

    // deleteHouse
    @DeleteMapping("/houses/{id}")
    void deleteHouse(@PathVariable int id) {
        houseRepository.deleteById(id);
    }

}
