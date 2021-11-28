public class Q1 {
    public static void main(String[] args) {
        System.out.println(getHobbits("HobbitsDo"));
    }
    
    public enum TokenType {
        //OPERATORS
        OP_MULTIPLY,
        OP_DIVIDE,
        OP_MOD,
        OP_ADD,
        OP_SUBTRACT,
        OP_LESS,
        OP_LESSEQUAL,
        OP_GREATER,
        OP_GREATEREQUAL,
        OP_EQUAL,
        OP_NOTEQUAL,
        OP_ASSIGN,
        //SYMBOLS
        LEFT_PAREN,
        RIGHT_PAREN,
        LEFT_BRACE,
        RIGHT_BRACE,
        LEFT_BRACKET,
        RIGHT_BRACKET,
        SEMICOLON,
        COMMA,
        //KEYWORDS
        KEYWORD_IF,
        KEYWORD_ELSE,
        KEYWORD_INT,
        KEYWORD_STRING,
        KEYWORD_PUBLIC,
        KEYWORD_CLASS,
        KEYWORD_VOID,
        KEYWORD_STATIC,
        //IDENTIFIERS AND LITERALS
        IDENTIFIER,
        INTEGER,
        STRING,
        //HOBBITS METHODS
        HOBBITS_SAY,
        HOBBITS_DO
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

    public static Boolean isLetter(char ch) {
        boolean letter;
        
        return letter;
    }
}
