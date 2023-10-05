package com.performancetests.demomysqlvsmongodbperformance.Controller;

import com.performancetests.demomysqlvsmongodbperformance.Service.StartTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("speed")
public class SpeedController {

    @Autowired
    StartTest startTest;
    @RequestMapping("/race/singleInsert/start")
    public void raceStart() throws InterruptedException {
        startTest.speedTestSingleInsert();
    }

    @RequestMapping("/race/bulk/start")
    public void raceBulkStart() throws InterruptedException {
        startTest.speedTestBulkInsert();
    }

}
