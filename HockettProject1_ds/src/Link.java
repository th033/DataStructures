/**
     * Class Name: Link
     * Class Author: Tyler Hockett
     * **************************
     * Purpose of the Class
     * to create a link list/to 
     * push and pop the list as needed
     * **************************
     * Date: 9/12/2017 USA
     * **************************
     * Date Changed:
     * **************************
     * Look At This!
     * my write method is not seeming
     * to malfunction although when i run
     * it the program doesn't function as
     * intended. Although, this 
     * doesn't appear to be because of my
     * code after a step by step.
     * 
     * **************************
     */
public class Link 
{
    public int value;
    public Link nextLink;
    public Link first;
    public Link last;
     /**
     * Method Name: push
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to push a value to the list
     * **************************
     * Date: 9/12/2017 USA
     * **************************
     */
  public void push(int newValue)
  {
      if(first==null)
      {
          //from class
           //IntegerLinkList temp=new IntegerLinkList();
          Link temp=new Link();
          temp.value=newValue;
          first=temp;
          last=temp;
      }else
      {
          Link temp=new Link();
          temp.value=newValue;
          last.nextLink=temp;
          last=temp;
      }
  }
   /**
     * Method Name: btnPopActionPerformed
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * to pop a value from the list
     * **************************
     * Date: 9/12/2017 USA
     * **************************
     */
  public void pop()
  {
      Link temp=new Link();
      temp=first;
      //I chose a while loop here to locate the link storing the last link as the nextLink
      //then I set that value to null to "remove" the link from the list
      while(temp.nextLink!=last)
      {
          temp=nextLink;
      }
      temp.nextLink=null;
  }
   /**
     * Method Name: btnPopActionPerformed
     * Method Author: Tyler Hockett
     * **************************
     * Purpose of the method
     * This should be writing the 
     * values of each list item then
     * passing the string back to main
     * **************************
     * Date: 9/12/2017 USA
     * **************************
     */
  public String write()
  {
      Link temp=new Link();
      temp=first;
      String answer=" ";
      //I used a do while loop because i wanted it to run at least once.
      //this loop works however the next steps in the debugg cause it to never return to main.
      do
      {
          answer+=" "+temp.value+" \n";
          temp=nextLink;
      }while(temp.nextLink!=null);
      return answer;
  }
}
