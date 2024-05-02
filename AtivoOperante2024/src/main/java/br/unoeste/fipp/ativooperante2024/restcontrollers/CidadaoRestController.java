package br.unoeste.fipp.ativooperante2024.restcontrollers;

import br.unoeste.fipp.ativooperante2024.services.DenunciaService;
import br.unoeste.fipp.ativooperante2024.services.OrgaoService;
import br.unoeste.fipp.ativooperante2024.services.TipoService;
import br.unoeste.fipp.ativooperante2024.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/cidadao/")
public class CidadaoRestController {
    @Autowired
    private OrgaoService orgaoService;

    @Autowired
    private DenunciaService denunciaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TipoService tipoService;

    @GetMapping("teste-conexao")
    public String testeConexao()
    {
        return "conectado";
    }
    // demais apis
    @GetMapping("/get-all-orgaos")
    public ResponseEntity<Object> buscarTodosOrgaos()
    {
        return new ResponseEntity<>(orgaoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get-all-denuncias")
    public ResponseEntity<Object> buscarTodasDenuncias()
    {
        return new ResponseEntity<>(denunciaService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get-all-usuarios")
    public ResponseEntity<Object> buscarTodosUsuarios()
    {
        return new ResponseEntity<>(usuarioService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/get-all-tipos")
    public ResponseEntity<Object> buscarTodosTipo()
    {
        return new ResponseEntity<>(tipoService.getAll(),HttpStatus.OK);
    }

}
