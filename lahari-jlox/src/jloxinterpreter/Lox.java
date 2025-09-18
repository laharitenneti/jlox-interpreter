package jloxinterpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    //to ensure that we're executing code w/o error
    static boolean hadError = false;
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));

        //In exit code, we're indicating an error
        if (hadError) System.exit(65);
    }
    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("> ");
            String line = reader.readLine();
            //readLine reads i/p line from the user on the command line
            if (line == null) break;
            run(line);
            hadError = false;
        }
    }


    //prints tokens the scanner will emit
    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        /*
        for (Token token: tokens) {
            System.out.println(token);
        }
         */
        Parser parser = new Parser(tokens);
        Expr expression = parser.parse();

        if (hadError) return;

        System.out.println(new AstPrinter().print(expression));

    }

    //error handling
    static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where, String message) {
        System.err.println("[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }

    static void error(Token token, String message) {
        if (token.type == TokenType.EOF) {
            report(token.line, " at end", message);
        } else {
            report(token.line, " at '" + token.lexeme +"'", message);
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            //Exit code from UNIX's "sysexits.h" header
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        } else {
            runPrompt();
        }
    }
}
