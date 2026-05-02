# Índice de Proyectos - Encapsulación y Abstracción

Resumen de todos los proyectos educativos sobre encapsulación y abstracción en OOP.

---

## 📚 Mapa de Aprendizaje

```
┌─────────────────────────────────────────────────────────────┐
│  FUNDAMENTOS: Cajero                                        │
│  - Encapsulación básica (private atributos)                │
│  - Getters (lectura segura)                                │
│  - Métodos controlados con validación                      │
│  - Diferencia setter peligroso vs control                  │
│  Nivel: PRINCIPIANTE                                       │
└──────────────────────┬──────────────────────────────────────┘
                       │
                       ↓
┌──────────────────────────────────────────────────────────────┐
│  APLICACIÓN: RosaliaShow (2 versiones)                       │
│  - Encapsulación avanzada (matrices, arraylists)            │
│  - Composición de objetos (Entrada contiene Asiento)        │
│  - Abstracción en capas (métodos que ocultan complejidad)   │
│  - Separación de responsabilidades                          │
│  Nivel: INTERMEDIO-AVANZADO                                │
└──────────────────────────────────────────────────────────────┘
```

---

## 🎯 Proyecto 1: CAJERO (Fundamentos)

**Ubicación:** `/Volumes/Compartido/IOC/SEMESTRE2/PROG/practicando/Proyectos/Cajero/`

### ¿Qué es?
Un sistema bancario simple que demuestra **encapsulación pura**: una clase `Cuenta` con protección total de datos.

### Conceptos
- ✅ `private` atributos
- ✅ Getters seguros
- ✅ Métodos controlados (`sacarDinero()`, `ingresarDinero()`)
- ✅ Validación ANTES de modificar
- ✅ Abstracción de formato (`getResumen()`)

### Archivos
```
Cajero/
├── Cuenta.java                      # La clase principal (2 atributos, métodos controlados)
├── Main.java                        # 10 demostraciones prácticas
├── README.md                        # Guía del proyecto
└── PREGUNTAS_EVALUACION.md         # 16 preguntas (4 niveles)
```

### Ejecución
```bash
cd Cajero
javac Cuenta.java Main.java
java Main
```

### Duración Esperada
- Lectura: 30-45 minutos
- Ejecución + experimentación: 20-30 minutos
- Preguntas de evaluación: 30-45 minutos

### Evaluación
16 preguntas progresivas:
- **Nivel 1 (Básico):** 3 preguntas sobre atributos privados, getters
- **Nivel 2 (Control):** 3 preguntas sobre setters vs métodos controlados
- **Nivel 3 (Aplicación):** 3 preguntas sobre diseño y casos reales
- **Nivel 4 (Profundidad):** 4 preguntas sobre abstracción y conceptos avanzados

**Escala:** 80%+ = Dominas encapsulación y control

---

## 🎯 Proyecto 2: ROSALIASHOW (Aplicación Completa)

**Ubicación:**
- Versión en blanco (para completar): `/Volumes/Compartido/IOC/SEMESTRE2/PROG/practicando/Proyectos/RosaliaShow/RosaliaShowBlanca/`
- Versión completada: `/Volumes/Compartido/IOC/SEMESTRE2/PROG/practicando/Proyectos/RosaliaShow/RosaliaShowDone/`

### ¿Qué es?
Sistema de gestión de entradas para un concierto. Aplica conceptos del Cajero en un proyecto más complejo.

### Conceptos
- ✅ Composición (Entrada contiene Asiento)
- ✅ Matrices 2D (estructura física)
- ✅ ArrayList (estructura dinámica)
- ✅ Encapsulación de múltiples clases
- ✅ Abstracción en capas (métodos que llaman métodos)
- ✅ LocalDateTime (fecha automática)
- ✅ Separación interfaz (Main) vs lógica (Concierto)
- ✅ Validación de datos complexos

### Clases
```
4 clases organizadas por responsabilidad:

1. Asiento.java (PASO 1)
   └─ Representa UN asiento físico
   └─ Datos: fila, número, sección, precio, disponibilidad
   └─ Métodos: getters, ocupar(), liberar(), getInfo()

2. Entrada.java (PASO 2)
   └─ Representa UNA compra realizada
   └─ Composición: contiene Asiento
   └─ Datos: id, asiento, cliente, fecha (auto), precio (extraído)
   └─ Métodos: getters, getDetalles()

3. Concierto.java (PASO 3)
   └─ Gestiona TODO: asientos y entradas
   └─ Datos: Asiento[][] (10×8), ArrayList<Entrada>
   └─ Métodos: validación, búsqueda, abstracción de iteración

4. Main.java (PASO 4)
   └─ Interfaz con usuario
   └─ Menú interactivo, lectura de Scanner
   └─ Delegación a Concierto (sin validar)
```

### Ejecución
```bash
cd RosaliaShowBlanca  # o RosaliaShowDone
javac *.java
java Main
```

### Menú
```
1. Ver mapa de asientos
2. Comprar entrada
3. Ver mis entradas
4. Cancelar entrada
5. Ver estadísticas (% ocupación)
6. Generar ticket
7. Salir
```

### Duración Esperada
- Lectura de código: 1-2 horas
- Ejecución + experimentación: 30 minutos
- Preguntas de evaluación: 45-60 minutos

### Evaluación
15 preguntas progresivas:
- **Nivel 1 (Conceptos):** Matriz vs ArrayList, composición
- **Nivel 2 (Encapsulación):** Validación, private, métodos controlados
- **Nivel 3 (Abstracción):** Delegación, capas, separación
- **Nivel 4 (Profundidad):** Arquitectura, responsabilidades, patrones

**Escala:** 80%+ = Dominas arquitectura de software orientada a objetos

---

## 🔄 Cómo Están Conectados

### Conceptos Comunes

| Concepto | Cajero | RosaliaShow | Propósito |
|----------|--------|-------------|-----------|
| **private** | Atributos | Todos los atributos | Encapsulación |
| **Getters** | getTitular(), getSaldo() | getters en cada clase | Lectura segura |
| **Validación** | sacarDinero(), ingresarDinero() | comprarEntrada(), cancelarEntrada() | Garantizar validez |
| **Abstracción** | getResumen() | getResumen(), getDetalles(), getInfo(), mostrarMapa() | Simplificar uso |
| **Composición** | N/A | Entrada contiene Asiento | Combinar objetos |
| **ArrayList** | N/A | ArrayList<Entrada> | Colecciones dinámicas |

### Progresión

```
Cajero:
  Aprende CÓMO encapsular y validar en 1 clase simple
  ↓
  ↓
RosaliaShow:
  Aplica DÓNDE y CUÁNDO usarlo en 4 clases interconectadas
  ↓
  ↓
Resultado:
  Entiendes arquitectura real de software
```

### Diferencias

| Aspecto | Cajero | RosaliaShow |
|---------|--------|-------------|
| **Clases** | 1 | 4 |
| **Complejidad** | Básica | Intermedia-Avanzada |
| **Estructuras** | Solo atributos | Matriz + ArrayList |
| **Relaciones** | N/A | Composición (Entrada → Asiento) |
| **Interfaz** | Demostración en main() | Menú interactivo completo |
| **Validación** | Simple (cantidad, rango) | Compleja (matriz, disponibilidad) |
| **Enfoque** | Teoría pura | Aplicación práctica |

---

## 📖 Orden Recomendado de Estudio

### **Semana 1: Fundamentos**

**Día 1-2: Cajero**
1. Leer `Cuenta.java` lentamente (30 min)
   - Entender cada comentario
   - Ver estructura: private, constructor, getters, métodos controlados
2. Ejecutar `Main.java` (15 min)
   - Ver cada demostración
   - Entender qué valida cada método
3. Responder preguntas Nivel 1-2 (45 min)
   - Asegurar comprensión básica

---

### **Semana 2: Aplicación**

**Día 1: RosaliaShow - Estructura**
1. Leer `Asiento.java` (20 min)
2. Leer `Entrada.java` (20 min)
3. Leer `Concierto.java` (30 min) ← MÁS COMPLEJO
4. Leer `Main.java` (15 min)

**Día 2: RosaliaShow - Ejecución**
1. Compilar y ejecutar (5 min)
2. Experimentar con cada opción del menú (20 min)
3. Entender flujo: Usuario → Main → Concierto → Asiento/Entrada (15 min)

**Día 3: RosaliaShow - Evaluación**
1. Responder preguntas Nivel 1-2 (1 hora)
2. Responder preguntas Nivel 3-4 (1 hora)
3. Bonus challenges (30 min)

---

## 🎓 Habilidades que Adquirirás

### Después de Cajero
- ✅ Entender `private` y por qué es necesario
- ✅ Implementar getters seguros
- ✅ Escribir métodos que VALIDAN antes de cambiar datos
- ✅ Diferencia entre setter peligroso vs control seguro
- ✅ Entender abstracción (ocultar CÓMO)

### Después de RosaliaShow
- ✅ Diseñar clases con responsabilidades claras
- ✅ Usar composición (un objeto contiene otro)
- ✅ Elegir entre Matriz (estructura fija) y ArrayList (dinámica)
- ✅ Implementar validaciones en métodos complejos
- ✅ Separar interfaz (Main) de lógica (Concierto)
- ✅ Usar LocalDateTime para automatismos
- ✅ Implementar búsqueda y modificación en colecciones

---

## 🔗 Recursos en Cada Proyecto

### Cajero/

| Archivo | Propósito |
|---------|-----------|
| `Cuenta.java` | Código comentado línea a línea |
| `Main.java` | 10 demostraciones con explicaciones |
| `README.md` | Guía de conceptos y flujo |
| `PREGUNTAS_EVALUACION.md` | 16 preguntas con respuestas |

### RosaliaShowBlanca/ y RosaliaShowDone/

| Archivo | Propósito |
|---------|-----------|
| `Asiento.java` | Clase simple con comentarios detallados |
| `Entrada.java` | Composición, LocalDateTime, abstracción |
| `Concierto.java` | Validación compleja, matrices, arraylists |
| `Main.java` | Menú interactivo, separación responsabilidades |
| `README.md` | Flujos, decisiones de diseño |
| `PREGUNTAS_EVALUACION.md` | 15 preguntas específicas del proyecto |

---

## ❓ FAQ

### ¿Por dónde empiezo?
**Empieza por Cajero.** Es simple, directo y sienta las bases. Sin Cajero, RosaliaShow será confuso.

### ¿Necesito hacer los dos proyectos?
**Sí, se refuerzan mutuamente.** Cajero enseña teoría, RosaliaShow la práctica. Uno sin otro no es completo.

### ¿Cuánto tiempo toma todo?
- **Cajero:** 1.5-2 horas (completo con preguntas)
- **RosaliaShow:** 3-4 horas (código + preguntas + experimentación)
- **Total:** 5-6 horas para aprender bien

### ¿Y si quiero más?
Crea tus propios proyectos aplicando los conceptos:
- **Banco:** Sistema con múltiples cuentas (versión avanzada de Cajero)
- **Librería:** Sistema de gestión de libros y préstamos (similar a RosaliaShow)
- **Tienda:** Sistema de inventario y compras

---

## 📊 Matriz de Conceptos

```
Concepto                  | Cajero | RosaliaShow | Dificultad
--------------------------|--------|-------------|----------
private (encapsulación)   |   ✅   |     ✅      | Fácil
Getters                   |   ✅   |     ✅      | Fácil
Constructores             |   ✅   |     ✅      | Fácil
Métodos controlados       |   ✅   |     ✅      | Medio
Abstracción               |   ✅   |     ✅✅    | Medio
Composición               |   ❌   |     ✅      | Medio
Matrices 2D               |   ❌   |     ✅      | Medio
ArrayList                 |   ❌   |     ✅      | Medio
LocalDateTime             |   ❌   |     ✅      | Fácil
Separación responsabilidades |  ❌   |     ✅      | Difícil
Delegación                |   ❌   |     ✅      | Difícil
```

---

**Creado para:** Enseñanza progresiva de Encapsulación y Abstracción en Java OOP.

**Fecha:** Abril 2026

**Versión:** 1.0
