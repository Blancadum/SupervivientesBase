import java.util.ArrayList;
import java.util.Random;

/**
 * Clase Isla - Gestiona la simulación de supervivencia
 *
 * TODO 1: Declara los atributos
 *         - jugadores (ArrayList<Jugador>)
 *         - diaActual (int) - comienza en 1
 *         - comida (int) - comienza en 50
 *         - madera (int) - comienza en 30
 *         - agua (int) - comienza en 40
 *         - refugioNivel (int) - comienza en 0
 *         - random (Random)
 */
public class Isla {

    // TODO 1: Aquí van los atributos

    /**
     * TODO 2: Constructor
     *         Inicializa todo según TODO 1
     *         Imprime: "🏝️ ¡Naufragados en la isla!"
     */

    /**
     * TODO 3: Método agregarJugador(String nombre, String especialidad)
     *         - Crea new Jugador(nombre, especialidad)
     *         - Agrega a ArrayList jugadores
     *         - Imprime: "✅ {nombre} unido ({especialidad})"
     */

    /**
     * TODO 4: Método buscarComida(Jugador jugador)
     *         Validación:
     *         - if (jugador.getEnergia() < 20):
     *           Imprime "❌ {nombre} está muy cansado"
     *           return
     *         Acción:
     *         - jugador.restarEnergía(20)
     *         - comidaEncontrada = random.nextInt(21) + 10  // 10-30
     *         - comida += comidaEncontrada
     *         - Imprime: "🔍 {nombre} busca comida → +{comidaEncontrada} unidades"
     */

    /**
     * TODO 5: Método recolectarAgua(Jugador jugador)
     *         Similar a TODO 4 pero:
     *         - Energía: 15 (no 20)
     *         - Agua encontrada: 15-25
     *         - Imprime con agua
     */

    /**
     * TODO 6: Método construirRefugio(Jugador jugador)
     *         Validación:
     *         - if (madera < 15):
     *           Imprime "❌ No hay suficiente madera"
     *           return
     *         Acción:
     *         - if (refugioNivel >= 3):
     *           Imprime "⛺ El refugio ya está en máximo nivel"
     *           return
     *         - madera -= 15
     *         - jugador.restarEnergía(30)
     *         - refugioNivel++
     *         - Imprime: "🏗️ {nombre} construye... Nivel refugio: {refugioNivel}"
     */

    /**
     * TODO 7: Método cazarAnimal(Jugador jugador)
     *         Validación:
     *         - if (jugador.getEnergia() < 40):
     *           Imprime error
     *           return
     *         Acción:
     *         - jugador.restarEnergía(40)
     *         - int resultado = random.nextInt(100)
     *         - if (resultado < 50):  // 50% éxito
     *             comida += 60
     *             Imprime: "🎯 ¡{nombre} caza un animal! +60 comida"
     *         - else:  // 50% fallo
     *             jugador.restarSalud(10)
     *             comida -= 30
     *             Imprime: "🐅 ¡Un animal ataca a {nombre}! -10 salud"
     */

    /**
     * TODO 8: Método descansarTodos()
     *         Validación:
     *         - if (comida < jugadores.size()):
     *           Imprime "❌ No hay comida para todos"
     *           return
     *         Acción:
     *         - Restar comida: comida -= jugadores.size()
     *         - Para cada jugador: jugador.recuperarEnergía(30)
     *         - Imprime: "😴 Todos descansan y recuperan energía"
     *         - Lista quiénes descansaron
     */

    /**
     * TODO 9: Método generarDesafío()
     *         Probabilidad: 40% de que ocurra algo
     *         - if (random.nextInt(100) < 40):
     *
     *         Elegir tipo (0-4):
     *         - int tipo = random.nextInt(5)
     *
     *         switch(tipo):
     *           case 0 (Lluvia):
     *             madera -= 10
     *             agua -= 5
     *             Imprime: "🌧️ La lluvia destruye el refugio..."
     *             break
     *
     *           case 1 (Enfermedad):
     *             Jugador enfermo = jugadores.get(random.nextInt(jugadores.size()))
     *             enfermo.restarSalud(15)
     *             Imprime: "🤒 {nombre} enferma..."
     *             break
     *
     *           case 2 (Animal):
     *             Jugador atacado = jugadores.get(random.nextInt(jugadores.size()))
     *             atacado.restarSalud(20)
     *             comida -= 30
     *             Imprime: "🦁 ¡Un animal ataca a {nombre}!"
     *             break
     *
     *           case 3 (Comida):
     *             comida -= 20
     *             Imprime: "🐛 La comida se pudre..."
     *             break
     *
     *           case 4 (Agua):
     *             Para cada jugador: restarSalud(5)
     *             Imprime: "💧 ¡Sin agua limpia!"
     *             break
     */

    /**
     * TODO 10: Método avanzarDía()
     *          1. Imprime: "---\n⏳ Termina el día {diaActual}\n---"
     *          2. Consumo de comida:
     *             - for (Jugador j : jugadores):
     *               if (comida >= 1):
     *                 comida -= 1
     *                 j.comer(5)  // Se alimenta, suma salud
     *               else:
     *                 j.restarSalud(10)  // Sin comida, pierde salud
     *          3. Daño ambiental:
     *             - for (Jugador j : jugadores):
     *               j.restarSalud(5)  // Exposición
     *          4. Llama generarDesafío()
     *          5. diaActual++
     *          6. Llama mostrarEstado()
     *          7. Retorna verificarEstado()
     */

    /**
     * TODO 11: Método verificarEstado()
     *          Retorna String:
     *          - Revisa condiciones de derrota:
     *            if (comida < 0 || agua < 0):
     *              return "DERROTA"
     *            for (Jugador j : jugadores):
     *              if (!j.estaVivo()):
     *                return "DERROTA"
     *
     *          - Revisa victoria:
     *            if (diaActual > 30):
     *              return "VICTORIA"
     *
     *          - Si sigue el juego:
     *            return null
     */

    /**
     * TODO 12: Método mostrarEstado()
     *          Imprime:
     *          "🌍 Día {diaActual}/30"
     *          "⛺ Refugio nivel {refugioNivel}"
     *          "🍗 Comida: {comida} | 💧 Agua: {agua} | 🪵 Madera: {madera}"
     *          ""
     *          "👥 Jugadores:"
     *          Para cada jugador: "- {getInfo()}"
     */

    /**
     * TODO 13: Getters
     *          - getJugadores() retorna jugadores
     *          - getDiaActual() retorna diaActual
     *          - getComida(), getAgua(), getMadera()
     *          - getRefugioNivel()
     */
}
