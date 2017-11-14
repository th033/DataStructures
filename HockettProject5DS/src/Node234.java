/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Boss
 */
public class Node234 
{
    private static final int ORDER=4;
    private int numItems;
    private Node234 parent;
    private Node234 childArray[]= new Node234[ORDER];
    private DataItem234 itemArray[]=new DataItem234[ORDER-1];
    
    //connect child to this node
    public void connectChild(int childNum, Node234 child)
    {
        childArray[childNum]=child;
        if(child!=null)
        {
            child.parent=this;
        }
    }
    //disconnect child from this node, return it
    public Node234 disconnectChild(int childNum)
    {
        Node234 tempNode = childArray[childNum];
        childArray[childNum]=null;
        return tempNode;
    }
    public Node234 getChild(int childNum)
    {
        return childArray[childNum];
    }
    public Node234 getParent()
    {
        return parent;
    }
    public boolean isLeaf()
    {
        return (childArray[0]==null) ? true:false;
    }
    public int getNumItems()
    {
        return numItems;
    }
    public DataItem234 getItem(int index)//get DataItem at index
    {
        return itemArray[index];
    }
    public boolean isFull()
    {
        return(numItems==ORDER-1)? true:false;
    }
    //return index of item(within node) if found, otherwise return -1
    public int findItem(String key)
    {
        for(int i=0;i<ORDER-1;i++)
        {
            if(itemArray[i]==null)
            {
                break;
            }else if(itemArray[i].getDData().compareToIgnoreCase(key)==0)
            {
                itemArray[i].addCount();
                return i;
            }
        }
        return -1;
    }
    public int insertItem(DataItem234 newItem)
    {
        //assumes node is not full 
        numItems++;                    //will add new item
        String newKey=newItem.getDData(); //key of new item
        
        //start on right, examine items. if item null, go left one cell. if not null, get its key
        for(int i=ORDER-2;i>=0;i--)
        {
            if(itemArray[i]==null)
            {
                continue;
            }else
            {
                String itsKey =itemArray[i].getDData();
                if(newKey.compareTo(itsKey)<0)
                {
                    itemArray[i+1]=itemArray[i];
                }else
                {
                    itemArray[i+1]=newItem;
                    return i+1;
                }
            }//end else(not null)
        }//end for
        itemArray[0]=newItem;
        return 0;
    }
    public DataItem234 removeItem()
    {
        //assumes node not empty 
        DataItem234 temp = itemArray[numItems-1];
        itemArray[numItems-1]=null;
        numItems--;
        return temp;
    }
//    public void disPlayNode()
//    {
//        for(int i=0;i<numItems;i++)
//        {
//            itemArray[i].displayItem();
//            System.out.println("/");
//        }
//    }
}
