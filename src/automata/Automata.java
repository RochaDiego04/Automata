
package automata;

import java.util.Map;


public class Automata {
    private String txtToAnalize;
    private final StateMachine stateMachine;
    private final String initialState = "Q0";
    private final String[] finalStates = {"Q2","Q5"};
    public final Tokens tokens;
    
    public Automata(String txtToAnalize) {
        this.txtToAnalize = txtToAnalize;
        this.stateMachine = new StateMachine();
        this.tokens = new Tokens();
    }
    
    public void setTxtToAnalize(String txtToAnalize) {
        this.txtToAnalize = txtToAnalize;
    }
    public String getTxtToAnalize(){
        return this.txtToAnalize;
    }
    
    public void evaluateText() {

    }
        
    private boolean isFinalState(String state) {

    }

    private void incrementToken(String token) {

    }

    public String transition(String currentState, char input) {

    }
}


