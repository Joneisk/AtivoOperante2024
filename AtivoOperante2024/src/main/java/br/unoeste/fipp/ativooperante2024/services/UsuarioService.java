package br.unoeste.fipp.ativooperante2024.services;
import br.unoeste.fipp.ativooperante2024.db.entities.Usuario;
import br.unoeste.fipp.ativooperante2024.db.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repo;

    public Usuario save(Usuario usuario)
    {
        return repo.save(usuario);
    }

    public Usuario getById(Long id)
    {
        return repo.findById(id).get();
    }

    public List<Usuario> getAll()
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
