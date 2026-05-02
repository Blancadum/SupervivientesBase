import java.util.Scanner;

/**
 * Clase Main - Menú principal de SurvivalIsland
 *
 * TODO: Implementa un menú interactivo con 5 opciones:
 *       1. Crear jugador
 *       2. Ver estado actual
 *       3. Nuevo turno (jugadores eligen acciones)
 *       4. Descansar todos
 *       5. Salir
 */
public class Main {

    public static void main(String[] args) {
        // TODO 1: Crea instancia de Isla
        Isla isla = null;  // TODO: reemplaza por new Isla()

        // TODO 2: Crea Scanner
        Scanner scanner = null;  // TODO: reemplaza por new Scanner(System.in)

        // TODO 3: Variable booleana
        boolean salir = false;

        // TODO 4: Bucle while (!salir)
        // Imprime:
        // 🏝️ === SURVIVAL ISLAND ===
        // 1. Crear jugador
        // 2. Ver estado actual
        // 3. Nuevo turno
        // 4. Descansar todos
        // 5. Salir
        // Elige:

        // TODO 5: Switch case para opciones

        // Caso 1: Crear jugador
        //   Pide nombre
        //   Pide especialidad ("Recolector", "Constructor", "Médico", "Cazador")
        //   Llama isla.agregarJugador(nombre, especialidad)

        // Caso 2: Ver estado actual
        //   Llama isla.mostrarEstado()

        // Caso 3: Nuevo turno
        //   for (Jugador j : isla.getJugadores()):
        //     if (!j.estaVivo()) continue;
        //     Imprime: "{nombre} ({especialidad}), ¿qué haces?"
        //     Imprime opciones:
        //       1. Buscar comida
        //       2. Recolectar agua
        //       3. Construir refugio
        //       4. Cazar animal
        //       5. No hacer nada
        //     Lee acción y llama método correspondiente
        //   Después de todos:
        //   String resultado = isla.avanzarDía()
        //   if (resultado != null):
        //     Muestra VICTORIA o DERROTA
        //     isla.mostrarEstado()
        //     salir = true (o pedir jugar de nuevo)

        // Caso 4: Descansar todos
        //   isla.descansarTodos()

        // Caso 5: Salir
        //   salir = true
        //   Imprime: "👋 ¡Espero hayan sobrevivido!"

        // Default: error

        // TODO 6: Try-catch para NumberFormatException

        // TODO 7: Cierra Scanner

        System.out.println("Implementa el menú aquí siguiendo los TODOs");
    }
}
