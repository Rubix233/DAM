import { Pedidos } from '../models/index.js';
import Log from '../models/log.js';

export class PedidosService {
    static async getAll() {
        return await Pedidos.findAll();
    }


    static async getById(id) {
        return await Pedidos.findByPk(id);
    }

    static async create(data) {
        const item = await Pedidos.create(data);
        await Log.create({ log: `Creado Pedidos con ID: ${item.id}` });
        return item;
    }

    static async update(id, data) {
        const item = await Pedidos.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: `Actualizado Pedidos con ID: ${id}` });
        }
        return item;
    }

    static async delete(id) {
        const item = await Pedidos.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: `Eliminado Pedidos con ID: ${id}` });
        }
        return item;
    }
}
