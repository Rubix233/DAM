import express from "express";
import {
    crearDetallePedido,
    obtenerDetallesPedido,
    obtenerDetallePedido,
    actualizarDetallePedido,
    eliminarDetallePedido
} from "../controllers/detalles_pedido.controller.js";

const router = express.Router();

router.post("/", crearDetallePedido);
router.get("/", obtenerDetallesPedido);
router.get("/:id", obtenerDetallePedido);
router.put("/:id", actualizarDetallePedido);
router.delete("/:id", eliminarDetallePedido);

export default router;
