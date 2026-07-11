public class HeapChecker {

    /**
     * Takes the helper methods made and checks the bin tree is a heap,
     * the new bt has all the elements of the original bt,
     * the new heap has all the elements of the original heap.
     * @param hOrig produces a new heap.
     * @param elt produces a new element.
     * @param hAdded produces a new bin tree.
     * @return true if all the methods pass, otherwise false.
     */
    public boolean addEltValidator(IHeap hOrig, int elt, IBinTree hAdded) {
        if (hAdded.hasElt(elt)) {
            if (hAdded.isHeap()
                    && hOrig.containedInBT(hAdded)
                    && hAdded.containedInHeap(hOrig, elt)) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    /**
     * Takes the helper methods made and checks the size of the heap and removes an elements from the heap,
     * checks for if the bin tree is a heap
     * and the bin tree contains the same elements from the original bin tree.
     * @param hOrig creates a new heap tree.
     * @param hRemoved creates a new bin tree.
     * @return true if the heap tree and bin tree are same, otherwise false.
     */
    public boolean remMinEltValidator(IHeap hOrig, IBinTree hRemoved) {
        if (((hOrig.size() - 1) == hRemoved.size()) && hRemoved.isHeap() && hOrig.containedInBT(hRemoved)) {
            return true;
        }
        else {
            return false;
        }
    }
}
