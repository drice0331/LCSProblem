/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import java.io.IOException;

/**
 *
 * @author drice
 */
public class LCS
{
    /**
     * First
     * @param a
     * @param b
     */
    public static String lcs(String a, String b)
    {
        String [][] charlook;
        if(a.length() > 0 && b.length() > 0)
        {
            charlook = new String [a.length()][b.length()];
        }
        else
        {
            return "";
        }
        String l = lcs(a.length() - 1, b.length() - 1, a, b, charlook);
        return l;
    }
    
    private static String lcs(int aPos, int bPos, String a, String b, String [][] charlook)
    {
        String seq;
        String seqdummy;
        char [] arrA = a.toCharArray();
        char [] arrB = b.toCharArray();
        if(aPos == -1 || bPos == -1)
        {
            //aPos or bPos is out of bounds
            return "";
        }
        seq = charlook[aPos][bPos];
        if(seq == null)
        {
            if(arrA[aPos] == arrB[bPos])
            {
                seq = Character.toString(arrA[aPos]);
                seqdummy = lcs(aPos - 1, bPos - 1, a, b, charlook);
                seq = seqdummy.concat(seq);
            }
            else
            {
                seq = lcs(aPos - 1, bPos, a, b, charlook);
                seqdummy = lcs(aPos, bPos - 1, a, b, charlook);
                if(seqdummy.length() >= seq.length())
                {
                    seq = seqdummy;
                }
            }
            charlook[aPos][bPos] = seq;
        }
        return seq;
    }
    
    
    public static void main(String[] args) throws IOException
    {        
        
        try {
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null)
            {
                String[] lineArray = line.split(";");
                if (lineArray.length > 0)
                {
                    if(lineArray.length == 2)
                    {
                        System.out.println(lcs(lineArray[0], lineArray[1]));
                    }
                    else
                    {
                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File Read Error: " + e.getMessage());
        }      
        
    }
}
