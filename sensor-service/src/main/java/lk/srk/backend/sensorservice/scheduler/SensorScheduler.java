package lk.srk.backend.sensorservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SensorScheduler {

    @Scheduled(fixedRate = 10000)
    public void fetchData(){
        System.out.println("Fetching sensor data...");
    }
}
