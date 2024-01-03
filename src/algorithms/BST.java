package algorithms;

import main.BSTInterface;

public class BST implements BSTInterface {

    public static class Node {
        public final int key; // key is immutable
        public volatile Node left;
        public volatile Node right;
        public volatile boolean marked; // marked for deletion

        public Node(int key) {
            this(key, null, null);
        }

        public Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.marked = false;
        }

        public void setChild(Node child, boolean isRight) {
            if (isRight) {
                this.right = child;
            } else {
                this.left = child;
            }
        }

        public Node getChild(boolean isRight) {
            if (isRight) {
                return this.right;
            } else {
                return this.left;
            }
        }
    }

    static class NodePair {
        public final Node parent;
        public final Node current;
        // Is `current` the right child of `parent`
        public final boolean isRight;

        public NodePair(Node parent, Node current, boolean isRight) {
            this.parent = parent;
            this.current = current;
            this.isRight = isRight;
        }
    }

    /**
     * A helper dummy node used as the head of the tree.
     * Keeping it removes some edge-cases where the tree is totally empty.
     */
    final Node head;
    /**
     * A helper dummy node (set to null) used to represent a "no child".
     */
    final Node sentinel;

    public BST() {
        head = new Node(Integer.MIN_VALUE);
        sentinel = null;
        head.left = sentinel;
        head.right = sentinel;
    }

    private static boolean isSentinelNode(Node node) {
        return node == null;
    }

    private static boolean isRealNode(Node node) {
        return !isSentinelNode(node);
    }

    private static boolean isLeaf(Node node) {
        return isSentinelNode(node.left) && isSentinelNode(node.right);
    }

    /**
     * Validate that the result is a valid result - the child is the correct child of the parent,
     * and none of them is marked.
     * The function should be called only when the locks over both the parent and child (if not null) are held.
     *
     * @param result - A search result
     */
    private boolean validate(NodePair result) {
        Node pred = result.parent;
        Node curr = result.current;
        return !pred.marked && (isSentinelNode(curr) || !curr.marked) && pred.getChild(result.isRight) == curr;
    }

    private NodePair findKey(final int key) {
        NodePair first = new NodePair(null, null, false);

        while (true) {
            NodePair second = findKeyOnce(key);
            if (second.parent == first.parent || isRealNode(second.current)) {
                return second;
            }

            first = second;
        }
    }

    private NodePair findKeyOnce(final int key) {
        Node parent = head;
        Node curr = head.right;
        boolean isRight = true;
        while (curr != sentinel) {
            if (curr.key < key) {
                parent = curr;
                curr = curr.right;
                isRight = true;
            } else if (curr.key > key) {
                parent = curr;
                curr = curr.left;
                isRight = false;
            } else {
                return new NodePair(parent, curr, isRight);
            }
        }

        return new NodePair(parent, curr, isRight);
    }

    public final boolean contains(final int key) {
        NodePair result = findKey(key);
        return isRealNode(result.current) && !result.current.marked;
    }

    public final boolean insert(final int key) {
        while (true) {
            NodePair pair = findKey(key);
            Node pred = pair.parent;
            Node curr = pair.current;
            boolean isRight = pair.isRight;
            synchronized (pred) {
                if (!validate(pair)) {
                    continue;
                }
                if (isSentinelNode(curr)) {
                    Node node = new Node(key, sentinel, sentinel);
                    pred.setChild(node, isRight);
                    return true;
                } else {
                    synchronized (curr) {
                        if (validate(pair)) {
                            return false;
                        }
                    }
                }
            }
        }
    }

    public final boolean remove(final int key) {
        while (true) {
            NodePair pair = findKey(key);
            Node pred = pair.parent;
            Node curr = pair.current;
            boolean isRight = pair.isRight;
            synchronized (pred) {
                if (!validate(pair)) {
                    continue;
                }
                if (isSentinelNode(curr)) {
                    return false;
                }
                synchronized (curr) {
                    if (validate(pair)) {
                        if (isRealNode(curr.left) && isRealNode(curr.right)) {
                            removeBinaryNode(pair);
                        } else if (isRealNode(curr.left)) {
                            curr.marked = true;
                            pred.setChild(curr.left, isRight);
                        } else {
                            curr.marked = true;
                            pred.setChild(curr.right, isRight);
                        }
                        return true;
                    }
                }
            }
        }
    }

    private NodePair findSuccessor(Node base) {
        Node parent = base;
        Node curr = base.right;
        boolean isRight = true;
        Node next = curr.left;
        while (isRealNode(next)) {
            parent = curr;
            curr = next;
            next = curr.left;
            isRight = false;
        }
        return new NodePair(parent, curr, isRight);
    }

    private void removeBinaryNode(NodePair toRemove) {
        while (true) {
            NodePair pair = findSuccessor(toRemove.current);
            Node pred = pair.parent;
            Node curr = pair.current;
            boolean isRight = pair.isRight;
            synchronized (pred) {
                if (!validate(pair)) {
                    continue;
                }
                synchronized (curr) {
                    NodePair secondPair = findSuccessor(toRemove.current);
                    if (secondPair.current != curr || secondPair.parent != pred || secondPair.isRight != isRight || isRealNode(curr.left)) {
                        continue;
                    }

                    if (validate(pair)) {
                        if (isSentinelNode(curr.right)) {
                            removeAndReplaceWithLeaf(toRemove, pair);
                        } else {
                            removeWithNonLeafSuccessor(toRemove, pair);
                        }
                        return;
                    }
                }
            }
        }
    }

    private void removeWithNonLeafSuccessor(NodePair toRemove, NodePair succ) {
        while (true) {
            NodePair pair = findSuccessor(succ.current);
            Node pred = pair.parent;
            Node curr = pair.current;
            boolean isRight = pair.isRight;
            synchronized (pred) {
                if (!validate(pair)) {
                    continue;
                }
                synchronized (curr) {
                    NodePair secondPair = findSuccessor(succ.current);
                    if (secondPair.current != curr || secondPair.parent != pred || secondPair.isRight != isRight || isRealNode(curr.left)) {
                        continue;
                    }
                    if (validate(pair)) {
                        curr.left = succ.current;
                        succ.parent.setChild(succ.current.right, succ.isRight);
                        succ.current.right = sentinel;
                        removeAndReplaceWithLeaf(toRemove, new NodePair(curr, succ.current, false));
                        return;
                    }
                }
            }
        }
    }

    private void removeAndReplaceWithLeaf(NodePair toRemove, NodePair replacementLeaf) {
        toRemove.current.marked = true;
        if (toRemove.current.right != replacementLeaf.current) {
            replacementLeaf.current.right = toRemove.current.right;
        }
        replacementLeaf.current.left = toRemove.current.left;
        toRemove.parent.setChild(replacementLeaf.current, toRemove.isRight);
        replacementLeaf.parent.setChild(sentinel, replacementLeaf.isRight);
    }

    public Node getRoot() {
        return head.right;
    }

    public String getName() {
        return " | ";
    }

    public final int size() {
        return getSize(head.right);
    }

    private int getSize(Node current) {
        if (isSentinelNode(current)) {
            return 0;
        }
        return 1 + getSize(current.left) + getSize(current.right);
    }

    public final long getKeysum() {
        return sumKeys(head.right);
    }

    private long sumKeys(Node current) {
        if (isSentinelNode(current)) {
            return 0;
        }
        return (long) current.key + sumKeys(current.left) + sumKeys(current.right);
    }
}
