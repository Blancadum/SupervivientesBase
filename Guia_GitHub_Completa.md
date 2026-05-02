# Guía Completa de GitHub

## Tabla de Contenidos
1. [Configuración Inicial](#configuración-inicial)
2. [Clonar un Repositorio](#clonar-un-repositorio)
3. [Trabajar con Ramas](#trabajar-con-ramas)
4. [Ciclo de Trabajo Básico](#ciclo-de-trabajo-básico)
5. [Crear un Pull Request](#crear-un-pull-request)
6. [Subir un Proyecto Local desde Cero](#subir-un-proyecto-local-desde-cero)
7. [Flujo Completo de Ejemplo](#flujo-completo-de-ejemplo)
8. [Otros Comandos Útiles](#otros-comandos-útiles)
9. [Buenas Prácticas](#buenas-prácticas)

---

## Configuración Inicial

Antes de empezar, configura tu identidad en Git:

```bash
git config --global user.name "Tu Nombre"
git config --global user.email "tu@email.com"
```

---

## Clonar un Repositorio

Para descargar un proyecto desde GitHub a tu máquina:

```bash
git clone https://github.com/usuario/nombre-repo.git
cd nombre-repo
```

Esto descarga todo el historial y todas las ramas.

---

## Trabajar con Ramas

### Ver ramas
```bash
git branch                    # Ver ramas locales
git branch -a                 # Ver todas (locales + remotas)
git branch -r                 # Ver solo ramas remotas
```

### Crear una rama nueva
```bash
git branch nombre-rama        # Solo crea la rama
git checkout -b nombre-rama   # Crea y te cambia a ella
git switch -b nombre-rama     # Alternativa moderna (más simple)
```

### Cambiar de rama
```bash
git checkout nombre-rama      # Forma antigua
git switch nombre-rama        # Forma moderna (recomendada)
```

### Eliminar una rama
```bash
git branch -d nombre-rama     # Local
git push origin --delete nombre-rama  # En GitHub
```

---

## Ciclo de Trabajo Básico

### 1. Hacer cambios y guardarlos

```bash
# Ver qué cambió
git status

# Agregar archivos específicos
git add archivo.java
git add .                     # Agregar todo

# Hacer un commit (guardar con mensaje)
git commit -m "Descripción clara del cambio"
```

### 2. Subir cambios a GitHub
```bash
git push origin nombre-rama
```

Si es la primera vez en esa rama:
```bash
git push -u origin nombre-rama
```

### 3. Descargar cambios de GitHub
```bash
git pull origin nombre-rama   # Descarga y fusiona
git fetch                     # Solo descarga (sin fusionar)
```

---

## Crear un Pull Request (PR)

Después de hacer `push`, GitHub te mostrará un botón para crear un PR. O manualmente:

```bash
# 1. Asegúrate de estar en tu rama
git switch mi-rama

# 2. Sube los cambios
git push origin mi-rama

# 3. Ve a GitHub y crea el PR desde la web
```

---

## Subir un Proyecto Local desde Cero

### 1. Crear el repositorio en GitHub

Ve a https://github.com/new y:
- Dale un nombre al repositorio (ej: `proyecto`)
- Elige si es público o privado
- **NO** inicialices con README, .gitignore ni licencia (lo haremos desde local)
- Click en "Create repository"

### 2. Inicializar Git en tu carpeta local

En la carpeta raíz de tu proyecto:

```bash
cd /ruta/a/proyecto
git init
```

### 3. Agregar todos tus archivos

```bash
git add .
```

### 4. Hacer el primer commit

```bash
git commit -m "Initial commit: proyecto inicial"
```

### 5. Conectar con tu repositorio remoto

```bash
git remote add origin https://github.com/isamar/proyecto.git
```

Para verificar que está bien:
```bash
git remote -v
```

### 6. Cambiar la rama principal a `main` (opcional pero recomendado)

```bash
git branch -M main
```

### 7. Subir todo a GitHub

```bash
git push -u origin main
```

### Ejemplo Completo

```bash
# 1. Ir al proyecto
cd ~/Proyectos/proyecto

# 2. Inicializar Git
git init

# 3. Configurar usuario (si no lo hiciste globalmente)
git config user.name "isamar"
git config user.email "tu@email.com"

# 4. Agregar archivos
git add .

# 5. Primer commit
git commit -m "Initial commit: proyecto base"

# 6. Conectar con GitHub
git remote add origin https://github.com/isamar/proyecto.git

# 7. Renombrar rama a main
git branch -M main

# 8. Subir
git push -u origin main
```

¡Y listo! Tu proyecto ya estará en `github.com/isamar/proyecto` 🚀

---

## Flujo Completo de Ejemplo

Imaginemos que trabajas en una feature de autenticación:

```bash
# 1. Clonar el proyecto
git clone https://github.com/miempresa/backend.git
cd backend

# 2. Crear rama para tu feature
git switch -b feature/autenticacion

# 3. Hacer cambios en tus archivos Java
# (editas LoginService.java, etc.)

# 4. Ver qué cambió
git status

# 5. Agregar los cambios
git add src/main/java/com/app/LoginService.java

# 6. Hacer commit
git commit -m "feat: implementar login con JWT"

# 7. Subir a GitHub
git push -u origin feature/autenticacion

# 8. Ve a GitHub y crea un Pull Request
# (pide que se revise y se fusione con main)
```

---

## Otros Comandos Útiles

```bash
# Ver historial de commits
git log
git log --oneline            # Versión compacta

# Ver cambios no guardados
git diff

# Deshacer cambios locales (CUIDADO)
git checkout -- archivo.java # Revierte un archivo
git reset --hard             # Revierte todo

# Traer cambios de otra rama a la actual
git merge nombre-rama

# Actualizar tu rama local con main (después de clonar)
git pull origin main
```

---

## Buenas Prácticas

1. **Crear una rama por feature**: Una rama = una funcionalidad
2. **Commits claros**: `git commit -m "feat: agregar validación SQL"` es mejor que `"cambios"`
3. **Hacer pull antes de push**: `git pull origin main` antes de trabajar en cambios grandes
4. **No trabajar directamente en `main`**: Siempre usa ramas y PRs
5. **Revisar cambios**: `git diff` antes de hacer commit

---

## Resumen Rápido de Comandos Más Usados

| Comando | Descripción |
|---------|------------|
| `git clone <url>` | Clonar repositorio |
| `git init` | Inicializar repositorio local |
| `git add .` | Agregar todos los cambios |
| `git commit -m "mensaje"` | Crear un commit |
| `git push origin rama` | Subir cambios a GitHub |
| `git pull origin rama` | Descargar cambios de GitHub |
| `git switch -b rama` | Crear y cambiar a nueva rama |
| `git branch` | Ver ramas locales |
| `git status` | Ver estado actual |
| `git log` | Ver historial de commits |

---

**¡Listo! Ya tienes todo lo que necesitas para trabajar con GitHub** 🎉
