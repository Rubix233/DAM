import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:prueba_endpoint/controller.dart'; // El controlador
import 'package:prueba_endpoint/data_fetcher.dart'; // ¡El nuevo widget!
import 'package:prueba_endpoint/user_provider.dart';

void main() {
  runApp(
    // Utilizamos MultiProvider para inyectar ambos controladores
    MultiProvider(
      providers: [
        ChangeNotifierProvider(create: (_) => RecipeController()),
        ChangeNotifierProvider(
          create: (_) => UserProvider(),
        ), // <-- Nuevo proveedor
      ],
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
