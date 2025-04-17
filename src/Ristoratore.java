import java.util.Date;
import java.util.LinkedList;

public class Ristoratore extends UtenteRegistrato{

    private LinkedList<Ristorante> ristoranti;

    public Ristoratore(String username, String nome, String cognome, Date dataNascita, String psw, Luogo luogo, LinkedList<Recensione> recensioni)
    {
        super(username, nome,cognome,dataNascita,psw, luogo);
        ristoratore=true;
        ristoranti = new LinkedList<>();

    }

    public LinkedList<Ristorante> getRistoranti() { return ristoranti;}

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public String toString()
    {
        String s="";
        for(Ristorante r : ristoranti)
            s+= r.toString();
        return  super.toString()+ s;
    }


    public void aggiungiRistorante(Ristorante ristorante)
    {
        ristoranti.add(ristorante);
    }

    public LinkedList<Recensione> visualizzaRecensioni()
    {
        LinkedList<Recensione> recensioni =new LinkedList<>();
        for(Ristorante r :ristoranti)
        {
            recensioni.addAll(r.getRecensioni());
        }
        return recensioni;
    }

    public void rispostaRecensione()
    {

    }

    public int numeroRecensioni()
    {
        int cont=0;
        for(Ristorante r : ristoranti)
        {
            cont+=r.getNumeroRecensioni();
        }
        return cont;
    }

    public double calcolaMedia()
    {
        int contStelle=0;
        for(Ristorante rist: ristoranti)
        {
            for(Recensione rec: rist.recensioni)
            {
                contStelle+=rec.getNumeroStelle();
            }
        }
        return contStelle/numeroRecensioni();
    }

    public String visualizzaRiepilogo(Ristorante ristorante)
    {
        String s = "";
        s+="Le stelle medie sono "+calcolaMedia()+" ("+numeroRecensioni()+"\n";
        for(Ristorante r: ristoranti)
        {
            s+=r.toString();
            for (Recensione rec: r.recensioni)
                s+="\t"+rec.toString();
        }

        return s;
    }

    public LinkedList<Ristorante> visualizzaPropriRistoranti()
    {
       return getRistoranti();
    }





}
