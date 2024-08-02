/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Jugador {
    private String nombre;
    private Mano mano;

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Mano();
    }

    public void pedirCarta(Mazo deck) {
        mano.agregarCarta(deck.repartirCarta());
    }

    public void detenerse() {
       
    }

    public String getNombre() {
        return nombre;
    }

    public Mano getMano() {
        return mano;
    }
}
