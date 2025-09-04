package jloxinterpreter;

enum TokenType {
    //Single character tokens
    LEFT_PAREN, RIGHT_PAREN, LEFT_BRACE, RIGHT_BRACE, COMMA, DOT, MINUS, PLUS, SEMICOLON, SLASH, STAR,

    //One or two char tokens
    BANG, BANG_EQUAL, EQUAL, EQUAL_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL,

    //Literals
    IDENTIFIER, STRING, NUMBER,

    //Keywords
    AND, OR, IF, ELSE, FOR, WHILE, TRUE, FALSE, CLASS, SUPER, THIS, FUN, RETURN, PRINT, VAR, NIL,

    //end of file
    EOF
}
