package com.github.swagger;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {
    private final Map<String, Person> personMap = new HashMap<>();

    @PostMapping
    public void add(@RequestBody Person person){
        personMap.put(person.getPanNumber(), person);
    }

    @GetMapping("/{pan}")
    public Person fetchByPAN(@PathVariable("pan") String pan){
        return personMap.get(pan);
    }

    @GetMapping
    public List<Person> get(){
        return new ArrayList<>(personMap.values());
    }

}