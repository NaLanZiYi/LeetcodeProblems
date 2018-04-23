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
        			//*****ע�������Ҫ��ֻ���������ڵ�ʱ��β���ڵ��nextΪ�գ����������ڴ�й©����*****
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
	
	//������-����1
	public ListNode oddEvenList1(ListNode head) {
		if(head!=null){
			ListNode odd = head, even = head.next, evencopy = even;
			while(even!=null&&even.next!=null){
				odd.next = odd.next.next;
				even.next = even.next.next;
				//odd����Ϊnull������even����Ϊnull
				odd = odd.next;
				even = even.next;
			}
			odd.next = evencopy;
		}
		return head;
	}
}
