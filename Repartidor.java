/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Repartidor {
    private Mano mano;

    public Repartidor() {
        mano = new Mano();
    }

    public void pedirCarta(Mazo mazo) {
        mano.agregarCarta(mazo.repartirCarta());
    }

    public Mano getMano() {
        return mano;
    }
}
