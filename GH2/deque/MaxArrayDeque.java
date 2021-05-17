package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        comparator = c;
    }

    public T max() {

        if (this.isEmpty()) {
            return null;

        } else {

            T currMax = this.get(0);

            for (int i = 0; i < this.size(); i += 1) {

                if (comparator.compare(this.get(i), currMax) > 0) {
                    currMax = this.get(i);
                } else {
                    continue;
                }
            }
            return currMax;
        }
    }

    public T max(Comparator<T> c) {

        if (this.isEmpty()) {
            return null;

        } else {
            T currMax = this.get(0);
            for (int i = 0; i < this.size(); i += 1) {
                if (c.compare(this.get(i), currMax) > 0) {
                    currMax = this.get(i);
                } else {
                    continue;
                }

            }

            return currMax;
        }
    }
}
