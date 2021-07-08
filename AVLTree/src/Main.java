import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        System.out.println();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)){

            Collections.sort(words);

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

            //AVL
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
        }
    }


}
