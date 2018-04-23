package simple;
import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray_88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i<m&&j<n){
        	if(nums1[i]<nums2[j]) list.add(nums1[i++]);
        	else list.add(nums2[j++]);
        }
        while(i<m) list.add(nums1[i++]);
        while(j<n) list.add(nums2[j++]);
        i = 0;
        while(i<list.size()) nums1[i] = list.get(i++);        
    }
	
	//讨论区-方法1：从后往前
	//由于nums1空间够大，从m+n-1的位置开始往前，不会覆盖nums1的元素造成元素丢失
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i>=0&&j>=0){
			if(nums1[i]>nums2[j]) nums1[k--] = nums1[i--];
			else nums1[k--] = nums2[j--];
		}
		//两种情况，如果nums2已结遍历完，由于nums1已经排好序，就不用再遍历，如果nums1遍历完，直接将nums2加到nums1即可
		//所以在这里只需要判断nums2是否遍历完
		while(j>=0) nums1[k--] = nums2[j--];
	}
	
	//讨论区-方法1：同上，但是稍有不同
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int i = m-1;
		int j = n-1;
		int k = m+n-1;
		while(i>=0&&j>=0){
			if(i<0||nums1[i]<nums2[j]) nums1[k--] = nums2[j--];
			else nums1[k--] = nums1[i--];
		}
	}
}
