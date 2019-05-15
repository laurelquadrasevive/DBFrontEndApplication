package com.cassandralearning.democassandra.controller;

import com.cassandralearning.democassandra.model.StudentBasicInfo;
import com.cassandralearning.democassandra.repository.StudentBasicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentBasicInfoController {

    @Autowired
    private StudentBasicInfoRepository studentBasicInfoRepository;

    @PostConstruct
    public void savePerson() {
        List<StudentBasicInfo> people = new ArrayList<>();
        people.add(new StudentBasicInfo(2, "Lionel", "12121", "Barkur", 22));
        people.add(new StudentBasicInfo(3, "Lona", "12651", "Dubai", 28));
        people.add(new StudentBasicInfo(4, "Leenurs", "12765", "USA", 32));
        studentBasicInfoRepository.saveAll(people);
    }

    @GetMapping("/getAllStudentBasicInfo")
    public List<StudentBasicInfo> getPerson() {
        return studentBasicInfoRepository.findAll();
    }

    @GetMapping("/getAllStudentBasicInfoFilterByAge/{age}")
    public List<StudentBasicInfo> getPersonfilterbyAge(@PathVariable int age) {
        return studentBasicInfoRepository.findByIdGreaterThan(age);
    }

    @GetMapping("/getAllStudentBasicInfoById/{id}")
    public Optional <StudentBasicInfo> getPersonById(@PathVariable int id) {
        return studentBasicInfoRepository.findById(id);
    }

    @GetMapping("/insert/{id}/{name}/{password}/{location}/{age}")
    public String insert(@PathVariable int id, @PathVariable String name, @PathVariable String password,
                       @PathVariable String location, @PathVariable int age) {
        StudentBasicInfo studentBasicInfo = new StudentBasicInfo(id, name, password, location, age);
        studentBasicInfoRepository.save(studentBasicInfo);
        return "User with ID "+id+" is added";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        studentBasicInfoRepository.deleteById(id);
        return "User with ID "+id+" is deleted";
    }

    @GetMapping("/error")
    public String errorPage() {
        return "URL entered in incorrect";
    }

}
