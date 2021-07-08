public class shellSort {
    public static int[] Sort(int arr[]) {
        int length = arr.length;
        int gap = 1;
        while (gap < length)
            gap = gap * 3 + 1;

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i - gap;
                while (j > 0 && arr[j] > temp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = temp;
            }
            gap = gap / 3;

        }
        return arr;
    }

    public static void main(String args[]) {
        int[] arr = {2,5,8,9,7,2,5,7,8,9};
        arr = Sort(arr);
        for (int i = 0 ; i < arr.length - 1 ; i ++ )
            System.out.println(arr[i]);
    }

}
