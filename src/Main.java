import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.insert(7);
        list.insert(1);
        list.insert(6);

        System.out.println("До сортування:");
        list.printList();

        list.insertionSort();
        System.out.println("Після сортування:");
        list.printList();

        // Конвертуємо список у масив для бінарного пошуку
        int[] array = {1, 2, 4, 5, 6, 7};

        int target = 5;
        System.out.println("Binary Search (ітеративно): " + binarySearch(array, target));
        System.out.println("Binary Search (рекурсивно): " + binarySearchRecoursive(array, target, 0, array.length - 1));
    }

    public static int binarySearchRecoursive(int[] array, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (high - low) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (target < array[mid]) {
            return binarySearchRecoursive(array, target, low, mid - 1);
        } else {
            return binarySearchRecoursive(array, target, mid + 1, high);
        }
    }

    public static int binarySearch(int[] array, int target) {
        Arrays.sort(array);
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (target < array[mid]) {
                low = mid - 1;
            } else {
                high = mid + 1;
            }
        }

        return -1;
    }
}
