public class Q1TesterKeywords {
    public static void main(String[] args) {
        System.out.println("Test case 1:");
        test_if();
        System.out.println();

        System.out.println("Test case 2:");
        test_else();
        System.out.println();

        System.out.println("Test case 3:");
        test_int();
        System.out.println();

        System.out.println("Test case 4:");
        test_string();
        System.out.println();

        System.out.println("Test case 5:");
        test_public();
        System.out.println();

        System.out.println("Test case 6:");
        test_class();
        System.out.println();

        System.out.println("Test case 7:");
        test_void();
        System.out.println();

        System.out.println("Test case 8:");
        test_static();
        System.out.println();

        System.out.println("Test case 9:");
        test_null();
        System.out.println();
    }

    public static void test_if() {
        TokenType t = Q1.getKeyword("if");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_IF);
    }

    public static void test_else() {
        TokenType t = Q1.getKeyword("else");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_ELSE);
    }

    public static void test_int() {
        TokenType t = Q1.getKeyword("int");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_INT);
    }

    public static void test_string() {
        TokenType t = Q1.getKeyword("String");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_STRING);
    }

    public static void test_public() {
        TokenType t = Q1.getKeyword("public");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_PUBLIC);
    }

    public static void test_class() {
        TokenType t = Q1.getKeyword("class");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_CLASS);
    }

    public static void test_void() {
        TokenType t = Q1.getKeyword("void");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_VOID);
    }

    public static void test_static() {
        TokenType t = Q1.getKeyword("static");
        System.out.println(t);
        System.out.println("Expect: " + TokenType.KEYWORD_STATIC);
    }

    public static void test_null() {
        TokenType t = Q1.getKeyword("notakeyword");
        System.out.println(t);
        System.out.println("Expect: " + null);
    }
}
