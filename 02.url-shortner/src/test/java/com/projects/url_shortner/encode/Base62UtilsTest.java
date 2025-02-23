package com.projects.url_shortner.encode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Base62UtilsTest {

    @Test
    public void test_encode_positive_number_to_base62() {
        long input = 123456789L;
        String encoded = Base62Utils.encode(input);

        assertEquals("8M0kX", encoded);
        assertEquals(input, Base62Utils.decode(encoded));

        assertTrue(encoded.matches("^[0-9A-Za-z]+$"));
    }

    @Test
    public void test_encode_website_to_base62() {
        long input = 123456789L;
        String website = "https://keras.io/";
        String encoded = Base62Utils.encode(website.hashCode());
        System.out.println(encoded);
//        assertEquals("8M0kX", encoded);
        assertEquals(website, Base62Utils.decode(encoded));

//        assertTrue(encoded.matches("^[0-9A-Za-z]+$"));
    }
}
