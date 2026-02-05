import express from "express";
import { sequelize } from "./config/db.js";

import fs from "fs";
import path from "path";
import { fileURLToPath } from "url";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();

app.use(express.json());

// Dynamic API Routes Registration
const routesPath = path.join(__dirname, "routes");
const routeFiles = fs.readdirSync(routesPath).filter(file => file.endsWith(".routes.js"));

for (const file of routeFiles) {
    const routeName = file.split(".")[0]; // e.g., "productos"
    const { default: router } = await import(`./routes/${file}`);
    app.use(`/api/${routeName}`, router);
    console.log(`✅ Ruta registrada: /api/${routeName}`);
}



// Sincronizar base de datos
(async () => {
    try {
        await sequelize.sync({ alter: true });
        console.log("✅ Tablas sincronizadas.");
    } catch (error) {
        console.error("❌ Error al sincronizar las tablas:", error);
    }
})();

const PORT = process.env.PORT || 4000;

app.listen(PORT, () => console.log(`🚀 Servidor en http://localhost:${PORT}`));