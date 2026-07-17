package Hashing;

import java.util.*;

public class User {

    public static int longestConsecutiveRun(int[] ids) {

        HashSet<Integer> idSet = new HashSet<>();

        for (int id : ids) {
            idSet.add(id);
        }

        int longest = 0;

        for (int id : idSet) {

            if (!idSet.contains(id - 1)) {

                int length = 1;
                int current = id;

                while (idSet.contains(current + 1)) {

                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ids = new int[n];

        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        System.out.println(longestConsecutiveRun(ids));

        sc.close();
    }
}
