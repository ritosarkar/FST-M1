package activities;

import java.util.HashMap;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args)
    {
        HashSet<String> hs = new HashSet<String>();
        hs.add("R");
        hs.add("I");
        hs.add("T");
        hs.add("O");
        hs.add("S");
        hs.add("A");
        System.out.println("Length of hash map is: "+hs.size());
        System.out.println(hs);
        hs.remove("A");
        if(hs.remove("x"))
            System.out.println("X had been removed successfully");
        else
            System.out.println("X is not present in the hash-set.");
        if(hs.contains("R"))
            System.out.println("Yes R is present in the hash-set.");
        System.out.println("Updated set is: ");
        System.out.println(hs);
    }
}
