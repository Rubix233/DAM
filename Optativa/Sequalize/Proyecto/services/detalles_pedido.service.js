import { DetallesPedido } from '../models/index.js';
import Log from '../models/log.js';

export class DetallesPedidoService {
    static async getAll() {
        return await DetallesPedido.findAll();
    }


    static async getById(id) {
        return await DetallesPedido.findByPk(id);
    }

    static async create(data) {
        const item = await DetallesPedido.create(data);
        await Log.create({ log: `Creado DetallesPedido con ID: ${item.id}` });
        return item;
    }

    static async update(id, data) {
        const item = await DetallesPedido.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: `Actualizado DetallesPedido con ID: ${id}` });
        }
        return item;
    }

    static async delete(id) {
        const item = await DetallesPedido.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: `Eliminado DetallesPedido con ID: ${id}` });
        }
        return item;
    }
}
