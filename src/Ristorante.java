import java.util.LinkedList;

public class Ristorante {
    private String nome;
    private String n_tel;
    private boolean domicilio;  //Disponibilità del servizio di delivery (true/false)
    private boolean prenotazione;    //Disponibilità del servizio di prenotazione online (true/false)
    public double prezzo_Medio;
    private LinkedList<String> cucina;
    private Luogo luogo;
    public LinkedList<Recensione> recensioni;

    public Ristorante(String nome, String n_tel, boolean domicilio, boolean prenotazione, double prezzo_Medio, LinkedList<String> cucina, Luogo luogo)
    {
        this.nome = nome;
        this.n_tel = n_tel;
        this.domicilio = domicilio;
        this.prenotazione = prenotazione;
        this.prezzo_Medio = prezzo_Medio;
        this.cucina = cucina;
        this.luogo = luogo;
        this.recensioni = new LinkedList<>();
    }
    //temporaneo
    public Ristorante(){}

    //<editor-fold desc="Getter">
    public String getNome(){return nome;}
    public String getN_tel(){return n_tel;}
    public boolean getDomicilio(){return domicilio;}
    public boolean getPrenotazione(){return prenotazione;}
    public LinkedList<String> getCucina(){return cucina;}
    public Luogo getLuogo(){return luogo;}
    public LinkedList<Recensione> getRecensioni(){return recensioni;}
    public int getNumeroRecensioni() {return recensioni.size();}
    public double getMediaStelle()
    {
        if(!recensioni.isEmpty())
        {
            int somma = 0;
            for (Recensione r : recensioni) {
                somma += r.getNumeroStelle();
            }
            return (double) somma / recensioni.size();
        }
        else
            return 0;
    }
    //</editor-fold>

    public String toString() {
        String cucine="";
        for(String c : cucina)
        {
            cucine+=c;
        }
        return "Ristorante: "+nome+" "+n_tel+" "+(domicilio ? "servizio di delivery disponibile" : "servizio di delivery non disponibile")+" "
                +(prenotazione ? "servizio di prenotazione online disponibile" : "servizio di prenotazione online non disponibile")+" "+cucine+" "+luogo.toString()+"\n";
    }

    public boolean equals(Ristorante r) {
        return this.nome.equals(r.nome) && this.luogo.equals(r.luogo);
    }

    @Override
    public boolean equals(Object r) {
        if(r instanceof Ristorante)
            return this.equals((Ristorante) r);
        return false;
    }
}
