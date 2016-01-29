/*
 * 就是dfs下一个结点，然后用Map记录一下访问过的结点信息。
 */

/*
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();

    UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null)
            return null;
        if (map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode nextNode : node.neighbors)
            newNode.neighbors.add(clone(nextNode));
        return newNode;
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
}
