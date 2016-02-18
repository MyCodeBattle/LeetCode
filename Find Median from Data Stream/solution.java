/*
 * 用两个优先队列，一个存从小到大一半的数，另一个存从大到小一半的数，每次根据奇偶直接取值。
 */

class MedianFinder {
    Queue<Integer> large = new PriorityQueue<>();
    Queue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());

    // Adds a number into the data structure.
    public void addNum(int num) {
        if (large.isEmpty() || num <= large.peek())
            small.offer(num);
        else
            large.offer(num);
        if (small.size() - large.size() == 2)
            large.offer(small.poll());
        if (large.size() > small.size())
            small.offer(large.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if ((small.size() + large.size()) % 2 == 1)
            return (double) small.peek();
        return ((double) small.peek() + large.peek()) / 2;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
