import java.util.LinkedList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static LinkedList<Integer> rutas = new LinkedList<>();
    static int tX, tY;
    static char[][] grid;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        tX = Integer.parseInt(input[0]);
        tY = Integer.parseInt(input[1]);

        grid = new char[tX][tY];

        for (int i = 0; i < tY; i++) {
            String line = br.readLine();
            for (int j = 0; j < tX; j++) {
                grid[j][i] = line.charAt(j);
            }
        }

        checkPath(0, 0, -1, -1, 1);

        if (rutas.size() > 0) {
            Collections.sort(rutas);
            System.out.println(rutas.get(0));
        } else {
            System.out.println("IMPOSIBLE");
        }
    }

    public static void checkPath(int currentX, int currentY, int oldX, int oldY, int counter) {

        int targetX = currentX;
        int targetY = currentY;

        check(targetX - 1, targetY - 1, currentX, currentY, counter);
        check(targetX, targetY - 1, currentX, currentY, counter);
        check(targetX + 1, targetY - 1, currentX, currentY, counter);

        check(targetX - 1, targetY, currentX, currentY, counter);
        check(targetX + 1, targetY, currentX, currentY, counter);

        check(targetX - 1, targetY + 1, currentX, currentY, counter);
        check(targetX, targetY + 1, currentX, currentY, counter);
        check(targetX + 1, targetY + 1, currentX, currentY, counter);
    }

    public static void check(int targetX, int targetY, int oldX, int oldY, int counter) {

        if (newSlot(targetX, targetY, oldX, oldY)) {
            if (checkSlot(targetX, targetY)) {

                if (targetX == tX - 1 && targetY == tY - 1) {
                    rutas.add(counter);
                } else {
                    checkPath(targetX, targetY, oldX, oldY, counter + 1);
                }
            }
        }
    }

    public static boolean newSlot(int x, int y, int oldX, int oldY) {
        if (x != oldX || y != oldY) {
            if (checkSlot(x, y)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkSlot(int x, int y) {
        if (x >= 0 && x < tX) {
            if (y >= 0 && y < tY) {
                if (grid[x][y] == '.') {
                    return true;
                }
            }
        }
        return false;
    }
}