package com.performancetests.demomysqlvsmongodbperformance.Controller;

import com.performancetests.demomysqlvsmongodbperformance.Service.RelationalStartTest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("relational/speed")
@RequiredArgsConstructor
public class RelationalSpeedController {
    private final RelationalStartTest relationalStartTest;

    @PostMapping("/race/singleInsert/start")
    public void singleInsertRace() throws InterruptedException {
        relationalStartTest.speedTestSingleInsertOfRelationship();
    }

}
