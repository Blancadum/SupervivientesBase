# 🏝️ SurvivalIsland - Explicación de la Solución

Guía detallada del código resuelto.

---

## 🏗️ Arquitectura

```
Main (menú interactivo)
  ↓
Isla (orquesta todo)
  ├─ jugadores: ArrayList<Jugador>
  ├─ recursos: comida, madera, agua, refugio
  ├─ dia, desafíos aleatorios
  └─ métodos: turnos, consumos, desafíos
      ↓
      Jugador (superviviente individual)
        ├─ nombre, salud, energía, especialidad
        └─ métodos: acciones, consumos
```

**Diferencia clave con otros proyectos:**
- CasinoPokemon: competencia (cada uno gana coins)
- LoboGAME: deducción (lobos vs aldeanos)
- **SurvivalIsland: COOPERACIÓN (todos ganan o pierden juntos)**

---

## 📦 Clases

### Jugador
**Responsabilidad:** Representa un superviviente con recursos personales

```java
private String nombre;
private int salud;              // 0-100
private int energia;            // 0-100
private String especialidad;    // Recolector, Constructor, etc.
```

**Métodos de consumo:**
```java
public void restarEnergía(int cantidad) {
    energia -= cantidad;
    if (energia < 0) energia = 0;
}

public void restarSalud(int cantidad) {
    salud -= cantidad;
    if (salud < 0) salud = 0;
}

public void recuperarEnergía(int cantidad) {
    energia += cantidad;
    if (energia > 100) energia = 100;
}

public void comer(int cantidad) {
    salud += cantidad;
    if (salud > 100) salud = 100;
}
```

**Por qué máximos?**
- Salud máx 100 y energía máx 100 previenen "desbordamientos"
- Realista: no puedes ser "más que 100% vivo"

---

### Isla
**Responsabilidad:** Gestiona toda la simulación de supervivencia

#### Atributos
```java
private ArrayList<Jugador> jugadores;     // Todos los supervivientes
private int diaActual;                    // 1-30
private int comida, madera, agua;         // Recursos compartidos
private int refugioNivel;                 // 0-3
private Random random;                    // Para desafíos y búsqueda
```

#### Acciones Diarias

**buscarComida()**
```java
if (jugador.getEnergia() < 20) {
    return;  // No tiene energía
}
jugador.restarEnergía(20);
int comidaEncontrada = random.nextInt(21) + 10;  // 10-30
comida += comidaEncontrada;
```

**cazarAnimal()** - Más riesgo, más recompensa
```java
if (jugador.getEnergia() < 40) return;

jugador.restarEnergía(40);
int resultado = random.nextInt(100);

if (resultado < 50) {        // 50% éxito
    comida += 60;            // Mucha comida
} else {                     // 50% fracaso
    jugador.restarSalud(10); // Daño
    comida -= 30;            // Pierden comida
}
```

**descansarTodos()** - Acción cooperativa
```java
if (comida < jugadores.size()) {
    return;  // No hay comida para todos
}

comida -= jugadores.size();  // Comen mientras descansan
for (Jugador j : jugadores) {
    j.recuperarEnergía(30);
}
```

---

## 🎮 Desafíos Aleatorios

Al final de cada día, 40% de probabilidad de que ocurra algo malo:

```java
if (random.nextInt(100) < 40) {  // 40% chance
    int tipo = random.nextInt(5);  // 5 tipos diferentes
    switch(tipo) {
        case 0: // LLUVIA
            madera -= 10;
            agua -= 5;
            break;
        case 1: // ENFERMEDAD
            Jugador enfermo = jugadores.get(random.nextInt(jugadores.size()));
            enfermo.restarSalud(15);
            break;
        case 2: // ANIMAL ATACA
            Jugador atacado = jugadores.get(random.nextInt(jugadores.size()));
            atacado.restarSalud(20);
            comida -= 30;
            break;
        case 3: // COMIDA PODRIDA
            comida -= 20;
            break;
        case 4: // SIN AGUA
            for (Jugador j : jugadores) {
                j.restarSalud(5);
            }
            break;
    }
}
```

**Por qué Random en desafíos?**
- Impredecibilidad = tensión
- Obliga a los jugadores a tomar decisiones estratégicas
- Cada partida es diferente

---

## 🔄 Flujo del Día

```
1. Menú → Cada jugador elige acción (buscar, construir, etc.)
2. Gasto de energía (acciones consumidas)
3. avanzarDía():
   - Consumo automático: -1 comida, +5 salud por jugador
   - Daño ambiental: -5 salud por exposición
   - Desafío aleatorio (40%)
   - diaActual++
4. Verificar si alguien murió o si es día 30+
5. Mostrar estado
```

---

## ✅ Condiciones de Victoria/Derrota

```java
public String verificarEstado() {
    // DERROTA: recursos críticos
    if (comida < 0 || agua < 0) {
        return "DERROTA";
    }

    // DERROTA: alguien muere
    for (Jugador j : jugadores) {
        if (!j.estaVivo()) {
            return "DERROTA";
        }
    }

    // VICTORIA: llegan a día 30+
    if (diaActual > 30) {
        return "VICTORIA";
    }

    // Sigue el juego
    return null;
}
```

**Diferencias con otros juegos:**
- LoboGAME: ganan algunos (lobos O aldeanos)
- **SurvivalIsland: ganan TODOS o pierden TODOS**

---

## 📊 Ejemplo de Partida

```
Jugadores: Juan (Recolector), María (Constructor), Pedro (Médico)
Recursos: Comida 50, Agua 40, Madera 30, Refugio nivel 0

🌍 Día 1
Juan: Buscar comida → +23 comida (energía: 80)
María: Construir refugio → Refugio nivel 1 (energía: 70)
Pedro: No hace nada → Energía +10

⏳ Fin del día 1:
- Consumo: -3 comida (comen 1 cada uno)
- Daño: -5 salud a todos (exposición)
- 🌧️ Lluvia: -10 madera, -5 agua

Estado: Comida 70, Agua 35, Madera 20, Refugio 1
Salud: Juan 95, María 95, Pedro 95

---

🌍 Día 2
Juan: Recolectar agua → +18 agua (energía: 85)
María: Construir refugio → Refugio nivel 2 (energía: 70)
Pedro: Caza animal → 50% éxito... ¡ÉXITO! +60 comida (energía: 60)

⏳ Fin del día 2:
- Consumo: -3 comida
- Daño: -5 salud
- 🤒 Desafío: Pedro enferma → -15 salud

Estado: Comida 127, Agua 53, Madera 20, Refugio 2
Salud: Juan 90, María 90, Pedro 80

---

... días 3-30 ...

🌍 Día 30
Estado general: Refugio nivel 3, comida abundante, todos vivos

⏳ Fin del día 30

🎉 ¡¡¡VICTORIA!!! ¡Fueron rescatados!
```

---

## 🎓 Conceptos Clave

| Concepto | Dónde | Por qué |
|----------|-------|--------|
| **ArrayList** | jugadores | Lista dinámica de supervivientes |
| **Random** | desafíos, búsqueda | Impredecibilidad |
| **Validación** | acciones | Energía/recursos suficientes |
| **Cálculos** | consumo diario | Simulación realista |
| **Estados** | salud/energía | Cambio a lo largo del juego |
| **Cooperación** | objetivo común | Dinámicas sociales distintas |
| **Bucles** | avanzarDía(), desafíos | Iteración de jugadores |

---

## 🔧 Mejoras Futuras

1. **Especialidades reales** - Recolector busca +comida, Constructor -madera
2. **Eventos específicos** - "Encuentra un cofre", "Brújula rota"
3. **Sistema de presagio** - Pista del desafío antes de que ocurra
4. **Guardar progreso** - Archivo con estado de partida
5. **Dificultad** - Normal/Difícil (más desafíos)
6. **Alianzas** - Jugadores pueden "confiar" recursos
7. **Exploración** - Isla con zonas diferentes (bosque, playa, montaña)
8. **Crafteo** - Combinar recursos para crear herramientas
9. **Personajes dinámicos** - Amistad/conflicto entre jugadores
10. **Histórico** - Guardar mejores partidas

---

## 💡 Puntos Clave

**¿Por qué cooperativo y no competitivo?**
- Enseña colaboración
- Dinámicas diferentes (negociación en lugar de competencia)
- Mayor re-jugabilidad (estrategias varían mucho)

**¿Por qué desafíos aleatorios?**
- Mantiene tensión
- Obliga a adaptarse
- Cada partida es única

**¿Por qué 30 días exactamente?**
- Alcanzable pero desafiante
- Con estrategia básica es posible ganar
- Sin estrategia, es muy difícil

**¿Cómo se balancea el juego?**
- Recursos iniciales son suficientes
- Pero hay que distribuir bien (alguien busca, otro construye)
- El refugio nivel 3 ayuda con desafíos
- Descansar es caro pero necesario

---

**¡Juego cooperativo completo para jugar en familia!** 👨‍👩‍👧‍👦

