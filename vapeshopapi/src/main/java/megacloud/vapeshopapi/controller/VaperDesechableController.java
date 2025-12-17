package megacloud.vapeshopapi.controller;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.VaperDesechable;
import megacloud.vapeshopapi.service.VaperDesechableService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vaperDesechables")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class VaperDesechableController {

    private final VaperDesechableService service;

    @GetMapping
    public List<VaperDesechable> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public VaperDesechable getById(@PathVariable Integer id) {
        return service.findById(id);
    }
}
