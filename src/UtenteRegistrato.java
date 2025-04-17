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

    private LinkedList<Ristorante> RistorantiPreferiti;

    public UtenteRegistrato(String username, String nome, String cognome, Date dataNascita, String password, boolean ristoratore, Luogo luogo) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.password = password;
        this.ristoratore = ristoratore;
        this.luogo = luogo;

        this.RistorantiPreferiti = new LinkedList<Ristorante>();
    }

    //<editor-fold desc="Getter">
    public String getUsername() { return username; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public Date getDataNascita() { return dataNascita; }
    public boolean isRistoratore() { return ristoratore; }
    public Luogo getLuogo() { return luogo; }
    public LinkedList<Ristorante> getRistorantiPreferiti() { return RistorantiPreferiti; }
    //</editor-fold>



    public void aggiungiPreferito(Ristorante ristorante) {
        if (!RistorantiPreferiti.contains(ristorante)) {
            RistorantiPreferiti.add(ristorante);
            System.out.println("Ristorante aggiunto ai preferiti: " /*+ ristorante.getNome()*/);
        } else {
            System.out.println("Il ristorante è già nei preferiti.");
        }
    }

    public void visualizzaPreferito() {
        if (RistorantiPreferiti.isEmpty()) {
            System.out.println("Nessun ristorante nei preferiti.");
        } else {
            System.out.println("Ristoranti preferiti:");
            for (Ristorante r : RistorantiPreferiti) {
                System.out.println("- " /*+ r.getNome()*/);
            }
        }
    }

    public void rimuoviPreferito(Ristorante ristorante) {
        if (RistorantiPreferiti.remove(ristorante)) {
            System.out.println("Ristorante rimosso dai preferiti: " /*+ ristorante.getNome()*/);
        } else {
            System.out.println("Il ristorante non era nei preferiti.");
        }
    }

    private void aggiungiRecensione(){
        //sviluppa metodo
    }

    private void rimuoviRecensione(){
        //sviluppa metodo
    }

    private void modificaRecensione(){
        //sviluppa metodo
    }

    private void visualizzaRecensioniFatte() {
        //sviluppa metodo
    }

    private void visualizzaRistorantiRecensiti() {
        //sviluppa metodo
    }

    @Override
    public void visualizzaRecensioni() {
        //sviluppa metodo
    }

    @Override
    public void visualizzaRistorante() {
        //sviluppa metodo
    }

    @Override
    public void cercaRistorante() {
        //sviluppa metodo
    }
}
