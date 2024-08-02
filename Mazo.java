import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Juan Jose
 * @Date: 2/08/2024
 */

public class Mazo {
    private List<Carta> cards;

    public Mazo() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j < 4; j++) { 
                cards.add(new Carta(i));
            }
        }
        barajar();
    }

    public void barajar() {
        Collections.shuffle(cards);
    }

    public Carta repartirCarta() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}
