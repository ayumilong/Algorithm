/**
 * File Name: SearchInABigSortedArray.java
 * Package Name: yz.lintcode
 * Project Name: LeetCode
 * Purpose:
 * Created Time: 6:52:45 PM Jan 13, 2016
 * Author: Yaolin Zhang
 */
package yz.lintcode;

/**
 * @author Yaolin Zhang
 * @time 6:52:45 PM Jan 13, 2016
 */
public class SearchInABigSortedArray {
	private class ArrayReader {
		// get the number at index, return -1 if not exists.
		public int get(int index) {
			return 0;
		}
	}

    public int searchBigSortedArray(ArrayReader reader, int target) {
        int low = 0;
        int high = 1;
        while (reader.get(high) != -1 && reader.get(high) < target){
            low = high;
            high *= 2;
        }
        ++high;
        while (low < high){
            int middle = (low + high) / 2;
            if (reader.get(middle) == target && (middle == 0 || reader.get(middle - 1) < target)){
                return middle;
            }
            if (reader.get(middle) >= target || reader.get(middle) == -1){
                high = middle;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

	public int searchBigSortedArray1(ArrayReader reader, int target) {
		int low = 0;
		int high = target;
		while (reader.get(high) != -1 && reader.get(high) < target) {
			low = high;
			high += target;
		}
		while (low < high) {
			int middle = (low + high) / 2;
			if (reader.get(middle) == target && (middle == 0 || reader.get(middle - 1) < target)) {
				return middle;
			}
			if (reader.get(middle) >= target || reader.get(middle) == -1) {
				high = middle;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}
}
