package jloxinterpreter;

public class Token {
    //final -> value can't be changed
    final TokenType type;
    final String lexeme;
    final Object literal;
    final int line;

    //constructor
    Token(TokenType type, String lexeme, Object literal, int line) {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
    }
    public String toString() {
        return type + " " + lexeme + " " + literal;
    }
}
