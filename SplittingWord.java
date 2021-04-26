import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SplittingWord {
    public static void main(String[] args) throws IOException{
        //initial stuff
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a word to split it into vowels and consonants in two different files.");
        String word = input.next();
        char[] arr = word.toCharArray();
        //initializing hashmaps for two groups
        HashMap<Character,Integer> vowelMap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> consoMap = new HashMap<Character,Integer>();
        //initializing file handlers
        File vowelFile = new File("Vowels");
        File consoFile = new File("Consonants");
        FileOutputStream vowelStream = new FileOutputStream(vowelFile);
        FileOutputStream consoStream = new FileOutputStream(consoFile);
        PrintWriter vowelPrint = new PrintWriter(vowelStream);
        PrintWriter consoPrint = new PrintWriter(consoStream);
        //loop to arrange them into groups
        for (char c:arr){
            if (c == 'a' || c == 'A' || c =='e' || c == 'E' || c =='i' || c == 'I' || c =='o' || c == 'O' || c =='u' || c == 'U')
                if(!vowelMap.containsKey(c)) vowelMap.put(c,1);
                else vowelMap.put(c,vowelMap.get(c)+1);
            else
                if(!consoMap.containsKey(c)) consoMap.put(c,1);
                else consoMap.put(c,consoMap.get(c)+1);
        }
        //loop to write them into files
        for(Map.Entry<Character,Integer> entry : vowelMap.entrySet())
            vowelPrint.println(entry.getKey()+" occurred "+entry.getValue()+" times.");
        for(Map.Entry<Character,Integer> entry : consoMap.entrySet())
            consoPrint.println(entry.getKey()+" occurred "+entry.getValue()+" times.");
        //closing formalities
        System.out.println(vowelMap);
        System.out.println(consoMap);
        vowelPrint.close();
        vowelStream.close();
        consoPrint.close();
        consoStream.close();
    }
}
