package com.crud.controller;

import com.crud.dao.UserRepository;
import com.crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Pc on 08.10.2017.
 */
@Controller

public class UserController {

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getUsers(ModelMap model) {
        List<User> users = this.repository.getAll();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.GET)
    public String addUser() {
        return "addUser";
    }

    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam(value = "isAdmin",
            required = true, defaultValue = "false") Boolean isAdmin) {
        User user = new User(name, Integer.parseInt(age), isAdmin);
        user.setCreatedDate();
        this.repository.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        this.repository.removeUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.GET)
    public String getUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("userAttribute", this.repository.get(id));
        return "updateUser";
    }

    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST)
    public String postUpdate(@RequestParam("name") String name, @RequestParam("age") String age, @RequestParam(value = "isAdmin",
            required = true, defaultValue = "false") Boolean isAdmin, @PathVariable Integer id, Model model) {
        User user = this.repository.get(id);
        user.setName(name);
        user.setAge(Integer.valueOf(age));
        user.setAdmin(isAdmin);
        repository.updateUser(user);
        return "redirect:/";
    }

}
