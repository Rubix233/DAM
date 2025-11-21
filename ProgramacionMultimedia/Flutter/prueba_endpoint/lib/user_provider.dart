import 'package:flutter/material.dart';
import 'package:prueba_endpoint/user_model.dart';

class UserProvider extends ChangeNotifier {
  final User _currentUser = User.fromJson({
    "_id": "6559d282e70a480d19f4a5b3",
    "nombre": "Juan Pérez",
    "correo": "juan.perez@example.com",
    "contrasena": "hashed_password",

    // 💥 COLORES PERSONALIZADOS
    "colorPrimary": "#2196F3", // Azul
    "colorSecondary": "#1B5E20", // Verde Oscuro (Green[900])

    "avatarGrid": [
      [0, 1, 1, 0, 0, 0, 0, 1, 1, 0],
      [1, 0, 1, 1, 0, 0, 1, 1, 0, 1],
      [0, 1, 0, 1, 1, 1, 1, 0, 1, 0],
      [1, 1, 0, 0, 1, 1, 0, 0, 1, 1],
      [0, 1, 1, 0, 0, 0, 0, 1, 1, 0],
      [1, 0, 1, 1, 1, 1, 1, 0, 1, 0],
      [0, 0, 0, 1, 0, 0, 1, 0, 0, 0],
      [1, 0, 1, 0, 1, 1, 0, 1, 0, 1],
      [0, 1, 1, 1, 0, 0, 1, 1, 1, 0],
      [1, 0, 1, 0, 0, 0, 0, 1, 0, 1],
    ],
  });

  User get currentUser => _currentUser;
}
