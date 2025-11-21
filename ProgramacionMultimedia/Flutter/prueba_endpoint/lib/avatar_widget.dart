import 'package:flutter/material.dart';

class AvatarWidget extends StatelessWidget {
  final List<List<int>> avatarGrid;
  final double cellSize;
  final String colorPrimaryHex;
  final String colorSecondaryHex;

  const AvatarWidget({
    super.key,
    required this.avatarGrid,
    this.cellSize = 10.0,
    required this.colorPrimaryHex,
    required this.colorSecondaryHex,
  });

  Color _hexToColor(String hex) {
    final buffer = StringBuffer();
    if (hex.length == 6 || hex.length == 7) buffer.write('ff');
    buffer.write(hex.replaceFirst('#', ''));
    return Color(int.parse(buffer.toString(), radix: 16));
  }

  @override
  Widget build(BuildContext context) {
    final rows = avatarGrid.length;
    final cols = avatarGrid.isNotEmpty ? avatarGrid[0].length : 0;

    if (rows == 0 || cols == 0) {
      return const CircleAvatar(child: Icon(Icons.person));
    }

    final color1 = _hexToColor(colorPrimaryHex);
    final color0 = _hexToColor(colorSecondaryHex);

    return Container(
      width: cols * cellSize,
      height: rows * cellSize,
      // Borde exterior negro opcional
      decoration: BoxDecoration(
        border: Border.all(color: Colors.black, width: 2),
      ),
      // 💥 AQUÍ ESTÁ EL CAMBIO: Usamos CustomPaint
      child: CustomPaint(
        painter: _AvatarPainter(
          grid: avatarGrid,
          color0: color0,
          color1: color1,
        ),
      ),
    );
  }
}

// 🎨 Clase que dibuja los píxeles directamente en el canvas
class _AvatarPainter extends CustomPainter {
  final List<List<int>> grid;
  final Color color0;
  final Color color1;

  _AvatarPainter({
    required this.grid,
    required this.color0,
    required this.color1,
  });

  @override
  void paint(Canvas canvas, Size size) {
    final paint = Paint()..style = PaintingStyle.fill;

    // Calculamos el tamaño exacto de cada celda basándonos en el tamaño total disponible
    final rows = grid.length;
    final cols = grid[0].length;
    final cellW = size.width / cols;
    final cellH = size.height / rows;

    // 1. Truco Anti-Líneas: Pintar TODO el fondo con el color secundario (0)
    // Esto asegura que no haya huecos blancos entre celdas.
    paint.color = color0;
    canvas.drawRect(Rect.fromLTWH(0, 0, size.width, size.height), paint);

    // 2. Pintar solo los bloques que son 1 encima
    paint.color = color1;

    // Desactivar anti-aliasing para bordes perfectamente cuadrados (estilo pixel art)
    paint.isAntiAlias = false;

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (grid[r][c] == 1) {
          // Para evitar micro-sangrado, usamos ceil/floor o dibujamos exacto.
          // Al tener el fondo ya pintado, drawRect funciona perfecto aquí.
          final rect = Rect.fromLTWH(
            c * cellW,
            r * cellH,
            cellW, // A veces se suma +0.5 para solapar si aún ves líneas,
            cellH, // pero con el fondo pintado no hace falta.
          );
          canvas.drawRect(rect, paint);
        }
      }
    }
  }

  @override
  bool shouldRepaint(covariant CustomPainter oldDelegate) {
    return true; // Repintar si cambian los datos
  }
}
