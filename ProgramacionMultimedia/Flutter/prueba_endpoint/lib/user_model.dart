class User {
  final String id;
  final String nombre;
  final String correo;
  final String? contrasena;
  final List<List<int>> avatarGrid;

  // 💥 Nuevos campos de color
  final String colorPrimary; // Para los 1s
  final String colorSecondary; // Para los 0s

  User({
    required this.id,
    required this.nombre,
    required this.correo,
    required this.avatarGrid,
    this.contrasena,
    // Valores por defecto si no vienen en el JSON
    this.colorPrimary = "#2196F3", // Azul Flutter por defecto
    this.colorSecondary = "#FFFFFF", // Blanco por defecto
  });

  factory User.fromJson(Map<String, dynamic> json) {
    final List<List<int>> grid = (json['avatarGrid'] as List<dynamic>)
        .map((row) => (row as List<dynamic>).cast<int>())
        .toList();

    return User(
      id: json['_id'] as String,
      nombre: json['nombre'] as String,
      correo: json['correo'] as String,
      contrasena: json['contrasena'] as String?,
      avatarGrid: grid,
      // Mapear los colores si existen, si no usar defaults
      colorPrimary: json['colorPrimary'] as String? ?? "#2196F3",
      colorSecondary: json['colorSecondary'] as String? ?? "#FFFFFF",
    );
  }
}
