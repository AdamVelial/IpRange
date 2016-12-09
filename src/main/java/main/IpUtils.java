package main;

import java.util.regex.Pattern;


public class IpUtils {

    private static final Pattern PATTERN = Pattern.compile(
            "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

    public static boolean validate(final String ip) {
        return PATTERN.matcher(ip).matches();
    }


    public static final String getIPFromLong(final long ipaslong) {
        return String.format("%d.%d.%d.%d",
                (ipaslong >>> 24) & 0xff,
                (ipaslong >>> 16) & 0xff,
                (ipaslong >>>  8) & 0xff,
                (ipaslong       ) & 0xff);
    }


}
