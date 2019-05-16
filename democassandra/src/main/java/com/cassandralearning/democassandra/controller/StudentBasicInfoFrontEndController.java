package com.cassandralearning.democassandra.controller;

import com.cassandralearning.democassandra.model.StudentBasicInfo;
import com.cassandralearning.democassandra.repository.StudentBasicInfoRepository;
import com.cassandralearning.democassandra.script.PopulateStudentBasicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentBasicInfoFrontEndController {

    @Autowired
    private PopulateStudentBasicInfo populateStudentBasicInfo;

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

    @RequestMapping(value = "/script" , method = RequestMethod.GET)
    public String runScript() {
        return "scriptRun";
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

    @RequestMapping(value = "/scripting", method = RequestMethod.GET)
    @ResponseBody
    public String scripting(@RequestParam int number) {
        populateStudentBasicInfo.finalRun(number);
        return "script ran";
    }
}