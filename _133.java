class Solution {
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