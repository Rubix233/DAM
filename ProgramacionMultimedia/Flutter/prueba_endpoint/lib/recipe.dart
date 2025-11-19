class Recipe {
  final String nombre;
  final String categoria;
  final String dificultad;
  final String tiempo;
  final int comensales;
  // Note: Removed 'descripcion' field from the class itself since it's not in your JSON.
  // If you need it, add it back and ensure it's nullable or has a default value.
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

  // 💥 FIX IS HERE: Use List<String>.from() for safe casting of List<dynamic>
  factory Recipe.fromJson(Map<String, dynamic> json) => Recipe(
    // Simple String casts are usually fine if the field is guaranteed to be there and a String
    nombre: json['nombre'] as String,
    categoria: json['categoria'] as String,
    dificultad: json['dificultad'] as String,
    tiempo: json['tiempo'] as String,
    comensales: json['comensales'] as int,

    // ⬇️ SAFELY CONVERT List<dynamic> to List<String>
    instrucciones: List<String>.from(json['instrucciones']),
    ingredientes: List<String>.from(json['ingredientes']),

    // Nullable fields that are missing in JSON are fine to omit in the factory
    // or set to a default value if not provided by the API:
    // youtubeUrl: json['youtubeUrl'] as String?,
    // imageUrl: json['imageUrl'] as String?,
  );

  // (The rest of your Recipe class methods are fine)
}
