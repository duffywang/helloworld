import java.util.ArrayList;
import java.util.Iterator;

/**
 * @auther : wangyufei
 * @date : 2020-04-20
 **/
public class ConcurrentException {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        Iterator<Integer> iterator = arrayList.iterator();

        // 复现方法一
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                arrayList.remove(integer);
            }
        }

        // 复现方法二
        for (Integer value : arrayList) {
            Integer integer = iterator.next();
            if (integer == 2) {
                arrayList.remove(integer);
            }
        }

        //不复现方法三
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if (integer == 2) {
                iterator.remove();
            }
        }
    }
}
