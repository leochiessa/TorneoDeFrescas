package TorneoDeFrescas;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public class App {
    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TorneoDeFrescas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");

        List<Vikingo> equipoVikingos = Arrays.asList(new Vikingo("Leonardo", 32, 75, new OrinarVikingo(), new BeberVikingo(), 70),
                new Vikingo("Gabriel", 35, 82, new OrinarVikingo(), new BeberVikingo(), 100),
                new Vikingo("Chiessa", 33, 77, new OrinarVikingo(), new BeberVikingo(), 80),
                new Vikingo("Lunghi", 34, 80, new OrinarVikingo(), new BeberVikingo(), 90));

        List<Espartano> equipoEspartanos = Arrays.asList(new Espartano("Juan", 29, 90, new OrinarEspartano(), new BeberEspartano(), 90),
                new Espartano("Ignacio", 30, 95, new OrinarEspartano(), new BeberEspartano(), 100),
                new Espartano("Algo", 32, 105, new OrinarEspartano(), new BeberEspartano(), 120),
                new Espartano("Mas", 31, 100, new OrinarEspartano(), new BeberEspartano(), 110));

        Collections.sort(equipoVikingos, Comparator.comparing(vikingo -> vikingo.getPeso()));
        Collections.sort(equipoEspartanos, Comparator.comparing(espartano -> espartano.getPeso()));

        System.out.println("VIKINGOS: " + equipoVikingos);
        System.out.println("ESPARTANOS: " + equipoEspartanos);

        String ganador = desafio(equipoVikingos.get(0), equipoEspartanos.get(0));

        persistir(con, ganador);
    }

    private static String desafio(Vikingo v, Espartano e) {

        String ganador = null;

        System.out.println("\n" + v.getNombre() + " - " + v.getEdad().toString() + " años - " + v.getPeso().toString() + " kg. - Profesional: " + v.getBebedorProfesional().toString() + ", VIKINGO     - VS -     " + e.getNombre() + " - " + e.getEdad().toString() + " años - " + e.getPeso().toString() + " kg. - Tolerancia: " + e.getToleranciaExtra().toString() + ", ESPARTANO");

        Integer v1 = v.getBebedorProfesional();
        Integer e1 = e.getToleranciaExtra();

        while (v1 != 0 && e1 != 0) {
            v1 = v1 - v.getBeber().beber();
            e1 = e1 - e.getBeber().beber();
        }

        if (v1 == 0) {
            System.out.println("\n FIN: " + v.getOrinar().orinar());
            ganador = e.getNombre() + ";" + e1;
        } else if (e1 == 0) {
            System.out.println("\n FIN: " + e.getOrinar().orinar());
            ganador = v.getNombre() + ";" + v1;
        }

        return ganador;
    }

    private static void persistir(Connection con, String ganador) throws SQLException {

        try {
            String[] parts = ganador.split(";");
            String part1 = parts[0];
            String part2 = parts[1];

            PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into resultado values(0, ?, ?)");
            ps.setString(1, parts[0]);
            ps.setString(2, parts[1]);
            ps.execute();
            ps.close();
            System.out.println("Datos guardados correctamente.");
        } catch (Exception ex) {
            System.out.println("Errror al guardar los datos.\n" + ex);
        } finally {
            if (!con.isClosed()) {
                con.close();
            }
        }
    }
}