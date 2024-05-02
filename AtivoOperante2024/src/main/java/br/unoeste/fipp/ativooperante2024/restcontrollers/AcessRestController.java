package br.unoeste.fipp.ativooperante2024.restcontrollers;


import br.unoeste.fipp.ativooperante2024.db.entities.Usuario;
import br.unoeste.fipp.ativooperante2024.security.JWTTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apis/security/")
public class AcessRestController {

    @PostMapping("logar")
    public ResponseEntity<Object> logar(@RequestBody Usuario usuario)//@RequestBody, escreve no Body
    {
        String token="Não autenticado";
        //Acesso ao BD para verificar a existência do usuário
        //comparar a senha
        if(usuario.getSenha()==123)
        {
            token=JWTTokenProvider.getToken(usuario.getEmail(), ""+usuario.getNivel());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.badRequest().body(token);//retorna o token também, pois ele vai estar com a informaçãp não autenticado
    }
}
