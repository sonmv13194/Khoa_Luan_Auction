package core.util.otp;

import vn.smartdev.core.util.otp.OTPGenerationException;
import vn.smartdev.core.util.otp.OTPGeneratorUtil;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Calendar;

import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by huynhduychuong on Oct 2, 2016.
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(value = {OTPGeneratorUtil.class, Calendar.class })
@PowerMockIgnore(value = "javax.crypto.*")
public class OTPGeneratorUtilTest {

    @Test
    public void shouldGenerateSameOTPIfSameSecretAndMinute() throws OTPGenerationException {
        String secret = "user.name";
        int otpLen = 4;
        Calendar firstTime = Calendar.getInstance();
        firstTime.set(2016, Calendar.OCTOBER, 2, 10, 10, 01); // 2016-10-02
                                                              // 10:10:01
        Calendar secondTime = Calendar.getInstance();
        secondTime.set(2016, Calendar.OCTOBER, 2, 10, 10, 59); // 2016-10-02
                                                               // 10:10:59
        PowerMockito.mockStatic(Calendar.class);

        when(Calendar.getInstance()).thenReturn(firstTime);
        String otp = OTPGeneratorUtil.generateOTP(secret, otpLen);
        when(Calendar.getInstance()).thenReturn(secondTime);
        String regeneratedOTPInTheSameMinuteWithFirstOTP = OTPGeneratorUtil.generateOTP(secret, otpLen);

        Assertions.assertThat(regeneratedOTPInTheSameMinuteWithFirstOTP).isEqualTo(otp);

    }
    
    @Test
    public void shouldGenerateOtherOTPIfSameSecretAndDifferentMinute() throws OTPGenerationException {
        String secret = "user.name";
        int otpLen = 4;
        Calendar firstTime = Calendar.getInstance();
        firstTime.set(2016, Calendar.OCTOBER, 2, 10, 10, 01); // 2016-10-02
                                                              // 10:10:01
        Calendar secondTime = Calendar.getInstance();
        secondTime.set(2016, Calendar.OCTOBER, 2, 10, 11, 01); // 2016-10-02
                                                               // 10:11:01
        PowerMockito.mockStatic(Calendar.class);

        when(Calendar.getInstance()).thenReturn(firstTime);
        String otp = OTPGeneratorUtil.generateOTP(secret, otpLen);
        when(Calendar.getInstance()).thenReturn(secondTime);
        String regeneratedOTPInTheSameMinuteWithFirstOTP = OTPGeneratorUtil.generateOTP(secret, otpLen);

        Assertions.assertThat(regeneratedOTPInTheSameMinuteWithFirstOTP).isNotEqualTo(otp);

    }
}
