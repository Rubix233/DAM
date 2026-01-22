import { Categorias } from "../models/index.js";

export const crearCategoria = async (req, res) => {
    try {
        const nuevaCategoria = await Categorias.create(req.body);
        res.status(201).json(nuevaCategoria);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al crear categoría", error });
    }
};

export const obtenerCategorias = async (req, res) => {
    try {
        const categorias = await Categorias.findAll();
        res.json(categorias);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener categorías", error });
    }
};

export const obtenerCategoria = async (req, res) => {
    try {
        const categoria = await Categorias.findByPk(req.params.id);
        if (!categoria) return res.status(404).json({ mensaje: "Categoría no encontrada" });
        res.json(categoria);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al obtener categoría", error });
    }
};

export const actualizarCategoria = async (req, res) => {
    try {
        const categoria = await Categorias.findByPk(req.params.id);
        if (!categoria) return res.status(404).json({ mensaje: "Categoría no encontrada" });

        await categoria.update(req.body);
        res.json(categoria);
    } catch (error) {
        res.status(500).json({ mensaje: "Error al actualizar categoría", error });
    }
};

export const eliminarCategoria = async (req, res) => {
    try {
        const categoria = await Categorias.findByPk(req.params.id);
        if (!categoria) return res.status(404).json({ mensaje: "Categoría no encontrada" });

        await categoria.destroy();
        res.json({ mensaje: "Categoría eliminada" });
    } catch (error) {
        res.status(500).json({ mensaje: "Error al eliminar categoría", error });
    }
};
