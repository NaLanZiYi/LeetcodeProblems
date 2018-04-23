package medium;

public class OddEvenLinkedList_328 {
	
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	
	public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode odd = head, even = head.next;
        ListNode evencopy = even;
        while(odd!=null&&even!=null){
        	if(even.next!=null){
        		odd.next = even.next;
        		odd = odd.next;
        		if(odd.next!=null){
        			even.next = odd.next;
        			even = even.next;
        		}else{
        			//*****注意这里：需要在只有奇数个节点时让尾部节点的next为空，否则会出现内存泄漏问题*****
        			even.next = null;
        			break;
        		}
        	}else{
        		break;
        	}        	
        }
        odd.next=evencopy;
        return head;
    }
	
	//讨论区-方法1
	public ListNode oddEvenList1(ListNode head) {
		if(head!=null){
			ListNode odd = head, even = head.next, evencopy = even;
			while(even!=null&&even.next!=null){
				odd.next = odd.next.next;
				even.next = even.next.next;
				//odd不会为null，但是even可能为null
				odd = odd.next;
				even = even.next;
			}
			odd.next = evencopy;
		}
		return head;
	}
}
