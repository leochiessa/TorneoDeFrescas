package TorneoDeFrescas;

public class Humano {
    private String nombre;
    private Integer edad;
    private Integer peso;
    private Orinar orinar;
    private Beber beber;

    public Humano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.orinar = orinar;
        this.beber = beber;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public Orinar getOrinar() {
        return orinar;
    }

    public Beber getBeber() {
        return beber;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
}