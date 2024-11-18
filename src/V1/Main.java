package V1;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        System.out.println("pushed: 10");
        stack.push(20);
        System.out.println("pushed: 20");

        System.out.println(stack.hasNext());

        stack.push(30);
        System.out.println("pushed: 30");
        stack.push(40);
        System.out.println("pushed: 40");

        System.out.println("Next: " + stack.next());
        System.out.println("Next: " + stack.next());
        
        stack.remove();
        System.out.println("Removed: 30");

        // Iterate over the stack
        while (stack.hasNext()) {
            System.out.println(stack.next());
        }

        // Pop elements from the stack
        System.out.println("Popped: " + stack.pop());
    }
}

