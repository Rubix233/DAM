import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const MODELS_DIR = path.join(__dirname, 'models');
const SERVICES_DIR = path.join(__dirname, 'services');
const CONTROLLERS_DIR = path.join(__dirname, 'controllers');
const BASE_CONTROLLERS_DIR = path.join(CONTROLLERS_DIR, 'base');
const ROUTES_DIR = path.join(__dirname, 'routes');

// Ensure directories exist
[SERVICES_DIR, CONTROLLERS_DIR, BASE_CONTROLLERS_DIR, ROUTES_DIR].forEach(dir => {
    if (!fs.existsSync(dir)) {
        fs.mkdirSync(dir, { recursive: true });
    }
});

async function generateAutoCRUD() {
    const files = fs.readdirSync(MODELS_DIR);
    const models = files
        .filter(f => f.endsWith('.js') && f !== 'index.js' && f !== 'init-models.js' && f !== 'log.js')
        .map(f => ({
            name: f.replace('.js', ''),
            className: f.replace('.js', '').charAt(0).toUpperCase() + f.replace('.js', '').slice(1).replace(/_([a-z])/g, (g) => g[1].toUpperCase())
        }));

    for (const model of models) {
        console.log(`Generando CRUD para: ${model.className}...`);

        const serviceName = `${model.name}Service`;
        const controllerBaseName = `${model.name}BaseController`;
        const controllerName = `${model.name}Controller`;
        const routesName = `${model.name}.routes`;

        // 1. Generate Service
        const serviceTemplate = `import { ${model.className} } from '../models/index.js';
import Log from '../models/log.js';

export class ${model.className}Service {
    static async getAll() {
        return await ${model.className}.findAll();
    }


    static async getById(id) {
        return await ${model.className}.findByPk(id);
    }

    static async create(data) {
        const item = await ${model.className}.create(data);
        await Log.create({ log: \`Creado ${model.className} con ID: \${item.id}\` });
        return item;
    }

    static async update(id, data) {
        const item = await ${model.className}.findByPk(id);
        if (item) {
            await item.update(data);
            await Log.create({ log: \`Actualizado ${model.className} con ID: \${id}\` });
        }
        return item;
    }

    static async delete(id) {
        const item = await ${model.className}.findByPk(id);
        if (item) {
            await item.destroy();
            await Log.create({ log: \`Eliminado ${model.className} con ID: \${id}\` });
        }
        return item;
    }
}
`;
        fs.writeFileSync(path.join(SERVICES_DIR, `${model.name}.service.js`), serviceTemplate);

        // 2. Generate Base Controller (Template Method Pattern)
        const baseControllerTemplate = `import { ${model.className}Service } from '../../services/${model.name}.service.js';

export class ${model.className}BaseController {
    async getAll(req, res) {
        try {
            const data = await ${model.className}Service.getAll();
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener datos", error: error.message });
        }
    }

    async getById(req, res) {
        try {
            const data = await ${model.className}Service.getById(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al obtener detalle", error: error.message });
        }
    }

    async create(req, res) {
        try {
            const data = await ${model.className}Service.create(req.body);
            res.status(201).json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al crear", error: error.message });
        }
    }

    async update(req, res) {
        try {
            const data = await ${model.className}Service.update(req.params.id, req.body);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json(data);
        } catch (error) {
            res.status(500).json({ mensaje: "Error al actualizar", error: error.message });
        }
    }

    async delete(req, res) {
        try {
            const data = await ${model.className}Service.delete(req.params.id);
            if (!data) return res.status(404).json({ mensaje: "No encontrado" });
            res.json({ mensaje: "Eliminado con éxito" });
        } catch (error) {
            res.status(500).json({ mensaje: "Error al eliminar", error: error.message });
        }
    }
}`;
        fs.writeFileSync(path.join(BASE_CONTROLLERS_DIR, `${model.name}.base.controller.js`), baseControllerTemplate);

        // 3. Generate Extended Controller (Customizable)
        const controllerPath = path.join(CONTROLLERS_DIR, `${model.name}.controller.js`);
        let shouldOverwrite = true;

        if (fs.existsSync(controllerPath)) {
            const content = fs.readFileSync(controllerPath, 'utf8');
            if (content.includes(`extends ${model.className}BaseController`)) {
                shouldOverwrite = false; // Preserve customized controller
            }
        }

        if (shouldOverwrite) {
            const controllerTemplate = `import { ${model.className}BaseController } from './base/${model.name}.base.controller.js';

class ${model.className}Controller extends ${model.className}BaseController {
    // Aquí puedes sobrescribir métodos del BaseController para personalizar la lógica
}

export default new ${model.className}Controller();
`;
            fs.writeFileSync(controllerPath, controllerTemplate);
        }

        // 4. Generate Routes
        const routesTemplate = `import express from 'express';
import controller from '../controllers/${model.name}.controller.js';

const router = express.Router();

router.get('/', (req, res) => controller.getAll(req, res));
router.get('/:id', (req, res) => controller.getById(req, res));
router.post('/', (req, res) => controller.create(req, res));
router.put('/:id', (req, res) => controller.update(req, res));
router.delete('/:id', (req, res) => controller.delete(req, res));

export default router;
`;
        fs.writeFileSync(path.join(ROUTES_DIR, `${model.name}.routes.js`), routesTemplate);
    }

    console.log(' Generación de AutoCRUD completada.');
}

generateAutoCRUD();

