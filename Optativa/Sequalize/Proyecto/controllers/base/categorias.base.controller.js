import { CategoriasService } from '../../services/categorias.service.js';

export class CategoriasBaseController {
    async getAll(req, res) {
        try {
            const data = await CategoriasService.getAll();
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener datos", error: error.message });
        }
    }

    async getById(req, res) {
        try {
            const data = await CategoriasService.getById(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener detalle", error: error.message });
        }
    }

    async create(req, res) {
        try {
            const data = await CategoriasService.create(req.body);
            res.status(201).json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al crear", error: error.message });
        }
    }

    async update(req, res) {
        try {
            const data = await CategoriasService.update(req.params.id, req.body);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al actualizar", error: error.message });
        }
    }

    async delete(req, res) {
        try {
            const data = await CategoriasService.delete(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json({ mensaje: "Eliminado con éxito" });
        } catch (error) {
            res.status(500).json({ mensaje: "Error al eliminar", error: error.message });
        }
    }
}