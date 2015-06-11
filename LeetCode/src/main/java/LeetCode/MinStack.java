package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: author
 * Date: 15-6-10
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 *
 *
 */

class MinStackA {
    // stack: store the stack numbers
    private Stack<Integer> stack = new Stack<Integer>();
    // minStack: store the current min values
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        // store current min value into minStack
        if (minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        // use equals to compare the value of two object, if equal, pop both of them
        if (stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


class MinStack {
    Node top = null;

    public void push(int x) {
        if (top == null) {
            top = new Node(x);
            top.min = x;
        } else {
            Node temp = new Node(x);
            temp.next = top;
            top = temp;
            top.min = Math.min(top.next.min, x);
        }
    }

    public void pop() {
        top = top.next;
        return;
    }

    public int top() {
        return top == null ? 0 : top.val;
    }

    public int getMin() {
        return top == null ? 0 : top.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MinStackC {
    private int[] arr = new int[100];
    private int index = -1;

    public void push(int x) {
        if(index == arr.length - 1){
            arr = Arrays.copyOf(arr, arr.length * 2);
        }
        arr[++index] = x;
    }

    public void pop() {
        if(index>-1){
            if(index == arr.length/2 && arr.length > 100){
                arr = Arrays.copyOf(arr, arr.length/2);
            }
            index--;
        }
    }

    public int top() {
        if(index > -1){
            return arr[index];
        }else{
            return 0;
        }
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=index; i++){
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
}
