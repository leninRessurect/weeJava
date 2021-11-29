public class Q1Tester {
    public static void main(String[] args) {
        System.out.println("Test case 1:");
        getOp_returnNull_char(); 
        System.out.println();

        System.out.println("Test case 2:"); 
        getOp_returnNotNull_char();
        System.out.println();

        System.out.println("Test case 3:"); 
        getOp_returnNull_str();
        System.out.println();

        System.out.println("Test case 4:"); 
        getOp_returnNotNull_str();
        System.out.println();

        System.out.println("Test case 5:"); 
        getSymbol_returnNull();
        System.out.println();

        System.out.println("Test case 6:"); 
        getSymbol_returnNotNull();
        System.out.println();

        System.out.println("Test case 7:"); 
        getHobbits_returnNull();
        System.out.println();

        System.out.println("Test case 8:"); 
        getHobbits_returnNotNull();
        System.out.println();

        System.out.println("Test case 9:");
        isLetter_returnFalse();
        System.out.println();

        System.out.println("Test case 10:");
        isLetter_returnTrue();
        System.out.println();

        System.out.println("Test case 11:");
        isDigit_returnFalse();
        System.out.println();

        System.out.println("Test case 12:");
        isDigit_returnTrue();
        System.out.println();

        System.out.println("Test case 13:");
        isWhiteSpace_returnFalse();
        System.out.println();

        System.out.println("Test case 14:");
        isWhiteSpace_returnTrue();
        System.out.println();

        System.out.println("Test case 15:");
        isLineBreak_returnFalse();
        System.out.println();

        System.out.println("Test case 16:");
        isLineBreak_returnTrue();
        System.out.println();


    }

    public static void getOp_returnNull_char() {
        TokenType t = Q1.getOp('{');
        System.out.println(t);
        System.out.println("Expect: " + null);
    }

    public static void getOp_returnNotNull_char() {
        TokenType t =Q1.getOp('%');
        System.out.println(t);
        System.out.println("Expect: " + TokenType.OP_MOD);
    }

    public static void getOp_returnNull_str() {
        TokenType t = Q1.getOp("**");
        System.out.println(t);
        System.out.println("Expect: " + null);
    }

    public static void getOp_returnNotNull_str() {
        TokenType t =Q1.getOp("==");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.OP_EQUAL);
    }

    public static void getSymbol_returnNull() {
        TokenType t = Q1.getSymbol('m');
        System.out.println(t);
        System.out.println("Expect: " + null);
        
    }

    public static void getSymbol_returnNotNull() {
        TokenType t = Q1.getSymbol(',');
        System.out.println(t);
        System.out.println("Expect: " + TokenType.COMMA);
    }

    public static void getHobbits_returnNull() {
        TokenType t = Q1.getHobbits("notafunction");
        System.out.println(t);
        System.out.println("Expect: " + null);
    }

    public static void getHobbits_returnNotNull() {
        TokenType t = Q1.getHobbits("HobbitsSay");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.HOBBITS_SAY);
    }

    public static void isLetter_returnFalse() {
        boolean l = Q1.isLetter('8');
        System.out.println(l);
        System.out.println("Expect: " + false);
    }

    public static void isLetter_returnTrue() {
        boolean l = Q1.isLetter('A');
        System.out.println(l);
        System.out.println("Expect: " + true);
    }

    public static void isDigit_returnFalse() {
        boolean d = Q1.isDigit('t');
        System.out.println(d);
        System.out.println("Expect: " + false);
    }

    public static void isDigit_returnTrue() {
        boolean d = Q1.isDigit('6');
        System.out.println(d);
        System.out.println("Expect: " + true);
    }

    public static void isWhiteSpace_returnFalse() {
        boolean w = Q1.isWhiteSpace('c');
        System.out.println(w);
        System.out.println("Expect: " + false);
    }

    public static void isWhiteSpace_returnTrue() {
        boolean w = Q1.isWhiteSpace(' ');
        System.out.println(w);
        System.out.println("Expect: " + true);
    }

    public static void isLineBreak_returnFalse() {
        boolean lb = Q1.isLineBreak('c');
        System.out.println(lb);
        System.out.println("Expect: " + false);
    }

    public static void isLineBreak_returnTrue() {
        boolean lb = Q1.isLineBreak('\n');
        System.out.println(lb);
        System.out.println("Expect: " + true);
    }
}
