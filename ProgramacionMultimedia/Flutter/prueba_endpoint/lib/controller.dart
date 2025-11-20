import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:prueba_endpoint/recipe.dart';

// El controlador extiende ChangeNotifier
class RecipeController extends ChangeNotifier {
  static const String _baseUrl = 'http://localhost:3000/api/recetas';

  // Variables de Estado (privadas)
  List<Recipe> _recipes = [];
  bool _isLoading = false;

  // Getters para acceder al estado desde la UI
  List<Recipe> get recipes => _recipes;
  bool get isLoading => _isLoading;

  RecipeController() {
    // Llama a la carga inicial de datos al crear la instancia
    fetchRecipes();
  }

  /// 1. Función para obtener todas las recetas (GET)
  Future<void> fetchRecipes() async {
    _isLoading = true;
    notifyListeners(); // Notifica a la UI que la carga ha comenzado

    try {
      final response = await http.get(Uri.parse(_baseUrl));

      if (response.statusCode == 200) {
        final List<dynamic> jsonList = json.decode(response.body);

        _recipes = jsonList
            .map((jsonMap) => Recipe.fromJson(jsonMap as Map<String, dynamic>))
            .toList();
      } else {
        print('Fallo al cargar recetas: ${response.statusCode}');
        _recipes = [];
      }
    } catch (e) {
      print('Excepción en fetchRecipes: $e');
      _recipes = [];
    }

    _isLoading = false;
    notifyListeners(); // Notifica a la UI que los datos están listos o la carga ha terminado
  }

  /// 2. Función para enviar la receta (POST)
  Future<void> sendRecipe(Recipe recipe) async {
    final Map<String, dynamic> recipeJson = recipe.toJson();

    final response = await http.post(
      Uri.parse(_baseUrl),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: jsonEncode(recipeJson),
    );

    if (response.statusCode == 201 || response.statusCode == 200) {
      // Si tiene éxito, refresca la lista llamando a fetchData()
      await fetchRecipes();
    } else {
      print('Error al enviar receta: ${response.statusCode}');
      // Manejo de errores de POST
    }
  }
}
