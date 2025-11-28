package Examen1erParcial.sis414.service;

import Examen1erParcial.sis414.model.Mesa;
import Examen1erParcial.sis414.model.Silla;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MesaService {
    private final List<Mesa> listaMesas = new ArrayList<>();

    public MesaService() {
        listaMesas.add(new Mesa(1, "Madera", 4, "Rectangular"));
        listaMesas.add(new Mesa(2, "Metal", 6, "Redonda"));
    }


    // Mesas
    public List<Mesa> obtenerMesas() { return listaMesas; }
    public Mesa obtenerMesaPorId(int id) {
        return listaMesas.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
    public void agregarMesa(Mesa mesa) { listaMesas.add(mesa); }
    public boolean eliminarMesa(int id) { return listaMesas.removeIf(m -> m.getId() == id); }
    public boolean actualizarMesa(int id, Mesa nuevaMesa) {
        Mesa mesaExistente = obtenerMesaPorId(id);
        if (mesaExistente == null) return false;
        mesaExistente.setMaterial(nuevaMesa.getMaterial());
        mesaExistente.setCantidadSillas(nuevaMesa.getCantidadSillas());
        mesaExistente.setForma(nuevaMesa.getForma());
        return true;
    }
    public boolean actualizarParcialMesa(int id, Map<String,Object> updates) {
        Mesa mesaExistente = obtenerMesaPorId(id);
        if (mesaExistente == null) return false;
        updates.forEach((key,value) -> {
            switch(key){
                case "material" -> mesaExistente.setMaterial((String)value);
                case "cantidadSillas" -> mesaExistente.setCantidadSillas((Integer)value);
                case "forma" -> mesaExistente.setForma((String)value);
            }
        });
        return true;
    }

    // Sillas
    public List<Silla> obtenerSillasDeMesa(int idMesa) {
        Mesa mesa = obtenerMesaPorId(idMesa);

        if (mesa == null) return null;

        return mesa.getSillas();
    }
    public boolean agregarSillaAMesa(int idMesa, Silla silla){
        Mesa mesa = obtenerMesaPorId(idMesa);
        if(mesa == null) return false;
        mesa.getSillas().add(silla);
        mesa.setCantidadSillas(mesa.getSillas().size());
        return true;
    }
    public boolean eliminarSillaDeMesa(int idMesa, int idSilla){
        Mesa mesa = obtenerMesaPorId(idMesa);
        if(mesa == null) return false;
        boolean removed = mesa.getSillas().removeIf(s -> s.getId() == idSilla);
        mesa.setCantidadSillas(mesa.getSillas().size());
        return removed;
    }
}
