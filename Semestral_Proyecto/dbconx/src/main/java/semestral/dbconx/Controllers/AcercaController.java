package semestral.dbconx.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semestral.dbconx.Models.Acerca;
import semestral.dbconx.Services.AcercaDB;

@RestController
public class AcercaController {
    @GetMapping("/acercas/all")
    public List<Acerca> obtenerAcerca(){
        return new AcercaDB().obtenerAcerca();
    }

    @PostMapping("/acerca")
    public int InsertarAcerca(@RequestBody Acerca acerca){
        return new AcercaDB().GuardarAcerca(acerca);   
    }

    @PutMapping("/acerca")
    public int ActualizarAcerca(@RequestBody Acerca acerca) {
        return new AcercaDB().ActualizarAcerca(acerca);
    }

    @DeleteMapping("/acerca/{cod_acer}")
    public int Delete(@PathVariable("cod_acer") int cod_acer) {
        return new AcercaDB().EliminarAcerca(cod_acer);
        
  }
}
