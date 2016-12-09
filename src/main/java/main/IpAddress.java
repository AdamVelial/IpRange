package main;

import java.util.ArrayList;
import java.util.List;


public class IpAddress {

    private final long ip;

    public IpAddress(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {

            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);

        }

        this.ip = result;
    }

    public String getIp() {
        return String.format("%d.%d.%d.%d",
                (ip >>> 24) & 0xff,
                (ip >>> 16) & 0xff,
                (ip >>>  8) & 0xff,
                (ip       ) & 0xff);
    }

    public long getIpAsLong(){
        return ip;
    }

    public List<String> getAllIpUntil(IpAddress ip){
        final long to = ip.getIpAsLong();
        List<String> list = new ArrayList<>();

        for (long i = this.ip + 1; i < to; i++) {
            list.add(IpUtils.getIPFromLong(i));
        }
        return list;
    }

    @Override
    public String toString() {
        return getIp();
    }
}
