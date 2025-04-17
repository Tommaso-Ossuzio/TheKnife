import java.util.Date;

public class Recensione {
    private int n_stelle;
    private String text;
    private Date data;
    private UtenteRegistrato utente;
    private Ristorante ristorante;

    public Recensione(int n_stelle, String text, UtenteRegistrato utente, Ristorante ristorante)
    {
        if(text.length()>=300)
            text=text.substring(0,300);
        this.n_stelle = n_stelle;
        this.text = text;
        this.utente = utente;
        this.ristorante = ristorante;
    }

    //<editor-fold desc="Getter">
    public int getN_stelle() {return n_stelle;}
    public String getText() {return text;}
    public Date getData() {return data;}
    public UtenteRegistrato getUtente() {return utente;}
    public Ristorante getRistorante() {return ristorante;}
    //</editor-fold>

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
