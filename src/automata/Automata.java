
package automata;

/**
 *
 * @author Diego
 */
public class Automata {
    private String txtToAnalize;
    
    public Automata(String txtToAnalize) {
        this.txtToAnalize = txtToAnalize;
    }
    
    public void setTxtToAnalize(String txtToAnalize) {
        this.txtToAnalize = txtToAnalize;
    }
    public String getTxtToAnalize(){
        return this.txtToAnalize;
    }
    
    public void analizando(){ 
        if(this.txtToAnalize.length() > 0) {
        System.out.println("Analizando tu chingadera de " + this.getTxtToAnalize());
        }
    }
}
