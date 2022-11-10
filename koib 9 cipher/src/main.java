import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.math.*;

public class main {

    public static void main(String[] args) {

        int[][] magicSquareNu;
        char[][] magicSquareSy;
        int sizeOfMS = 5;
        String name = "Gorodkov Gleb Yurevich";
        String decryptedName;

        System.out.println("text for encrypt: " + name);
        magicSquareNu = cipher.generateSquareNumbers(sizeOfMS);
        System.out.println("magic square:");
        cipher.displayMS(magicSquareNu, sizeOfMS);

        System.out.println("\n");
        magicSquareSy = cipher.generateSquareSymbols(name, magicSquareNu, sizeOfMS);
        System.out.println("encrypted name: " + "\n");
        cipher.displayMS(magicSquareSy, sizeOfMS);

        decryptedName = cipher.decrypt(magicSquareNu, magicSquareSy, sizeOfMS);
        System.out.println("\n" + "decrypted name: " + decryptedName);


        System.out.println("\n" + "RSA");
        Scanner sc=new Scanner(System.in);
        int p, q, n, z, i, d = 0, e;
        System.out.println("Enter the number to be encrypted and decrypted");
        int msg=sc.nextInt();
        double c;
        BigInteger msgback;
        System.out.println("Enter 1st prime number p");
        p=sc.nextInt();
        System.out.println("Enter 2nd prime number q");
        q=sc.nextInt();

        n=p*q;
        z=(p-1)*(q-1);
        System.out.println("the value of z = "+z);


        for(e=2;e<z;e++)
        {
            if(cipher.gcd(e,z)==1)            // e is for public key exponent
            {
                break;
            }
        }
        System.out.println("the value of e = "+e);
        for(i=0;i<=9;i++)
        {
            int x=1+(i*z);
            if(x%e==0)      //d is for private key exponent
            {
                d=x/e;
                break;
            }
        }
        System.out.println("the value of d = "+d);
        c = (Math.pow(msg,e)) % n;
        System.out.println("Encrypted message is : " + c);


        BigInteger N = BigInteger.valueOf(n);

        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : " + msgback);
    }
}
