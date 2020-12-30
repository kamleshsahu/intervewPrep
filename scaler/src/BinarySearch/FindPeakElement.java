package BinarySearch;

public class FindPeakElement {

    public int solve(int[] A) {
        return A[search(A, 0, A.length - 1)];
    }

    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
