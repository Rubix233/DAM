class Recipe {
  final String nombre;
  final String categoria;
  final String dificultad;
  final String tiempo;
  final int comensales;
  final List<String> instrucciones;
  final List<String> ingredientes;
  final String? youtubeUrl;
  final String? imageUrl;

  Recipe({
    required this.nombre,
    required this.categoria,
    this.dificultad = 'Todos los niveles',
    this.tiempo = '',
    this.comensales = 1,
    List<String>? instrucciones,
    List<String>? ingredientes,
    this.youtubeUrl,
    this.imageUrl,
  }) : instrucciones = instrucciones ?? const [],
       ingredientes = ingredientes ?? const [];

  // 1. Método Factory para deserialización (GET)
  factory Recipe.fromJson(Map<String, dynamic> json) => Recipe(
    nombre: json['nombre'] as String,
    categoria: json['categoria'] as String,
    dificultad: json['dificultad'] as String,
    tiempo: json['tiempo'] as String,
    comensales: json['comensales'] as int,
    instrucciones: List<String>.from(json['instrucciones']),
    ingredientes: List<String>.from(json['ingredientes']),
    // Nota: Para campos opcionales que podrían faltar en el JSON de la API,
    // es mejor usar el operador null-aware '?.' o un cast condicional.
    youtubeUrl: json['youtubeUrl'] as String?,
    imageUrl: json['imageUrl'] as String?,
  );

  // 2. Método toJson para serialización (POST)
  Map<String, dynamic> toJson() {
    return {
      'nombre': nombre,
      'categoria': categoria,
      'dificultad': dificultad,
      'tiempo': tiempo,
      'comensales': comensales,
      'instrucciones': instrucciones,
      'ingredientes': ingredientes,
      // Incluir campos opcionales solo si tienen valor (no null)
      if (youtubeUrl != null) 'youtubeUrl': youtubeUrl,
      if (imageUrl != null) 'imageUrl': imageUrl,
    };
  }
}
