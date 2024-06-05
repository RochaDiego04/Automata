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
Identificadores: Identifiers
Operadores Relacionales: Relational Operators
Operadores Lógicos: Logical Operators
Operadores Aritméticos: Arithmetic Operators
Asignaciones: Assignments
Número Enteros: Integers
Números Decimales: Decimal Numbers
Incremento: Increment (aunque especificaste 0, la palabra en inglés es "Increment")
Decremento: Decrement
Cadena de caracteres: String
Comentario: Comment
Comentario de Linea: Line Comment (aunque especificaste 0, la traducción es "Line Comment")
Paréntesis: Parentheses
Llaves: Braces o Curly Braces
Errores: Errors 
*/