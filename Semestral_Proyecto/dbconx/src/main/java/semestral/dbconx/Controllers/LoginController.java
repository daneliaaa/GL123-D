package semestral.dbconx.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semestral.dbconx.Models.Login;
import semestral.dbconx.Services.LoginDB;

@RestController
public class LoginController {
    @GetMapping("/logins/all")
    public List<Login> obtenerLogin(){
        return new LoginDB().obtenerLogin();
    }

    @PostMapping("/login")
    public int InsertarLogin(@RequestBody Login login){
        return new LoginDB().GuardarLogin(login);   
    }

    @PutMapping("/login")
    public int ActualizarLogin(@RequestBody Login login) {
        return new LoginDB().ActualizarLogin(login);
    }

    @DeleteMapping("/login/{cod_log}")
    public int Delete(@PathVariable("cod_log") int cod_log) {
        return new LoginDB().EliminarLogin(cod_log);
  }
}
