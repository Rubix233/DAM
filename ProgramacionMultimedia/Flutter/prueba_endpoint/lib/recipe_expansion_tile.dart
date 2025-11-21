import 'package:flutter/material.dart';
import 'package:prueba_endpoint/recipe.dart';

class RecipeExpansionTile extends StatelessWidget {
  final Recipe recipe;

  const RecipeExpansionTile({super.key, required this.recipe});

  // Función auxiliar para construir la lista de ingredientes/instrucciones
  Widget _buildDetailsList({
    required String title,
    required List<String> items,
    required bool numbered,
  }) {
    if (items.isEmpty)
      return const SizedBox.shrink(); // No muestra nada si está vacío

    return Padding(
      padding: const EdgeInsets.only(top: 10.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            title,
            style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 16),
          ),
          const Divider(height: 5, color: Colors.grey),
          // Usamos Column o ListView.builder para mostrar la lista
          ...List.generate(items.length, (index) {
            return Padding(
              padding: const EdgeInsets.symmetric(vertical: 4.0),
              child: Row(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    numbered ? '${index + 1}. ' : '• ',
                    style: const TextStyle(fontWeight: FontWeight.bold),
                  ),
                  Expanded(child: Text(items[index])),
                ],
              ),
            );
          }),
        ],
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Card(
      margin: const EdgeInsets.symmetric(vertical: 8.0, horizontal: 16.0),
      // 💥 Usamos ExpansionTile en lugar de Column
      child: ExpansionTile(
        // La cabecera (Header) es lo que siempre está visible
        title: Text(
          recipe.nombre,
          style: const TextStyle(
            fontWeight: FontWeight.bold,
            fontSize: 18,
            color: Colors.blue,
          ),
        ),
        // Subtítulo con datos secundarios
        subtitle: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text(
              'Categoria: ${recipe.categoria} | Dificultad: ${recipe.dificultad}',
            ),
          ],
        ),
        // Contenido (Children) es lo que aparece al desplegarse
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.only(
              left: 16.0,
              right: 16.0,
              bottom: 12.0,
            ),
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: <Widget>[
                // Mostrar datos adicionales en la zona de contenido
                Text('Tiempo: ${recipe.tiempo}'),
                Text('Raciones: ${recipe.comensales}'),

                // Mostrar ingredientes
                _buildDetailsList(
                  title: 'Ingredientes 🧂',
                  items: recipe.ingredientes,
                  numbered: false,
                ),

                // Mostrar instrucciones/pasos
                _buildDetailsList(
                  title: 'Instrucciones 🧑‍🍳',
                  items: recipe.instrucciones,
                  numbered: true,
                ),
              ],
            ),
          ),
        ],
      ),
    );
  }
}
