import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

abstract class Animale1 {

    private String nomeAnimale;
    private int eta;
    private String specie;
    private String proprietario;

    public Animale1(String nomeAnimale, int eta, String specie, String proprietario) {
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

class Cane1 extends Animale1 {

    private String razza;
    private String microchipId;

    public Cane1(String nomeAnimale, int eta, String specie, String proprietario, String razza, String microchipId) {
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

public class Canile1 {
    public void aggiungiCane() {
        Scanner myStr = new Scanner(System.in);
        Scanner myInt = new Scanner(System.in);

        System.out.println("Inserisci le informazioni del nuovo cane:");
        System.out.print("Nome: ");
        String nomeCane = myStr.nextLine();
        System.out.print("Età: ");
        int etaCane = myInt.nextInt();
        System.out.print("Specie: ");
        String specieCane = myStr.nextLine();
        System.out.print("Razza: ");
        String razzaCane = myStr.nextLine();
        System.out.print("Microchip ID: ");
        String microchipIdCane = myStr.nextLine();
        System.out.print("Proprietario iniziale: ");
        String proprietarioCane = myStr.nextLine();

        Cane1 nuovoCane = new Cane1(nomeCane, etaCane, specieCane, razzaCane, microchipIdCane, proprietarioCane);
         // Aggiungi il cane al dizionario

        System.out.println("Cane aggiunto correttamente!");
    }
    public static void main(String[] args) {
        Scanner myStr = new Scanner(System.in);
        Scanner myInt = new Scanner(System.in);
        Map<Personale, Cane1> cani = new HashMap<>();

        // Creare istanze di Cane
        Cane1 samantha = new Cane1("Samantha", 13, "Cane","    ", "Pitbull", "54795289");
        Cane1 oreo = new Cane1("Oreo", 2, "Cane","    ", "Meticcio", "15184648");
        Cane1 bobby = new Cane1("Bobby", 8, "Cane","    ", "Golden Retriver", "16198254");
        //Probabilmente verrà ammazzato da Alessia Ronchetti


        // Creare istanze di Personale
        Personale francesco = new Personale("Francesco", "Dottore");
        Personale gilberto = new Personale("Gilberto", "Gestore Cani");
        Personale alessia = new Personale("Alessia", "Gestore Cani");


        cani.put(gilberto, oreo);
        cani.put(alessia, samantha);
        cani.put(francesco, bobby);

        boolean i=true;
        while (i==true) {
            System.out.println("Inserisci nome futuro proprietario: ");
            String utente=myStr.nextLine();
    
            
            System.out.println("Cosa vuoi fare?");
            System.out.println("[1] Addozione cane");
            System.out.println("[2] Modifica Personale Respondabile");
            System.out.println("[3] Aggiungi cane");
            System.out.println("[4] Visualizza Cani");
            int selezione=myInt.nextInt();
            
            

    
            if(selezione==1){
                System.out.println("Cani disponibili per l'adozione:");
                for (Cane1 cane : cani.values()) {
                    if (cane.getPropritario().equals("    ")) {
                        System.out.println(cane.getDescrizione_completa());
                    }
                }
                if(cani.size()==0){
                    i=false;
                    break;
                }
                System.out.println("Quale cane vuoi adottare?");
                String sceltaCane=myStr.nextLine();
                Cane1 caneSelezionato = null;
                
                for (Cane1 cane : cani.values()) {
                    if (cane.getNomeAnimale().equalsIgnoreCase(sceltaCane)) {
                        caneSelezionato = cane;
                        break;
                    }
                }
    
                if (caneSelezionato != null) {
                    caneSelezionato.setPropritario(utente);
                    System.out.println("Hai scelto di adottare il cane:");
    
                    System.out.println(caneSelezionato.getDescrizione_completa());
                    
                } else {
                    System.out.println("Il cane specificato non è disponibile per l'adozione.");
                }
                System.out.println("");
                for (Cane1 cane : cani.values()) {
                    System.out.println(cane.getDescrizione_completa());
                }
    



                System.out.println("Vuoi Uscire o Continuare");
                System.out.println("[1] Esci");
                System.out.println("[2] Continua");
                int sistema=myInt.nextInt();
                if(sistema==1){
                    System.out.println("Arrivederci");
                    i=false;
                }else{
                    continue;
                }
            }else if(selezione==2){
                System.out.println("Informazioni sugli animali:");
                for (Cane1 cane : cani.values()) {
                    System.out.println(cane.getDescrizione_completa());
                }
                System.out.println("Quale cane vuoi modifica il responsabile?");
                String sceltaCane=myStr.nextLine();
                Cane1 caneSelezionato1 = null;
                
                for (Cane1 cane : cani.values()) {
                    if (cane.getNomeAnimale().equalsIgnoreCase(sceltaCane)) {
                        caneSelezionato1 = cane;
                        break;
                    }
                }
                //WIP
            }else if(selezione==3){
                /*Cane1 canin = new Cane1(utente, selezione, utente, utente, utente, utente);
                canin.aggiungiCane();*/
                //cani.aggiungiCane();
                System.out.println("Inserisci le informazioni del nuovo cane:");
                System.out.print("Nome: ");
                String nomeCane = myStr.nextLine();
                System.out.print("Età: ");
                int etaCane = myInt.nextInt();
                System.out.print("Specie: ");
                String specieCane = myStr.nextLine();
                System.out.print("Razza: ");
                String razzaCane = myStr.nextLine();
                System.out.print("Microchip ID: ");
                String microchipIdCane = myStr.nextLine();
                String proprietarioCane = "    ";
        
                Cane1 nuovoCane = new Cane1(nomeCane, etaCane, specieCane, razzaCane, microchipIdCane, proprietarioCane);
                System.out.println("Chi è il responsabile?");
                System.out.println("[1] Francesco");
                System.out.println("[2] Gilberto");
                System.out.println("[3] Alessia");
                int selettoreResp=myInt.nextInt();
                if(selettoreResp==1){
                    cani.put(francesco, nuovoCane);
                }else if(selettoreResp==2){
                    cani.put(gilberto, nuovoCane);

                }else if(selettoreResp==3){
                    cani.put(alessia, nuovoCane);

                }else{
                cani.put(null, nuovoCane);
                }
                
        
                System.out.println("Cane aggiunto correttamente!");
                //WIP
            }else if(selezione==4){
                System.out.println("Quali cani vuoi vedere?");
                System.out.println("[1] TUTTI");
                System.out.println("[2] ADOTTATI");
                System.out.println("[3] NON ADOTTATI");
                int visualizzatore=myInt.nextInt();

                if(visualizzatore==1){              
                System.out.println("Informazioni sugli animali:");
                    for (Cane1 cane : cani.values()) {
                        System.out.println(cane.getDescrizione_completa());
                    }
                }else if(visualizzatore==2){
                    for (Cane1 cane : cani.values()) {
                        if (!cane.getPropritario().equals("    ")) {
                            System.out.println(cane.getDescrizione_completa());
                        }
                    }
                    
                }else if(visualizzatore==3){
                    for (Cane1 cane : cani.values()) {
                        if (cane.getPropritario().equals("    ")) {
                            System.out.println(cane.getDescrizione_completa());
                        }
                    }
                    
                }else{
                    continue;

                }

            }else{
                System.out.println("Arrivederci");
                i=false;
            }  
        }
    }
}