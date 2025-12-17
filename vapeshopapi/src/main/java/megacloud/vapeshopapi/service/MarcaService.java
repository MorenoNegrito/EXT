package megacloud.vapeshopapi.service;

import megacloud.vapeshopapi.entity.Marca;

import java.util.List;

public interface MarcaService {
    List<Marca> findAll();
    Marca findById(Integer id);
}