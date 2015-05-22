package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-3-10
 * Time: 上午9:27
 * To change this template use File | Settings | File Templates.
 */
public class AddTwoNumber {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) return null;
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		int offset = 0;
		ListNode head = null;
		ListNode tail = null;
		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val + offset;
			if (sum >= 10) {
				sum -= 10;
				offset = 1;
			} else {
				offset = 0;
			}
			if (head == null) {
				head = new ListNode(sum);
				tail = head;
			} else {
				ListNode node = new ListNode(sum);
				if (tail != null) {
					tail.next = node;
				}
				tail = node;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int sum = l1.val + offset;
			if (sum >= 10) {
				sum -= 10;
				offset = 1;
			} else {
				offset = 0;
			}
			ListNode node = new ListNode(sum);
			if (tail != null) {
				tail.next = node;
			}
			tail = node;
			l1 = l1.next;
		}
		while (l2 != null) {
			int sum = l2.val + offset;
			if (sum >= 10) {
				sum -= 10;
				offset = 1;
			} else {
				offset = 0;
			}
			ListNode node = new ListNode(sum);
			if (tail != null) {
				tail.next = node;
			}
			tail = node;
			l2 = l2.next;
		}
		//{5}, {5}
		if (offset != 0) {
			ListNode node = new ListNode(offset);
			tail.next = node;
			tail = node;
			tail.next = null;
		}
		return  head;
	}

	public class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public void doTest() {
		ListNode l1 = new ListNode(2);
		ListNode n1 = new ListNode(4);
		ListNode n2 = new ListNode(3);
		l1.next = n1;
		n1.next = n2;
		ListNode l2 = new ListNode(5);
		ListNode m1 = new ListNode(6);
		ListNode m2 = new ListNode(4);
		l2.next = m1;
		m1.next = m2;
		ListNode result = addTwoNumbers(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
	}

	public static void main(String[] args) {
		AddTwoNumber addTwoNumber = new AddTwoNumber();
		addTwoNumber.doTest();

	}
}
