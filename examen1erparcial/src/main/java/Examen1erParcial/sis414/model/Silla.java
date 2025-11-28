package Examen1erParcial.sis414.model;

public class Silla {
    private int id;
    private String material;
    private boolean conRespaldo;

    public Silla(int id, String material, boolean conRespaldo) {
        this.id = id;
        this.material = material;
        this.conRespaldo = conRespaldo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    public boolean isConRespaldo() { return conRespaldo; }
    public void setConRespaldo(boolean conRespaldo) { this.conRespaldo = conRespaldo; }
}
