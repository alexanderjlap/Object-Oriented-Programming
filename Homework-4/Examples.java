import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {
    HeapChecker heapchecker1 = new HeapChecker();

    DataHeap dataheapempty = new DataHeap(0);
    DataHeap heap5 = new DataHeap(5);
    DataHeap heap6 = new DataHeap(6);
    DataHeap heap7 = new DataHeap(7);
    DataHeap heap9 = new DataHeap(9);
    DataHeap heap2 = new DataHeap(2, heap5, heap6);
    DataHeap heap3 = new DataHeap(3, heap7, heap9);
    DataHeap heap1 = new DataHeap(1, heap2, heap3);

    //AddEltValidator Tests
    @Test
    public void testAddEltValidator_givenValidBinaryTree() {
        assertTrue(heapchecker1.addEltValidator(heap1, 4, heap1.addElt(4)));
    }

    @Test
    public void testAddEltValidator_missingAddedElt() {
        DataBT databt5 = new DataBT(5);
        DataBT databt6 = new DataBT(6);
        DataBT databt7 = new DataBT(7);
        DataBT databt9 = new DataBT(9);
        DataBT databt2 = new DataBT(2, heap5, heap6);
        DataBT databt3 = new DataBT(3, heap7, heap9);
        DataBT databt1 = new DataBT(1, heap2, heap3);
        assertFalse(heapchecker1.addEltValidator(heap1, 4, heap1));
    }

    @Test
    public void testAddEltValidator_extraneousElts() {
        DataBT databt999 = new DataBT(999);
        DataBT databt5 = new DataBT(5);
        DataBT databt6 = new DataBT(6);
        DataBT databt7 = new DataBT(7);
        DataBT databt9 = new DataBT(9, databt999, new MtBT());
        DataBT databt4 = new DataBT(4, databt9, new MtBT());
        DataBT databt2 = new DataBT(2, databt4, databt5);
        DataBT databt3 = new DataBT(3, databt6, databt7);
        DataBT databt1 = new DataBT(1, databt2, databt3);
        assertFalse(heapchecker1.addEltValidator(heap1, 4, databt1));
    }

    @Test
    public void testAddEltValidator_givenBinaryTreeWithMissingAddElt() {
        DataBT databt4 = new DataBT(4);
        DataBT databt5 = new DataBT(5);
        DataBT databt6 = new DataBT(6);
        DataBT databt7 = new DataBT(7);
        DataBT databt2 = new DataBT(2, databt4, databt5);
        DataBT databt3 = new DataBT(3, databt6, databt7);
        DataBT databt1 = new DataBT(1, databt2, databt3);
        assertFalse(heapchecker1.addEltValidator(heap1, 4, databt1));
    }

    @Test
    public void testAddEltValidator_givenNotHeap() {
        DataBT databt4 = new DataBT(4);
        DataBT databt5 = new DataBT(5);
        DataBT databt6 = new DataBT(6);
        DataBT databt7 = new DataBT(7);
        DataBT databt9 = new DataBT(9, databt4, new MtBT());
        DataBT databt2 = new DataBT(2, databt9, databt5);
        DataBT databt3 = new DataBT(3, databt6, databt7);
        DataBT databt1 = new DataBT(1, databt2, databt3);
        assertFalse(heapchecker1.addEltValidator(heap1, 4, databt1));
    }

    //RemMinEltValidator Tests
    @Test
    public void testRemMinEltValidator_validBinaryTree() {
        DataHeap dataheap1 = new DataHeap(3, heap2, heap3);
        assertTrue(heapchecker1.remMinEltValidator(dataheap1, dataheap1.remMinElt()));
    }

    @Test
    public void testRemMinEltValidator_missingAddedElts() {
        DataHeap dataheap1 = new DataHeap(4, heap5, heap6);
        assertFalse(heapchecker1.remMinEltValidator(dataheap1, dataheap1.remMinElt()));
    }

    @Test
    public void testRemMinEltValidator_extraneousElts() {
        DataHeap dataheap1 = new DataHeap(2, heap5, heap6);
        DataHeap dataheap2 = new DataHeap(999);
        assertFalse(heapchecker1.remMinEltValidator(dataheap1, dataheap2.remMinElt()));
    }

    @Test
    public void testRemMinEltValidator_givenBinaryTreeWithMissingAddElt() {
        DataHeap dataheap1 = new DataHeap(5, heap7, heap9);
        assertFalse(heapchecker1.remMinEltValidator(dataheap1, dataheap1.remMinElt()));
    }

    @Test
    public void testRemMinEltValidator_givenNotHeap() {
        assertFalse(heapchecker1.remMinEltValidator(dataheapempty, dataheapempty));
    }
}
