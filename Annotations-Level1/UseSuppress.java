import java.util.*;

public class UseSuppress {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(99);
        list.add(0);
        List<Integer> nums = list;
        for (Integer num : nums) {
            System.out.println(num);
        }

    }
}
