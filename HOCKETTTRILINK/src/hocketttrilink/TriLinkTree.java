
package hocketttrilink;

/**
     * Class Name: TriLinkTree
     * Class Author: Tyler Hockett
     * **************************
     * To interact with the TriLink Node
     * to insert find count delete print
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     * Date Changed:
     * **************************
     * Look At This!
     * 
     * **************************
     */
public class TriLinkTree 
{
    
    TriLinkNode root = null;
    TriLinkNode temp = null;
        /**
     * Method Name: insertNode
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to insert node into tree or call recInsert
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    public void insertNode(int val)
    {
        temp=new TriLinkNode();
        temp.v1=val;
        temp.d1=false;
        temp.i1=true;
        if(root==null)
        {
            root=temp;
        }else
        {
            recInsertNode(root);
        }
        
    }
            /**
     * Method Name: recInsertNode
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to insert node into tree
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    public void recInsertNode(TriLinkNode curNode)
    {
        if(curNode.i1==true&&curNode.i2==true)
        {
            if(temp.v1<curNode.v1)
            {
                if(curNode.left!=null)
                {
                    recInsertNode(curNode.left);
                }else
                {
                    curNode.left=temp;
                    curNode.left.up=curNode;
                }
            }else if(temp.v1>curNode.v2)
            {
                if(curNode.right!=null)
                {
                    recInsertNode(curNode.right);
                }else
                {
                    curNode.right=temp;
                    curNode.right.up=curNode;
                }
            }else if(temp.v1>curNode.v1&&temp.v1<curNode.v2)
            {
                if(curNode.down!=null)
                {
                    recInsertNode(curNode.down);
                }else
                {
                    curNode.down=temp;
                    curNode.down.up=curNode;
                }
            }
        }else if(temp.v1>curNode.v1)
        {
            curNode.v2=temp.v1;
            curNode.d2=false;
            curNode.i2=true;
        }else if(temp.v1<curNode.v1&&curNode.left!=null)
        {
            recInsertNode(curNode.left);
        }else if(temp.v1<curNode.v1&&curNode.left==null)
        {
            curNode.left=temp;
        }
    }
    
    
    
    
            /**
     * Method Name: find
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * call recFind
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    public boolean find(int toFind)
    {
        boolean answer=false;
        if(recFind(root,toFind)==true)
        {
            answer=true;
        }
        return answer;
    }
            /**
     * Method Name: recFind
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * if value is found and hasn't been
     * deleted we return positive
     * else negative
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    public boolean recFind(TriLinkNode curNode,int toFind)
    {
        boolean answer=false;
            if(curNode.v1==toFind&&curNode.d1==false&&curNode.i1==true)
            {
                answer=true;
                //curNode.d1=true;
                return answer;
            }else if(curNode.v2==toFind && curNode.d2==false && curNode.i2==true)
            {
                answer=true;
                //curNode.d2=true;
                return answer;
            }
            if(curNode.left!=null)
            {
                answer=recFind(curNode.left, toFind);
            }
            if(curNode.down !=null)
            {
                answer=recFind(curNode.down, toFind);
            }
            if(curNode.right!=null)
            {
                answer=recFind(curNode.right, toFind);
            }

        return answer;
    }
    
    
    
            /**
     * Method Name: delete
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to call recDelete return positive or 
     * negative if it worked or not
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    
    
    public boolean delete(int toDelete)
    {
        boolean answer=false;
        if(recDelete(root,toDelete)==true)
        {
            answer=true;
        }
        return answer;
    }
    public boolean
                 /**
     * Method Name: recDelete
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     *to search and find value requested then
     * "delete" it
     * positive is deleted
     * negative is not there or has 
     * already been deleted
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */recDelete(TriLinkNode curNode,int toDelete)
    {
        boolean answer=false;

            if(curNode.v1==toDelete && curNode.d1==false && curNode.i1==true)
            {
                answer=true;
                curNode.d1=true;
                return answer;
            }else if(curNode.v2==toDelete && curNode.d2==false && curNode.i2==true)
            {
                answer=true;
                curNode.d2=true;
                return answer;
            }
            if(curNode.left!=null)
            {
                answer=recDelete(curNode.left, toDelete);
            }
            if(curNode.down !=null)
            {
                answer=recDelete(curNode.down, toDelete);
            }
            if(curNode.right!=null)
            {
               answer= recDelete(curNode.right, toDelete);
            }
        return answer;
    }
    
    
    
            /**
     * Method Name: display
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * calls and returns answer of recDisplay
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    
    
    public String display()
    {
        return recDisplay(root);
    }
            /**
     * Method Name: recDisplay
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to print the value of the tree in order
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    
    public String recDisplay(TriLinkNode curNode)
    {
        String answer="";
        
        if(curNode.left!=null)
        {
            answer+=recDisplay(curNode.left);
        }
        if(curNode.i1==true&&curNode.d1==false)
        {
        answer+=" "+curNode.v1;
        }
        if(curNode.down!=null)
        {
            answer+=recDisplay(curNode.down);
        }
        if(curNode.i2==true&&curNode.d2==false)
        {
        answer+=" "+curNode.v2;
        }
        if(curNode.right!=null)
        {
           answer+= recDisplay(curNode.right);
        }
        
        return answer;
    }
    
    
    
            /**
     * Method Name: getCount
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to call recCount
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    
    
    public int getCount()
    {
        int answer=0;
        answer+=recCount(root);
        return answer;
    }
            /**
     * Method Name: recCount
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to add a value to the total count
     * if the value was inserted and not deleted
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     *
     */
    public int recCount(TriLinkNode curNode)
    {
        int answer= 0;
        if(curNode.i1==true&&curNode.d1==false)
        {
            answer+=1;
        }
        if(curNode.i2==true&&curNode.d2==false)
        {
            answer+=1;
        }
        if(curNode.left!=null)
        {
            answer+=recCount(curNode.left);
        }
        if(curNode.down!=null)
        {
            answer+=recCount(curNode.down);
        }
        if(curNode.right!=null)
        {
            answer+=recCount(curNode.right);
        }
        return answer;
    }
}
