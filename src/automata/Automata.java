package automata;

/* 
Ahora mismo cualquier caracter que no mande a un estado,
comenzando con el inicial, se marca como error.
De igual manera un estado de no asignación
*/

import java.util.Map;

public class Automata {
    private String txtToAnalyze;
    private final StateMachine stateMachine;
    private final String initialState = "Q1";
    private final Tokens tokens;
    
   String[] keywords = {
            "if",
            "main",
            "else",
            "switch",
            "case",
            "default",
            "for",
            "do",
            "while",
            "break",
            "int",
            "String",
            "double",
            "char",
            "print"
        };


    public Automata(String txtToAnalyze) {
        this.txtToAnalyze = txtToAnalyze;
        this.stateMachine = new StateMachine();
        this.tokens = new Tokens();
    }

    public void setTxtToAnalyze(String txtToAnalyze) {
        this.txtToAnalyze = txtToAnalyze;
    }

    public String getTxtToAnalyze() {
        return this.txtToAnalyze;
    }

    public void evaluateText() {
        String currentState = initialState;
        StringBuilder token = new StringBuilder();

        for (char ch : txtToAnalyze.toCharArray()) {
            if (ch == ' ' || ch == '\n' || ch == '\t') {
                processToken(token.toString(), currentState);
                token.setLength(0); // Reset the token
                currentState = initialState; // Reset the state
            } else {
                currentState = stateMachine.getNextState(currentState, ch);
                token.append(ch);
            }
        }
        // Process the last token if it exists
        if (token.length() > 0) {
            processToken(token.toString(), currentState);
        }
    }

    private void processToken(String token, String finalState) {
        if (token.trim().isEmpty()) {
            return;
        }
        
        if (isFinalState(finalState)) {
            switch (finalState) {
                case "IDENT":
                    if (isKeyword(token)) {
                        incrementToken("keywords");
                    } else {
                        incrementToken("identifiers");
                    }
                    break;
                case "INCRMNT":
                    incrementToken("Increment");
                    break;
                case "DECRMNT":
                    incrementToken("Decrement");
                    break;
                case "INT":
                    incrementToken("Integers");
                    break;
                case "DECIMAL":
                    incrementToken("Decimal Numbers");
                    break;
                case "COM_ML":
                    incrementToken("Comment");
                    break;
                case "COM_LIN":
                    incrementToken("Line Comment");
                    break;
                case "ASIGN":
                    incrementToken("Assignments");
                    break;
                case "OA1":
                case "OA2":
                case "OA3":
                case "OA4":
                    incrementToken("Arithmetic Operators");
                    break;
                case "OPR_REL1":
                case "OPR_REL2":
                    incrementToken("Relational Operators");
                    break;
                case "OPR_LOG1":
                case "OPR_LOG2":
                    incrementToken("Logical Operators");
                    break;
                case "BRACE":
                    incrementToken("Braces");
                    break;
                case "PRNTHSIS":
                    incrementToken("Parentheses");
                    break;
                case "STRING":
                    incrementToken("String");
                    break;
            }
        } else {
        incrementToken("Errors");
        }
    }
    
    private boolean isKeyword(String token) {
        for (String keyword : keywords) {
            if (keyword.equals(token)) {
                return true;
            }
        }
        return false;
    }

    private boolean isFinalState(String state) {
        return switch (state) {
            case "IDENT", "INCRMNT", "DECRMNT", "INT", "DECIMAL", "COM_ML", "COM_LIN", "ASIGN", "OA1", "OA2", "OA3", "OA4", "OPR_REL1", "OPR_REL2", "OPR_LOG1", "OPR_LOG2", "BRACE", "PRNTHSIS", "STRING" -> true;
            default -> false;
        };
    }

    private void incrementToken(String token) {
        tokens.tokens.put(token, tokens.tokens.get(token) + 1);
    }
    
    public void resetTokens() {
    for (Map.Entry<String, Integer> entry : this.tokens.tokens.entrySet()) {
        entry.setValue(0);
    }
}
    
public String getTokenCount() {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<String, Integer> entry : this.tokens.tokens.entrySet()) {
        result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    }
    return result.toString();
}

}
