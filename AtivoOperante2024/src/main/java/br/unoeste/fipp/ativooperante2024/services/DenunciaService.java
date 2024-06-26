package br.unoeste.fipp.ativooperante2024.services;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import br.unoeste.fipp.ativooperante2024.db.repositories.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DenunciaService {

    @Autowired
    private DenunciaRepository repo;

    public Denuncia save(Denuncia denuncia)
    {
        return repo.save(denuncia);
    }

    public Denuncia getById(Long id)
    {
        return repo.findById(id).get();
    }

    public List<Denuncia> getAll()
    {
        return repo.findAll();
    }

    public boolean delete(Long id)
    {
        try{
            repo.deleteById(id);

        }
        catch (Exception e)
        {
            return false;
        }
        return true;
    }
}
