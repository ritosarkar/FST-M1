package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList();
        myList.add("C");
        myList.add("Java");
        myList.add("Selenium");
        myList.add("Cucumber");
        myList.add("TestNg");

        for(String name: myList)
            System.out.println(name);

        System.out.println("Third element in the list is:"+myList.get(2));
        if(myList.contains("Selenium"))
            System.out.println("Yes we have selenium in the list.");
        System.out.println("Size of the arraylist is: "+myList.size());
        myList.remove(0);
        System.out.println("Size after removing from arraylist is: "+myList.size());
    }
}
