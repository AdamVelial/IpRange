import main.IpAddress;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by art on 08.12.16.
 */
public class TestIpAddressRange {

    @Test
    public void testIncorectRange(){

        IpAddress start = new IpAddress("10.10.2.1");
        IpAddress end = new IpAddress("10.10.1.1");

        assertTrue(start.getAllIpUntil(end).size() == 0);

    }

    @Test
    public void testRange(){
        IpAddress start = new IpAddress("192.168.0.1");
        IpAddress end = new IpAddress("192.168.0.5");

        List<String> expected = Arrays.asList(
             "192.168.0.2",
             "192.168.0.3",
             "192.168.0.4"
        );

        List<String> addr = start.getAllIpUntil(end);

        assertTrue(addr.equals(expected));
    }
}
