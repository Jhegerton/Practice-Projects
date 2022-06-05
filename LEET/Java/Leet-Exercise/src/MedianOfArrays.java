import java.util.*;

public class MedianOfArrays {

    public static void run(){
        final Integer[] ARR1 = {1,2,3};
        final Integer[] ARR2 = {2,3,4,5};
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(ARR1));
        list.addAll(Arrays.asList(ARR2));
        Collections.sort(list);

//        for(Integer num : list){
//            System.out.print(num + " ");
//        }


        Tree tree = new Tree(list.get(0));
        list.remove(0);
        tree.insertAll(list);
        tree.printTree();



//        float median = 0;
//
//        Integer evenFirst = (list.size() / 2 ) - 1;
//        Integer evenLast = (list.size() / 2) + 1;
//        Integer middle = (list.size() + 1) / 2;
//        if(list.size() % 2 == 0){
//            median = (float) (tree.traverseInOrder(root, evenFirst) + tree.traverseInOrder(root, evenLast)) / 2;
//        }
//        else{
//            median = (float) (tree.traverseInOrder(root, middle));
//        }

//        System.out.println("The median is " + median + " [3]");



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
    Node root;
    public Tree(Integer rootValue){
        super();
        root = new Node(rootValue);
    }

    public void insertVal(Node node, int value){

        if(value < node.value){
            if(node.left != null){
                insertVal(node.left, value);

            }
            else{
                node.left = new Node(value);
            }
        }
        else if (value > node.value){
            if(node.right != null) {
                insertVal(node.right, value);

            } else{
                node.right = new Node(value);

            }
        }
        else{
            node.left = new Node(value);
        }

    }
    public void insertAll(List<Integer> list){
        for(Integer num : list){
            this.insert(num);
        }
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
    public void displayTree(Node node){
        if(node != null){
            displayTree(node.left);
            System.out.print(node.value + " ");
            displayTree(node.right);
        }
    }
    void printTree() {
        displayTree(root);
    }
    void insert(Integer num){
        insertVal(root, num);
    }

}


