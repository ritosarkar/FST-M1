package activities;

interface Addable{
    int add(int num1,int num2);
}

public class Activity12 {

    public static void main(String[] args){
        Addable ad1=(a,b) -> (a + b);
        System.out.println(ad1.add(19,12));

        Addable ad2=(int a, int b) -> {return (a+b);};
        System.out.println(ad1.add(129,112));

    }
}
