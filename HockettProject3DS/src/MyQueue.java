/**
     * Class Name: MyQueue
     * Class Author: Tyler Hockett
     * **************************
     * Purpose of the Class
     * To communicate between the gui
     * and the Link list to queue and 
     * dequeue
     * **************************
     * Date: 9/26/2017 USA
     * **************************
     * Date Changed:
     * **************************
     * Look At This!
     * 
     * **************************
     */
public class MyQueue 
{
    LinkList head;
    LinkList tail;
    /**
     * Constructor Name: MyQueue
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * this is the constructor for the 
     * class, it makes head and tail null
     * **************************
     * Date: 9/26/2017 USA
     * **************************
     */
    public MyQueue()
    {
        head=null;
        tail=null;;
    }
        /**
     * Method Name: enqueue
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * add integers to the link list
     * **************************
     * Date: 9/26/2017 USA
     * **************************
     */
    public void enqueue(int value)
{
    if(head==null)
    {
        LinkList temp=new LinkList();
        temp.value=value;
        head = temp;
        tail=temp;
    }else
    {
        LinkList temp=new LinkList();
        temp.value=value;
        tail.nextLL=temp;
        tail=temp;
    }
}
        /**
     * Method Name: dequeue
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * take integers off the link list
     * **************************
     * Date: 9/26/2017 USA
     * **************************
     */
public int dequeue()
{
    
    int tbR;
    if (head !=null)
    {
        tbR=head.value;
        head=head.nextLL;
    }else
    {
        tbR=0;
    }
    return tbR;
}
}
