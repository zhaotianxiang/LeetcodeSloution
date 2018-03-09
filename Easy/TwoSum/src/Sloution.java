import java.util.HashMap;
import java.util.Map;

public class Sloution {
    /**
     * @param nums 已知数组
     * @param target 两个数之和
     * @return 数组中两个数的位置
     */
    public int[] twoSum(int [] nums,int target){
        //首先构造哈希表，将所有的数组值存入哈希表
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length ; i++)
        {
            map.put(nums[i],i);
        }
        //主要算法如下，依次循环，在循环中判断哈希表中是否有满足条件的值
        for(int i = 0; i < nums.length; i++)
        {
            int complement = target - nums[i];
            if(map.containsKey(complement)&&map.get(complement)!=i)
            {
                return new int[] {i,map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
