public class One {
    public static double findMedian(int[] list1, int[] list2) {
        if (list1.length > list2.length) {
            return findMedian(list2, list1);
        }

        int totalLength = list1.length + list2.length;
        int halfLength = (totalLength + 1) / 2;
        int low = 0;
        int high = list1.length;

        while (low <= high) {
            int partitionList1 = (low + high) / 2;
            int partitionList2 = halfLength - partitionList1;
            int maxLeftList1 = partitionList1 == 0 ? Integer.MIN_VALUE : list1[partitionList1 - 1];
            int minRightList1 = partitionList1 == list1.length ? Integer.MAX_VALUE : list1[partitionList1];
            int maxLeftList2 = partitionList2 == 0 ? Integer.MIN_VALUE : list2[partitionList2 - 1];
            int minRightList2 = partitionList2 == list2.length ? Integer.MAX_VALUE : list2[partitionList2];

            if (maxLeftList1 <= minRightList2 && maxLeftList2 <= minRightList1) {
                if (totalLength % 2 == 0) {
                    return (Math.max(maxLeftList1, maxLeftList2) + Math.min(minRightList1, minRightList2)) / 2.0;
                } else {
                    return Math.max(maxLeftList1, maxLeftList2);
                }
            } else if (maxLeftList1 > minRightList2) {
                high = partitionList1 - 1;
            } else {
                low = partitionList1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or of unequal length");
    }

    public static void main(String[] args) {
        int[] list1 = {3, 5, 8, 9};
        int[] list2 = {2, 6, 10, 12};

        double median = findMedian(list1, list2);
        System.out.println("The median is: " + median);
    }
}
