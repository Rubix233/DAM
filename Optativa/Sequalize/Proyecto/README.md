# Proyecto API REST con Sequelize y AutoCRUD

Este proyecto es una API REST construida con Node.js, Express y Sequelize, siguiendo una arquitectura **MVC Reducida** y con un sistema de **AutoCRUD** para la generación automática de endpoints.

## Requisitos Previos

- Node.js (v16+)
- MySQL / MariaDB

## Instalación

1. Clona el repositorio.
2. Navega a la carpeta del proyecto:
   ```bash
   cd Proyecto
   ```
3. Instala las dependencias:
   ```bash
   npm install
   ```

## Configuración

1. Copia el archivo de ejemplo de variables de entorno:
   ```bash
   cp .env.example .env
   ```
2. Edita el archivo `.env` con tus credenciales de base de datos:
   ```env
   DB_NAME=nombre_de_tu_db
   DB_USER=tu_usuario
   DB_PASS=tu_password
   DB_HOST=localhost
   DB_DIALECT=mysql
   PORT=4000
   ```

## Base de Datos

El proyecto utiliza `sequelize.sync({ alter: true })` en `server.js` para sincronizar automáticamente los modelos con las tablas de la base de datos al iniciar el servidor. No se requieren migraciones manuales iniciales.

### Registro de Log
Se ha implementado una tabla `Log` que registra automáticamente todas las operaciones de creación, actualización y borrado realizadas a través de la API.

## Ejecución

### Lanzar el Servidor
Para iniciar el servidor en modo desarrollo (con nodemon):
```bash
npm run dev
```
O en modo normal:
```bash
npm start
```

### Ejecutar el AutoCRUD
Si añades nuevos modelos en la carpeta `models/`, puedes generar automáticamente sus servicios, controladores y rutas ejecutando:
```bash
node autocrud.js
```
El script generará:
- **Services** en `services/`
- **Base Controllers** en `controllers/base/`
- **Extended Controllers** en `controllers/`
- **Routes** en `routes/`

## Ejemplos de Endpoints

### Recurso: Productos (`/api/productos`)

| Método | Endpoint | Descripción |
|---|---|---|
| GET | `/api/productos` | Obtener todos los productos |
| GET | `/api/productos/:id` | Obtener un producto por ID |
| POST | `/api/productos` | Crear un nuevo producto |
| PUT | `/api/productos/:id` | Actualizar un producto existente |
| DELETE | `/api/productos/:id` | Eliminar un producto |

#### Ejemplo de Cuerpo (POST /api/productos)
```json
{
  "nombre": "Laptop Gaming",
  "precio": 1200.50,
  "stock": 10
}
```

## Arquitectura (MVC Reducida)

1. **Routes**: Definen los puntos de entrada y delegan al controlador.
2. **Controllers**: Gestionan la lógica de la petición. Los controladores en `controllers/` heredan de los de `controllers/base/` para permitir personalizaciones sin perder el código generado.
3. **Services**: Contienen la lógica de negocio y la interacción directa con Sequelize.
4. **Models**: Definición de los modelos de datos.
