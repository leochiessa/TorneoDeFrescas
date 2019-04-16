package TorneoDeFrescas;

public class Vikingo extends Humano {
    private Integer bebedorProfesional;

    public Vikingo(String nombre, Integer edad, Integer peso, Orinar orinar, Beber beber, Integer bebedorProfesional) {
        super(nombre, edad, peso, orinar, beber);
        this.bebedorProfesional = bebedorProfesional;
    }

    public Integer getBebedorProfesional() {
        return bebedorProfesional;
    }

    public void setBebedorProfesional(Integer bebedorProfesional) {
        this.bebedorProfesional = bebedorProfesional;
    }

    @Override
    public String toString(){
        return this.getNombre() + " - " + this.getEdad() + " años - " + this.getPeso() + " kg. - Profesional: " + this.getBebedorProfesional();
    }
}