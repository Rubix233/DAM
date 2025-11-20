import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:prueba_endpoint/controller.dart'; // El controlador
import 'package:prueba_endpoint/data_fetcher.dart'; // ¡El nuevo widget!

void main() {
  // 1. Inicializa el controlador y lo provee a toda la aplicación
  runApp(
    ChangeNotifierProvider(
      create: (context) => RecipeController(),
      child: const MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Listado de Recetas',
      home: Scaffold(
        appBar: AppBar(title: const Text('Listado de Recetas')),
        // 2. Usamos el DataFetcher importado
        body: DataFetcher(),
      ),
    );
  }
}
