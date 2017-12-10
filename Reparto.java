
import java.util.ArrayList;
import java.util.List;

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
 * @author alunni
 */
public class Reparto {
    protected String id;
    protected String nome;
    private int numDipendenti ;
    List<Dipendente> dipendente;
    
    public Reparto(String id, String nome) {
        this.id = id;
        this.nome = nome;
        numDipendenti=0;
        dipendente = new ArrayList();
        
    }

    public int addDipendente(Dipendente d) {
        if (dipendente.size() < 20) {
            this.dipendente.add(d);
            return dipendente.size();
        } else {
            return -1;
        }
    }

    public boolean rimuoviDipendente(Dipendente d){
        return this.dipendente.remove(d);
    }

    public int incMax() {
        if (numDipendenti < 20) {
            numDipendenti++;
            return numDipendenti;
        } else {
            return -1;
        }
    }

    public int getMax() {
        return numDipendenti;
    }

    public void setMax(int max) {
        this.numDipendenti = max;
    }
    public void stampaDati(){
        System.out.println("Id del reparto: " + id);
        System.out.println("Nome del reparto: " + nome);
        System.out.println("Dipendenti del reparto:");
        for (int i = 0; i < dipendente.size(); i++) {
            System.out.println("\t"+dipendente.get(i).nome + " " + dipendente.get(i).cognome + " " + dipendente.get(i).getMatricola() + "\n");
            
        }
    }
}

