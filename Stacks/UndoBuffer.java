package Stacks;

class UndoBuffer {
    private String[] data;
    private int top;

    UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    boolean push(String edit) {
        if (top == data.length - 1) {
            System.out.println("Undo Buffer Full");
            return false;
        }
        data[++top] = edit;
        return true;
    }

    String pop() {
        if (isEmpty())
            throw new RuntimeException("Nothing to undo");
        return data[top--];
    }

    String peek() {
        if (isEmpty())
            throw new RuntimeException("Undo Buffer is empty");
        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBuffer buffer = new UndoBuffer(3);

        buffer.push("Edit 1");
        buffer.push("Edit 2");
        buffer.push("Edit 3");

        System.out.println("Top Edit: " + buffer.peek());
        System.out.println("Undo: " + buffer.pop());
        System.out.println("Top After Undo: " + buffer.peek());

        buffer.push("Edit 4");

        while (!buffer.isEmpty()) {
            System.out.println(buffer.pop());
        }
    }
}