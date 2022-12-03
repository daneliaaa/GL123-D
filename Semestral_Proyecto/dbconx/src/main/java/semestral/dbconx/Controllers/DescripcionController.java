package semestral.dbconx.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import semestral.dbconx.Models.Descripcion;
import semestral.dbconx.Services.DescripcionDB;

@RestController
public class DescripcionController {
    @GetMapping("/descripciones/all")
    public List<Descripcion> obtenerDescripcion(){
        return new DescripcionDB().obtenerDescripcion();
    }

    @PostMapping("/descripcion")
    public int InsertarDescripcion(@RequestBody Descripcion descripcion){
        return new DescripcionDB().GuardarDescripcion(descripcion);   
    }

    @PutMapping("/descripcion")
    public int ActualizarDescripcion(@RequestBody Descripcion descripcion) {
        return new DescripcionDB().ActualizarDescripcion(descripcion);
    }

    @DeleteMapping("/descripcion/{cod_desc}")
    public int Delete(@PathVariable("cod_desc") int cod_desc) {
        return new DescripcionDB().EliminarDescripcion(cod_desc);
  }
}
