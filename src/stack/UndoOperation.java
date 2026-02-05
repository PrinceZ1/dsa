package stack;

import java.util.Stack;

public class UndoOperation {

    /**
     * Approach 1: Simple Undo using Stack (State-based)
     *
     * Time Complexity:
     *  - write: O(1)
     *  - undo: O(1)
     *
     * Space Complexity: O(n * m)
     *  - n: number of operations
     *  - m: size of state
     */
    static class StateBasedUndo {

        private Stack<String> history = new Stack<>();
        private String currentState = "";

        public void write(String text) {
            history.push(currentState);
            currentState += text;
        }

        public void undo() {
            if (!history.isEmpty()) {
                currentState = history.pop();
            }
        }

        public String getText() {
            return currentState;
        }
    }

    /**
     * Approach 2: Command-based Undo (More interview-ready)
     *
     * Time Complexity:
     *  - write: O(1)
     *  - undo: O(1)
     *
     * Space Complexity: O(n)
     */
    static class CommandBasedUndo {

        private StringBuilder text = new StringBuilder();
        private Stack<Command> history = new Stack<>();

        // Command interface
        interface Command {
            void undo();
        }

        public void write(String str) {
            int startIndex = text.length();
            text.append(str);

            history.push(() -> text.delete(startIndex, text.length()));
        }

        public void undo() {
            if (!history.isEmpty()) {
                history.pop().undo();
            }
        }

        public String getText() {
            return text.toString();
        }
    }

    public static void main(String[] args) {

        System.out.println("State-based Undo:");
        StateBasedUndo s1 = new StateBasedUndo();
        s1.write("Hello");
        s1.write(" World");
        System.out.println(s1.getText()); // Hello World
        s1.undo();
        System.out.println(s1.getText()); // Hello

        System.out.println("\nCommand-based Undo:");
        CommandBasedUndo s2 = new CommandBasedUndo();
        s2.write("Java");
        s2.write(" Stack");
        s2.write(" Undo");
        System.out.println(s2.getText()); // Java Stack Undo
        s2.undo();
        System.out.println(s2.getText()); // Java Stack
        s2.undo();
        System.out.println(s2.getText()); // Java
    }
}
