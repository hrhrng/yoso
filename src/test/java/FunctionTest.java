import com.hrhrng.yoso.SwapHeap;

import java.util.Arrays;

public class FunctionTest {
    class aaa extends bbb {
        public static void main(String[] args) {
            SwapHeap s = new SwapHeap(Arrays.asList(3,4,1,5,543,1,6,6,3));
        }
    }

    class bbb implements Comparable<bbb>{

        @Override
        public int compareTo(bbb o) {
            return 0;
        }
    }
}
