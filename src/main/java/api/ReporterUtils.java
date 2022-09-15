package api;

public class ReporterUtils {
    private ReporterUtils() { }

    // general constants
    public static final String CRLF = System.lineSeparator();
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String TOKEN = "$";

    // default css styles
    public static final String CSS_CONTAINER = "container";
    public static final String CSS_SUBTITLE = "subtitle";
    public static final String CSS_BLOCK = "block";
    public static final String CSS_SPLITTER = "splitter";
    public static final String CSS_HALF_LEFT = "half left";
    public static final String CSS_HALF_RIGHT = "half right";
    public static final String CSS_MASTER = "master";
    public static final String CSS_DETAIL = "detail";
    public static final String CSS_MASTER_DETAIL = "masterdetail";
    public static final String CSS_PASSED = "pass";
    public static final String CSS_FAILED = "fail";
    public static final String CSS_SKIPPED = "skip";

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
