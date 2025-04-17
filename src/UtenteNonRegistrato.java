import java.util.Date;
import java.util.LinkedList;

public class UtenteNonRegistrato extends Utente {
    public UtenteNonRegistrato() {}


    public void registrazione(String username, String nome, String cognome, Date dataNascita, String password, boolean ristoratore, Luogo luogo) {
        //implementazione metodo in corso
        if(!ristoratore)
        {
            UtenteRegistrato u = new UtenteRegistrato(username, nome, cognome, dataNascita, password, luogo);
            //aggiungere l'utente al file (il controllo su tutti i parametri inseriti viene fatto a priopri quando si richiede la registrazione)
        }
        else
        {
            //inserire la parte con il ristoratore
            //aggiungere il ristoratore al file
        }
        System.out.println("Registrazione effettuata con successo");
    }

    @Override
    public LinkedList<Recensione> visualizzaRecensioni(Ristorante ristorante) {
        //implementa metodo
        return new  LinkedList<Recensione>();
    }

    @Override
    public String visualizzaRistorante(Ristorante ristorante ) {
        //implementa metodo
        return  "";
    }

    @Override
    public Ristorante cercaRistorante(String nome, String numeroTelefono, boolean prenotazioneOnline, double prezzoMinore, double prezzoMaggiore, LinkedList<String> cucine, Luogo luogo)
    {
        //implementa metodo
        return new Ristorante();
    }
}
