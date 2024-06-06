package automata;

public class StateMachine {
   
    // Constructor
    public StateMachine() {
    }

    // Métodos de condición
    private boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }
    
    private boolean isSpecialCharacter(char ch) {
        return !isLetter(ch) && !isDigit(ch);
    }

    public String getNextState(String currentState, char inputChar) {
        switch (currentState) {
            // ESTADO INICIAL
            case "Q1":
                 // (palabra) Identificador   
                if (isLetter(inputChar)) {
                    return "IDENT";
                }
                 // (+, ++) Operador Aritmético suma e Incremento 
                else if (inputChar == '+') {
                    return "OA1";
                }
                 // (*, %) Operadores Aritméticos
                else if (inputChar == '*' || inputChar == '%') {
                    return "OA2";
                }
                 // (-, --, int, -int, double, -double) Operador Aritmético resta, decremento, entero positivo, entero negativo o decimales
                else if (isDigit(inputChar)) {
                    return "INT";
                }
                else if (inputChar == '-') {
                    return "OA3";
                }
                // (/, //palabra, /*palabra*/) Operador aritmético division,  comentario en linea, comentario grande
                else if (inputChar == '/') {
                    return "OA4";
                }
                // (!, <= >= > < ==, =) Operador lógico negación, operadores relacionales o asignación
                else if (inputChar == '!') {
                    return "OPR_LOG1";
                }
                else if (inputChar == '<' || inputChar == '>') {
                    return "OPR_REL1";
                }
                else if (inputChar == '=') {
                    return "ASIGN";
                }
                // (&&, ||, ( ), { }) Operador lógico de AND OR, parentesis, llave
               else if (inputChar == '&') {
                    return "NA5";
                }
               else  if (inputChar == '|' ) {
                    return "NA6";
                }
               else  if (inputChar == '{' || inputChar == '}') {
                    return "BRACE";
                }
               else if (inputChar == '(' || inputChar == ')') {
                    return "PRNTHSIS";
                }
                // ("palabra") Cadena de texto string
               else if (inputChar == '"') {
                    return "NA7";
                }

            
            // (palabra) Identificadores
            case "IDENT":
                if ( isLetter(inputChar) || isDigit(inputChar) || inputChar == '_' ) {
                    return "IDENT";
                }
                else if (isSpecialCharacter(inputChar)){
                    return "ERROR";
                }
                break;
            
            case "Q2":
                if (isSpecialCharacter(inputChar)) {
                    return "Q2";
                }
                break;
            
            // (+, ++) Operador Aritmético suma e Incremento              
            case "OA1":
                if (inputChar == '+') {
                    return "INCRMNT";
                }
                else if ( isLetter(inputChar) || isDigit(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
            
            case "INCRMNT":
                if (isLetter(inputChar) || isDigit(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
                
             // (*, %) Operadores Aritméticos
            case "OA2":
                if (isLetter(inputChar) || isDigit(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
                
            // (-, --, int, -int, double, -double) Operador Aritmético resta, decremento, entero positivo, entero negativo o decimales
           case "OA3":
                if (isDigit(inputChar)) {
                    return "INT";
                }
                else if( inputChar == '-') {
                    return "DECRMNT";
                }
                else if( isLetter(inputChar) || isSpecialCharacter(inputChar) ) {
                    return "ERROR";
                }
                break;
                
           case "DECRMNT":
                if( inputChar == '-') {
                    return "DECRMT";
                }
                else if( isLetter(inputChar) || isDigit(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
                
            case "INT":
                if (isDigit(inputChar)) {
                    return "INT";
                }
                else if( inputChar == '.') {
                    return "NA1";
                }
               else if( isLetter(inputChar) || isSpecialCharacter(inputChar) ) {
                    return "ERROR";
                }
                break;
              
            case "NA1":
                if (isDigit(inputChar)) {
                    return "DECIMAL";
                }
                else if( isLetter(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
                
            case "DECIMAL":
                if (isDigit(inputChar)) {
                    return "DECIMAL";
                }
                else if( isLetter(inputChar) || isSpecialCharacter(inputChar)) {
                    return "ERROR";
                }
                break;
             
            // (/, //palabra, /*palabra*/) Operador aritmético division,  comentario en linea, comentario grande
            case "OA4":
                if(inputChar == '*') {
                    return "NA2";
                }
                else if(inputChar == '/') {
                    return "NA3";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             case "NA2":
                if (inputChar == '*') {
                    return "NA4";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA2";
                }
                break;
                
           case "NA4":
                if ( inputChar == '*') {
                    return "NA4";
                }
                else if (inputChar == '/') {
                    return "COM_ML";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA2";
                }
                break;
                
             case "COM_ML":
                if (isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
           case "NA3":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "COM_LIN";
                }
                break;
                
            case "COM_LIN":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "COM_LIN";
                }
                break;
            
             // (!, <= >= > < ==, =) Operador lógico negación, operadores relacionales o asignación      
            case "OPR_LOG1":
                if (inputChar == '=') {
                    return "OPR_REL2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
            case "OPR_REL1":
                if (inputChar == '=') {
                    return "OPR_REL2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             case "ASIGN":
                if (inputChar == '=') {
                    return "OPR_REL2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             case "OPR_REL2":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             // (&&, ||, ( ), { }) Operador lógico de AND OR, parentesis, llave
              case "NA5":
                if (inputChar == '&') {
                    return "OPR_LOG2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
              case "NA6":
                if (inputChar == '|') {
                    return "OPR_LOG2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;  
                
             case "OPR_LOG2":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
             
             case "BRACE":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
             
             case "PRNTHSIS":
                if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             // ("palabra") Cadena de texto string
             case "NA7":
                    return "NA8";
                    
             case "NA8":
                 if(inputChar == '"') {
                     return "STRING";
                 }
                 else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA8";
                }
                break;
                
              case "STRING":
                 if(inputChar == '"') {
                     return "STRING";
                 }
                 else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA8";
                }
                break;
                
              case "ERROR":
                    return "ERROR";
        }
        return "ERROR"; 
    
    }
    
public static void main(String[] args) {
    StateMachine stateMachine = new StateMachine();
    String input = "/*comentario*ooo*/ + 123 -- ++ int double 1.5 //hola / <= # | \"hola\"aa\" ( ).";
    String initialState = "Q1";

    System.out.println("Input: " + input);

    String[] tokens = input.split(" ");
    for (String token : tokens) {
        String currentState = initialState;
        System.out.println("\nProcessing token: " + token);
        for (char ch : token.toCharArray()) {
            String nextState = stateMachine.getNextState(currentState, ch);
            System.out.println("Character: '" + ch + "' -> Current State: " + currentState + " -> Next State: " + nextState);
            currentState = nextState;
            if (currentState.equals("ERROR")) {
                break;
            }
        }
        System.out.println("Final State for token '" + token + "': " + currentState);
    }
}

}
