package br.unoeste.fipp.ativooperante2024.restcontrollers;

import br.unoeste.fipp.ativooperante2024.db.entities.Denuncia;
import br.unoeste.fipp.ativooperante2024.db.entities.Orgao;
import br.unoeste.fipp.ativooperante2024.db.entities.Tipo;
import br.unoeste.fipp.ativooperante2024.db.entities.Usuario;
import br.unoeste.fipp.ativooperante2024.db.repositories.DenunciaRepository;
import br.unoeste.fipp.ativooperante2024.db.repositories.OrgaoRepository;
import br.unoeste.fipp.ativooperante2024.services.DenunciaService;
import br.unoeste.fipp.ativooperante2024.services.OrgaoService;
import br.unoeste.fipp.ativooperante2024.services.TipoService;
import br.unoeste.fipp.ativooperante2024.services.UsuarioService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("apis/adm/")
public class AdminRestController {
    @Autowired
    OrgaoService orgaoService;

    @Autowired
    DenunciaService denunciaService;

    @Autowired
    TipoService tipoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("teste-conexao")
    public String testeConexao()
    {
        return "conectado";
    }

    // demais apis

    //Orgaos
    @GetMapping("/delete-orgao")
    public ResponseEntity<Object> excluirOrgao(@RequestParam(value="id") Long id)
    {
        if(orgaoService.delete(id))
            return new ResponseEntity<>("",HttpStatus.OK);
        else
            return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/add-orgao")
    public ResponseEntity<Object> salvarOrgao (@RequestBody Orgao orgao)
    {
        Orgao novo;
        novo=orgaoService.save(orgao);
        return new ResponseEntity<>(novo, HttpStatus.OK);
    }

    @GetMapping("/get-orgao")
    public ResponseEntity<Object> buscarUmOrgao(@RequestParam(value="id") Long id)
    {
        Orgao orgao;
        orgao=orgaoService.getById(id);
        if(orgao==null)
            orgao=new Orgao();
        return new ResponseEntity<>(orgao,HttpStatus.OK);
    }
    @GetMapping("/get-all-orgaos")
    public ResponseEntity<Object> buscarTodosOrgaos()
    {
        return new ResponseEntity<>(orgaoService.getAll(),HttpStatus.OK);
    }
    //Denuncias
    @GetMapping("/get-denuncia")
    public ResponseEntity<Object> buscarUmaDenuncia(@RequestParam(value="id") Long id)
    {
        return new ResponseEntity<>(denunciaService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-denuncias")
    public ResponseEntity<Object> buscarTodasDenuncias()
    {
        return new ResponseEntity<>(denunciaService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/add-denuncia")
    public ResponseEntity<Object> salvarDenuncia (@RequestBody Denuncia denuncia)
    {
        return new ResponseEntity<>(denunciaService.save(denuncia),HttpStatus.OK);
    }

    @GetMapping("/delete-denuncia")
    public ResponseEntity<Object> excluirDenuncia(@RequestParam(value="id") Long id)
    {
        if(denunciaService.delete(id))
            return new ResponseEntity<>("",HttpStatus.OK);
        else
            return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }
    //Tipo
    @GetMapping("/get-tipo")
    public ResponseEntity<Object> buscarUmTipo(@RequestParam(value="id") Long id)
    {
        return new ResponseEntity<>(tipoService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-tipos")
    public ResponseEntity<Object> buscarTodosTipo()
    {
        return new ResponseEntity<>(tipoService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/add-tipo")
    public ResponseEntity<Object> salvarTipos (@RequestBody Tipo tipo)
    {
        return new ResponseEntity<>(tipoService.save(tipo),HttpStatus.OK);
    }

    @GetMapping("/delete-tipo")
    public ResponseEntity<Object> excluirTipo(@RequestParam(value="id") Long id)
    {
        if(tipoService.delete(id))
            return new ResponseEntity<>("",HttpStatus.OK);
        else
            return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }


    //Usuario

    @GetMapping("/get-usuario")
    public ResponseEntity<Object> buscarUmUsuario(@RequestParam(value="id") Long id)
    {
        return new ResponseEntity<>(usuarioService.getById(id),HttpStatus.OK);
    }

    @GetMapping("/get-all-usuarios")
    public ResponseEntity<Object> buscarTodosUsuarios()
    {
        return new ResponseEntity<>(usuarioService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/add-usario")
    public ResponseEntity<Object> salvarUsuario (@RequestBody Usuario usuario)
    {
        return new ResponseEntity<>(usuarioService.save(usuario),HttpStatus.OK);
    }

    @GetMapping("/delete-usuario")
    public ResponseEntity<Object> excluirUsuario(@RequestParam(value="id") Long id)
    {
        if(usuarioService.delete(id))
            return new ResponseEntity<>("",HttpStatus.OK);
        else
            return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
    }



}
