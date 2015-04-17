import java.util.Arrays;

/**
 * Created by sky on 06/04/15.
 */
/*
 * Implement a stack that supports push, pop and median (the one from statistics)
 * operation in the most efficient way
 * URL: http://www.careercup.com/question?id=5769897411870720
 */

public class Ideone1 {

    private static class MyStack {
        private Integer[] elementData;
        int size;

        public MyStack(int capacity) {
            elementData = new Integer[capacity];
            size = 0;
        }

        public void add(Integer e) {
            if (size + 1 > elementData.length) {
                int newCapacity = elementData.length << 1;
                elementData = Arrays.copyOf(elementData, newCapacity);
            }

            elementData[size++] = e;
        }

        public Integer remove() {
            Integer value = elementData[--size];
            elementData[size] = null;

            if (size < (elementData.length / 4)) {
                int newCapacity = elementData.length / 2;
                elementData = Arrays.copyOf(elementData, newCapacity);
            }

            return value;
        }

        public boolean empty() {
            return this.size == 0;
        }

        public float median() {
            Integer[] copied = Arrays.copyOf(elementData, size);
            Arrays.sort(copied);

            float median;

            if ((copied.length % 2) != 0) {
                // Odd
                median = copied[copied.length / 2];
            } else {
                // Even
                int mid = copied.length / 2;
                median = (float) (copied[mid - 1] + copied[mid]) / 2;
            }
            return median;
        }
    }

    public void run() {
        MyStack myStack = new MyStack(10);
        myStack.add(1);
        myStack.add(2);
        myStack.add(3);
        myStack.add(4);

        System.out.println(myStack.median());
    }

    public static void main(String[] args) {
        new Ideone1().run();
    }
}
