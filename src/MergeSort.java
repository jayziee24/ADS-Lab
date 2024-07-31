import java.util.*;
public class MergeSort {
    static void merge(int arr[], int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int n = right - left + 1;
        int[] new_arr = new int[n];
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                new_arr[k] = arr[i];
                i++;
            } else {
                new_arr[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            new_arr[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            new_arr[k] = arr[j];
            j++;
            k++;
        }
        for (int c = 0; c < n; c++) {
            arr[left + c] = new_arr[c];
        }
    }
    static void mergeSort(int arr[], int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        mergeSort(arr, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}