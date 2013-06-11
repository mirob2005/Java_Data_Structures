package trees;

public class Trees {

    public static void main(String[] args) {
        BST bst = new BST();
        System.out.print("Adding the following to the BST: ");
        for(int i =0;i<15;i++){
            int number = (int)Math.round(Math.random()*100);
            bst.add(number);
            System.out.print(number+" ");
        }
        System.out.println("\n");
        bst.traverseDFSpreorder();
        bst.traverseDFSinorder();
        bst.traverseDFSpostorder();
        bst.traverseBFS();
    }
}
