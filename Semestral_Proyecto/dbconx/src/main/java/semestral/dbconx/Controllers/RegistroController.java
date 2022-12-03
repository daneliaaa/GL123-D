package semestral.dbconx.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semestral.dbconx.Models.Registro;
import semestral.dbconx.Services.RegistroDB;

@RestController
public class RegistroController {
    @GetMapping("/registros/all")
    public List<Registro> ObtenerPais(){
        return new RegistroDB().obtenerRegistros();
    }

    @PostMapping("/registro")
    public int InsertarPais(@RequestBody Registro registro){
        return new RegistroDB().GuardarRegistro(registro);   
    }

    @PutMapping("/registro")
    public int ActualizarRegistro(@RequestBody Registro registro) {
        return new RegistroDB().ActualizarRegistros(registro);
    }

    @DeleteMapping("/registro/{correo}")
    public int Delete(@PathVariable("correo") int correo) {
        return new RegistroDB().EliminarRegistro(correo);
  }
}
