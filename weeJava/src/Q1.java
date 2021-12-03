public class Q1 {
    public static void main(String[] args) {
        TokenType op1 = getOp('+');
        System.out.println("op1: " + op1);

        TokenType op2 = getOp("==");
        System.out.println("op2: " + op2);

        TokenType sym = getSymbol('{');
        System.out.println("symbol: " + sym);

        TokenType keyword = getKeyword("int");
        System.out.println("keyword: " + keyword);

        TokenType hobbits = getHobbits("HobbitsSay");
        System.out.println("hobbits: " + hobbits);

        boolean letter = isLetter('a');
        System.out.println("letter: " + letter);
        
        boolean digit = isDigit('0');
        System.out.println("digit: " + digit);

        boolean whiteSpace = isWhiteSpace(' ');
        System.out.println("whiteSpace: " + whiteSpace);

        boolean newLine = isLineBreak('\n');
        System.out.println("newline: " + newLine);
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
        if (!String.valueOf(ch).matches(".")) {
            lineBreak = true;
        } else {
            lineBreak = false;
        }
        return lineBreak;
    }
}
