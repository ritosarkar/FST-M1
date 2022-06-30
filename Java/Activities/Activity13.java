package activities;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Activity13 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        ArrayList<Integer> list=new ArrayList<>();
        Random indexGen=new Random();
        System.out.println("Enter the integers:");
        System.out.println("Enter / or any character to indicate the end of file.");

        while (scan.hasNextInt())
            list.add(scan.nextInt());
        Integer[] nums = list.toArray(new Integer[0]);
        int index= indexGen.nextInt(nums.length);
        System.out.println("Index is: "+index); 
        System.out.println("Value at index is: "+nums[index]);
        scan.close();
    }

}
