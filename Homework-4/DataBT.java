class DataBT implements IBinTree {
    int data;
    IBinTree left;
    IBinTree right;

    DataBT(int data, IBinTree left, IBinTree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // an alternate constructor for when both subtrees are empty
    DataBT(int data) {
        this.data = data;
        this.left = new MtBT();
        this.right = new MtBT();
    }

    // determines whether this node or node in subtree has given element
    public boolean hasElt(int e) {
        return this.data == e || this.left.hasElt(e) || this.right.hasElt(e);
    }

    // adds 1 to the number of nodes in the left and right subtrees
    public int size() {
        return 1 + this.left.size() + this.right.size();
    }

    // adds 1 to the height of the taller subtree
    public int height() {
        return 1 + Math.max(this.left.height(), this.right.height());
    }

    /**
     * Compares the values of the left subtree starting at the first level and moves down, then right is checked.
     * @return true is the left subtrees and right subtree are passed correctly.
     */
    @Override
    public boolean isHeap() {
        if (this.left.isBigger(this.data) && this.right.isBigger(this.data)) {
            if (this.left.isHeap() && this.right.isHeap()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Compares the data integer with the new elt int.
     * @param elt is a new int.
     * @return true is data is greater, false otherwise.
     */
    public boolean isBigger(int elt) {
        if (this.data > elt)
            return true;
        else
            return false;
    }

    /**
     * The new heap is checked for all the elements of the original heap.
     * @param heap creates a new heap tree.
     * @return true if the new heap is the same as the original heap.
     */
    public boolean containedInHeap(IHeap heap, int elt) {
        if (this.data == elt) {
            return (this.left.containedInHeap(heap, elt) && this.right.containedInHeap(heap, elt));
        }
        if (heap.hasElt(this.data)) {
            if (left.containedInHeap(heap, elt) && right.containedInHeap(heap, elt))
                return true;
            else
                return false;
        } else
            return false;
    }
}
