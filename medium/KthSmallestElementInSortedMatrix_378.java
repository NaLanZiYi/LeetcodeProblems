package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class KthSmallestElementInSortedMatrix_378 {
	//寻找第k阁最小值，包括重复值
	public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length*matrix[0].length<k) return 0;
        SortedSet<Integer> set = new TreeSet<>(new Comparator(){
			public int compare(Object arg0, Object arg1) {
				if((Integer)arg0<(Integer)arg1) return -1;
				else return 1;
			}        	
        });
       for(int i=0;i<matrix.length;i++){
    	   for(int j=0;j<matrix[0].length;j++){
    		   set.add(matrix[i][j]);
    		   if(set.size()>k) set.remove(set.last());  //这里删不掉元素，因而此方法有问题
    	   }
       }
       System.out.println(set.size());
       System.out.println(Arrays.toString(set.toArray()));
       System.out.println(set.last());
       set.remove(set.first());
       System.out.println(Arrays.toString(set.toArray()));
       return set.last();
    }
	
	//讨论区-方法1：二分法师
	public int kthSmallest1(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0], right = matrix[n-1][n-1];
		while(left<right){
			int mid = left+(right-left)/2;
			//二分查找小于等于mid的元素个数
			int count = 0, j = n-1;
			for(int i=0;i<n;i++){
				while(j>=0&&matrix[i][j]>mid) j--;
				count += j+1;				
			}
			//如果元素个数不够，则需要在比mid大的元素中继续寻找，否则在较小的元素中寻找以降低count
			if(count<k) left = mid+1;
			else right = mid;
		}
		return left;
	}
	
	//讨论区-方法2：最小堆
	 public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int bound = matrix.length < k ? matrix.length : k;
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int j = 0; j <= bound-1; j++) pq.offer(new Tuple(0, j, matrix[0][j]));
        for(int i = 0; i < k-1; i++) {
            Tuple t = pq.poll();
            if(t.x == n-1) continue;
            pq.offer(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return pq.poll().val;
	 }
	 
	 //讨论区-方法3：最小堆的变形
	 public int kthSmallest3(int[][] matrix, int k) {
		 int c = 0;
	        PriorityQueue<int[]> queue = new PriorityQueue<>(
	            k, (o1, o2) -> matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]]);
	        queue.offer(new int[] {0, 0});
	        while (true) {
	            int[] pair = queue.poll();
	            if (++c == k) {
	                return matrix[pair[0]][pair[1]];
	            }
	            if (pair[0] == 0 && pair[1] + 1 < matrix[0].length) {
	                queue.offer(new int[] {0, pair[1] + 1});
	            }
	            if (pair[0] + 1 < matrix.length) {
	                queue.offer(new int[] {pair[0] + 1, pair[1]});
	            }
	        }
	 }

	public static void main(String[] args) {
		KthSmallestElementInSortedMatrix_378 test = new KthSmallestElementInSortedMatrix_378();
		int a = test.kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8);
	}
	
	class Tuple implements Comparable<Tuple> {
	    int x, y, val;
	    public Tuple (int x, int y, int val) {
	        this.x = x;
	        this.y = y;
	        this.val = val;
	    }
	    
	    @Override
	    public int compareTo (Tuple that) {
	        return this.val - that.val;
	    }
	}
}
