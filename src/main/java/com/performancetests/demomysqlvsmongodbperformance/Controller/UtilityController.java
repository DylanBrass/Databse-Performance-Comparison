package com.performancetests.demomysqlvsmongodbperformance.Controller;

import com.performancetests.demomysqlvsmongodbperformance.Service.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("utilities")
public class UtilityController {
    @Autowired
    Utilities utilities;

    @RequestMapping("/clear")
    public void clear() {
        utilities.clear();
    }

}
