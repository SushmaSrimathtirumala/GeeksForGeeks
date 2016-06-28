package Regular.LinkedLists.LRUCache;

import DsAndUtils.DLLNode;
import DsAndUtils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gakshintala on 6/15/16.
 */
public class LRUCache {
    static LRUQueue lruQueue = new LRUQueue();

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.referPage(1);
        lruCache.referPage(2);
        lruCache.referPage(3);
        lruCache.referPage(4);
        lruCache.referPage(5);
        Utils.printDLL(lruQueue.front);
        lruCache.referPage(6);
        Utils.printDLL(lruQueue.front);
        lruCache.referPage(3);
        Utils.printDLL(lruQueue.front);
    }

    public void referPage(int pageNo) {
        // Motto is not to have faster refers for recently used cache, but to remove least recently used cache.
        // So HashMap is always referred.
        DLLNode node = lruQueue.getNodeForPage(pageNo);
        if (node == null) { // New page
            node = new DLLNode(pageNo);
            lruQueue.enqueue(pageNo, node);
        } else if (node != lruQueue.front) { // No need to rearrange if the node is already front.
            node.prev.next = node.next;
            // If node is rear, adjust the queue rear
            if (node == lruQueue.rear) {
                lruQueue.rear = node.prev;
            } else { // If not, connect its next to prev
                node.next.prev = node.prev;
            }
            // Adjust front
            node.next = lruQueue.front;
            lruQueue.front.prev = node;
            lruQueue.front = node;
            node.prev = null;
        }
    }
}

class LRUQueue {
    private static final int SIZE = 5;
    DLLNode front, rear;
    private int count = 0;
    private Map<Integer, DLLNode> pageToNodeMap = new HashMap<>();

    public void enqueue(int pageNo, DLLNode node) {
        // If queue is full, dequeue rear.
        if (isQueueFull()) {
            dequeue();
        }
        // Initial state with front and rear are not initialized
        if (front == null) {
            front = rear = node;
        } else { // Enqueue in front
            node.next = front;
            front.prev = node;
            front = node;
        }
        // Put node in Hashmap for quick access.
        pageToNodeMap.put(pageNo, node);
        count++;
    }

    public void dequeue() {
        if (rear != null) {
            rear = rear.prev;
            rear.next = null;
            count--;
        }
    }

    public DLLNode getNodeForPage(int pageNo) {
        return pageToNodeMap.get(pageNo);
    }

    public boolean isQueueFull() {
        return count >= SIZE;
    }
}