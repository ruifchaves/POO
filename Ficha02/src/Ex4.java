import java.util.Arrays;

/**
 * 4. Crie um programa que para um array de inteiros, disponibilize os seguinte
 * métodos:
 * (a) método que ordene um array de inteiros por ordem crescente;
 * (b) método que implemente a procura binária de um elemento num array
 * de inteiros;
 */

public class Ex4 {
    public int[] ordenarArray(int[] ints){
        Arrays.sort(ints);
        return ints;
    }

    public int binarysearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarysearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarysearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
