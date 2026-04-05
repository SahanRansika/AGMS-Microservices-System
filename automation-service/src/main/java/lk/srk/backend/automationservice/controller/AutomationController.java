package lk.srk.backend.automationservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    @PostMapping("/process")
    public String process(@RequestBody Map<String,Object> data){

        double temp = (double) data.get("temperature");

        if(temp > 30){
            return "TURN_FAN_ON";
        }
        else if(temp < 20){
            return "TURN_HEATER_ON";
        }

        return "NORMAL";
    }
}
