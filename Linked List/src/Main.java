public class Main {
    public static void main(String[] args){
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0 ; i < 5 ; i ++){
            linkedList.add(i);
            System.out.println(linkedList);
        }

        linkedList.add(2);
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);

    }
}
