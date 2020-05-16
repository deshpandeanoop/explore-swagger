package com.github.swagger;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonsController {
    private final Map<String, Person> personMap = new HashMap<>();

    @PostMapping
    @ApiOperation(value = "Adds person into the system, please make sure to use verified PAN")
    public void add(@RequestBody Person person){
        personMap.put(person.getPanNumber(), person);
    }

    @GetMapping("/{pan}")
    @ApiOperation(value = "Returns person details based on PAN")
    public Person fetchByPAN(@PathVariable("pan") String pan){
        return personMap.get(pan);
    }

    @GetMapping
    @ApiOperation(value = "Returns all persons in system")
    public List<Person> get(){
        return new ArrayList<>(personMap.values());
    }
}