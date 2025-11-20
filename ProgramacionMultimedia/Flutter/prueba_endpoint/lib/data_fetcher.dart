import 'package:flutter/material.dart';
import 'package:provider/provider.dart'; // Necesario para Consumer y context.read
import 'package:prueba_endpoint/recipe.dart'; // La clase Recipe
import 'package:prueba_endpoint/controller.dart'; // El RecipeController

class DataFetcher extends StatelessWidget {
  DataFetcher({super.key});

  // Receta de prueba para el POST
  final Recipe recetaMandada = Recipe(
    nombre: "Receta de prueba POST",
    categoria: "Test",
    tiempo: "1 hora",
    comensales: 2,
    ingredientes: ["Ingrediente 1", "Ingrediente 2"],
    instrucciones: ["Paso 1", "Paso 2"],
    dificultad: "Fácil",
  );

  // Función para construir el Card de la Receta
  Widget _buildRecipeCard(Recipe recipe) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 16.0),
      child: Padding(
        padding: const EdgeInsets.all(12.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: <Widget>[
            Text(
              recipe.nombre,
              style: const TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 18,
                color: Colors.blue,
              ),
            ),
            const Divider(),
            Text('Categoria: ${recipe.categoria}'),
            Text('Dificultad: ${recipe.dificultad}'),
            Text('Tiempo: ${recipe.tiempo}'),
            Text('Raciones: ${recipe.comensales}'),
          ],
        ),
      ),
    );
  }

  // Función para construir el Botón de POST
  Widget _buildPostButton(BuildContext context) {
    // Usamos context.read para invocar un método (POST) sin escuchar los cambios.
    final controller = context.read<RecipeController>();

    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: ElevatedButton.icon(
        onPressed: () {
          // Llama al método del controlador
          controller.sendRecipe(recetaMandada);
          // Notificación visual al usuario
          ScaffoldMessenger.of(
            context,
          ).showSnackBar(const SnackBar(content: Text('Enviando receta...')));
        },
        icon: const Icon(Icons.add_box),
        label: const Text('Añadir Receta de Prueba (POST)'),
        style: ElevatedButton.styleFrom(
          minimumSize: const Size(double.infinity, 50),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    // Escucha los cambios del controlador
    return Consumer<RecipeController>(
      builder: (context, controller, child) {
        final List<Recipe> recipes = controller.recipes;
        final bool isLoading = controller.isLoading;

        if (isLoading && recipes.isEmpty) {
          return const Center(child: CircularProgressIndicator());
        }

        if (recipes.isEmpty && !isLoading) {
          return const Center(child: Text('No se encontraron recetas.'));
        }

        // Construcción de la lista
        return ListView.builder(
          itemCount: recipes.length + 1,
          itemBuilder: (context, index) {
            if (index == recipes.length) {
              return _buildPostButton(context); // El botón
            }
            return _buildRecipeCard(recipes[index]); // La tarjeta
          },
        );
      },
    );
  }
}
