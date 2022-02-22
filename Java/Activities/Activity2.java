package activities;

public class Activity2 {
    public boolean checkThirty(int[] num, int searchKey, int fixedKey) {
      int checkSum = 0;
       for (int number : num)
       {
         if (number == searchKey)
          checkSum += number;
         if (checkSum >= fixedKey)
          break;
       }
        return checkSum == 30;
    }
    public static void main(String[] args) {
        int[]  intArr = new int[]{10, 77, 10, 54, -11,10};
        int keyNum = 10;
        int counter = 30;
        Activity2 activity2 = new Activity2();
        System.out.print("Result returned"+ ": <"+ activity2.checkThirty(intArr, keyNum, counter)+">");
    }
}
