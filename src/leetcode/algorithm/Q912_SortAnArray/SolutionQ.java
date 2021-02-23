package leetcode.algorithm.Q912_SortAnArray;

public class SolutionQ {
    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int pivotIdx = partition(nums, left, right);
        quickSort(nums, left, pivotIdx - 1);
        quickSort(nums, pivotIdx+1, right);
    }

    private int partition(int[] nums, int left, int right){
        int pivotIdx = left + (int)(Math.random() * (right - left + 1));
        int pivot = nums[pivotIdx];
        swap(nums, pivotIdx, right);
        int lb = left;
        int rb = right - 1;
        while(lb <= rb){
            if(nums[lb] < pivot){
                lb ++;
            }else if(nums[rb] >= pivot){
                rb --;
            } else{
                swap(nums, lb++, rb--);
            }

        }
        swap(nums, lb, right);
        return lb;

    }
    private void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
