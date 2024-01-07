package com.example;

import java.util.Scanner;

public class CRC {
    static String datastream;
    static String generator = "10011";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---At the Sender---\n Enter data stream ");

        String datastream = sc.nextLine();

        int datalen = datastream.length();
        int genlen = generator.length();

        int data[] = new int[datalen + genlen - 1];
        int codeword[] = new int[datalen + genlen - 1];
        int div[] = new int[generator.length()];

        for (int i = 0; i < datastream.length(); i++)
            data[i] = Integer.parseInt(datastream.charAt(i) + "");

        for (int i = 0; i < generator.length(); i++)
            div[i] = Integer.parseInt(generator.charAt(i) + "");

        codeword = calculateCRC(data, div, datalen);

        System.out.println("The CRC(Final Codeword) code is: ");
        for (int i = 0; i < codeword.length; i++)
            System.out.print(codeword[i]);
        System.out.println("\n");

        System.out.println("---At the receiver---\n Enter Received codeword: ");

        datastream = sc.nextLine();
        int[] receivedCodeword = new int[datastream.length() + generator.length() - 1];

        for (int i = 0; i < datastream.length(); i++)
            receivedCodeword[i] = Integer.parseInt(String.valueOf(datastream.charAt(i)));

        int[] remainder = calculateCRC(receivedCodeword, div, datalen);

        boolean valid = true;

        for (int i = 0; i < remainder.length; i++)
            if (remainder[i] == 1) {
                valid = false;
                break;
            }

        if (valid)
            System.out.println("Data stream is valid. No error occurred.");
        else
            System.out.println("Data stream is invalid. CRC error occurred.");

        sc.close();
    }

    public static int[] calculateCRC(int[] divrem, int[] divisor, int len) {
        for (int i = 0; i < len; i++) {
            if (divrem[i] == 1) {
                for (int j = 0; j < divisor.length; j++) {
                    divrem[i + j] ^= divisor[j];
                }
            }
        }
        return divrem;
    }
}
