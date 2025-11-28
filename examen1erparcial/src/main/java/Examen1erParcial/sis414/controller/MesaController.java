package Examen1erParcial.sis414.controller;

import Examen1erParcial.sis414.model.Mesa;
import Examen1erParcial.sis414.model.Silla;
import Examen1erParcial.sis414.service.MesaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mesas")
public class MesaController {
    private final MesaService mesaService;

    public MesaController(MesaService mesaService){
        this.mesaService = mesaService;
    }

    // Mesas
    @GetMapping public List<Mesa> getMesas(){ return mesaService.obtenerMesas(); }
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable int id){
        Mesa m = mesaService.obtenerMesaPorId(id);
        if(m==null) return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(m);
    }
    @PostMapping public ResponseEntity<Mesa> addMesa(@RequestBody Mesa m){
        mesaService.agregarMesa(m);
        return ResponseEntity.status(HttpStatus.CREATED).body(m);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> putMesa(@PathVariable int id,@RequestBody Mesa m){
        boolean updated = mesaService.actualizarMesa(id,m);
        if(!updated) return ResponseEntity.badRequest().body(null);
        return ResponseEntity.ok(mesaService.obtenerMesaPorId(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMesa(@PathVariable int id){
        boolean deleted = mesaService.eliminarMesa(id);
        if(!deleted) return ResponseEntity.badRequest().body("Mesa no encontrada");
        return ResponseEntity.noContent().build();
    }

    // Sillas
    @GetMapping("/{idMesa}/sillas")
    public ResponseEntity<List<Silla>> getSillasDeMesa(@PathVariable int idMesa){
        List<Silla> sillas = mesaService.obtenerSillasDeMesa(idMesa);

        if(sillas == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(sillas);
    }

    @PostMapping("/{idMesa}/sillas")
    public ResponseEntity<?> addSilla(@PathVariable int idMesa,@RequestBody Silla s){
        boolean added = mesaService.agregarSillaAMesa(idMesa,s);
        if(!added) return ResponseEntity.badRequest().body("Mesa no encontrada");
        return ResponseEntity.status(HttpStatus.CREATED).body(s);
    }
    @DeleteMapping("/{idMesa}/sillas/{idSilla}")
    public ResponseEntity<?> deleteSilla(@PathVariable int idMesa,@PathVariable int idSilla){
        boolean deleted = mesaService.eliminarSillaDeMesa(idMesa,idSilla);
        if(!deleted) return ResponseEntity.badRequest().body("Mesa o Silla no encontrada");
        return ResponseEntity.noContent().build();
    }
}


