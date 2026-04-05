package lk.srk.backend.zoneservice.service;

import lk.srk.backend.zoneservice.entity.Zone;
import lk.srk.backend.zoneservice.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ZoneService {

    private final ZoneRepository repo;

    // ✅ Constructor Injection
    public ZoneService(ZoneRepository repo) {
        this.repo = repo;
    }

    public Zone save(Zone zone) {
        if(zone.getMinTemp() >= zone.getMaxTemp()) {
            throw new RuntimeException("Invalid temperature range");
        }

        zone.setDeviceId(UUID.randomUUID().toString());
        return repo.save(zone);
    }

    public Zone get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Zone not found"));
    }
}