package simple;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists_160 {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while(headA!=null) {
        	set.add(headA);
        	headA = headA.next;
        }
        while(headB!=null){
        	if(set.contains(headB)) return headB;
        	else headB = headB.next;
        }
        return null;
    }
	
	//讨论区-方法1：厉害了我的哥哥
	//核心思想：两个指针同时遍历两个链表，当一个链表到达末尾null时，将指针指向另一个链表继续遍历,每个指针都遍历m+n次
	//运行时间复杂度O(m+n),即使两个链表长度不同，也将会相遇（要么为null，要么到达交叉节点）
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) return null;
		ListNode a = headA;
		ListNode b = headB;
		while(a!=b){
			a = a==null ? headB : a.next;
			b = b==null ? headA : b.next;
		}
		return a;
	}
	
	//讨论区-方法2：将两个链表按照长度小的对齐，然后同时遍历
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		int lenA = length(headA);
		int lenB = length(headB);
		while(lenA>lenB){
			 headA = headA.next;
			 lenA--;
		}
		while(lenB>lenA){
			headB = headB.next;
			lenB--;
		}
		while(headA!=headB){
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode head) {
		int len = 0;
		while(head!=null){
			len++;
			head = head.next;
		}
		return len;
	}
	
	//讨论区-方法3：将两个链表相连，采用快慢指针，如果有环，必定能找到
	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) return null;
		// find last node of list A (c3)
		ListNode endA = headA;
		while (endA.next != null) {
			endA = endA.next;
		}
		// join c3 to b1 making a c1...c3-b1...b3-c1 loop (if b3 indeed points to c1)
		endA.next = headB;

		ListNode start = null; // if there's no cycle this will stay null
		// Floyd's cycle finder
		ListNode slow = headA, fast = headA;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // found a cycle
				// reset to beginning to find cycle start point (c1)
				start = headA;
				while (slow != start) {
					slow = slow.next;
					start = start.next;
				}
				break;
			}
		}
		//恢复链表A的结构
		endA.next = null;
		return start;
	}
	
	//讨论区-方法4：修改链表结构，先计算B的所有节点值，然后将A所有节点值+1，再次计算B所有节点值，若有变化，则有交叉
	//注意要修复修改的链表
	public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
		if(headA==null||headB==null) return null;
		int countb1 = 0;
		int lenb = 0;
		ListNode a = headA, b = headB;
		while(b!=null){
			countb1 += b.val;
			b = b.next;
			lenb++;
		}
		while(a!=null){
			a.val += 1;
			a = a.next;
		}
		b = headB;
		int countb2 = 0;
		while(b!=null){
			countb2 += b.val;
			b = b.next;
		}
		//还原链表A
		a = headA;
		while(a!=null){
			a.val -= 1;
			a = a.next;
		}
		if(countb1==countb2) return null;
		b = headB;
		for(int i=0;i<lenb-(countb2-countb1);i++){
			b = b.next;
		}
		return b;
	}
}
