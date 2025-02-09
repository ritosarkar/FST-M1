package activities;

public class Activity4 {
    void sort(int[] arr)
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void printArray(int[] arr)
    {
        for (int j : arr) System.out.print(j + " ");

        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] arr = { 12, 11, 13, 5, 6,23,1,45,23,10 };

        Activity4 ob = new Activity4();
        ob.sort(arr);
        System.out.println("Sorted Array in Ascending Order: ");
        printArray(arr);
    }
}
