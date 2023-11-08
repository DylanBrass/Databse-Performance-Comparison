package com.performancetests.demomysqlvsmongodbperformance.Controller;

import com.performancetests.demomysqlvsmongodbperformance.Service.StartTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("performance")
public class Controller {

    @Autowired
    StartTest startTest;

    @GetMapping("/mysql/start")
    public void mysqlPerformance() {
        startTest.startTest();
    }

    @GetMapping("/mongodb/start")
    public void mongodbPerformance() {
        startTest.startMongoTest();
    }
}
