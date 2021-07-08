public class insertionSort {
    public static int[] Sort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                }
                else break;
            }
            arr[j + 1] = value;
        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 5, 8, 4, 5, 2, 4, 2};
        arr = Sort(arr);
        for (int i = 0 ; i < arr.length - 1 ; i ++ )
            System.out.println(arr[i]);
    }


}

