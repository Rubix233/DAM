import { Clientes } from '../models/index.js';
import Log from '../models/log.js';

export class ClientesService {
    static async getAll() {
        return await Clientes.findAll();
    }


    static async getById(id) {
        return await Clientes.findByPk(id);
    }

    static async create(data) {
        const item = await Clientes.create(data);
        await Log.create({ log: `Creado Clientes con ID: ${item.id}` });
        return item;
    }

    static async update(id, data) {
        const item = await Clientes.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: `Actualizado Clientes con ID: ${id}` });
        }
        return item;
    }

    static async delete(id) {
        const item = await Clientes.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: `Eliminado Clientes con ID: ${id}` });
        }
        return item;
    }
}
