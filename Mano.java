import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Mano {
    private List<Carta> cards;

    public Mano() {
        cards = new ArrayList<>();
    }

    public void agregarCarta(Carta card) {
        cards.add(card);
    }

    public int obtenerValorTotal() {
        int total = 0;
        for (Carta card : cards) {
            total += card.getValue();
        }
        return total;
    }

    public List<Carta> getCards() {
        return cards;
    }
}
