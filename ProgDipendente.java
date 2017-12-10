
import java.util.List;
import java.util.ArrayList;

/*
 * The MIT License
 *
 * Copyright 2017 Alex/xKrasto.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions: 
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 *
 * @author Alex, xKrasto
 */
public class ProgDipendente {

    public static Reparto insReparto(String id, String nom) {
//        String id = Input.reqString("Inserisci il codice del reparto(id)");
//        String nom = Input.reqString("Inserisci il nome del reparto: ");
        Reparto reparto = new Reparto(id, nom);
        return reparto;
    }

    public static Dipendente insDipendente(String nome, String cognome, String matricola, double stipendio, int lvl) {
//        String nome = Input.reqString("Inserisci il nome: ");
//        String cognome = Input.reqString("Inserisci il cognome: ");
//        String matricola = Input.reqString("Inserisci la matricola: ");
//        double stipendio = Input.reqDouble("Inserisci lo stipendio: ");
//        int lvl = Input.reqInt("Inserisci il livello: ");
        Dipendente dipendente = new Dipendente(nome, cognome, matricola, stipendio, lvl);
        return dipendente;
    }

    public static String insEMail() {
        return Input.reqString("Inserisci l'email: ");
    }

    public static Reparto trovaRepartoR(List<Reparto> reparto) {
        Reparto r = null;
        String nome;
        boolean scelta = false;
        do {
            scelta = false;
            nome = Input.reqString("Inserisci il nome o id del reparto: ");
            for (int i = 0; i < reparto.size(); i++) {
                if (nome.equals(reparto.get(i).nome) || nome.equals(reparto.get(i).id)) {
                    r = reparto.get(i);
                    break;
                }
            }
            if (r == null) {
                scelta = Input.reqBoolean("Non è stato trovato nessun dipendente con quel nominativo, vuoi provare di nuovo?");
            }
        } while (scelta);

        return r;
    }

    public static int trovaRepartoI(List<Reparto> reparto) {
        int ind = -1;
        String nome;
        boolean scelta = false;
        do {
            scelta = false;
            nome = Input.reqString("Inserisci il nome o id del reparto: ");
            for (int i = 0; i < reparto.size(); i++) {
                if (nome.equals(reparto.get(i).nome) || nome.equals(reparto.get(i).id)) {
                    ind = i;
                    break;
                }
            }
            if (ind == -1) {
                scelta = Input.reqBoolean("Non è stato trovato nessun dipendente con quel nominativo, vuoi provare di nuovo?");
            }
        } while (scelta);

        return ind;
    }

    public static int trovaDipendenteI(List<Dipendente> dipendente) {
        int ind = -1;
        String nome;
        boolean scelta = false;
        do {
            scelta = false;
            nome = Input.reqString("Inserisci il nome, cognome o matricola del dipendente: ");
            for (int i = 0; i < dipendente.size(); i++) {
                if (nome.equals(dipendente.get(i).nome) || nome.equals(dipendente.get(i).cognome) || nome.equals(dipendente.get(i).getMatricola())) {
                    ind = i;
                    break;
                }

            }
            if (ind == -1) {
                scelta = Input.reqBoolean("Non è stato trovato nessun dipendente con quel nominativo, vuoi provare di nuovo?");
            }
        } while (scelta);

        return ind;
    }

    public static Dipendente trovaDipendenteD(List<Dipendente> dipendente) {
        Dipendente d = null;
        String nome;
        boolean scelta = false;
        do {
            scelta = false;
            nome = Input.reqString("Inserisci il nome, cognome o matricola del dipendente: ");
            for (int i = 0; i < dipendente.size(); i++) {
                if (nome.equals(dipendente.get(i).nome) || nome.equals(dipendente.get(i).cognome) || nome.equals(dipendente.get(i).getMatricola())) {
                    d = dipendente.get(i);
                    break;
                }

            }
            if (d == null) {
                scelta = Input.reqBoolean("Non è stato trovato nessun dipendente con quel nominativo, vuoi provare di nuovo?");
            }
        } while (scelta);

        return d;
    }

    public static void swapReparto(List<Dipendente> dipendente, List<Reparto> reparto) {
        Dipendente sfortunato = trovaDipendenteD(dipendente);
        if (sfortunato == null) {
            System.out.println("Swap annullato!");
            return;
        }
        System.out.println("Inserisci il reparto dove vuoi spostarlo");
        int repartoDestinazione = trovaRepartoI(reparto);
        if (repartoDestinazione == -1) {
            System.out.println("Swap annullato!");
            return;
        }
        for (int i = 0; i < reparto.size(); i++) {                          //Per scorrere tra tutti i reparti
            for (int j = 0; j < reparto.get(i).dipendente.size(); j++) {    //Per scorrere tra tutti i dipendenti dell'*i* reparto
                if (sfortunato == reparto.get(i).dipendente.get(j)) {
                    reparto.get(i).rimuoviDipendente(sfortunato);
                    reparto.get(repartoDestinazione).addDipendente(sfortunato);
                    return;
                }
            }
        }
        System.out.println("Il dipendente da te inserito non è stato trovato in nessun reparto, swap annullato!");
    }

    public static boolean checkReparto(List<Reparto> reparto, String param) {
        for (int i = 0; i < reparto.size(); i++) {
            if (param.equals(reparto.get(i).id) || param.equals(reparto.get(i).nome)) {
                System.out.println("Il parametro da te inserito è già stato usato");
                return true;
            }
        }
        return false;
    }

    public static boolean checkMatricola(List<Dipendente> dipendente, String param) {
        for (int i = 0; i < dipendente.size(); i++) {
            if (param.equals(dipendente.get(i).getMatricola())) {
                System.out.println("La matricola da te inserita è già di un altro dipendente");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        //final int NUMR = 3, NUMD = 5;
        List<Reparto> reparto = new ArrayList<>();
        List<Dipendente> dipendente = new ArrayList<>();
        int scelta = 0;
        do {
            do {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                scelta = Input.reqInt("Inserisci:\n"
                        + "1 per aggiungere un reparto                              |\n"
                        + "2 per aggiungere un dipendente;                          |\n"
                        + "3 per assegnare ad un dipendente un reparto              |\n"
                        + "4 per assegnare ad un reparto un dipendente              |\n"
                        + "5 per licenziare un dipendente da un reparto             |\n"
                        + "6 per spostare un dipendente da un reparto ad un altro   |\n"
                        + "7 per mostrare un riepilogo di tutti i dipendenti        |\n"
                        + "8 per mostrare un riepilogo di tutti i reparti           |\n"
                        + "9 per uscire                                             |\n");

            } while (scelta < 0 || scelta > 10);
            switch (scelta) {
                case 1: {
                    System.out.println("Ok, hai scelto di aggiungere un reparto!");
                    String id, nom;
                    do {
                        id = Input.reqString("Inserisci il codice del reparto(id): ");
                    } while (checkReparto(reparto, id));
                    do {    //Controllo che il nome non sia già stato per un altro reparto
                        nom = Input.reqString("Inserisci il nome del reparto: ");
                    } while (checkReparto(reparto, nom));
                    reparto.add(insReparto(id, nom));
                    break;
                }
                case 2: {
                    System.out.println("Ok, hai scelto di aggiungere un dipendente!");
                    String nome = Input.reqString("Inserisci il nome: ");
                    String cognome = Input.reqString("Inserisci il cognome: ");
                    String matricola;
                    do {
                        matricola = Input.reqString("Inserisci la matricola: ");
                    } while (checkMatricola(dipendente, matricola));
                    double stipendio = Input.reqDouble("Inserisci lo stipendio: ");
                    int lvl = Input.reqInt("Inserisci il livello: ");
                    dipendente.add(insDipendente(nome, cognome, matricola, stipendio, lvl));
                    break;
                }
                case 3: {
                    System.out.println("Ok, hai scelto di assegnare ad un dipendente un reparto");         //Aggiungo le graffe così  lo scope si riduce al case 3
                    //dipendente.get(trovaDipendenteI(dipendente)).setReparto(trovaRepartoR(reparto));        
                    int dipCercato = trovaDipendenteI(dipendente);
                    if (dipCercato == -1) {
                        System.out.println("Assegnazione annullata!");
                        break;
                    }
                    Reparto repTrovato = trovaRepartoR(reparto);
                    if (repTrovato == null) {
                        System.out.println("Assegnazione annullata!");
                        break;
                    }
                    dipendente.get(dipCercato).setReparto(repTrovato);
                    break;
                }

                case 4: {
                    System.out.println("Ok, hai scelto di assegnare ad un reparto un dipendente");
                    Dipendente fortunato = trovaDipendenteD(dipendente);
                    if (fortunato == null) {
                        System.out.println("Assegnazione annullata!");
                        break;
                    }
                    int repTrovato = trovaRepartoI(reparto);
                    if (repTrovato == -1) {
                        System.out.println("Assegnazione annullata!");
                        break;
                    }
                    int codice = reparto.get(repTrovato).addDipendente(fortunato);
                    System.out.print("DA RIMUOVERE CODICE (-1 se non esiste, altrimenti dovrebbe essere il numero dei dipendenti assumibili: " + codice + "\n");
                    break;
                }

                case 5: {
                    System.out.println("Ok. hai scelto di licenziare un dipendente da un reparto!");
                    Dipendente d = trovaDipendenteD(dipendente);
                    if (d == null) {
                        System.out.println("Licenziamento annullato!");
                        break;
                    }
                    int repTrovato = trovaRepartoI(reparto);
                    if (repTrovato == -1) {
                        System.out.println("Licenziamento annullato!");
                        break;
                    }
                    reparto.get(repTrovato).rimuoviDipendente(d);
                    break;
                }

                case 6: {
                    swapReparto(dipendente, reparto);
                }

                case 7: {
                    if(dipendente.isEmpty()) System.out.println("Nessun dipendente ancora inserito!");
                    else{
                    for (int i = 0; i < dipendente.size(); i++) {
                        System.out.println("---------------");
                        dipendente.get(i).stampaDati();
                    }
                    }
                    break;
                }

                case 8: {
                    if(reparto.isEmpty()) System.out.println("Nessun reparto ancora inserito!");
                    else{   
                    for (int i = 0; i < reparto.size(); i++) {
                        System.out.println("---------------");
                        reparto.get(i).stampaDati();
                    }
                    }
                }

                default:
                    break;
            }
        } while (scelta != 9);
        System.exit(0);
    }

}
