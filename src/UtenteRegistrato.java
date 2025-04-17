import java.util.Date;

public class UtenteRegistrato extends Utente{
    String username;
    String nome;
    String cognome;
    Date dataNascita;
    String password;
    boolean ristoratore;
    Luogo luogo;

    public UtenteRegistrato(String username, String nome, String cognome, Date dataNascita, String password, boolean ristoratore, Luogo luogo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.password = password;
        this.ristoratore = ristoratore;
        this.luogo = luogo;
    }

    private void aggiungiPreferito(){
        //sviluppa metodo
    }

    private void visualizzaPreferito(){
        //sviluppa metodo
    }

    private void rimuoviPreferito(){
        //sviluppa metodo
    }

    private void aggiungiRecensione(){
        //sviluppa metodo
    }
}
