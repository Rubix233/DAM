import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tablero Flutter',
      home: const TableroFlutter(),
    );
  }
}

class TableroFlutter extends StatelessWidget {
  const TableroFlutter({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Tablero Flutter'),
        backgroundColor: Colors.blueAccent,
        centerTitle: true,
      ),
      body: Column(
        children: [
          //  1
          Expanded(
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    color: Colors.red[200],
                    child: const Center(child: Text('Texto simple')),
                  ),
                ),

                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.green[200],
                    child: const Center(
                      child: Icon(Icons.star, size: 40, color: Colors.yellow),
                    ),
                  ),
                ),

                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.blue[200],
                    child: Center(
                      child: ElevatedButton(
                        onPressed: () => print('Botón 1 pulsado'),
                        child: const Text('Botón 1'),
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),

          const SizedBox(height: 8),

          //  2
          Expanded(
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    color: Colors.orange[200],
                    child: const Center(child: FlutterLogo(size: 50)),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.purple[200],
                    child: Center(
                      child: ElevatedButton(
                        onPressed: () => print('Botón 2 pulsado'),
                        child: const Text('Botón 2'),
                      ),
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.teal[200],
                    child: const Center(child: Text('Otro texto')),
                  ),
                ),
              ],
            ),
          ),

          const SizedBox(height: 8),

          // 3
          Expanded(
            child: Row(
              children: [
                Expanded(
                  child: Container(
                    color: Colors.pink[200],
                    child: Center(
                      child: ElevatedButton(
                        onPressed: () => print('Botón 3 pulsado'),
                        child: const Text('Botón 3'),
                      ),
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.lime[200],
                    child: const Center(
                      child: Icon(Icons.favorite, size: 40, color: Colors.red),
                    ),
                  ),
                ),
                const SizedBox(width: 8),
                Expanded(
                  child: Container(
                    color: Colors.cyan[200],
                    child: const Center(child: Text('Celda final')),
                  ),
                ),
              ],
            ),
          ),
        ],
      ),
      bottomNavigationBar: BottomAppBar(
        color: Colors.blueAccent,
        child: const Padding(
          padding: EdgeInsets.all(12.0),
          child: Text(
            'Pie de página',
            textAlign: TextAlign.center,
            style: TextStyle(color: Colors.white),
          ),
        ),
      ),
    );
  }
}
