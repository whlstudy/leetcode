package leetcode.arrays;

import java.util.*;

/**
 * @author whl
 * @date 2019/11/8 3:05 下午
 */
public class MedianFinder {
    List<Integer> arr;

    /**
     * initialize your data structure here.
     */
    /*public MedianFinder() {
        arr = new ArrayList<>();
    }

    // 列表插入时间复杂度过高
    public void addNum(int num) {
        int i = Collections.binarySearch(arr, num);
        if (i < 0) arr.add(-i - 1, num);
        else
            arr.add(i, num);
    }

    public double findMedian() {
        int num = arr.size() / 2;
        if (arr.size() % 2 != 0) return arr.get(num);
        else
            return ((arr.get(num - 1) + arr.get(num)) * 1.0) / 2;
    }*/
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(6);
        medianFinder.addNum(4);
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
    }

    // use heap
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>();
        minHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    private void rebalance() {
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    public void addNum(int num) {
        if (minHeap.size() == 0 || minHeap.peek() > num) {
            minHeap.add(num);
        } else
            maxHeap.add(num);

        rebalance();
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek() + maxHeap.peek()) * 1.0 / 2;

        return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
    }

}
