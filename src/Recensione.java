import java.util.Date;

public class Recensione {
    int n_stelle;
    String text;
    Date data;
    UtenteRegistrato utente;
    Ristorante ristorante;

    public Recensione(int n_stelle, String text, UtenteRegistrato utente, Ristorante ristorante)
    {
        this.n_stelle = n_stelle;
        this.text = text;
        this.utente = utente;
        this.ristorante = ristorante;
    }

    @Override
    public String toString() {
        return "Recensione: "+ n_stelle+" "+text+" "+utente+" "+ristorante+"\n";
    }

    public boolean equals(Recensione r) {
        return this.data.equals(r.data) && this.utente.equals(r.utente) && this.ristorante.equals(r.ristorante);
    }

    @Override
    public boolean equals(Object r) {
        if(r instanceof Recensione)
            return this.equals((Recensione)r);
        return false;
    }
}
