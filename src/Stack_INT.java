import java.util.Scanner;

public class Stack_INT {
    private static class Node {
        public int data;
        public Node next;
    }

    private static class Return {
        public int item;
        public boolean ok;
    }

   private static Node top;

    public void init() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int item) {
        Node newNode = new Node();
        newNode.data = item;
        newNode.next = top;
        top = newNode;
    }

    public Return pop() {
        Return output = new Return();

        if (!isEmpty()) {
            output.item = top.data;
            top = top.next;
            output.ok = true;
        } else {
            output.ok = false;
        }
        return output;
    }

    public Return top() {
        Return output = new Return();
        if (!isEmpty()) {
            output.item = top.data;
            output.ok = true;
        } else {
            output.ok = false;
        }
        return output;
    }

    public static void main (String[] args) {
        Stack_INT stack = new Stack_INT();
        Return res = new Return();
        Scanner input = new Scanner(System.in);

        int module, num;

        stack.init();

        System.out.println("Digite valor número na base 10: ");
        num = input.nextInt();

        while (num > 0) {
            module = num % 2;
            stack.push(module);
            num = num / 2;
        }

        System.out.println("Número em binário: ");
        do {
            res = stack.pop();
            if (res.ok) {
                System.out.println(" " + res.item);
            }
        } while (res.ok);
        input.close();
    }
}
