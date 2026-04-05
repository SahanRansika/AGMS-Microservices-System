package lk.srk.backend.automationservice.service;

import lk.srk.backend.automationservice.dto.SensorData;
import lk.srk.backend.automationservice.dto.Zone;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AutomationService {

    private final RestTemplate restTemplate;

    // ✅ Constructor Injection
    public AutomationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void process(SensorData data) {

        Zone zone = restTemplate.getForObject(
                "http://localhost:8081/api/zones/" + data.getZoneId(),
                Zone.class
        );

        if (zone == null) {
            System.out.println("Zone not found!");
            return;
        }

        if (data.getTemperature() > zone.getMaxTemp()) {
            System.out.println("🔥 TURN_FAN_ON");
        } else if (data.getTemperature() < zone.getMinTemp()) {
            System.out.println("❄️ TURN_HEATER_ON");
        } else {
            System.out.println("✅ NORMAL");
        }
    }
}
