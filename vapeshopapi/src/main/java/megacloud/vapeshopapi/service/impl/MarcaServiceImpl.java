package megacloud.vapeshopapi.service.impl;

import lombok.RequiredArgsConstructor;
import megacloud.vapeshopapi.entity.Marca;
import megacloud.vapeshopapi.repository.MarcaRepository;
import megacloud.vapeshopapi.service.MarcaService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MarcaServiceImpl implements MarcaService {

    private final MarcaRepository repository;

    @Override
    public List<Marca> findAll() {
        return repository.findAll();
    }

    @Override
    public Marca findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca no encontrada"));
    }

    @Override
    public Marca create(Marca marca) {
        return repository.save(marca);
    }

    @Override
    public Marca update(Marca marca) {
        if (!repository.existsById(marca.getId())) {
            throw new RuntimeException("Marca no encontrada");
        }
        return repository.save(marca);
    }

    @Override
    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Marca no encontrada");
        }
        repository.deleteById(id);
    }
}