import java.util.Scanner;

/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Juego {
    private Jugador jugador;
    private Repartidor repartirdor;
    private Mazo mazo;
    private int juegosGanados;
    private int juegosPerdidos;
    private int juegosEmpatados;

    public Juego(String nombreJugador) {
        jugador = new Jugador(nombreJugador);
        repartirdor = new Repartidor();
        mazo = new Mazo();
        juegosGanados = 0;
        juegosPerdidos = 0;
        juegosEmpatados = 0;
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        String decision;

        do {
            jugador.getMano().getCards().clear();
            repartirdor.getMano().getCards().clear();
            mazo = new Mazo();
            jugador.pedirCarta(mazo);
            jugador.pedirCarta(mazo);
            repartirdor.pedirCarta(mazo);
            repartirdor.pedirCarta(mazo);

            boolean jugadorContinua = true;
            while (jugadorContinua) {
                System.out.println("Tu mano: " + jugador.getMano().obtenerValorTotal());
                System.out.print("¿Deseas pedir una carta (s) o detenerte (n)? ");
                decision = scanner.nextLine();

                if (decision.equalsIgnoreCase("s")) {
                    jugador.pedirCarta(mazo);
                    repartirdor.pedirCarta(mazo);

                    if (jugador.getMano().obtenerValorTotal() > 21) {
                        System.out.println("¡Has perdido! Tu mano supera los 21.");
                        juegosPerdidos++;
                        jugadorContinua = false;
                    }
                } else if (decision.equalsIgnoreCase("n")) {
                    jugadorContinua = false;
                }
            }

            if (jugador.getMano().obtenerValorTotal() <= 21) {
                System.out.println("Tu mano final: " + jugador.getMano().obtenerValorTotal());
                System.out.println("Mano del repartidor: " + repartirdor.getMano().obtenerValorTotal());
                String resultado = compararManos();
                System.out.println(resultado);

                if (resultado.contains("ganado")) {
                    juegosGanados++;
                } else if (resultado.contains("perdido")) {
                    juegosPerdidos++;
                } else {
                    juegosEmpatados++;
                }
            }

            System.out.print("¿Deseas jugar otra partida? (s/n): ");
            decision = scanner.nextLine();
        } while (decision.equalsIgnoreCase("s"));

        mostrarEstadisticas();
    }

    public String compararManos() {
        int jugadorValor = jugador.getMano().obtenerValorTotal();
        int repartirdorValor = repartirdor.getMano().obtenerValorTotal();

        if (jugadorValor > 21) {
            return "¡Has perdido! Tu mano supera los 21.";
        } else if (repartirdorValor > 21) {
            return "¡Has ganado! La mano del repartirdor supera los 21.";
        } else if (jugadorValor > repartirdorValor) {
            return "¡Has ganado! Tu mano está más cerca de 21.";
        } else if (jugadorValor < repartirdorValor) {
            return "¡Has perdido! La mano del repartirdor está más cerca de 21.";
        } else {
            return "Es un empate.";
        }
    }

    private void mostrarEstadisticas() {
        System.out.println("Estadísticas del juego:");
        System.out.println("Juegos ganados: " + juegosGanados);
        System.out.println("Juegos perdidos: " + juegosPerdidos);
        System.out.println("Juegos empatados: " + juegosEmpatados);
    }
}
