package medium;

import java.util.Random;

public class LinkedListRandomNode_382 {
	private ListNode head;
	/**
	 * Definition for singly-linked list.*/
	  public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }
	 
	
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public LinkedListRandomNode_382(ListNode head) {
	    this.head = head;
	}
	
	/** Returns a random node's value. */
	//������-����1����ˮ�س����㷨
	public int getRandom() {
		Random rand = new Random();
	    ListNode node = head;
	    int r = node.val;
	    for(int i=1;node.next!=null;i++){
	    	node = node.next;
	    	if(rand.nextInt(i+1)==i){
	    		r = node.val;
	    	}
	    }
	    return r;
	}
	
	//������-����2������1�ı���
	public int getRandom1() {
		Random rand = new Random();
		ListNode node = head;
		ListNode cur = head;
		int count = 1;
		while(cur!=null){
			//����ÿ��Ԫ�ر����صĸ��ʶ���ͬ�����Կ��Լ򵥵�ѡ��������Ƿ�Ϊ0������rand.nextInt(count+1)==count
			if(rand.nextInt(count)==0){
				node = cur;
			}
			cur = cur.next;
			count++;
		}
		return node.val;
	}
}
