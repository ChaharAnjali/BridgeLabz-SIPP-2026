package Graphs;

import java.util.*;

public class SparseFriendGraph {

    static Map<Integer, Set<Integer>> friendGraph = new HashMap<>();

    static void addFriendship(int u, int v) {

        friendGraph
                .computeIfAbsent(u, k -> new HashSet<>())
                .add(v);

        friendGraph
                .computeIfAbsent(v, k -> new HashSet<>())
                .add(u);
    }

    static boolean isFriend(int u, int v) {

        return friendGraph
                .getOrDefault(u, Collections.emptySet())
                .contains(v);
    }

    public static void main(String[] args) {

        addFriendship(1, 2);
        addFriendship(1, 3);
        addFriendship(2, 4);
        addFriendship(3, 5);

        System.out.println(friendGraph);

        System.out.println(
                "Is 1 friend with 3? "
                        + isFriend(1, 3));

        System.out.println(
                "Is 1 friend with 5? "
                        + isFriend(1, 5));
    }
}