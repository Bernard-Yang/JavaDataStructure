public class bubbleSort {
    public static int[] Sort(int arr[]){
        for (int i = 0 ; i < arr.length - 1 ; i ++ ){
            for (int j = 0 ; j < arr.length - 1 - i ; j ++){
                int temp = 0;
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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

