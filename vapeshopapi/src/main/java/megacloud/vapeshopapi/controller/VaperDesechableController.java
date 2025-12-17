package megacloud.vapeshopapi.controller;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.VaperDesechable;
import megacloud.vapeshopapi.service.VaperDesechableService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vaperDesechables")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VaperDesechableController {

    private final VaperDesechableService service;

    @GetMapping
    public ResponseEntity<List<VaperDesechable>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VaperDesechable> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VaperDesechable> create(@RequestBody VaperDesechable vaper) {
        VaperDesechable created = service.create(vaper);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VaperDesechable> update(@PathVariable Integer id, @RequestBody VaperDesechable vaper) {
        vaper.setId(id);
        return ResponseEntity.ok(service.update(vaper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}