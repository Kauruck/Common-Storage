import com.kauruck.common.storage.tree.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeTest {

    private BinaryTree<Integer> tree;

    @BeforeEach
    public void setUp(){
        tree = new BinaryTree<>();
        tree.add(1);
        tree.add(3);
        tree.add(4);
    }

    @Test
    @DisplayName("Test the traversing of the tree inorder")
    public void testTraversingInOrder(){
        String output = tree.traverseInOrder();
        assertEquals("1 3 4", output);
    }

    @Test
    @DisplayName("Test the traversing of the tree preorder")
    public void testTraversingPreOrder(){
        String output = tree.traverseInPreorder();
        assertEquals("1 3 4", output);
    }

    @Test
    @DisplayName("Test the traversing of the tree postorder")
    public void testTraversingPostOrder(){
        String output = tree.traverseInPostorder();
        assertEquals("4 3 1", output);
    }

    @Test
    @DisplayName("Test the adding of a number")
    public void testAdding(){
        tree.add(2);
        assertEquals("1 2 3 4", tree.traverseInOrder(), "Inorder works with adding");
        assertEquals("1 3 2 4", tree.traverseInPreorder(), "Preorder works with adding");
        assertEquals("2 4 3 1", tree.traverseInPostorder(), "Postorder works with adding");
    }
    @Test
    @DisplayName("Test the removing of a number")
    public void testRemoving(){
        tree.add(2);
        tree.remove(3);
        assertEquals("1 2 4", tree.traverseInOrder(), "Inorder works with removing");
        assertEquals("1 2 4", tree.traverseInPreorder(), "Preorder works with removing");
        assertEquals("4 2 1", tree.traverseInPostorder(), "Postorder works with removing");
    }

    @Test
    @DisplayName("Test the generating of a list")
    public void testList(){
        assertEquals(Arrays.asList(1, 3, 4), tree.traverseInOrderForList(), "Inorder works with lists");
        assertEquals(Arrays.asList(1, 3, 4), tree.traverseInPreorderForList(), "Preorder works with lists");
        assertEquals(Arrays.asList(4, 3, 1), tree.traverseInPostorderForList(), "Postorder works with lists");
    }
}
