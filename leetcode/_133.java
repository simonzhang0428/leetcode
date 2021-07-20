import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class _133 {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if (node == null) {
            return null;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            for (Node n : currNode.neighbors) {
                if (!map.containsKey(n)) {
                    map.put(n, new Node(n.val));
                    queue.offer(n);
                }

                map.get(currNode).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}