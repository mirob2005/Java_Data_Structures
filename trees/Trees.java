package trees;

public class Trees {

    public static void main(String[] args) {
        BST bst = new BST();
        System.out.print("Adding the following to the BST: ");
        int root = 0,internal = 0,leaf = 0;
        for(int i =0;i<15;i++){
            int number = (int)Math.round(Math.random()*100);
            while(bst.find(number)){
                number = (int)Math.round(Math.random()*100);
            }
            bst.add(number);
            System.out.print(number+" ");
            if(i==0) root = number;
            else if(i==1) internal = number;
            else if(i==14) leaf = number;
        }
//        bst.add(10);
//        bst.add(5);
//        bst.add(2);
//        bst.add(7);
//        bst.add(4);
//        bst.add(1);
//        bst.add(9);
//        bst.add(6);
//        bst.add(0);
//        bst.add(11);
//        bst.add(8);
//        bst.add(3);
        System.out.println("\n");
        bst.traverseDFSpreorder();
        bst.traverseDFSinorder();
        bst.traverseDFSpostorder();
        bst.traverseBFS();
        System.out.println("Max value = "+ bst.findMax());
        System.out.println("Min value = "+ bst.findMin());
        System.out.println("Value 23 is present: "+ bst.find(23));
        System.out.println("Value "+leaf+" is present: "+ bst.find(leaf));
        
        bst.printBranches();
        BST copy = bst.copyTree();
        System.out.println("Trees after the copy:");
        System.out.println("Copied Tree:");
        copy.printBranches();
        System.out.println("Original Tree:");
        bst.printBranches();
        copy.delete(internal);
        copy.delete(root);
        copy.delete(leaf);
        System.out.println("Trees after the deleting a root ("+root+"), an internal("+internal+"), and a leaf node("+leaf+") in copy:");
        System.out.println("Copied Tree:");
        copy.printBranches();
        System.out.println("Original Tree:");
        bst.printBranches();
        bst.deleteTree();
        System.out.println("Trees after the delete tree:");
        System.out.println("Copied Tree:");
        copy.printBranches();
        System.out.println("Original Tree:");
        bst.printBranches();
    }
}
