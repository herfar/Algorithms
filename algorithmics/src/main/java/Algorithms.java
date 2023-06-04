

import java.util.*;

public class Algorithms {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2,3,4,5}, new int []{}));



    }


    // -----------------------------------------------------------------------------------------------------------------
    public static boolean isIntegerPalindrome(int a) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        return String.valueOf(a).equals(sb.reverse().toString());
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int[] countBits(int n) {
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            a[i] = (int) s.chars().filter(word -> word == '1').count();
        }
        return a;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int maxProfit(int[] prices) {
        int min_price = 1111110;
        int max_profit = -1111110;
        for (int price : prices) {
            min_price = Math.min(min_price, price);
            max_profit = Math.max(max_profit, price - min_price);
        }
        return max_profit;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static double findMaxAverage(int[] nums, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        double ans = -10000;
        double d = 0;
        for (Integer i : nums) {
            stack.addLast(i);
            if (stack.size() >= k) {
                stack.pollLast();
                d = d + i;
                ans = Math.max(ans, d / k);
            }
        }
        return ans;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static boolean isPerfectSquare(int num) {
        boolean d = false;
        if (num == 1) {
            return true;
        } else {
            for (int i = num / 2; i > 0; i--) {
                if (i * i == num) {
                    d = true;
                    break;
                }
            }
        }
        return d;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int addDigits(int num) {
        if (num == 0) return 0;
        else if (num % 9 == 0) return 9;
        else return num % 9;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;
        return Arrays.stream(s.split("")).filter(a -> a.equals("A")).count() < 2;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    if (i == j) continue;
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int romanToInt(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String[] h = s.split("");
            if (Objects.equals(h[i], "I")) count++;
            if (Objects.equals(h[i], "V")) count = count + 5;
            if (Objects.equals(h[i], "X")) count = count + 10;
            if (Objects.equals(h[i], "L")) count = count + 50;
            if (Objects.equals(h[i], "C")) count = count + 100;
            if (Objects.equals(h[i], "D")) count = count + 500;
            if (Objects.equals(h[i], "M")) count = count + 1000;
        }
        if (s.contains("IX")) count = count - 2;
        if (s.contains("IV")) count = count - 2;
        if (s.contains("XL")) count = count - 20;
        if (s.contains("XC")) count = count - 20;
        if (s.contains("CD")) count = count - 200;
        if (s.contains("CM")) count = count - 200;
        return count;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int lengthOfLastWord(String s) {
        String[] o = s.split(" ");
        return o[o.length - 1].length();
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int mySqrt(int x) {
        return (int) (x / Math.sqrt(x));
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for (int digit : digits) {
            sb.append(digit);
        }
        String[] s = String.valueOf(Integer.parseInt(sb.toString()) + 1).split("");
        int[] last = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            last[i] = Integer.parseInt(s[i]);
        }
        return last;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() == nums.length;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static HashMap<Integer, Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> findTheMostPopular = new HashMap<>();
        for (int num : nums) {
            if (findTheMostPopular.containsKey(num)) {
                findTheMostPopular.put(num, findTheMostPopular.get(num) + 1);
            } else {
                findTheMostPopular.put(num, 1);
            }
            // if (findTheMostPopular.get(num) > (nums.length/2)) return num;
        }
        return findTheMostPopular;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Integer j : nums) if (map.get(j) == 1) return j;
        return 0;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int[] singleNumber3(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        int [] a = new int[2];
        for (Integer i : nums) {
            if (count >= 1 && map.get(i) == 1) {
                a[1] = i;
                break;
            }
            if (map.get(i) == 1) {
                a[0] = i;
                count++;
            }
        }
        return a;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> repeated = new HashMap<>();
        int [] a = new int[k];
        int min = 100;
        int max = -100;
        int stop = 0;
        if (nums.length == 1) {
            a[0] = nums[0];
            return a;
        } else {
            for (Integer number : nums) {
                if (repeated.containsKey(number)) {
                    repeated.put(number, repeated.get(number) + 1);
                } else {
                    repeated.put(number, 1);
                }
                min = Math.min(min, repeated.get(number));
                max = Math.max(max, repeated.get(number));
            }
            for (Map.Entry<Integer, Integer> entry : repeated.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                if (k == 1) {
                    break;
                } else if (value > min && value <= max) {
                    a[stop++] = key;
                } else if (min == max) {
                    a[stop++] = key;
                }
            }
        }
        return a;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static boolean isAnagram(String s, String t) {
        HashMap<String, Integer> first = new HashMap<>();
        HashMap<String, Integer> second = new HashMap<>();

        for (String i : s.split("")) {
            if (first.containsKey(i)) {
                first.put(i, first.get(i) + 1);
            } else {
                first.put(i, 1);
            }
        }
        for (String i : t.split("")) {
            if (second.containsKey(i)) {
                second.put(i, second.get(i) + 1);
            } else {
                second.put(i, 1);
            }
        }
        return first.equals(second);
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String [] one = s.toLowerCase().replace(" ", "").split("[^a-zA-Z0-9]");
        for (String value : one) {
            sb.append(value);
        }
        String str = String.valueOf(sb);
        return str.contentEquals(sb.reverse());
    }
    // -----------------------------------------------------------------------------------------------------------------

    // Сортировка слиянием
    public static void sortMerge(int [] a) {
        int n = a.length;
        if (n == 1) return;

        int mid = n/2;
        int [] l = new int[mid];
        int [] r = new int[n-mid];
        System.arraycopy(a, 0, l, 0, mid);
        if (n - mid >= 0) System.arraycopy(a, mid, r, 0, n - mid);

        sortMerge(l);
        sortMerge(r);
        merge(a, l, r);
    }
    private static void merge(int[] a, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (l[i] < r[j]) {
                a[idx] = l[i];
                i++;
            } else {
                a[idx] = r[j];
                j++;
            }
            idx++;
        }
        for (int ll = i; ll < left; ll++) a[idx++] = l[ll];
        for (int rr = j; rr < right; rr++) a[idx++] = r[rr];
    }
    //Конец сортировки слиянием
    // -----------------------------------------------------------------------------------------------------------------

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        sort(nums1);
    }
    public static void sort (int [] b) {
        int n = b.length;
        if (n == 1) return;

        int middle = n/2;
        int [] l = new int[middle];
        int [] r = new int[n-middle];

        System.arraycopy(b, 0, l, 0, middle);
        if (n - middle >= 0) System.arraycopy(b, middle, r, 0, n - middle);

        sort(l);
        sort(r);
        secondMerge(b, l, r);
    }
    private static void secondMerge(int[] a, int[] l, int[] r) {
        int left = l.length;
        int right = r.length;
        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right) {
            if (l[i] < r[j]) {
                a[idx] = l[i];
                i++;
            } else {
                a[idx] = r[j];
                j++;
            }
            idx++;
        }
        for (int ll = i; ll < left; ll++) a[idx++] = l[ll];
        for (int rr = j; rr < right; rr++) a[idx++] = r[rr];
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0 && i % 5 != 0) {
                list.add("Fizz");
            } else if (i % 5 == 0 && i % 3 != 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    // -----------------------------------------------------------------------------------------------------------------
    public static int arraySign(int[] nums) {
        int ifNegative = 0;
        int ifZero = 0;
        for (int num : nums) {
            if (num < 0) ifNegative++;
            if (num == 0) ifZero++;
        }
        if (ifNegative%2 == 0 && ifZero == 0) return 1;
        if (ifZero > 0) return 0;
        return -1;
    }
    // -----------------------------------------------------------------------------------------------------------------

    //Given two sorted arrays nums1 and nums2 of size m and n respectively,
    // return the median of the two sorted arrays.
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int [] sumArr = new int[m+n];
        System.arraycopy(nums1, 0, sumArr, 0, nums1.length);
        System.arraycopy(nums2, 0, sumArr, m, n);
        Arrays.sort(sumArr);
        int median = sumArr.length/2;
        if (sumArr.length == 2) return (double) (sumArr[0] + sumArr[1])/2;
        if (sumArr.length % 2 != 0) return sumArr[median];
        return (double) (sumArr[median] + sumArr[median-1])/2;
    }
    // -----------------------------------------------------------------------------------------------------------------
}
