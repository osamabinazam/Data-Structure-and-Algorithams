package Trees.BasicTree;

import java.util.ArrayList;

public class TreeNode {

    String data;
    ArrayList<TreeNode> children ;

    TreeNode(String data){
        this.data = data;
        children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode newNode){
        this.children.add(newNode);
    }

    public  String print(int level){
        String returnString = "    ".repeat(level)+data+"\n";
        for(TreeNode node : children){
            returnString += ""+node.print(level+1);
        }
        return returnString;
    }

    public static void main(String[] args) {
        TreeNode Drinks = new TreeNode("Drinks");
        TreeNode Hot = new TreeNode("Hot");
        TreeNode Cold = new TreeNode("Cold");

        TreeNode Tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        TreeNode Karak = new TreeNode("Karak Chai");
        TreeNode wine = new TreeNode("Wine");
        TreeNode bear = new TreeNode("Bear");
        TreeNode cocacola = new TreeNode("Coca Cola");

        //Children of Drink
        Drinks.addChild(Hot);
        Drinks.addChild(Cold);
        //Children of Hot
        Hot.addChild(coffee);
        Hot.addChild(Karak);
        Hot.addChild(Tea);
        //Children of Cold Drinks
        Cold.addChild(cocacola);
        Cold.addChild(bear);
        Cold.addChild(wine);

        System.out.println("Simple Basic Tree Example: \n");

        System.out.println(Drinks.print(0));
    }

}