package api;

public class ReporterUtils {
    private ReporterUtils() { }

    public static final String CRLF = System.lineSeparator();
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String TOKEN = "$";
    public static final String LEFT_TAG = "<";
    public static final String RIGHT_TAG = ">";
    public static final String SLASH = "/";

    public static boolean isNotEmpty(Object o) {
        return o != null && o.toString().length() > 0;
    }

    public static <T> T getOrDefault(T o, T dv) {
        return o == null ? dv : o;
    }

    public static void debug(String... s) {
        System.out.println("-----------------------------------------------------" + CRLF);
        for (String p : s) {
            System.out.println(String.format("%s", p) + CRLF);
        }
        System.out.println("-----------------------------------------------------" + CRLF);
    }
}
