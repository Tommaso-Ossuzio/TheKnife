import javax.management.AttributeNotFoundException;
import java.util.Date;

public class UtenteNonRegistrato extends Utente {
    public UtenteNonRegistrato() {}


    public void registrazione(String username, String nome, String cognome, Date dataNascita, String password, boolean ristoratore, Luogo luogo) {
        //implementazione metodo in corso
        if(!ristoratore)
        {
            UtenteRegistrato u = new UtenteRegistrato(username, nome, cognome, dataNascita, password, ristoratore, luogo);
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
    public void visualizzaRecensioni() {
        //implementa metodo
    }

    @Override
    public void visualizzaRistorante() {
        //implementa metodo
    }

    @Override
    public void cercaRistorante() {
        //implementa metodo
    }
}
