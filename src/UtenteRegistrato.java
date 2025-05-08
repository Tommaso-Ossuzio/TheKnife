
import java.util.Date;
import java.util.LinkedList;

public class UtenteRegistrato extends Utente{
    String username;
    String nome;
    String cognome;
    Date dataNascita;
    String password;
    boolean ristoratore;
    Luogo luogo;

    private LinkedList<Ristorante> ristorantiPreferiti;
    private LinkedList<Recensione> recensioni;

    public UtenteRegistrato(String username, String nome, String cognome, Date dataNascita, String password, Luogo luogo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.password = password;
        this.ristoratore = false;
        this.luogo = luogo;

        this.ristorantiPreferiti = new LinkedList<Ristorante>();
        this.recensioni = new LinkedList<>();
    }

    //<editor-fold desc="Getter">
    public String getUsername() { return username; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public Date getDataNascita() { return dataNascita; }
    public boolean isRistoratore() { return ristoratore; }
    public Luogo getLuogo() { return luogo; }
    public LinkedList<Ristorante> getRistorantiPreferiti() { return ristorantiPreferiti; }
    public LinkedList<Recensione> getRecensioni() { return recensioni; }
    //</editor-fold>



    public void aggiungiPreferito(Ristorante ristorante) {
        if (!ristorantiPreferiti.contains(ristorante)) {
            ristorantiPreferiti.add(ristorante);
            System.out.println("Ristorante aggiunto ai preferiti: " /*+ ristorante.getNome()*/);
        } else {
            System.out.println("Il ristorante è già nei preferiti.");
        }
    }

    public void visualizzaPreferito() {
        if (ristorantiPreferiti.isEmpty()) {
            System.out.println("Nessun ristorante nei preferiti.");
        } else {
            System.out.println("Ristoranti preferiti:");
            for (Ristorante r : ristorantiPreferiti) {
                System.out.println("- " /*+ r.getNome()*/);
            }
        }
    }

    public void rimuoviPreferito(Ristorante ristorante) {
        if (ristorantiPreferiti.remove(ristorante)) {
            System.out.println("Ristorante rimosso dai preferiti: " /*+ ristorante.getNome()*/);
        } else {
            System.out.println("Il ristorante non era nei preferiti.");
        }
    }

    private void aggiungiRecensione(int n_stelle,String text, Date data, Ristorante ristorante)
    {
        Recensione recensione= new Recensione(n_stelle, text,this, ristorante );
        recensioni.add(recensione);
        Ristorante r = ristorante;
        r.recensioni.add(recensione);
    }

    private void rimuoviRecensione(Recensione recensione)
    {
        recensioni.remove(recensioni.indexOf(recensione));
        Ristorante ristorante= recensione.getRistorante();
        ristorante.recensioni.remove(recensioni.indexOf(ristorante));

    }

    private void modificaRecensione(Recensione recensione, String text, int numeroStelle )
    {
        numeroStelle = numeroStelle == 0 ? recensione.getNumeroStelle(): numeroStelle;
        text = text.length()==0 ||text ==null ? recensione.getText(): text;
        if(recensioni.contains(recensione)) {
            recensioni.set(recensioni.indexOf(recensione), new Recensione(numeroStelle, text, this, recensione.getRistorante()));
            Ristorante ristorante= recensione.getRistorante();
            ristorante.recensioni.set(recensioni.indexOf(recensione), new Recensione(numeroStelle, text, this, recensione.getRistorante()));
        }
    }

    private LinkedList<Recensione> visualizzaRecensioniFatte()
    {
        return getRecensioni();
    }

    private LinkedList<Ristorante> visualizzaRistorantiRecensiti()
    {
        LinkedList<Ristorante> lista = new LinkedList<>();
        for(Recensione r: recensioni )
            lista.add(r.getRistorante());
        return lista;
    }

    //da verificare in utente se void o LinkedList
    @Override
    public LinkedList<Recensione> visualizzaRecensioni(Ristorante ristorante)
    {
        return ristorante.getRecensioni();
    }


    @Override
    public String visualizzaRistorante(Ristorante ristorante)
    {
        return ristorante.toString();
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
        GestioneFile gf = new GestioneFile();
        LinkedList<Ristorante> lista = gf.leggiFile();


        if(luogo!= null)
        {
            //da gestire opportunamente con il luogo definitivo
        }

        if(cucina != null)
        {
            lista.removeIf((x)-> !(x.getCucina().equals(cucina)));
        }
        //per convenzione se il valore è zero il campo è considerato nullo
        if(prezzoMinore>0)
        {    if(prezzoMaggiore>0)
            {
                //Ricerca completa min>x>max
                lista.removeIf((x)->x.prezzo_Medio<prezzoMaggiore);
            }
            //ricerca min>x
            lista.removeIf((x)->x.prezzo_Medio<prezzoMinore);
        }
        else
            if(prezzoMaggiore>0)
                //ricerca max>x
                lista.removeIf((x)->x.prezzo_Medio<prezzoMaggiore);

        if(delivery)
        {
            lista.removeIf((x)->x.getDomicilio()==false);
        }

        if(prenotazioneOn)
        {
            lista.removeIf((x)->x.getPrenotazione()==false);
        }

        //per convenzione lo il num stelle a zero è nullo
        if(medStelle>=0)
        {
            lista.removeIf((x)->x.getMediaStelle()<medStelle);
        }

        return lista;
    }

//    public static void main(String args[])
//    {
//        Luogo luogo = new Luogo("rea","fa","d",3,4.5,3.4);
//        UtenteRegistrato ut = new UtenteRegistrato("gig","fa","faf",new Date("23/5/2005"),"12345",luogo);
//        LinkedList<Ristorante> lista = ut.cercaRistorante(luogo,"Italiana",0,35,true,false,0);
//
//        System.out.println(lista.toString());
//
//    }

}
