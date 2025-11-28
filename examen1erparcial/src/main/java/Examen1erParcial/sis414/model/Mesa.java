package Examen1erParcial.sis414.model;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int id;
    private String material;
    private int cantidadSillas;
    private String forma;
    private List<Silla> sillas = new ArrayList<>();

    // Constructor
    public Mesa(int id, String material, int cantidadSillas, String forma) {
        this.id = id;
        this.material = material;
        this.cantidadSillas = cantidadSillas;
        this.forma = forma;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public int getCantidadSillas() { return cantidadSillas; }
    public void setCantidadSillas(int cantidadSillas) { this.cantidadSillas = cantidadSillas; }

    public String getForma() { return forma; }
    public void setForma(String forma) { this.forma = forma; }

    public List<Silla> getSillas() { return sillas; }
    public void setSillas(List<Silla> sillas) { this.sillas = sillas; }
}

