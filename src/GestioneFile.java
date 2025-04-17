import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GestioneFile {

    private String percorsoFile;

    public GestioneFile() {
        String nomeFile = "michelin_my_maps.csv";
        this.percorsoFile = System.getProperty("user.dir") + File.separator + nomeFile;
    }

    public void leggiFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(percorsoFile))) {
            String riga;

            while ((riga = br.readLine()) != null) {
                String[] valori = riga.split(",");
                for (String valore : valori) {
                    System.out.print(valore.trim() + " | ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.err.println("Errore nella lettura del file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestioneFile gf = new GestioneFile();
        gf.leggiFile();
    }
}
