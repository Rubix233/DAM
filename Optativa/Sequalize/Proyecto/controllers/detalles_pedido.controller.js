import { DetallesPedido } from "../models/index.js";

export const crearDetallePedido = async (req, res) => {
    try {
        const nuevoDetalle = await DetallesPedido.create(req.body);
        res.status(201).json(nuevoDetalle);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al crear detalle de pedido", error });
    }
};

export const obtenerDetallesPedido = async (req, res) => {
    try {
        const detalles = await DetallesPedido.findAll({ include: ["pedido", "producto"] });
        res.json(detalles);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener detalles de pedidos", error });
    }
};

export const obtenerDetallePedido = async (req, res) => {
    try {
        const detalle = await DetallesPedido.findByPk(req.params.id, { include: ["pedido", "producto"] });
        if (!detalle) return res.status(404).json({ mensaje: "Detalle de pedido no encontrado" });
        res.json(detalle);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener detalle de pedido", error });
    }
};

export const actualizarDetallePedido = async (req, res) => {
    try {
        const detalle = await DetallesPedido.findByPk(req.params.id);
        if (!detalle) return res.status(404).json({ mensaje: "Detalle de pedido no encontrado" });

        await detalle.update(req.body);
        res.json(detalle);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al actualizar detalle de pedido", error });
    }
};

export const eliminarDetallePedido = async (req, res) => {
    try {
        const detalle = await DetallesPedido.findByPk(req.params.id);
        if (!detalle) return res.status(404).json({ mensaje: "Detalle de pedido no encontrado" });

        await detalle.destroy();
        res.json({ mensaje: "Detalle de pedido eliminado" });
    } catch (error) {
        res.status(500).json({ mensaje: "Error al eliminar detalle de pedido", error });
    }
};
