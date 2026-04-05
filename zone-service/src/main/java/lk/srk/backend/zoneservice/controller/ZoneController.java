package lk.srk.backend.zoneservice.controller;

import lk.srk.backend.zoneservice.entity.Zone;
import lk.srk.backend.zoneservice.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {
    @Autowired
        private ZoneRepository repo;

    @PostMapping
    public Zone create(@RequestBody Zone zone) {
        if(zone.getMinTemp() >= zone.getMaxTemp()){
            throw new RuntimeException("Invalid temperature range");
        }
        return repo.save(zone);
    }

    @GetMapping("/{id}")
    public Zone get(@PathVariable Long id){
        return repo.findById(id).orElseThrow();
    }
}
