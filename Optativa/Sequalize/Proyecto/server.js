import express from "express";
import { sequelize } from "./config/db.js";

// Import Routes
import productoRoutes from "./routes/productos.routes.js";
import categoriaRoutes from "./routes/categorias.routes.js";
import clienteRoutes from "./routes/clientes.routes.js";
import pedidoRoutes from "./routes/pedidos.routes.js";
import detallePedidoRoutes from "./routes/detalles_pedido.routes.js";

const app = express();

app.use(express.json());

// Register API Routes
app.use("/api/productos", productoRoutes);
app.use("/api/categorias", categoriaRoutes);
app.use("/api/clientes", clienteRoutes);
app.use("/api/pedidos", pedidoRoutes);
app.use("/api/detalles-pedidos", detallePedidoRoutes);

// Sincronizar base de datos
(async () => {
    try {
        await sequelize.sync({ alter: true });
        console.log("✅ Tablas sincronizadas.");
    } catch (error) {
        console.error("❌ Error al sincronizar las tablas:", error);
    }
})();

const PORT = 4000;
app.listen(PORT, () => console.log(`🚀 Servidor en http://localhost:${PORT}`));