import { DetallesPedidoService } from '../../services/detalles_pedido.service.js';

export class DetallesPedidoBaseController {
    async getAll(req, res) {
        try {
            const data = await DetallesPedidoService.getAll();
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener datos", error: error.message });
        }
    }

    async getById(req, res) {
        try {
            const data = await DetallesPedidoService.getById(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener detalle", error: error.message });
        }
    }

    async create(req, res) {
        try {
            const data = await DetallesPedidoService.create(req.body);
            res.status(201).json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al crear", error: error.message });
        }
    }

    async update(req, res) {
        try {
            const data = await DetallesPedidoService.update(req.params.id, req.body);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al actualizar", error: error.message });
        }
    }

    async delete(req, res) {
        try {
            const data = await DetallesPedidoService.delete(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json({ mensaje: "Eliminado con éxito" });
        } catch (error) {
            res.status(500).json({ mensaje: "Error al eliminar", error: error.message });
        }
    }
}