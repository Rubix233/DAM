import { Pedidos } from "../models/index.js";

export const crearPedido = async (req, res) => {
    try {
        const nuevoPedido = await Pedidos.create(req.body);
        res.status(201).json(nuevoPedido);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al crear pedido", error });
    }
};

export const obtenerPedidos = async (req, res) => {
    try {
        const pedidos = await Pedidos.findAll({ include: "cliente" });
        res.json(pedidos);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener pedidos", error });
    }
};

export const obtenerPedido = async (req, res) => {
    try {
        const pedido = await Pedidos.findByPk(req.params.id, { include: "cliente" });
        if (!pedido) return res.status(404).json({ mensaje: "Pedido no encontrado" });
        res.json(pedido);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener pedido", error });
    }
};

export const actualizarPedido = async (req, res) => {
    try {
        const pedido = await Pedidos.findByPk(req.params.id);
        if (!pedido) return res.status(404).json({ mensaje: "Pedido no encontrado" });

        await pedido.update(req.body);
        res.json(pedido);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al actualizar pedido", error });
    }
};

export const eliminarPedido = async (req, res) => {
    try {
        const pedido = await Pedidos.findByPk(req.params.id);
        if (!pedido) return res.status(404).json({ mensaje: "Pedido no encontrado" });

        await pedido.destroy();
        res.json({ mensaje: "Pedido eliminado" });
    } catch (error) {
        res.status(500).json({ mensaje: "Error al eliminar pedido", error });
    }
};
