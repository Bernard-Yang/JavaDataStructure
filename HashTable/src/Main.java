import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)){

            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words){
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + "s");

            //RBTree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words){
                if (avl.contains(word))
                    avl.set(word, bst.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + "s");

            //HashTable
            startTime = System.nanoTime();

            HashTable<String, Integer> ht= new HashTable<>();
            for (String word : words){
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for (String word : words)
                ht.contains(word);
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + "s");

            //RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words){
                if (rbTree.contains(word))
                    rbTree.set(word, rbTree.get(word) + 1);
                else
                    rbTree.add(word, 1);
            }

            for (String word : words)
                rbTree.contains(word);
            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + "s");
        }
    }


}
