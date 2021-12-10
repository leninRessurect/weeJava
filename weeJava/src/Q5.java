import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Deque;
import java.util.LinkedList;

public class Q5 {
    public static void main(String[] args) {
        System.out.println("## Q5Example1:");
        scan("src/Q5Example1.txt");

        System.out.println("\n## Q5Example2:");
        scan("src/Q5Example2.txt");

        System.out.println("\n## Q5Example3:");
        scan("src/Q5Example3.txt");
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

    /**
	 * To read the content of a file into a string
	 * @param fname the file name
	 * @return the string representing the file content
	 */
	public static String readFile2String(String fname) {
		String content = null;
		try {
	        content = new String(Files.readAllBytes(Paths.get(fname)));
		} catch (IOException e) {
			System.out.println("Fail to read a file");
		}
		
		return content;
	}

    /**
     * reads contents of file into string, parses into tokens. finds compile time errors, prints them
     * @param fname the file name
     */
    public static void scan(String fname) {
        String text = readFile2String(fname);
        int n = text.length();
        int index = 0;
        int lineNumber = 1;
        // Deque is a modified stack object that allows for easier manipulation
        Deque<Integer> braceStack = new LinkedList<Integer>();
        Deque<Integer> bracketStack = new LinkedList<Integer>();
        Deque<Integer> parenStack = new LinkedList<Integer>();

        while (index < n) {
            char ch = text.charAt(index); //current character
            char ch_next =' ';
            if (index < n-1) {
                ch_next = text.charAt(index+1); // next character
            } 
            String ch_nextString = new String(new char[]{ch,ch_next}); // concantantes char and char+1 into a string

            boolean whiteSpace = isWhiteSpace(ch); // bool to indicate whitespace
            boolean newLine = isLineBreak(ch); //bool to indicate new line
            TokenType sym = getSymbol(ch);  // symbol name or null
            TokenType op = getOp(ch); // operator name or null
            TokenType op_str = getOp(ch_nextString); //operator name or null
            boolean letter = isLetter(ch); // bool to indicate letter
            boolean digit = isDigit(ch); // bool to indicate digit
            
            
            if (ch=='/' && ch_next=='/') {
                //handle single line comments
                while (!isLineBreak(ch)) {
                    // skip characters untill new line
                    index++;
                    ch = text.charAt(index);
                }
                index++;
                continue;
            } else if (ch=='/' && ch_next=='*') {
                // handle multiline comments
                while (index < n) {
                    index++;
                    ch = text.charAt(index);
                    ch_next = text.charAt(index+1);
                    if (ch=='*' && ch_next=='/') { //end comment encountered
                        index = index + 2; // skip encomment
                        break;
                    }
                }
                continue;

            } else if (whiteSpace) { 
                // ch is whitespace
                if (newLine) {
                    lineNumber++;
                }
                index++;
                continue; // back to start of loop

            // deal with symbols
            } else if (sym!=null) { // ch is symbol
                // if open bracket push to stack
                if (sym==TokenType.LEFT_BRACE || sym==TokenType.LEFT_BRACKET || sym==TokenType.LEFT_PAREN) {
                    if (sym==TokenType.LEFT_BRACE) {
                        braceStack.push(lineNumber); 
                    } else if (sym==TokenType.LEFT_BRACKET) {
                        bracketStack.push(lineNumber);
                    } else if (sym==TokenType.LEFT_PAREN) {
                        parenStack.push(lineNumber);
                    }
                } else if (sym==TokenType.RIGHT_BRACE || sym==TokenType.RIGHT_BRACKET || sym==TokenType.RIGHT_PAREN) {
                    // if close bracket, remove match from stack, or if no match print error
                    if (sym==TokenType.RIGHT_BRACE) {
                        if (braceStack.isEmpty()) {
                            System.out.println("Syntax error: unmatched brace at Line " + lineNumber);
                        } else {
                            braceStack.removeLast();
                        }
                    } else if (sym==TokenType.RIGHT_BRACKET) {
                        if (bracketStack.isEmpty()) {
                            System.out.println("Syntax error: unmatched bracket at Line " + lineNumber);
                        } else {
                            bracketStack.removeLast();
                        }
                    } else if (sym==TokenType.RIGHT_PAREN) {
                        if (parenStack.isEmpty()) {
                            System.out.println("Syntax error: unmatched Parenthesis at Line " + lineNumber);
                        } else {
                            parenStack.removeLast();
                        }
                    }
                }
                index++;
                continue;

            // deal with operators
            } else if (op!=null || op_str!=null) { //ch is op or ch+ch_next is double char op
                // deal with double char op
                if (op_str!=null) { 
                    index = index + 2; // skip rest of op
                    continue;
                // deal with single char op
                } else { 
                    index++;
                    continue;
                }

            // deal with IDENTIFIERS KEYWORDS HOBBITSMETHODS
            } else if (letter || ch=='_') {
                String word = ""; 
                word = word + ch; // add chars into string to form word
                index++;
                // builds characters of word into string
                while(index < n) {
                    ch = text.charAt(index);
                    if (isLetter(ch)) { //ch is letter
                        word = word + ch;
                        index++;
                        continue;
                    } else if (isDigit(ch)) { //ch is digit
                        word = word + ch;
                        index++;
                        continue;
                    } else if (ch=='_') { //ch is underscore
                        word = word + ch;
                        index++;
                        continue;
                    } else { // gets to end char + 1 and ends loop 
                        break;
                    }
                }
                // find and print word and type
                TokenType keyword = getKeyword(word); // returns token type or null
                TokenType hobbits = getHobbits(word); // returns token type or null
                if (keyword != null) { // is keyword
                    continue;
                } else if (hobbits != null) { // is hobbits method
                    continue;
                } else {
                    continue;
                }
            
            // deal with digits
            } else if (digit) { //ch is digit
                String number = "";
                number = number + ch;
                index++;
                // builds characters of number into string
                while (index < n) {
                    ch = text.charAt(index);
                    if (isDigit(ch)) {
                        number = number + ch;
                        index++;
                        continue;
                    } else if (isLetter(ch)) {
                        System.out.println("Syntax error on token \"" + number.charAt(0) + "\", delete this token at Line " + lineNumber);
                        break;
                    } else {
                        break;
                    }
                }
                continue;
            // DEAL WITH STRINGS
            } else if (ch=='\"') { // ch is beginning of string
                String str = "";
                str = str + ch;
                index++;
                // builds characters into string
                while (index < n) {
                    ch = text.charAt(index);
                    // hopefully this will be this case (string closed)
                    if (ch=='\"') { // stops when it encounters end quote
                        str = str + ch;
                        index++;
                        break;
                    // handles unclosed strings error
                    // checks if last char of file is not end quote
                    } else if (index==n-1) { // index reaches end of file
                        System.out.println("String literal is not properly closed by a double-quote at Line " + lineNumber);
                        index++;
                        break;
                    // is valid string character
                    } else {
                        str = str + ch;
                        index++;
                        continue;
                    }
                }
            // anything not dealt with
            } else {
                System.out.println(lineNumber + ", Encountered something not expected: " + ch);
                index++;
                continue;
            }

            
        }

        while (braceStack.size() != 0) {
            System.out.println("Syntax error: unmatched Brace at Line " + braceStack.peek());
            braceStack.removeFirst();
        }
        while (bracketStack.size() != 0) {
            System.out.println("Syntax error: unmatched Bracket at Line " + bracketStack.peek());
            bracketStack.removeFirst();
        }
        while (parenStack.size() != 0) {
            System.out.println("Syntax error: unmatched Parenthesis at Line " + parenStack.peek());
            parenStack.removeFirst();
        }
    }
}
