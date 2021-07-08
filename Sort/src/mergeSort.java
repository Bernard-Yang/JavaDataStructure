public class mergeSort {
    public static void Sort(int arr[]) {
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int arr[], int l, int r){
        if (l >= r)
            return;
        int mid = l +(r - 1)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int arr[], int l, int mid, int r){
        int aux[] = new int[r-l+1];
        for (int i = l ; i <= r; i++){
            aux[i-l] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l ; k <= r; k++ ){
            if (i > mid){
                arr[k] = aux[j - l];
                j ++;
            }
            else if (j > r){
                arr[k] = aux[i - l];
                i++;
            }
            else if (aux[i - l] < aux[j - l]){
                arr[k] = aux[i - l];
                i++;
            }
            else{
                arr[k] = aux[j - l];
                j++;
            }

        }
    }

    public static void main(String args[]) {
        int[] arr = {2,5,8,9,7,2,5,7,8,9};
        Sort(arr);
        for (int i = 0 ; i < arr.length - 1 ; i ++ )
            System.out.println(arr[i]);
    }

}
