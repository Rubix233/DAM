import { DataTypes } from "sequelize";
import { sequelize } from "../config/db.js";

const Log = sequelize.define("Log", {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true,
    },
    log: {
        type: DataTypes.TEXT,
        allowNull: false,
    }
}, {
    timestamps: true,
});

export default Log;
