package reverselinkedlist;

public class Main {

    public static void main(String[] args) {
        Node node1 = new Node("D", null);
        Node node2 = new Node("C", node1);
        Node node3 = new Node("B", node2);
        Node currentNode = new Node("A", node3);

        printLinkedList(currentNode);
        printLinkedList(reverseLinkedList(currentNode));
    }

    public static Node reverseLinkedList(Node currentNode) {
        Node previousNode = null;
        // How it is now: previousNode = null, currentNode = A -> B, currentNode.nextNode = B -> C
        // What I want to happen on the next iteration: previousNode = A -> null, currentNode = B -> A, currentNode.nextNode = C -> D
        while (currentNode.nextNode != null) {
            Node nextNode = currentNode.nextNode;
            currentNode.nextNode = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        currentNode.nextNode = previousNode;
        return currentNode;
    }

    private static void printLinkedList(Node currentNode) {
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.value);
            if (currentNode.nextNode != null) {
                result.append(" -> ");
            }
            currentNode = currentNode.nextNode;
        }
        System.out.println(result);
    }
}
