import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pruebas de Jugador - Supervivientes")
public class JugadorTest {

    private Jugador jugador;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Juan", "Recolector");
    }

    @Test
    @DisplayName("Constructor inicializa correctamente")
    void testConstructor() {
        assertEquals("Juan", jugador.getNombre());
        assertEquals("Recolector", jugador.getEspecialidad());
        assertEquals(100, jugador.getSalud());
        assertEquals(100, jugador.getEnergia());
    }

    @Test
    @DisplayName("Salud inicial es 100")
    void testSaludInicial() {
        assertEquals(100, jugador.getSalud());
    }

    @Test
    @DisplayName("Energía inicial es 100")
    void testEnergiaInicial() {
        assertEquals(100, jugador.getEnergia());
    }

    @Test
    @DisplayName("Restar energía")
    void testRestarEnergia() {
        jugador.restarEnergia(20);
        assertEquals(80, jugador.getEnergia());
    }

    @Test
    @DisplayName("Restar energía múltiples veces")
    void testRestarEnergia_Multiple() {
        jugador.restarEnergia(30);
        jugador.restarEnergia(20);
        assertEquals(50, jugador.getEnergia());
    }

    @Test
    @DisplayName("Recuperar energía")
    void testRecuperarEnergia() {
        jugador.restarEnergia(50);
        jugador.recuperarEnergia(30);
        assertEquals(80, jugador.getEnergia());
    }

    @Test
    @DisplayName("Energía no excede máximo")
    void testRecuperarEnergia_NoExcedeMax() {
        jugador.restarEnergia(10);
        jugador.recuperarEnergia(50);
        assertTrue(jugador.getEnergia() <= 100);
    }

    @Test
    @DisplayName("Restar salud")
    void testRestarSalud() {
        jugador.restarSalud(10);
        assertEquals(90, jugador.getSalud());
    }

    @Test
    @DisplayName("Restar salud múltiples veces")
    void testRestarSalud_Multiple() {
        jugador.restarSalud(20);
        jugador.restarSalud(15);
        assertEquals(65, jugador.getSalud());
    }

    @Test
    @DisplayName("Comer recupera salud")
    void testComer() {
        jugador.restarSalud(30);
        jugador.comer(25);
        assertEquals(95, jugador.getSalud());
    }

    @Test
    @DisplayName("Salud no excede máximo")
    void testComer_NoExcedeMax() {
        jugador.comer(50);
        assertTrue(jugador.getSalud() <= 100);
    }

    @Test
    @DisplayName("Jugador está vivo inicialmente")
    void testEstaVivo_Inicial() {
        assertTrue(jugador.estaVivo());
    }

    @Test
    @DisplayName("Jugador muere si salud <= 0")
    void testEstaVivo_Muerto() {
        jugador.restarSalud(100);
        assertFalse(jugador.estaVivo());
    }

    @Test
    @DisplayName("Información del jugador")
    void testGetInfo() {
        String info = jugador.getInfo();
        assertTrue(info.contains("Juan"));
        assertTrue(info.contains("100"));
    }

    @Test
    @DisplayName("Especialidad Recolector")
    void testEspecialidad_Recolector() {
        Jugador j = new Jugador("Ana", "Recolector");
        assertEquals("Recolector", j.getEspecialidad());
    }

    @Test
    @DisplayName("Especialidad Constructor")
    void testEspecialidad_Constructor() {
        Jugador j = new Jugador("Pedro", "Constructor");
        assertEquals("Constructor", j.getEspecialidad());
    }

    @Test
    @DisplayName("Especialidad Médico")
    void testEspecialidad_Medico() {
        Jugador j = new Jugador("Carlos", "Médico");
        assertEquals("Médico", j.getEspecialidad());
    }

    @Test
    @DisplayName("Flujo completo: día de supervivencia")
    void testFlujoCompleto_DiaSupervivencia() {
        // Búsqueda de comida
        jugador.restarEnergia(20);
        assertEquals(80, jugador.getEnergia());

        // Enfermedad
        jugador.restarSalud(15);
        assertEquals(85, jugador.getSalud());

        // Descanso
        jugador.recuperarEnergia(30);
        assertEquals(100, jugador.getEnergia());

        // Comida
        jugador.comer(15);
        assertEquals(100, jugador.getSalud());

        assertTrue(jugador.estaVivo());
    }

    @Test
    @DisplayName("Energía y salud no son negativas")
    void testValoresNoNegativos() {
        jugador.restarEnergia(200);
        jugador.restarSalud(200);
        assertTrue(jugador.getEnergia() >= 0);
        assertTrue(jugador.getSalud() >= 0);
    }

    @Test
    @DisplayName("Múltiples jugadores independientes")
    void testMultiplesJugadores() {
        Jugador j1 = new Jugador("Juan", "Recolector");
        Jugador j2 = new Jugador("María", "Constructor");

        j1.restarEnergia(50);
        j2.restarEnergia(20);

        assertEquals(50, j1.getEnergia());
        assertEquals(80, j2.getEnergia());
    }

    @Test
    @DisplayName("Sobrevivencia crítica (bajo peligro)")
    void testSobrevivenciaCritica() {
        jugador.restarSalud(95);
        jugador.restarEnergia(95);

        assertEquals(5, jugador.getSalud());
        assertEquals(5, jugador.getEnergia());
        assertTrue(jugador.estaVivo());
    }

    @Test
    @DisplayName("Muerte por falta de salud")
    void testMuertePorSalud() {
        jugador.restarSalud(100);
        assertFalse(jugador.estaVivo());
    }
}
