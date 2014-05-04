

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Hasso Mehide (hassom@ut.ee)
 */
public class Util {

  public static <T> List<T> copy(List<T> list) {
    List<T> copy =  new ArrayList<T>();
    copy.addAll(list);
    return copy;
  }

  public static List<Integer> createRandomList(int numberOfElements) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < numberOfElements; i++) {
      list.add((int) Math.round(Math.random() * 1000000));
    }
    return list;
  }

  public static List<Integer> createSortedList(int numberOfElements) {
    List<Integer> list = createRandomList(numberOfElements);
    Collections.sort(list);
    return list;
  }

  public static List<Integer> createReversedList(int numberOfElements) {
    List<Integer> list = createSortedList(numberOfElements);
    Collections.reverse(list);
    return list;
  }

}
