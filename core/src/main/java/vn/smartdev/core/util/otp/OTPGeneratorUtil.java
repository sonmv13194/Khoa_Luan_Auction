package vn.smartdev.core.util.otp;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import vn.smartdev.core.util.datetime.DateTimeUtil;

public class OTPGeneratorUtil {
    private static final int TRUNCATION_OFFSET = 3;

    /**
     * Generate OTP base minute
     * @param secret Secret Code
     * @param length OTP Length
     * @return OTP Value
     * @throws OTPGenerationException 
     */
    public static String generateOTP(String secret, int length) throws OTPGenerationException {
        String interval = DateTimeUtil.convertDateToString(Calendar.getInstance().getTime(), "yyyyMMddHHmm");
        return generateOTP(secret, Long.valueOf(interval), length);

    }
    /**
     * Generate OTP base interval
     * @param secret Secret Code
     * @param interval Interval
     * @param length OTP Length
     * @return OTP Value
     * @throws OTPGenerationException 
     */
    public static String generateOTP(String secret, long interval, int length) throws OTPGenerationException {
        try {
            return HOTPAlgorithm.generateOTP(secret.getBytes(), interval, length, false, TRUNCATION_OFFSET);
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
            throw new OTPGenerationException(e);
        }
    }
}
