import main.IpUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by art on 08.12.16.
 */
public class TestIpUtils {

    private List<String> correctIp;
    private List<String> incorrectIp;

    @Before
    public void init(){
        this.correctIp = Arrays.asList(
                "192.168.4.132",
                "192.168.4.133",
                "192.168.4.134",
                "192.168.4.135",
                "192.168.4.136",
                "192.168.4.137",
                "192.168.4.138",
                "192.168.4.139"
        );

        this.incorrectIp = Arrays.asList(
                "asdasd",
                "sdas.sadas.asdas.asda",
                "sd,asd,sadasd,sdadasd",
                "10.10.10.0.",
                "10.10.10.0.1",
                "10.0.4.1/24"
        );
    }

    @Test
    public void test(){
        boolean isCorrect = correctIp.parallelStream()
                .allMatch(IpUtils::validate);
        boolean isIncorrect = !incorrectIp.parallelStream()
                .allMatch(IpUtils::validate);

        System.out.println(isCorrect);
        System.out.println(isIncorrect);


        assertTrue(isCorrect);
        assertTrue(isIncorrect);
    }
}
