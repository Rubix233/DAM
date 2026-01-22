import express from "express";
import {
    crearCategoria,
    obtenerCategorias,
    obtenerCategoria,
    actualizarCategoria,
    eliminarCategoria
} from "../controllers/categorias.controller.js";

const router = express.Router();

router.post("/", crearCategoria);
router.get("/", obtenerCategorias);
router.get("/:id", obtenerCategoria);
router.put("/:id", actualizarCategoria);
router.delete("/:id", eliminarCategoria);

export default router;
