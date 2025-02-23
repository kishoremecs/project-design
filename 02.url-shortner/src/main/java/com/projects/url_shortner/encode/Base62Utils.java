package com.projects.url_shortner.encode;

import java.math.BigInteger;

public class Base62Utils {
    private static final String BASE62_ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = 62;

    // Encode a number to Base62
    public static String encode(long number) {
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            sb.append(BASE62_ALPHABET.charAt((int) (number % BASE)));
            number /= BASE;
        }
        return sb.reverse().toString();
    }

    // Decode Base62 to a number
    public static long decode(String base62) {
        long result = 0;
        for (char c : base62.toCharArray()) {
            result = result * BASE + BASE62_ALPHABET.indexOf(c);
        }
        return result;
    }

    public static void main(String[] args) {
        long number = 123456789L;
        String url = "https://www.google.co.in/";
        System.out.println(url.hashCode() & Long.MAX_VALUE);
        String encoded = encode(url.hashCode() & Long.MAX_VALUE);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + decode(encoded));
    }
}
