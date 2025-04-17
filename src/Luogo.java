public class Luogo {

    private String nazione;
    private String via;
    private String citta;
    private int n_civico;
    private double latitudine;
    private double longitudine;

    public Luogo(String nazione, String via, String citta, int n_civico,double latitudine, double longitudine)
    {
        this.nazione = nazione;
        this.via = via;
        this.citta = citta;
        this.n_civico = n_civico;
        this.latitudine = latitudine;
        this.longitudine = longitudine;
    }

    public String GetNazione() { return nazione;}
    public String GetVia() { return via;}
    public String GetCitta() { return citta;}
    public int GetN_civico() { return n_civico;}
    public double GetLatitudine() { return latitudine;}
    public double GetLongitudine() { return longitudine;}

    public boolean equals(Luogo l)
    {
        return this.nazione.equals(l.nazione) && this.via.equals(l.via) && this.citta.equals(l.citta) &&this.latitudine == l.latitudine && this.longitudine == l.longitudine ;
    }

    @Override
    public String toString()
    {
        return "Luogo: "+nazione+" "+via+" "+citta+" "+n_civico+" "+latitudine+" "+longitudine+"\n";
    }
//    public boolean equals(RettangoloCustom altro) {
//        return this.base == altro.base && this.altezza == altro.altezza;
//        //return this.getBase()==altro.getBase() && this.getAltezza()==altro.getAltezza();
//    }
//
//    @Override
//    public boolean equals(Object altro) {
//        if (altro instanceof RettangoloCustom)
//            return this.equals((RettangoloCustom) altro);
//        return false;



}
