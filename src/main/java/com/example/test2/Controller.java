package com.example.test2;

import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

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
    public Person add(@RequestBody Person b){
        ar.add(b);
        return b;

    }

    @GetMapping(value = "/person/{id}")
    @ResponseBody
    public Person search(@PathVariable("id") int pid){


        return ar.stream().filter(Person->Person.getId()==pid).findFirst().get();

    }

    @PutMapping(value = "person/{id}")
    public String update(@PathVariable("id") int pid, @RequestBody   Person p){
        List<Person> l2 = new ArrayList<>();
        l2= ar.stream().filter(Person->Person.getId()==pid).collect(Collectors.toList());
        l2.get(0).setAge(p.getAge());
        l2.get(0).setId(p.getId());
        l2.get(0).setName(p.getName());
        return "UPDATED";
    }


    @DeleteMapping(value = "person/{id}")
    public String delete(@PathVariable("id") int pid)
    {
        List<Person> l2 = new ArrayList<>();
        l2= ar.stream().filter(Person->Person.getId()==pid).collect(Collectors.toList());
        ar.remove(l2.get(0));
        System.out.println("Last one2");
        return "Removed";
    }

    @GetMapping(value = "/dep")
    public List<Person> findDepartmentPeople (@RequestParam int depId ){
        List<Person> l2 = new ArrayList<>() ;
        l2= ar.stream().filter(Person->Person.getDepId()==depId).collect(Collectors.toList());
        return l2;

    }

}