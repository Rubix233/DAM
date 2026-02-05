import { Productos } from '../models/index.js';
import Log from '../models/log.js';

export class ProductosService {
    static async getAll() {
        return await Productos.findAll();
    }


    static async getById(id) {
        return await Productos.findByPk(id);
    }

    static async create(data) {
        const item = await Productos.create(data);
        await Log.create({ log: `Creado Productos con ID: ${item.id}` });
        return item;
    }

    static async update(id, data) {
        const item = await Productos.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: `Actualizado Productos con ID: ${id}` });
        }
        return item;
    }

    static async delete(id) {
        const item = await Productos.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: `Eliminado Productos con ID: ${id}` });
        }
        return item;
    }
}
