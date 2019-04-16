package TorneoDeFrescas;

public class Espartano extends Humano {
    private Integer toleranciaExtra;

    public Espartano(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer toleranciaExtra) {
        super(nombre, edad, peso, orinar, beber);
        this.toleranciaExtra = toleranciaExtra;
    }

    public Integer getToleranciaExtra() {
        return toleranciaExtra;
    }

    public void setToleranciaExtra(Integer toleranciaExtra) {
        this.toleranciaExtra = toleranciaExtra;
    }

    @Override
    public String toString(){
        return this.getNombre() + " - " + this.getEdad() + " años - " + this.getPeso() + " kg. - Tolerancia: " + this.getToleranciaExtra();
    }
}