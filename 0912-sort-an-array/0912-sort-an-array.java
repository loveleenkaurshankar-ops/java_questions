class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];

        int l = left;
        int j = mid + 1;
        int k = 0;

        while (l <= mid && j <= right) {
            if (nums[l] <= nums[j]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (l <= mid) {
            temp[k++] = nums[l++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            nums[left + x] = temp[x];
        }
    }
}