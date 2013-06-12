package trees;

import java.util.ArrayList;
import java.util.List;

public class Trees {
    public static <T extends Comparable<T>> boolean verifyDelete(BST bst, List<T> list, List<T> deleted){
        //Check to make sure all items not deleted can be found
        //and all items delete are not found.
        boolean verify = true;
        for(T item:list){
            if(deleted.contains(item)){
                verify = verify && !bst.find(item);
            }
            else{
                verify = verify && bst.find(item);
            }
        }
        return verify;
    }

    public static void main(String[] args) throws Exception {
        BST bst = new BST();
        List<Integer> numbers = new ArrayList<>();
        
        System.out.print("Adding the following to the BST: ");
        int root = 0,internal = 0,leaf = 0;
        for(int i =0;i<15;i++){
            int number = (int)Math.round(Math.random()*100);
            //Get unique numbers to add
            while(bst.find(number)){
                number = (int)Math.round(Math.random()*100);
            }
            numbers.add(number);
            bst.add(number);
            if(i==0) root = number;
            else if(i==1) internal = number;
            else if(i==14) leaf = number;
        }
        for(int num:numbers){
            System.out.print(num+" ");
        }
        System.out.println();

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
        List<Integer> delete = new ArrayList<>();
        delete.add(leaf);
        delete.add(root);
        delete.add(internal);
        if(!verifyDelete(copy,numbers,delete)){
            throw new Exception("Delete Failed!");
        }
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
