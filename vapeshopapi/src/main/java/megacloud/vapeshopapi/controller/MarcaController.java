package megacloud.vapeshopapi.controller;


import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.Marca;
import megacloud.vapeshopapi.service.MarcaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MarcaController {

    private final MarcaService service;

    @GetMapping
    public List<Marca> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Marca getById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
