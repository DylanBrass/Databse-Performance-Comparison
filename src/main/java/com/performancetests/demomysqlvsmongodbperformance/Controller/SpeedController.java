package com.performancetests.demomysqlvsmongodbperformance.Controller;

import com.performancetests.demomysqlvsmongodbperformance.Service.StartTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("speed")
public class SpeedController {

    @Autowired
    StartTest startTest;
    @GetMapping("/race/singleInsert/{num}/start")
    public void raceStart(@PathVariable int num) throws InterruptedException {
        startTest.speedTestSingleInsert(num);
    }

    @GetMapping("/race/bulk/start")
    public void raceBulkStart()  {
        startTest.speedTestBulkInsert();
    }

    @GetMapping("/race/selectAll/start")
    public void raceSelectAllStart()  {
        startTest.speedTestSelect();
    }

    @GetMapping("/race/deleteAll/start")
    public void raceDeleteAllStart()  {
        startTest.speedDeleteRace();
    }


}
