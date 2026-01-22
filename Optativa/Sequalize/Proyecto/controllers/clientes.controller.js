import { Clientes } from "../models/index.js";

export const crearCliente = async (req, res) => {
    try {
        const nuevoCliente = await Clientes.create(req.body);
        res.status(201).json(nuevoCliente);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al crear cliente", error });
    }
};

export const obtenerClientes = async (req, res) => {
    try {
        const clientes = await Clientes.findAll();
        res.json(clientes);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener clientes", error });
    }
};

export const obtenerCliente = async (req, res) => {
    try {
        const cliente = await Clientes.findByPk(req.params.id);
        if (!cliente) return res.status(404).json({ mensaje: "Cliente no encontrado" });
        res.json(cliente);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener cliente", error });
    }
};

export const actualizarCliente = async (req, res) => {
    try {
        const cliente = await Clientes.findByPk(req.params.id);
        if (!cliente) return res.status(404).json({ mensaje: "Cliente no encontrado" });

        await cliente.update(req.body);
        res.json(cliente);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al actualizar cliente", error });
    }
};

export const eliminarCliente = async (req, res) => {
    try {
        const cliente = await Clientes.findByPk(req.params.id);
        if (!cliente) return res.status(404).json({ mensaje: "Cliente no encontrado" });

        await cliente.destroy();
        res.json({ mensaje: "Cliente eliminado" });
    } catch (error) {
        res.status(500).json({ mensaje: "Error al eliminar cliente", error });
    }
};
