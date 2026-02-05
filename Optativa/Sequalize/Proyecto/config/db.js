import { Sequelize } from "sequelize";
import dotenv from "dotenv";

dotenv.config();

export const sequelize = new Sequelize(
    process.env.DB_NAME || "api_rest_db",
    process.env.DB_USER || "root",
    process.env.DB_PASS || "",
    {
        host: process.env.DB_HOST || "localhost",
        dialect: process.env.DB_DIALECT || "mysql",
        logging: false
    }
);

// Comprobar conexión
(async () => {
    try {
        await sequelize.authenticate();
        console.log("✅ Conexión establecida con la base de datos.");
    } catch (error) {
        console.error("❌ Error al conectar a la base de datos:", error);
    }
})();