# 🏝️ Supervivientes - Guía Paso a Paso

## 📋 Resumen del Proyecto

Un juego **cooperativo** donde toda la familia intenta sobrevivir en una isla deshabitada:
- **30 días** para ser rescatados
- **Recursos compartidos:** comida, madera, agua
- **Cada turno:** Elegir acción (buscar, construir, descansar)
- **Desafíos aleatorios:** Lluvia, enfermedad, animales
- **Objetivo común:** Que **nadie muera** en 30 días

A diferencia de LoboGAME/CasinoPokemon, **no hay competencia**, todos colaboran para ganar juntos.

---

## 🎯 Objetivo de Aprendizaje

Este proyecto integra:
- **ArrayList**: Jugadores, recursos, desafíos
- **Random**: Eventos impredecibles
- **Estados**: Salud, energía, día actual
- **Cálculos**: Consumo de recursos, daño
- **Validación**: Acciones posibles
- **Cooperación**: Decisiones de grupo
- **Progreso**: Contador de días hasta rescate

---

## 🏗️ Estructura de Clases

```
Jugador
├─ nombre, salud, energía, especialidad
└─ métodos: trabajar(), descansar(), comer(), enfermarse()

Isla
├─ jugadores: ArrayList<Jugador>
├─ diaActual: int
├─ comida, madera, agua: int
├─ refugioNivel: int (0-3)
└─ métodos:
   ├─ avanzarDía()
   ├─ buscarComida()
   ├─ construirRefugio()
   ├─ descansarTodos()
   ├─ generarDesafío()
   └─ verificarEstado()

Main
└─ menú: crear jugadores, turnos, acciones
```

---

## 🔄 Pasos para Resolver

### **Paso 1: Clase Jugador**

Atributos:
- `nombre` (String)
- `salud` (int) - 0-100, comienza en 100
- `energia` (int) - 0-100, comienza en 100
- `especialidad` (String) - "Recolector", "Constructor", "Médico", "Cazador"

Métodos:
- `getNombre()`, `getSalud()`, `getEnergia()`, `getEspecialidad()`
- `restarEnergía(int cantidad)` - resta energía
- `restarSalud(int cantidad)` - resta salud (por enfermedad, hambre)
- `recuperarEnergía(int cantidad)` - suma energía (descansando)
- `comer(int cantidad)` - suma salud
- `estaVivo()` - retorna true si salud > 0
- `getInfo()` - retorna "{nombre} - Salud:{salud}, Energía:{energia}"

---

### **Paso 2: Clase Isla - Inicialización**

Atributos:
- `jugadores` (ArrayList<Jugador>)
- `diaActual` (int) - comienza en 1
- `comida` (int) - comienza en 50
- `madera` (int) - comienza en 30
- `agua` (int) - comienza en 40
- `refugioNivel` (int) - 0 (nada), 1 (básico), 2 (bueno), 3 (excelente)
- `random` (Random)

Constructor:
- Inicializa todo
- Imprime "🏝️ ¡Naufragados en la isla!"

Método `agregarJugador(String nombre, String especialidad)`:
- Crea Jugador
- Agrega a ArrayList
- Imprime confirmación

---

### **Paso 3: Acciones Diarias**

#### `buscarComida(Jugador jugador)`
- Valida energía >= 20
- Si no: "❌ Muy cansado"
- Si sí:
  - Resta 20 energía
  - Genera comida aleatoria: 10-30 unidades (Random)
  - Suma a comida total
  - Imprime: "{nombre} busca comida → +20 unidades"

#### `construirRefugio(Jugador jugador)`
- Valida: madera >= 15
- Si no: "❌ No hay suficiente madera"
- Si sí:
  - Resta 15 madera
  - Resta 30 energía
  - Aumenta refugioNivel en 1 (máximo 3)
  - Imprime: "{nombre} construye... Nivel refugio: {nivel}"

#### `recolectarAgua(Jugador jugador)`
- Similar a buscarComida pero con agua
- Energía: 15
- Agua encontrada: 15-25 unidades

#### `descansarTodos()`
- Todos los jugadores recuperan 30 energía (máximo 100)
- Imprime quiénes descansaron
- **Costo:** Se consume 1 comida por jugador
- Valida: comida >= jugadores.size()

#### `cazarAnimal(Jugador jugador)` (opcional)
- Acción de riesgo
- Validar: energía >= 40
- Random: 50% éxito
- Si éxito: +60 comida, -40 energía
- Si fallo: -10 salud, -40 energía
- Imprime resultado dramático

---

### **Paso 4: Desafíos Aleatorios**

Método `generarDesafío()`:
- Cada día, al final, probabilidad 40% de desafío
- `random.nextInt(100) < 40`
- Elige desafío aleatorio:

```
int tipo = random.nextInt(5);

switch(tipo) {
    case 0: // Lluvia
        madera -= 10;
        agua -= 5;
        Imprime: "🌧️ La lluvia destruye madera..."
        break;
    case 1: // Enfermedad
        Elige jugador aleatorio
        Resta 15 salud
        Imprime: "{nombre} enferma..."
        break;
    case 2: // Animal salvaje
        Elige jugador aleatorio
        Resta 20 salud
        Resta 30 comida (lo que robó)
        Imprime: "🦁 ¡Un animal ataca!"
        break;
    case 3: // Alimentos se pudren
        comida -= 20
        Imprime: "🐛 La comida se pudre..."
        break;
    case 4: // Falta agua
        Todos pierden 5 salud
        Imprime: "💧 ¡Sin agua limpia!"
        break;
}
```

---

### **Paso 5: Verificar Estado**

Método `verificarEstado()` retorna String:
- Si alguien tiene salud <= 0: return "DERROTA" (murió)
- Si día >= 30: return "VICTORIA" (rescatados)
- Si comida < 0 o agua < 0: return "DERROTA" (recursos críticos)
- Else: return null (sigue el juego)

Método `mostrarEstado()`:
- Imprime estado actual:
  - "🌍 Día {dia}/30"
  - "🏕️ Refugio nivel {nivel}"
  - "🍗 Comida: {comida} | 💧 Agua: {agua} | 🪵 Madera: {madera}"
  - Lista de jugadores con salud/energía

---

### **Paso 6: Avanzar Día**

Método `avanzarDía()`:
1. Imprime: "---\n⏳ Termina el día {dia}\n---"
2. **Consumo automático:**
   - Cada jugador consume 5 comida (alimentarse)
   - Cada jugador pierde 5 salud por exposición
3. **Imprime:**
   - Quién comió, quién no tiene suficiente comida
   - Cambios de salud
4. Llama `generarDesafío()`
5. diaActual++
6. Llama `mostrarEstado()`
7. Retorna resultado de `verificarEstado()`

---

### **Paso 7: Main - Menú Principal**

Menú:
```
🏝️ === SURVIVAL ISLAND ===
1. Crear jugador
2. Ver estado actual
3. Nuevo turno (jugadores eligen acciones)
4. Descansar todos (consume comida)
5. Salir
```

Cuando `Nuevo turno`:
```
Para cada jugador vivo:
  Mostrar estado
  Preguntar acción:
    1. Buscar comida
    2. Recolectar agua
    3. Construir refugio
    4. Cazar animal (riesgo)
    5. No hacer nada
```

Después de que todos eligen:
```
Llama isla.avanzarDía()
Si resultado != null:
  Mostrar VICTORIA o DERROTA
  Mostrar estado final
```

---

## 🎮 Ejemplo de Partida

```
🏝️ === SURVIVAL ISLAND ===

1. Crear jugador
Nombre: Juan, Especialidad: Recolector
✅ Juan unido (Recolector)

Nombre: María, Especialidad: Constructor
✅ María unida (Constructor)

Nombre: Pedro, Especialidad: Médico
✅ Pedro unido (Médico)

🌍 Día 1/30
🏕️ Refugio nivel 0
🍗 Comida: 50 | 💧 Agua: 40 | 🪵 Madera: 30

👥 Jugadores:
- Juan - Salud: 100, Energía: 100
- María - Salud: 100, Energía: 100
- Pedro - Salud: 100, Energía: 100

3. Nuevo turno

Juan (Recolector), ¿qué haces?
1. Buscar comida
2. Recolectar agua
3. Construir refugio
4. Cazar animal
5. No hacer nada
Elige: 1

✅ Juan busca comida → +27 unidades (energía: 80)

María (Constructor), ¿qué haces?
Elige: 3

✅ María construye refugio → Nivel 1 (energía: 70)

Pedro (Médico), ¿qué haces?
Elige: 5

⏳ Termina el día 1

🍗 Todos comen (-3 comida, -5 salud por exposición)
Comida restante: 74
Salud general: ~95

🌧️ ¡Lluvia! -10 madera, -5 agua

🌍 Día 2/30
🏕️ Refugio nivel 1
🍗 Comida: 74 | 💧 Agua: 35 | 🪵 Madera: 20

...

🌍 Día 30/30
🎉 ¡¡¡VICTORIA!!! ¡Fueron rescatados!
```

---

## 📌 Notas Importantes

- **Cooperativo:** Ganan todos juntos o pierden juntos
- **Especialidades:** Pueden afectar eficiencia (Recolector +10% comida, Constructor -10% madera)
- **Desafíos:** Generados al final del día, no predecibles
- **Recursos críticos:** Si llegan a negativo, DERROTA
- **Equilibrio:** No es imposible, pero requiere estrategia
- **Decisiones de grupo:** "¿Cazamos o buscamos comida?"

---

## ✨ Conceptos Clave

| Concepto | Dónde | Por qué |
|----------|-------|--------|
| **ArrayList** | jugadores | Lista de participantes |
| **Random** | desafíos, búsqueda | Impredecibilidad |
| **Validación** | acciones | Recursos suficientes |
| **Cálculos** | consumo, daño | Simulación realista |
| **Estados** | salud, energía, día | Progreso del juego |
| **Cooperación** | objetivo común | Cambio de dinámicas |
| **Scanner** | menú, acciones | Interacción |

---

¡Ahora abre los archivos en **PLANTILLAS/** y resuelve! 🏝️

