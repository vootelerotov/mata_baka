
import java.util.Collections;
import java.util.List;

/**
 * @author Hasso Mehide (hassom@ut.ee)
 */
public class Sort {

  public static void main(String[] args) {
    System.out.println(getAverageTime(5000));
  }

  private static long getAverageTime(int numberOfElements) {
    long totalTime = 0;
    for (int i = 0; i < 10; i++) {
      List<Integer> list = Util.createRandomList(numberOfElements);
      long start = System.currentTimeMillis();
      bubbleSort(list);
      // mergeSort(list);
      // Collections.sort(list);
      totalTime += System.currentTimeMillis() - start;
    }
    return Math.round(totalTime / 10.0);
  }

  private static <T extends Comparable<? super T>> List<T> bubbleSort(List<T> list) {
    int n = list.size();
    for (int i = 0; i < n; i++) {
      boolean swapped = false;
      for (int j = n - 1; j > i; j--) {
        if (list.get(j).compareTo(list.get(j - 1)) < 0) {
          Collections.swap(list, j, j - 1);
          swapped = true;
        }
      }
      if (!swapped) {
        break;
      }
    }
    return list;
  }

  private static <T extends Comparable<? super T>> List<T> mergeSort(List<T> list) {
    int n = list.size();
    int m = Math.round(n / 2);
    if (n > 1) {
      List<T> left = list.subList(0, m);
      List<T> right = list.subList(m, n);

      left = mergeSort(left);
      right = mergeSort(right);

      List<T> copy = Util.copy(left);
      int i = 0, j = m, k = 0;
      while (i < m && j < n) {
        list.set(k++, (list.get(j).compareTo(copy.get(i)) < 0) ? list.get(j++) : copy.get(i++));
      }
      while (i < m) {
        list.set(k++, copy.get(i++));
      }
    }
    return list;
  }

}
