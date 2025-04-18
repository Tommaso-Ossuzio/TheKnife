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

    /*
        Per tipologia di cucina
        Per locazione geografica (DATO OBBLIGATORIO PER OGNI METODO DI RICERCA) !!!
        Per fascia di prezzo (es. “minore di 30€”, “tra 20€ e 50€”)
        In base alla disponibilità del servizio di delivery
        In base alla disponibilità del servizio di prenotazione online
        Per media del numero di stelle
        Una combinazione dei precedenti criteri di ricerca

        possiamo decidere se fare un unico metodo, quindi in base agli elementi inseriti troviamo i ristoranti (gli elementi non inseriti saranno null)
        oppure facciamo più metodi con l'overloading (anche se essendoci la combinazione di più criteri conviene farne uno unico)
    */
    @Override
    public LinkedList<Ristorante> cercaRistorante(Luogo luogo, String cucina, double prezzoMinore, double prezzoMaggiore, boolean delivery, boolean prenotazioneOn, double medStelle)
    {
        //implementazione in corso
        //L'idea è quella di prendere una lista di ristoranti partendo dal primo criterio di ricerca
        // e nel caso di più criteri: eliminare i ristoranti che non li soddisfano contemporaneamente

        GestioneFile g = new GestioneFile();
        LinkedList<Ristorante> r = null;

        if(luogo!=null)
        {
            //r = g.leggiFile().contains(x->(x instanceof Ristorante) && x(Ristorante).)
        }
        return new LinkedList<Ristorante>();
    }
}
