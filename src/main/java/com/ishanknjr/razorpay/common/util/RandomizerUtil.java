package com.ishanknjr.razorpay.common.util;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class RandomizerUtil{
    private static final SecureRandom SECURE_RANDOM = new SecureRandom(); // thread safe , random is also there in java

    public static String randomBase64(int length) {
        byte[] buf = new byte[length];
        SECURE_RANDOM.nextBytes(buf);
//        [4,.... ]-128 to 127
        return Base64.getUrlEncoder().withoutPadding().encodeToString(buf);

//         buf used in this url are thread safe - op is safe for the url
//       lemngth * 3/4  = actual base 64 ength which means 64 * 3 /4 = 48 char of length

    }
}
