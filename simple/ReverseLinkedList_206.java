package simple;

public class ReverseLinkedList_206 {
	public ListNode reverseList(ListNode head) {
		
//		if(head==null) return null;
//        ListNode cur=head,pre=cur;
//        head=head.next;
//        while(head!=null){
//        	cur=head;
//        	head=head.next;
//        	cur.next=pre;
//        	pre=cur;
//        }
//        return cur;
		//杩唬瀹炵幇
        ListNode pre=null,next=null;
        while(head!=null){
        	next=head.next;
        	head.next=pre;
        	pre=head;
        	head=next;
        }
        return pre;
    }
	
	public ListNode reverseList1(ListNode head) {
		//閫掑綊瀹炵幇
		return reverse(head,null);
	}
	
	public ListNode reverse(ListNode node,ListNode pre){
		if(node==null) return pre;
		ListNode node2=node.next;
		node.next=pre;
		pre=node;
		return reverse(node2, node);
	}
	
	//璁ㄨ鍖?:鍙︿竴绉嶉?掑綊瀹炵幇
	public ListNode reverseList2(ListNode head) {
		//閫掑綊瀹為檯涓婃槸浠庢渶鍚庝竴涓紑濮嬪線鍓嶆墽琛岋紝鐩稿綋浜庤鎵惧埌鏈?灏鹃儴鐨勮妭鐐逛綔涓哄ご缁撶偣tail锛?
		//姣忔閫掑綊灏辫祴鍊间簡tail->next鐨勫??
		if(head==null||head.next==null) return head;
		ListNode node=reverseList2(head.next);
		head.next.next=head;  //灏嗛摼琛ㄨ繛鎺ヨ捣鏉?
		head.next=null;   //鍙湪绗竴娆￠?掑綊璋冪敤鏈夌敤锛屾墍鏈夐?掑綊杩斿洖鍚庯紝灏嗗熬缁撶偣鐨勪笅涓?涓厓绱犲鍒朵负绌?
		return node;    
	}
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	}
}

 	

