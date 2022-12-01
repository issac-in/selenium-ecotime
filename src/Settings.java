public class Settings {
    public static String user = ""; // for AD login
    public static String pass = ""; // for AD login

    public static String inHour = ""; // Any number between 1 to 12, inclusive.
    public static String inMinute = ""; // 00 or 15 or 30 or 45
    public static String inAP = ""; // A or P (represents AM or PM)
    public static String inTime = inHour + ":" + inMinute + " " + inAP + "M";

    public static String outHour = ""; // Any number between 1 to 12, inclusive.
    public static String outMinute = ""; // 00 or 15 or 30 or 45
    public static String outAP = ""; // A or P (pepresents AM or PM)
    public static String outTime = outHour + ":" + outMinute + " " + outAP + "M";

    public static String date = ""; // MM/DD format

    public static String jobCode = ""; // aka Title Code
    public static String payCode = ""; // Hours Worked OR On Call/Call Back Worked

    public static int waitFor2FA = 10; // in seconds
    public static int waitForSelect = 500; // in milliseconds
}
