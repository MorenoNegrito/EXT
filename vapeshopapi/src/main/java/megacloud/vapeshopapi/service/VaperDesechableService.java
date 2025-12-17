package megacloud.vapeshopapi.service;

import megacloud.vapeshopapi.entity.VaperDesechable;

import java.util.List;

public interface VaperDesechableService {
    List<VaperDesechable> findAll();
    VaperDesechable findById(Integer id);
    VaperDesechable create(VaperDesechable vaper);
    VaperDesechable update(VaperDesechable vaper);
    void delete(Integer id);
}