package Stacks;

class CallStack {

    private static class Frame {
        String functionName;
        Frame next;

        Frame(String functionName, Frame next) {
            this.functionName = functionName;
            this.next = next;
        }
    }

    private Frame top = null;

    void push(String functionName) {
        top = new Frame(functionName, top);
    }

    String pop() {
        if (isEmpty())
            throw new RuntimeException("No active call to return from");

        String name = top.functionName;
        top = top.next;
        return name;
    }

    String peek() {
        if (isEmpty())
            throw new RuntimeException("Call stack is empty");

        return top.functionName;
    }

    boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CallStack stack = new CallStack();

        stack.push("main()");
        stack.push("login()");
        stack.push("validateUser()");

        System.out.println("Current Function: " + stack.peek());

        System.out.println("Returned From: " + stack.pop());

        System.out.println("Current Function: " + stack.peek());
    }
}
