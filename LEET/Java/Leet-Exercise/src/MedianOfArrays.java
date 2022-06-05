import java.util.*;

public class MedianOfArrays {

    public static void run(){
        final Integer[] ARR1 = {1,2,3};
        final Integer[] ARR2 = {2,3,4,5};
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(ARR1));
        list.addAll(Arrays.asList(ARR2));
        Collections.sort(list);

        for(Integer num : list){
            System.out.print(num + " ");
        }


        Tree tree = Tree.insertAll(list);
        float median = 0;
        Tree.Node root = new Tree.Node(list.get(0));
        Integer evenFirst = (list.size() / 2 ) - 1;
        Integer evenLast = (list.size() / 2) + 1;
        Integer middle = (list.size() + 1) / 2;
        if(list.size() % 2 == 0){
            median = (float) (tree.traverseInOrder(root, evenFirst) + tree.traverseInOrder(root, evenLast)) / 2;
        }
        else{
            median = (float) (tree.traverseInOrder(root, middle));
        }

        System.out.println("The median is " + median + " [3]");



   }

}
class Tree{
    static class Node{
        int value;
        Node left, right;
        Node(int value){
            this.value = value;
            left = null;
            right = null;

        }
    }
    public void insert(Node node, int value){
        if(value < node.value){
            if(node.left != null){
                insert(node.left, value);

            }
            else{
                node.left = new Node(value);
            }
        }
        else if (value > node.value){
            if(node.right != null) {
                insert(node.right, value);
            }
        }
        else{
            node.right = new Node(value);

        }
    }
    public static Tree insertAll(List<Integer> list){
        Tree tree = new Tree();
        Node root = new Node(list.get(0));
        for(Integer num : list){
            tree.insert(root, num);
        }
        return tree;
    }
    public Integer traverseInOrder(Node node, int n){
        if(node != null && n > 0){
            traverseInOrder(node.left, n - 1);
            traverseInOrder(node.right, n - 1);
        }
        else{
            return node.value;
        }
        return null;
    }
}


