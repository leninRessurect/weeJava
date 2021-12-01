import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3 {
    public static void main(String[] args) {
        System.out.println("## Q3Example1:");
        scan("src/Q3Example1.txt");
        System.out.println("\n## Q3Example2:");
        scan("src/Q3Example2.txt");
    }

    public static void scan(String fname) {
        String text = readFile2String(fname);
        int n = text.length();
        int index = 0;
        while (index < n) {
            // assign charachters
            char ch = text.charAt(index); // current character
            char ch_next = ' '; // assign next character unless at last index in which case space is appended
            if (index < n-1) {
                ch_next = text.charAt(index+1);
            }
            //handle single line comments
            if (ch=='/' && ch_next=='/') {
                // skip characters untill new line
                while (!isLineBreak(ch)) {
                    index++;
                    ch = text.charAt(index);
                }
            }
            // handle mutliline comments
            if (ch=='/' && ch_next=='*') {
                // skip characters unitll endcomment
                while (!isEndComment(ch, ch_next)) {
                    index++;
                    ch = text.charAt(index);
                    ch_next = text.charAt(index+1);
                }
                // skips endcomment
                if (isEndComment(ch, ch_next)) {
                    index = index + 2;
                    ch = text.charAt(index);
                }
            }
            // print char and loop
            System.out.print(ch);
            index++;
        }
    }
    
    // read a file into a string
    public static String readFile2String (String fname) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(fname)));
        } catch (IOException e) {
            System.out.println("Fail to read a file");
        }
        return content;
    }

    public static TokenType getOp(char ch) {
        TokenType token;
        switch (ch) {
            case '*': token = TokenType.OP_MULTIPLY; break;
            case '/': token = TokenType.OP_DIVIDE; break;
            case '%': token = TokenType.OP_MOD; break;
            case '+': token = TokenType.OP_ADD; break;
            case '-': token = TokenType.OP_SUBTRACT; break;
            case '<': token = TokenType.OP_LESS; break;
            case '>': token = TokenType.OP_GREATER; break;
            case '=': token = TokenType.OP_ASSIGN; break;
            default: token = null; break;
        }
        return token;
    } 

    public static TokenType getOp(String s) {
        TokenType token;
        switch (s) {
            case "<=": token = TokenType.OP_LESSEQUAL; break;
            case ">=": token = TokenType.OP_GREATEREQUAL; break;
            case "==": token = TokenType.OP_EQUAL; break;
            case "!=": token = TokenType.OP_NOTEQUAL; break;
            default: token = null; break;
        }
        return token;
    } 

    public static TokenType getSymbol(char ch) {
        TokenType token;
        switch (ch) {
            case '(': token = TokenType.LEFT_PAREN; break;
            case ')': token = TokenType.RIGHT_PAREN; break;
            case '{': token = TokenType.LEFT_BRACE; break;
            case '}': token = TokenType.RIGHT_BRACE; break;
            case '[': token = TokenType.LEFT_BRACKET; break;
            case ']': token = TokenType.RIGHT_BRACKET; break;
            case ';': token = TokenType.SEMICOLON; break;
            case ',': token = TokenType.COMMA; break;
            default: token = null; break;
        }
        return token;
    } 

    public static TokenType getKeyword(String s) {
        TokenType token;
        switch (s) {
            case "if": token = TokenType.KEYWORD_IF; break;
            case "else": token = TokenType.KEYWORD_ELSE; break;
            case "int": token = TokenType.KEYWORD_INT; break;
            case "String": token = TokenType.KEYWORD_STRING; break;
            case "public": token = TokenType.KEYWORD_PUBLIC; break;
            case "class": token = TokenType.KEYWORD_CLASS; break;
            case "void": token = TokenType.KEYWORD_VOID; break;
            case "static": token = TokenType.KEYWORD_STATIC; break;
            default: token = null; break;
        }
        return token;
    }

    public static TokenType getHobbits(String s) {
        TokenType token;
        switch (s) {
            case "HobbitsSay": token = TokenType.HOBBITS_SAY; break;
            case "HobbitsDo": token = TokenType.HOBBITS_DO; break;
            default: token = null; break;
        }
        return token;
    }

    public static boolean isLetter(char ch) {
        boolean letter;
        if (Character.isLetter(ch)) {
            letter = true;
        } else {
            letter = false;
        }
        return letter;
    }

    public static boolean isDigit(char ch) {
        boolean digit;
        if (Character.isDigit(ch)) {
            digit = true;
        } else {
            digit = false;
        }
        return digit;
    }

    public static boolean isWhiteSpace(char ch) {
        boolean whiteSpace;
        if (Character.isWhitespace(ch)) {
            whiteSpace = true;
        } else {
            whiteSpace = false;
        }
        return whiteSpace;
    }

    public static boolean isLineBreak(char ch) {
        boolean lineBreak;
        if (ch == '\n' || ch == '\r') {
            lineBreak = true;
        } else {
            lineBreak = false;
        }
        return lineBreak;
    }
    // checks if charachters correspond to */
    public static boolean isEndComment(char ch, char ch_next) {
        boolean endComment;
        if (ch=='*' && ch_next=='/') {
            endComment = true;
        } else {
            endComment = false;
        }

        return endComment;
    }

}
