package megacloud.vapeshopapi.service.impl;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.VaperDesechable;
import megacloud.vapeshopapi.repository.VaperDesechableRepository;
import megacloud.vapeshopapi.service.VaperDesechableService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VaperDesechableServiceImpl
        implements VaperDesechableService {

    private final VaperDesechableRepository repository;

    @Override
    public List<VaperDesechable> findAll() {
        return repository.findAll();
    }

    @Override
    public VaperDesechable findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}
