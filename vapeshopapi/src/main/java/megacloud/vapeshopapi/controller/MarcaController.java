package megacloud.vapeshopapi.controller;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.Marca;
import megacloud.vapeshopapi.service.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    public ResponseEntity<List<Marca>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marca> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Marca> create(@RequestBody Marca marca) {
        Marca created = service.create(marca);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marca> update(@PathVariable Integer id, @RequestBody Marca marca) {
        marca.setId(id);
        return ResponseEntity.ok(service.update(marca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}