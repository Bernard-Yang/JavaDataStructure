public class _1 {
    public static int[] selectSort(int[] a){
        for (int i = 0 ; i < a.length - 1 ; i ++){
            int min = i;
            for(int j = i + 1 ; j < a.length - 1; j ++){
                if (a[min] > a[j])
                    min = j;
            }

            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
        return a;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 6, 3, 22, 4};
        selectSort(arr);
        for (int i = 0 ; i < arr.length - 1 ; i ++)
            System.out.println(arr[i]);
    }
}
