package com.cassandralearning.democassandra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentBasicInfoMainController {

    @RequestMapping(value = "/")
    public String mainpage() {
        return "mainpage";
    }

    @RequestMapping(value = "/insertingToDB")
    public String insertingToDB() {
        return "insertToDB";
    }

    @RequestMapping(value = "/updatingToDB")
    public String updatingToDB() {
        return "updateToDB";
    }

    @RequestMapping(value = "/deletingToDB")
    public String deletingToDB() {
        return "deleteDB";
    }

    @RequestMapping(value = "/scriptingToDB")
    public String scriptingToDB() {
        return "scriptRun";
    }
}
