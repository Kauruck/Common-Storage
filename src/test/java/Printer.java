import com.kauruck.common.storage.tree.BinaryTree;

public class Printer {

    public static void main(String[] args){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(1);
        tree.add(3);
        tree.add(4);
        System.out.println(tree);
    }
}
