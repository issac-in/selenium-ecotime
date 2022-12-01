public class Settings {
    public static String user = ""; // for AD login
    public static String pass = ""; // for AD login

    public static String inHour = ""; // [1-12]
    public static String inMinute = ""; // 00 15 30 45
    public static String inAP = ""; // A or P (AM or PM)
    public static String inTime = inHour + ":" + inMinute + " " + inAP + "M";

    public static String outHour = ""; // [1-12]
    public static String outMinute = ""; // 00 15 30 45
    public static String outAP = ""; // A or P (AM or PM)
    public static String outTime = outHour + ":" + outMinute + " " + outAP + "M";

    public static String date = ""; // MM/DD format

    public static String jobCode = ""; // aka Title Code
    public static String payCode = ""; // Hours Worked OR On Call/Call Back Worked

    public static int waitFor2FA = 10; // in seconds
    public static int waitForSelect = 250; // in milliseconds
}
