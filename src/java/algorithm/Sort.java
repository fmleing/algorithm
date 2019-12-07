package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sort {
    public static void main(String[] args){
        List<Integer> sorts = new ArrayList<Integer>();
        sorts.add(1);
        sorts.add(5);
        sorts.add(4);
        sorts.add(7);
        sorts.add(2);
        sorts.add(9);
        sorts.add(0);
        shellSort(sorts,0,sorts.size());
        System.out.println(sorts.size());
        for (int i = 0; i < sorts.size(); i++) {
            System.out.println(sorts.get(i));
        }
    }

    public static List<Integer> bubbleSort(List<Integer> sorts) {
        // isLoop 是判断排序中是否存在置换数据的情况，如果不存在，说明数组已经是有序的，直接退出即可。
        boolean isLoop = true;
        for (int i = sorts.size()-1; isLoop && i > 0; i--) {
            // 将标志位置为false，是为了下面如果没有比较时服务。
            isLoop = false;
            for (int j = 0; j < i; j++) {
                // 比较相邻两个数
                if (sorts.get(j) > sorts.get(j + 1)) {
                    isLoop = true;
                    swap(sorts,j,j+1);
                }
            }
        }
        return sorts;
    }

    public static void swap(List<Integer> sorts, int a, int b) {
        int temp = sorts.get(a);
        sorts.set(a, sorts.get(b));
        sorts.set(b, temp);
    }

    // 选择排序 O(N2) 不稳定  （不稳定的原因是如果有个元素a比当前元素b小，并且这个b有个相等数值的元素c,而a在c的后面那么排序完成后
    // b会在c的后面
    public static List<Integer> selectSort(List<Integer> sorts) {
        for (int i = 0; i < sorts.size(); i++) {
            // 初始化最小元素
            int minIndex = i;

            for (int j = i; j < sorts.size(); j++) {
                if (sorts.get(j) < sorts.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(sorts, minIndex, i);
            }
        }
        return sorts;
    }

    // 快速排序 错误
    public static List<Integer> quiteSortErr(List<Integer> sorts,int begin,int end) {
        if (begin >= end) {
            return sorts;
        }
        // 选择基准
        int mid = begin;
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();

        int midValue = sorts.get(mid);
        for (int i = begin; i < end; i++) {
            if (sorts.get(i) < midValue) {
                leftList.add(sorts.get(i));
            }else{
                rightList.add(sorts.get(i));
            }
        }
        leftList = quiteSortErr(leftList, 0, leftList.size() - 1);
        rightList = quiteSortErr(rightList, 0, rightList.size() - 1);
        sorts = new ArrayList<Integer>();
        sorts.addAll(leftList);
        sorts.addAll(rightList);
        return sorts;
    }

    // 快速排序 正确  老版
    public static List<Integer> quiteSortOld(List<Integer> sorts, int begin, int end) {

        // 递归出口
        if (begin >= end - 1) {
            return sorts;
        }
        // 基本位置
        int tagIndex = begin;
        int tagValue = sorts.get(tagIndex);
        while (begin < end) {
            // 从后判断
            while (begin < end) {
                if (sorts.get(end) < tagValue) {
                    sorts.set(begin++, sorts.get(end));
                    break;
                }
                --end;
            }

            // 从头判断
            while (begin < end) {
                if (sorts.get(begin) > tagValue) {
                    sorts.set(end--, sorts.get(begin));
                    break;
                }
                ++begin;
            }
        }
        // 划分
        // 替换
        tagIndex = begin;
        sorts.set(tagIndex, tagValue);
        quiteSortOld(sorts, 0, begin);
        quiteSortOld(sorts, begin, end);
        return sorts;
    }

    // 快速排序 正确  新版
    public static List<Integer> quiteSort(List<Integer> sorts, int begin, int end) {
        if (begin < end - 1) {
            int partition = partition(sorts, begin, end);
            quiteSort(sorts, begin, partition-1);
            quiteSort(sorts, partition+1, end);
        }
        return sorts;
    }

    // 划分大小  小于这个数的放左边  大于这个数的放右边
    public static Integer partition(List<Integer> sorts, int left, int right) {
        int pivot = left;
        int index = left+1;

        for (int i = index; i <= right; i++) {
            if (sorts.get(i) < sorts.get(pivot)) {
                // 置换
                swap(sorts, i, index);
                index++;
            }
        }
        swap(sorts, pivot, index - 1);
        return index - 1;
    }

    // 插入排序
    public static List<Integer> insertSort(List<Integer> sorts) {
        for (int i = 0; i < sorts.size(); i++) {
            int temp = sorts.get(i);
            int swapIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (sorts.get(j) > temp) {
                    sorts.set(swapIndex, sorts.get(j));
                    swapIndex = j;
                }
            }
            sorts.set(swapIndex, temp);
        }
        return sorts;
    }

    // 希尔排序  插入排序的加强版  增加步数这一概念
    public static List<Integer> shellSort(List<Integer> sorts, int begin, int end) {
        for (int step = (end - begin) / 2; step > 0; step /= 2) {
            // 组数
            for (int group = begin; group < begin + step; group++) {
                int nextIndex = group + step;
                // 类似插入排序
                for (int i = nextIndex; i < end; i+=nextIndex) {
                    for (int j = i-step; j >= begin; j -= nextIndex) {
                        if (sorts.get(j + step) < sorts.get(j)) {
                            swap(sorts, j + step, j);
                        }
                    }
                }
            }
        }
        return sorts;
    }

}
