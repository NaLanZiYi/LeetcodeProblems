package simple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


/**
 * 鎵惧嚭涓や釜鏁扮粍鐨勪氦鍙夋暟瀛?
 * @author Dian
 *
 */
public class TreeIntersection_349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[]{};
        Set nums1Set = new HashSet<>(Arrays.asList(nums1));
        Set nums2Set = new HashSet<>(Arrays.asList(nums2));
        int tempInt =0;
        List result = new ArrayList<Integer>();
        
        Iterator iterator = nums1Set.iterator();
        while(iterator.hasNext()){
        	//鎶ラ敊----I cannot be cast to java.lang.Integer
        	tempInt=(int) iterator.next();
        	if(nums2Set.contains(tempInt)){
        		result.add(tempInt);
        	}
        }
        int[] resultArr= new int[result.size()];
        for(int i=0;i<result.size();i++){
        	resultArr[i]=(int) result.get(i);
        }
        return resultArr;
    }
	
	
	//鍒╃敤set鑷姩鍘婚櫎閲嶅鍏冪礌鐨勭壒鎬?
	public int[] intersection1(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[]{};
        
        Set<Integer> nums1Set = new HashSet<Integer>();
        Set<Integer> nums2Set = new HashSet<Integer>();
        for(int i:nums1){
        	nums1Set.add(i);
        }
        for(int j:nums2){
        	nums2Set.add(j);
        }
        int tempInt =0;
        List<Integer> result = new ArrayList<Integer>();
        
        Iterator<Integer> iterator = nums1Set.iterator();
        while(iterator.hasNext()){
        	tempInt=(int) iterator.next();
        	if(nums2Set.contains(tempInt)){
        		result.add(tempInt);
        	}
        }
        int[] resultArr= new int[result.size()];
        for(int i=0;i<result.size();i++){
        	resultArr[i]=(int) result.get(i);
        }
        return resultArr;
    }
	
	//鏉ヨ嚜璁ㄨ鍖?--鍑忓皯閬嶅巻娆℃暟
	public int[] intersection2(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[]{};
        
        Set<Integer> nums1Set = new HashSet<Integer>();
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int i:nums1){
        	nums1Set.add(i);
        }
        //杩欓噷灏辩洿鎺ュ彲浠ュ垽鏂氦鍙夊厓绱犱簡
        for(int j:nums2){
        	if(nums1Set.contains(j)){
        		//鍒╃敤set鐨勪笉閲嶅鐗规??
        		resultSet.add(j);
        	}
        }
        int k=0;
        int[] resultArr= new int[resultSet.size()];
        for(int i : resultSet){
        	resultArr[k++]=i;
        }
        return resultArr;
    }
	
	//杩樺彲浠ュ厛瀵规暟缁勮繘琛屾帓搴忥紝鐒跺悗閬嶅巻
	public int[] intersection3(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> resultSet = new HashSet<Integer>();
        int i=0,j=0;
        while(i<nums1.length&&j<nums2.length){
        	if(nums1[i]<nums2[j]){
        		i++;
        	}else if(nums1[i]>nums2[j]){
        		j++;
        	}else{
        		resultSet.add(nums1[i]);
        		i++;
        		j++;
        	}        	
        }
        int k=0;
        int[] resarr=new int[resultSet.size()];
        for(int m:resultSet){
        	resarr[k++]=m;
        }
        return resarr;
    }
		
	public static void main(String[] args){
		new TreeIntersection_349().intersection(new int[]{1}, new int[]{1});
	}
}
