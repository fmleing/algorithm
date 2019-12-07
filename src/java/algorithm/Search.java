package algorithm;

import java.util.List;

public class Search {

    public static void main(String[] args) {

    }

    // 顺序查找
    public static Integer orderSearch(List<Integer> searchs,Integer searchValue){
        // 一个一个查找
        for (int i = 0; i < searchs.size() ; i++) {
            if (searchs.get(i).equals(searchValue)) {
                return i;
            }
        }
        return -1;
    }

    // 二分查找
    public static Integer binarySearch(List<Integer> searchs, Integer searchValue) {
        // 如果查找集合没有顺序，先进行排序
        // 这里针对有顺序的集合进行查找
        int len = searchs.size();
        int begin = 0;
        int end = len-1;
        while ( begin < end ) {
            int mid = begin + (end - begin) / 2;
            int midValue = searchs.get(mid);
            if (midValue == searchValue) {
                return mid;
            } else if (midValue > searchValue) {
                end = mid-1;
            }else{
                begin = mid+1;
            }
        }
        return -1;
    }

    // 插值查找  mid=low+(key-a[low])/(a[high]-a[low])*(high-low) 核心

    // 优缺点 ： 1. 对于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找, 速度较快.
    //2. 关键字分布不均匀的情况下，该方法不一定比折半查找要好


}
