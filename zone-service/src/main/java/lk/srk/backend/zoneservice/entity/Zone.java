package lk.srk.backend.zoneservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Zone {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double minTemp;
    private Double maxTemp;
    private String deviceId;
}
