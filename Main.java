import java.util.Scanner;

/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();

        Juego juego = new Juego(nombre);
        juego.iniciarJuego();
    }
}
