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
                if (inputChar == '+') {
                    return "OA1";
                }
                 // (*, %) Operadores Aritméticos
                if (inputChar == '*' || inputChar == '%') {
                    return "OA2";
                }
                 // (-, --, int, -int, double, -double) Operador Aritmético resta, decremento, entero positivo, entero negativo o decimales
                 if (isDigit(inputChar)) {
                    return "INT";
                }
                 if (inputChar == '-') {
                    return "OA3";
                }
                // (/, //palabra, /*palabra*/) Operador aritmético division,  comentario en linea, comentario grande
                 if (inputChar == '/') {
                    return "OA4";
                }
                // (!, <= >= > < ==, =) Operador lógico negación, operadores relacionales o asignación
                 if (inputChar == '!') {
                    return "OPR_LOG1";
                }
                 if (inputChar == '<' || inputChar == '>') {
                    return "OPR_REL1";
                }
                 if (inputChar == '=') {
                    return "ASIGN";
                }
                // (&&, ||, ( ), { }) Operador lógico de AND OR, parentesis, llave
                if (inputChar == '&') {
                    return "NA5";
                }
                 if (inputChar == '|' ) {
                    return "NA6";
                }
                 if (inputChar == '{' || inputChar == '}') {
                    return "BRACE";
                }
                if (inputChar == '(' || inputChar == ')') {
                    return "PRNTHSIS";
                }
                // ("palabra") Cadena de texto string
                if (inputChar == '"') {
                    return "NA7";
                }
                break;
            
            // (palabra) Identificadores
            case "IDENT":
                if (isLetter(inputChar) || isDigit(inputChar) || (isSpecialCharacter(inputChar) && inputChar == '_') ) {
                    return "IDENT";
                }
                else if (isSpecialCharacter(inputChar) && inputChar != '_'){
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
                    return "INC";
                }
                else if ( isLetter(inputChar) || isDigit(inputChar) || (isSpecialCharacter(inputChar) && inputChar != '+')) {
                    return "ERROR";
                }
                break;
            
            case "INC":
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
                else if( isLetter(inputChar) || (isSpecialCharacter(inputChar) && inputChar != '-')) {
                    return "ERROR";
                }
                break;
                
           case "DECRMNT":
                if (isDigit(inputChar)) {
                    return "INT";
                }
                else if( inputChar == '-') {
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
               else if( isLetter(inputChar) || (isSpecialCharacter(inputChar) && inputChar != '.')) {
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
                if (isDigit(inputChar)) {
                    return "DECIMAL";
                }
                else if(isSpecialCharacter(inputChar) && inputChar == '*') {
                    return "NA2";
                }
                else if(isSpecialCharacter(inputChar) && inputChar == '/') {
                    return "NA3";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             case "NA2":
                if (isSpecialCharacter(inputChar) && inputChar == '*') {
                    return "NA4";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA2";
                }
                break;
                
           case "N4":
                if (isSpecialCharacter(inputChar) && inputChar == '*') {
                    return "NA4";
                }
                else if (isSpecialCharacter(inputChar) && inputChar == '/') {
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
                if (isSpecialCharacter(inputChar) && inputChar == '=') {
                    return "OPR_REL2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
            case "OPR_REL1":
                if (isSpecialCharacter(inputChar) && inputChar == '=') {
                    return "OPR_REL2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
             case "ASIGN":
                if (isSpecialCharacter(inputChar) && inputChar == '=') {
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
                if (isSpecialCharacter(inputChar) && inputChar == '&') {
                    return "OPR_LOG2";
                }
                else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
              case "NA6":
                if (isSpecialCharacter(inputChar) && inputChar == '|') {
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
                 if(isSpecialCharacter(inputChar) && inputChar == '"') {
                     return "STRING";
                 }
                 else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "ERROR";
                }
                break;
                
              case "STRING":
                 if(isSpecialCharacter(inputChar) && inputChar == '"') {
                     return "STRING";
                 }
                 else if(isLetter(inputChar) || isSpecialCharacter(inputChar) || isDigit(inputChar)) {
                    return "NA8";
                }
                break;
                
             // Other cases
            default:
                break;
          
        }
        return "ERROR"; 
    
    }
    
    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine();
        //System.out.println(stateMachine.isSpecialCharacter('%'));
    }
}
