package Generics;

import java.util.*;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getsecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

class Stack<T> {
    private ArrayList<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty()) {
            System.out.println("Stack is Empty");
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }
}

class Repository<T> {
    private ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void display() {
        for (T item : data) {
            System.out.println(item);
        }
    }
}

class Utility {
    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T value : arr) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }

        return max;
    }

    // Wildcard Method
    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

// Main Class
public class Main {

    public static void main(String[] args) {

        // Pair
        Pair<String, Integer> pair = new Pair<>("Age", 21);
        System.out.println("Pair: " + pair);

        // Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());

        // findMax
        Integer[] numbers = { 10, 50, 30, 80, 40 };
        System.out.println("Maximum = " + Utility.findMax(numbers));

        // Repository
        Repository<String> repository = new Repository<>();
        repository.add("Laptop");
        repository.add("Mobile");
        repository.add("Tablet");

        System.out.println("Repository Data:");
        repository.display();

        // Wildcard
        List<String> names = Arrays.asList("Anjali", "Rahul", "Priya");
        System.out.println("Printing List:");
        Utility.printList(names);
    }
}
