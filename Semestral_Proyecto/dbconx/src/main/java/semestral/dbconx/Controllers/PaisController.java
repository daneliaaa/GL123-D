package semestral.dbconx.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semestral.dbconx.Models.Paises;
import semestral.dbconx.Services.PaisDB;

@RestController
public class PaisController {
   
    @GetMapping("/paises/all")
    public List<Paises> ObtenerPais(){
        return new PaisDB().ObtenerPais();
    }

    @PostMapping("/pais")
    public int InsertarPais(@RequestBody Paises paises){
        return new PaisDB().GuardarPais(paises);
    }

    @PutMapping("/pais")
    public int ActualizarProducto(@RequestBody Paises pais) {
        return new PaisDB().ActualizarPaises(pais);
    }

    @DeleteMapping("/pais/{codpais}")
    public int Delete(@PathVariable("codpais") int codpais) {
        return new PaisDB().EliminarPais(codpais);
  }
}
