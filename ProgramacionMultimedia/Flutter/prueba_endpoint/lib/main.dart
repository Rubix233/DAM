import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:prueba_endpoint/recipe.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('Flutter + Servicios Web')),
        body: Center(child: DataFetcher()),
      ),
    );
  }
}

class DataFetcher extends StatefulWidget {
  @override
  _DataFetcherState createState() => _DataFetcherState();
}

class _DataFetcherState extends State<DataFetcher> {
  Recipe? _recipe;
  @override
  void initState() {
    super.initState();
    fetchData();
  }

  Future fetchData() async {
    final response = await http.get(
      Uri.parse('http://localhost:3000/api/recetas/691b130b50cea8e5ca74dae5'),
    );
    if (response.statusCode == 200) {
      final Map<String, dynamic> jsonData = json.decode(response.body);
      final fetchedRecipe = Recipe.fromJson(jsonData);

      setState(() {
        _recipe = fetchedRecipe;
      });
    } else {
      setState(() {
        _recipe = null;
      });
      print('Error al cargar datos: ${response.statusCode}');
    }
  }

  @override
  Widget build(BuildContext context) {
    // Show a loading indicator if the data hasn't arrived yet
    if (_recipe == null) {
      return const Center(child: CircularProgressIndicator());
    }

    // Use a simple Column of Text widgets for minimal display
    return SingleChildScrollView(
      padding: const EdgeInsets.all(16.0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: <Widget>[
          // Recipe Name (Title)
          Text(
            'Nombre: ${_recipe!.nombre}',
            style: const TextStyle(fontWeight: FontWeight.bold, fontSize: 18),
          ),
          const SizedBox(height: 10),

          // Metadata in simple lines
          Text('Categoria -> ${_recipe!.categoria}'),
          Text('Dificultad -> ${_recipe!.dificultad}'),
          Text('Tiempo -> ${_recipe!.tiempo}'),
          Text('Raciones -> ${_recipe!.comensales}'), // Use comensales
          // NOTE: 'Descripcion' field is omitted here as it's not in your JSON
          const SizedBox(height: 15),
          const Text(
            'Ingredientes:',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          // List ingredients
          ..._recipe!.ingredientes.map((ing) => Text('- $ing')).toList(),

          const SizedBox(height: 15),
          const Text(
            'Instrucciones:', // Corrected label for clarity
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          // List instructions (steps)
          ..._recipe!.instrucciones
              .asMap()
              .entries
              .map((entry) => Text('${entry.key + 1}. ${entry.value}'))
              .toList(),
        ],
      ),
    );
  }
}
