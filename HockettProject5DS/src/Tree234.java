/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Boss
 */
public class Tree234 
{
 private String tempString = "";
 private Node234 root=new Node234();
 public int find(String key)
 {
     Node234 curNode=root;
     int childNumber;
     while(true)
     {
         if((childNumber=curNode.findItem(key))!=-1)
         {             
             return childNumber;
         }else if(curNode.isLeaf())
         {
             return -1;
         }else
         {
             curNode=getNextChild(curNode, key);
         }
     }
 }
     public void insert(String dValue)
     {
         Node234 curNode=root;
         DataItem234 tempItem = new DataItem234(dValue);
         
         while(true)
         {
             if(curNode.isFull() )
             {
                 split(curNode);
                 curNode=curNode.getParent();
                 
                 curNode=getNextChild(curNode, dValue);
             }else if(curNode.isLeaf() )
             {
                 break;
             }else
             {
                 curNode=getNextChild(curNode, dValue);
             }
         }
         curNode.insertItem(tempItem);
     }
     public void split(Node234 thisNode)
     {
         DataItem234 itemB, itemC;
         Node234 parent, child2, child3;
         int itemIndex;
         itemC=thisNode.removeItem();
         itemB=thisNode.removeItem();
         child2=thisNode.disconnectChild(2);
         child3=thisNode.disconnectChild(3);
         
         Node234 newRight=new Node234();
         if(thisNode==root)
         {
                     root=new Node234();
                     parent = root;
                     root.connectChild(0, thisNode);
         }else
         {
             parent=thisNode.getParent();
         }
             itemIndex=parent.insertItem(itemB);
             int n = parent.getNumItems();
             for(int i=n-1; i>itemIndex; i--)
             {
                 Node234 temp= parent.disconnectChild(i);
                 parent.connectChild(i+1, temp);
             }
             
             parent.connectChild(itemIndex+1, newRight);
             
             newRight.insertItem(itemC);
             newRight.connectChild(0,child2);
             newRight.connectChild(1, child3);
         
     }
     public Node234 getNextChild(Node234 theNode, String theValue)
     {
         int i;
         int numItems=theNode.getNumItems();
         for(i=0; i<numItems;i++)
         {
             if( theValue.compareToIgnoreCase(theNode.getItem(i).getDData())<0)// < theNode.getItem(i).getDData() )
             {
                 return theNode.getChild(i);
             }
         }
         return theNode.getChild(i);
     }
     
          /**
     * Method Name: printOut
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to call recPrintOut and finally
     * return the string
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    public String printOut()
    {
        String answer="";
        answer+=recPrintOut(root);
        return answer;
    }
     /**
     * Method Name: recPrintOut
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to check if there is a left, passes left
     * then check if theres a right after
     * adding the curTree value
     * to get all values from the binarytree
     * **************************
     * Date: 10/1/2017 USA
     * **************************
     *
     */
    private String recPrintOut(Node234 cur)
    {
        
        if(cur.isLeaf()){
            for(int i = 0; i < cur.getNumItems(); i++){
                tempString+="Word: " + cur.getItem(i).getDData() + "\t\t\tCount: " + cur.getItem(i).getCount()+"\n";
            }
        }
        else{
            for(int i = 0; i < cur.getNumItems() + 1; i++){
                recPrintOut(cur.getChild(i));
                if(i < cur.getNumItems()){
                  tempString+="Word: " + cur.getItem(i).getDData() + "\t\t\tCount: " + cur.getItem(i).getCount()+"\n";  
                }
            }
        }
        return tempString;
            
    }
}
