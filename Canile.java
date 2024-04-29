import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Animale {

    private String nomeAnimale;
    private int eta;
    private String specie;
    private String proprietario;

    public Animale(String nomeAnimale, int eta, String specie, String proprietario) {
        this.nomeAnimale = nomeAnimale;
        this.eta = eta;
        this.specie = specie;
        this.proprietario =proprietario;
    }

    public String getNomeAnimale() {
        return nomeAnimale;
    }

    public void setNomeAnimale(String nomeAnimale) {
        this.nomeAnimale = nomeAnimale;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }
    public String getPropritario() {
        return proprietario;
    }

    public void setPropritario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getDescrizione() {
        return "Nome: " + nomeAnimale + ", Età: " + eta + ", Specie: " + specie+", Proprietario: "+proprietario;
    }
}

class Cane extends Animale {

    private String razza;
    private String microchipId;

    public Cane(String nomeAnimale, int eta, String specie, String proprietario, String razza, String microchipId) {
        super(nomeAnimale, eta, specie,proprietario);
        this.razza = razza;
        this.microchipId = microchipId;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza; 
    }

    public String getMicrochipId() {
        return microchipId;
    }

    public void setMicrochipId(String microchipId) {
        this.microchipId = microchipId;
    }

    public String getDescrizione_completa() {
        return super.getDescrizione()+", Razza: " + razza + ", Microchip ID:" + microchipId;
    }


}

class Personale {
    String nome;
    String ruolo;

    public Personale(String nome, String ruolo) {
        this.nome = nome;
        this.ruolo = ruolo;
    }

    public String info_personale() {
        return "Nome: " + nome + ", Ruolo: " + ruolo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getNome() {
        return nome;
    }

    public String getRuolo() {
        return ruolo;
    }

}

public class Canile {

    public static void main(String[] args) {

        Map<Personale, Cane> cani = new HashMap<>();

        Scanner myStr = new Scanner(System.in);
        Scanner myInt = new Scanner(System.in);

        // Creare istanze di Cane
        Cane samantha = new Cane("Samantha", 13, "Cane","Mirko Campari", "Pitbull", "54795289");
        Cane oreo = new Cane("Oreo", 2, "Cane","Cristian Dumitrescu", "Meticcio", "15184648");
        Cane bobby = new Cane("Bobby", 8, "Cane","Sante Agostinelli", "Golden Retriver", "16198254");
        //Probabilmente verrà ammazzato da Alessia Ronchetti


        // Creare istanze di Personale
        Personale francesco = new Personale("Francesco", "Dottore");
        Personale gilberto = new Personale("Gilberto", "Gestore Cani");
        Personale alessia = new Personale("Alessia", "Gestore Cani");


        cani.put(gilberto, oreo);
        cani.put(alessia, samantha);
        cani.put(francesco, bobby);


        // Assegnare ogni cane a un membro del personale come responsabile
        System.out.println("Inserisci il tuo nome: ");
        String utente=myStr.nextLine();

        System.out.println("Informazioni sugli animali:");
        for (Cane cane : cani.values()) {
            System.out.println(cane.getDescrizione_completa());
        }

        System.out.println("Vuoi adottare un cane?");
        System.out.println("[1] SI");
        System.out.println("[2] NO");
        int selezione=myInt.nextInt();

        if(selezione==1){
            System.out.println("Informazioni sugli animali:");
            for (Cane cane : cani.values()) {
                System.out.println(cane.getDescrizione_completa());
            }
            System.out.println("Quale cane vuoi adottare?");
            String sceltaCane=myStr.nextLine();
            




        }else{
            System.out.println("Arrivederci");
        }


        // Stampare informazioni sugli animali e sul personale

    }
}