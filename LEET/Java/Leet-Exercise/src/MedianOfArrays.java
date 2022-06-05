import java.io.IOException;
import java.util.*;

public class MedianOfArrays {

    public static void run(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter an array followed by commas");
        Integer[] arr1 = getArray(scan.nextLine());
        System.out.println("Enter another array");
        Integer[] arr2 = getArray(scan.nextLine());

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(arr1));
        list.addAll(Arrays.asList(arr2));
        Collections.sort(list);

//        Tree tree = new Tree(list.get(0));
//        list.remove(0);
//        tree.insertAll(list);
//        tree.printTree();

        float median = 0;

        if(list.size() % 2 == 0){
            median = ((float) list.get(list.size() / 2) + (float) list.get(list.size() / 2)) / 2;
        }else {
            median = (float) list.get((list.size() + 1) / 2);
        }
        System.out.println(median);

   }
   public static Integer[] getArray(String input){
       String[] strArr = input.split(",");
       Integer[] arr = new Integer[strArr.length];

       for(int i = 0; i < strArr.length; i++){
           arr[i] = Integer.parseInt(strArr[i]);
       }

       return arr;
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

    Integer val = 1;
    Integer result = 1;

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
            val = node.value;
            traverseInOrder(node.right, n - 1);
            val = node.value;
        }

        return val;
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
    Integer search(int n){
        val = result = root.value;
        return traverseInOrder(root, n);
    }

}


