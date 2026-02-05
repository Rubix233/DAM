import { Categorias } from '../models/index.js';
import Log from '../models/log.js';

export class CategoriasService {
    static async getAll() {
        return await Categorias.findAll();
    }


    static async getById(id) {
        return await Categorias.findByPk(id);
    }

    static async create(data) {
        const item = await Categorias.create(data);
        await Log.create({ log: `Creado Categorias con ID: ${item.id}` });
        return item;
    }

    static async update(id, data) {
        const item = await Categorias.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: `Actualizado Categorias con ID: ${id}` });
        }
        return item;
    }

    static async delete(id) {
        const item = await Categorias.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: `Eliminado Categorias con ID: ${id}` });
        }
        return item;
    }
}
