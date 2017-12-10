
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
 * @author Alex
 */
public class Dipendente extends Anagrafica {

    private String matricola;
    private double stipendio;
    protected Reparto reparto;
    private int lvl;
    
    public Dipendente(String nome, String cognome, String matricola, double stipendio,int lvl) {
        super(nome, cognome);
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.lvl = lvl;
    }

    public double levelUp() {
        if (lvl < 7) {
            lvl += 1;
            stipendio += (stipendio * 10 / 100);
            return stipendio;
        } else {
            return -1;
        }
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    public String getMatricola() {
        return matricola;
    }
    
    
    
    
    @Override
    public void stampaDati() {
        super.stampaDati(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Stipendio: " + stipendio + "€");
        System.out.println("Matricola: " + matricola + ";");
        System.out.println("Appartiene al reparto " + reparto.nome + " id del reparto: " + reparto.id + ";");
        System.out.println("Livello: " + lvl + ";");
    }
    public boolean scambiaReparto(List<Reparto> reparto, String nomeOrId){
        boolean trovato=false;
        for (int i = 0; i < reparto.size(); i++) {
            if (nomeOrId.equals(reparto.get(i).nome) || nomeOrId.equals(reparto.get(i).id) ) {
                this.reparto=reparto.get(i);
                trovato=true;
                break;
            }
        }
        return trovato;
    }
}
