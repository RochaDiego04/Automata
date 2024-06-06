package automata;

import java.util.HashMap;
import java.util.Map;

public class Tokens {
    
    public final Map<String, Integer> tokens;
    
      public Tokens() {
        this.tokens = new HashMap<String, Integer>() {{
            put("keywords", 0);
            put("identifiers", 0);
            put("Relational Operators", 0);
            put("Logical Operators", 0);
            put("Arithmetic Operators", 0);
            put("Assignments", 0);
            put("Integers", 0);
            put("Decimal Numbers", 0);
            put("Increment", 0);
            put("Decrement", 0);
            put("String", 0);
            put("Comment", 0);
            put("Line Comment", 0);
            put("Parentheses", 0);
            put("Braces", 0);
            put("Errors", 0);
        }};
      }
}

/* 
Palabras reservadas: Keywords 
Identificadores: Identifiers "IDENT",
Operadores Relacionales: Relational Operators  "OPR_REL1", "OPR_REL2"
Operadores Lógicos: Logical Operators  "OPR_LOG1", "OPR_LOG2"
Operadores Aritméticos: Arithmetic Operators "OA1", "OA2", "OA3" "OA4"
Asignaciones: Assignments "ASIGN"
Número Enteros: Integers "INT"
Números Decimales: Decimal Numbers  "DECIMAL"
Incremento: Increment  "INCRMNT"
Decremento: Decrement  "DECRMNT"
Cadena de caracteres: String  "STRING"
Comentario: Comment   "COM_ML"
Comentario de Linea: Line Comment  "COM_LIN"
Paréntesis: Parentheses  "PRNTHSIS"
Llaves: Braces o Curly Braces  "BRACE"
Errores: Errors   "ERROR"
*/