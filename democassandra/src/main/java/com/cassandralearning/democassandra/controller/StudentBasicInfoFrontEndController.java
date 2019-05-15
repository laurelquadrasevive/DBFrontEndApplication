package com.cassandralearning.democassandra.controller;

import com.cassandralearning.democassandra.model.StudentBasicInfo;
import com.cassandralearning.democassandra.repository.StudentBasicInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class StudentBasicInfoFrontEndController {

    @Autowired
    private StudentBasicInfoRepository studentBasicInfoRepository;

    @RequestMapping("/insertToDB")
    public String insertTODB( ) {
        return "insertTODB";
    }

    @RequestMapping("/deleteFromDB")
    public String deleteFromDB() {
        return "deleteDB";
    }

    @RequestMapping("/updateToDB")
    public String updateToDB() {
        return "updateToDB";
    }

    @RequestMapping(value = "/inserting", method = RequestMethod.GET)
    @ResponseBody
    public String inserting(@RequestParam int id, @RequestParam String name, @RequestParam String password,
                            @RequestParam String location, @RequestParam int age) {
        StudentBasicInfo studentBasicInfo = new StudentBasicInfo(id, name, password, location, age);
        studentBasicInfoRepository.save(studentBasicInfo);
        return "inserted in db";
    }

    @RequestMapping(value = "/deleting", method = RequestMethod.GET)
    @ResponseBody
    public String deleting(@RequestParam int id) {
        studentBasicInfoRepository.deleteById(id);
        return "deleted in db";
    }

    @RequestMapping(value = "/updating", method = RequestMethod.GET)
    @ResponseBody
    public String updating(@RequestParam int id, @RequestParam String name, @RequestParam String password,
                           @RequestParam String location, @RequestParam int age) {
        Optional<StudentBasicInfo> studentBasicInfoPresent =studentBasicInfoRepository.findById(id);
        if (studentBasicInfoPresent.isPresent()) {
            StudentBasicInfo studentBasicInfo = new StudentBasicInfo(id,name,password,location,age);
            studentBasicInfoRepository.save(studentBasicInfo);
        }
        else {
            return "User not present in DB";
        }
        return "updated user in db";
    }
}
