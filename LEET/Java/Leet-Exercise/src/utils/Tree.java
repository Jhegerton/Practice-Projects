package utils;

import java.util.Collection;

public class Tree{
        static class Node{
            int value;
            Node left;
            Node right;
            Node(int value){
                this.value = value;
                left = null;
                right = null;

            }
        }
        Node root;

        Integer val = 1;
        Integer result = 1;

        public Tree(){
            super();
        }

        private void insertVal(Node node, int value){

            if(this.root == null){
                this.root = new Node(value);
            }
            else if(value < node.value){
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
        private void inOrderTraversal(Node node){
            if(node != null){
                inOrderTraversal(node.left);
                M.p(node.value + " ");
                inOrderTraversal(node.right);
            }
        }
        private void reverseOrderTraversal(Node node){
            if(node != null){
                inOrderTraversal(node.right);
                M.p(node.value + " ");
                inOrderTraversal(node.left);
            }
        }
        public void printTree() {
            M.pl("Sorted Ascending:");
            inOrderTraversal(root);
        }
        public void printTreeBackwards(){
            M.pl("Sorted Descending:");
            reverseOrderTraversal(root);
        }
        public void insertAll(Collection<Integer> col) {
            for (Integer num : col) {
                this.insert(num);
            }
        }
        public void insertAll(Integer[] array){
            for(Integer num : array){
                this.insert(num);
            }
        }
        public void insert(Integer num){
            insertVal(root, num);
        }

}
