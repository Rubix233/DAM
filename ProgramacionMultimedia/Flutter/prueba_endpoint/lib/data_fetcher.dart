import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:prueba_endpoint/recipe.dart';
import 'package:prueba_endpoint/controller.dart';
import 'package:prueba_endpoint/ventana_crear_receta.dart';
import 'package:prueba_endpoint/recipe_expansion_tile.dart';
import 'package:prueba_endpoint/avatar_widget.dart';
import 'package:prueba_endpoint/user_provider.dart';
import 'package:prueba_endpoint/user_model.dart';

class DataFetcher extends StatelessWidget {
  DataFetcher({super.key});

  // Opciones de formulario para el diálogo
  final List<String> _categorias = [
    'Plato principal',
    'Postre',
    'Bebidas',
    'Aperitivo',
    'Otros',
  ];
  final List<String> _dificultades = [
    'Muy fácil',
    'Fácil',
    'Intermedio',
    'Difícil',
  ];

  // Función que abre el pop-up y maneja la respuesta
  Future<void> _showCreationDialog(BuildContext context) async {
    final RecipeController controller = context.read<RecipeController>();

    // Muestra el diálogo y espera a que devuelva un valor (una Receta o null)
    final Recipe? nuevaReceta = await showDialog<Recipe>(
      context: context,
      builder: (ctx) => DialogoCrearReceta(
        categorias: _categorias,
        dificultades: _dificultades,
      ),
    );

    // Si el diálogo devolvió una receta (el usuario presionó 'Guardar')
    if (nuevaReceta != null) {
      ScaffoldMessenger.of(context).showSnackBar(
        SnackBar(content: Text('Enviando receta: ${nuevaReceta.nombre}')),
      );

      // Llama al controlador para enviar la nueva receta
      await controller.sendRecipe(nuevaReceta);
    } else {
      // Mensaje de cancelación (opcional)
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Creación de receta cancelada.')),
      );
    }
  }

  // Función para construir el Botón que abre el diálogo
  Widget _buildPostButton(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: ElevatedButton.icon(
        onPressed: () => _showCreationDialog(context), // Llama al diálogo
        icon: const Icon(Icons.add_box),
        label: const Text('Crear Nueva Receta'),
        style: ElevatedButton.styleFrom(
          minimumSize: const Size(double.infinity, 50),
        ),
      ),
    );
  }

  // Widget para mostrar la cabecera del usuario (Avatar + Nombre)
  Widget _buildUserHeader(BuildContext context) {
    // Usamos context.watch para obtener la información del usuario del proveedor
    final userProvider = context.watch<UserProvider>();
    final User user = userProvider.currentUser;

    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Row(
            children: [
              // Pintamos el avatar con la matriz del usuario
              AvatarWidget(
                avatarGrid: user.avatarGrid,
                cellSize: 10.0,
                // Pasamos los colores del objeto usuario
                colorPrimaryHex: user.colorPrimary,
                colorSecondaryHex: user.colorSecondary,
              ),
              const SizedBox(width: 12),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    'Hola, ${user.nombre}!',
                    style: const TextStyle(
                      fontSize: 20,
                      fontWeight: FontWeight.bold,
                    ),
                  ),
                  Text(
                    'Correo: ${user.correo}',
                    style: TextStyle(color: Colors.grey.shade600),
                  ),
                ],
              ),
            ],
          ),
          const Divider(height: 24),
          const Text(
            'Recetas disponibles:',
            style: TextStyle(fontSize: 16, fontWeight: FontWeight.w600),
          ),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    // Escucha los cambios del controlador de recetas
    return Consumer<RecipeController>(
      builder: (context, recipeController, child) {
        final List<Recipe> recipes = recipeController.recipes;
        final bool isLoading = recipeController.isLoading;

        if (isLoading && recipes.isEmpty) {
          return const Center(child: CircularProgressIndicator());
        }

        // Si no hay recetas y no está cargando, mostramos la cabecera y solo el botón
        if (recipes.isEmpty && !isLoading) {
          return SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                _buildUserHeader(context),
                const Center(child: Text('No se encontraron recetas.')),
                _buildPostButton(context),
              ],
            ),
          );
        }

        // Construcción de la lista (incluye cabecera y botón)
        return ListView.builder(
          // itemCount: 1 (Cabecera) + recipes.length (Recetas) + 1 (Botón)
          itemCount: recipes.length + 2,
          itemBuilder: (context, index) {
            // Fila 0: Cabecera del Usuario
            if (index == 0) {
              return _buildUserHeader(context);
            }

            // Última fila: Botón de Crear Receta
            if (index == recipes.length + 1) {
              return _buildPostButton(context);
            }

            // Filas intermedias: Recetas (el índice de la receta es index - 1)
            final recipe = recipes[index - 1];
            return RecipeExpansionTile(recipe: recipe);
          },
        );
      },
    );
  }
}
