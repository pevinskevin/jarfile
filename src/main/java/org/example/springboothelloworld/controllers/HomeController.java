package org.example.springboothelloworld.controllers;
import org.example.springboothelloworld.models.Person;
import org.example.springboothelloworld.models.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @Autowired private ListCreator listCreator;

    @GetMapping("/")
    public String index(Model model) {

        ArrayList<Something> list = listCreator.getList();
        model.addAttribute("list", list);

        Person newPerson = new Person(12, "Kevin", "Strandberg");

        model.addAttribute("id", newPerson.getId());
        model.addAttribute("firstName", newPerson.getFirstName());
        model.addAttribute("lastName", newPerson.getLastName());

        Person anotherPerson = new Person(28, "Niels Peter", "Strandberg");

        model.addAttribute("anotherPerson", anotherPerson);


        return "home/index";
    }
}
