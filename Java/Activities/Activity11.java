package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args)
    {
        HashMap<Integer,String> colours=new HashMap<>();
        colours.put(1,"Green");
        colours.put(2,"Orange");
        colours.put(3,"Yellow");
        colours.put(4,"Blue");
        colours.put(5,"Brown");
        colours.remove(2);
        if (colours.containsValue("Green"))
            System.out.println("Green is present");
        else
            System.out.println("Green is not present") ;
        System.out.println("Size of the has map is: "+colours.size());
        System.out.println(colours);
    }
}
