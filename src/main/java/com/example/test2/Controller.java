package com.example.test2;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.MessageInterpolator;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.executable.ValidateOnExecution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class Controller {

    List<Person> ar = new ArrayList<>();


    @PostConstruct
    private void init() {
    }


    @GetMapping(value = "/person")
    public List<Person> Person1(){
     /*   Person build  = new Person.PersonBuilder()
                         .setname("HEH")
                         .setage(21)
                         .setid(1)
                         .build();

      */
        return ar;
    }

    @PostMapping(path = "/person")
    public Person add(@Valid @RequestBody  Person b){
        ar.add(b);
        return b;

    }

    @PostMapping(path ="/persons")
    public void addAll( @RequestBody @NotEmpty(message = "People List can't be empty") @Validated List< Person> people){
        ar.addAll(people);

    }

    @GetMapping(value = "/person/{id}")
    @ResponseBody
    public Person search(@PathVariable("id") int pid){


        return ar.stream().filter(Person->Person.getId()==pid).findFirst().get();

    }
    enum lang{
        arabic,english,french;
    }

    @PutMapping(value = "person/{id}")
    public String update(@PathVariable("id") int pid, @Valid @RequestBody   Person p){
        List<Person> l2 = new ArrayList<>();
        l2= ar.stream().filter(Person->Person.getId()==pid).collect(Collectors.toList());
        l2.get(0).setAge(p.getAge());
        l2.get(0).setId(p.getId());
        l2.get(0).setName(p.getName());
        l2.get(0).setPhoneNumber(p.getPhoneNumber());
        l2.get(0).setDepId(p.getDepId());
        return "UPDATED";
    }


    @DeleteMapping(value = "person/{id}")
    public String delete(@PathVariable("id") int pid)
    {
        List<Person> l2 = new ArrayList<>();
        l2= ar.stream().filter(Person->Person.getId()==pid).collect(Collectors.toList());
        ar.remove(l2.get(0));
        return "Removed";
    }

    @GetMapping(value = "/dep")
    public List<Person> findDepartmentPeople (@RequestParam int depId ){
        List<Person> l2 = new ArrayList<>() ;
        l2= ar.stream().filter(Person->Person.getDepId()==depId).collect(Collectors.toList());
        return l2;

    }


}