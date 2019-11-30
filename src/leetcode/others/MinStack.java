package leetcode.others;

/**
 * @author whl
 * @date 2019/10/13 2:42 下午
 * <p>
 * 实现栈
 */
public class MinStack {
    Node head;
    Node tail;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (head == null) {
            Node node = new Node(x, null, null);
            head = node;
            tail = node;
        } else {
            Node node = new Node(x, tail, null);
            tail.next = node;
            tail = node;
        }
    }

    public void pop() {
        if (head == null) return;
        if(tail.pre != null){
            Node temp = tail;
            tail = temp.pre;
            tail.next = null;
            temp.pre = null;
        }else {
            head = null;
            tail = null;
        }
    }

    public int top() {
        if(tail != null) return tail.val;
        return -1;
    }

    public int getMin() {
        Node p = head;
        int min = Integer.MAX_VALUE;
        while(p != null){
            if(p.val < min) min = p.val;
            p = p.next;
        }
        return min;
    }

    class Node {
        int val;
        Node pre;
        Node next;

        public Node(int val, Node pre, Node next) {
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
    }
}
