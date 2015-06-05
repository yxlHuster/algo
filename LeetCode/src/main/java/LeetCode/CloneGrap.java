package LeetCode;

/**
 * Created with IntelliJ IDEA.
 * User: yongleixiao
 * Date: 15-5-31
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors
 */

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int label) {
        this.label = label;
        this.neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
public class CloneGrap {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        nodeMap.put(node, newHead);
        while (!queue.isEmpty()) {
            UndirectedGraphNode current = queue.pop();
            for (UndirectedGraphNode aNeighbor : current.neighbors) {
                if (!nodeMap.containsKey(aNeighbor)) {
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    nodeMap.get(current).neighbors.add(copy);
                    nodeMap.put(aNeighbor, copy);
                    queue.push(aNeighbor);
                } else {  //this not push to avoid cycle
                    nodeMap.get(current).neighbors.add(nodeMap.get(aNeighbor));
                }
            }
        }
        return newHead;
    }

}
