import java.util.LinkedList;

public abstract class Utente {


    public abstract Ristorante cercaRistorante(String nome, String numeroTelefono, boolean prenotazioneOnline, double prezzoMinore, double prezzoMaggiore, LinkedList<String> cucine, Luogo luogo);

    public abstract LinkedList<Recensione> visualizzaRecensioni(Ristorante ristorante);

    public abstract String visualizzaRistorante(Ristorante ristorante);
}
