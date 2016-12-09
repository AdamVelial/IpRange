package main;

import main.exeptions.IpAddressFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IpAddressFormatException {

        try( BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ) {
            String first;
            String second;

            IpAddress firstIp;
            IpAddress secondIp;

            System.out.println("Введите первый адрес: ");
            first = reader.readLine();
            if(!IpUtils.validate(first)) throw new IpAddressFormatException(first);
            firstIp = new IpAddress(first);

            System.out.println("Введите второй адрес: ");
            second = reader.readLine();
            if(!IpUtils.validate(second)) throw new IpAddressFormatException(second);
            secondIp = new IpAddress(second);


            List<String> ips = firstIp.getAllIpUntil(secondIp);

            ips.stream()
                    .forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
