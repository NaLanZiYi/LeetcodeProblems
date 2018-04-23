package simple;

public class RemoveNthNodeFromList_19 {
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	//讨论区-1：维持两个距离为n+1的指针，当快指针到达末尾时，慢指针刚好在n+1的位置，正好在要被删除的节点前面
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode start = new ListNode(0);
		ListNode slow = start, fast = start;
		slow.next = head;
		for(int i=1;i<=n+1;i++){
			fast = fast.next;
		}
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		//第二种方式：如果for循环里后移了n次，则while循环条件需要变成fast.next!=null
		slow.next=slow.next.next;
		return start.next;
    }
}
