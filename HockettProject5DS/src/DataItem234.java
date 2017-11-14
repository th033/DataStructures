/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Boss
 */
public class DataItem234 
{
private String dData;
private int count=0;
public DataItem234(String dd)
{
    dData=dd;
    count++;
}
public String getDData()
{
    return dData;
}
public void displayItem()
{
    System.out.print("/"+dData);
}
public int getCount()
{
    return count;
}
public void addCount()
{
    count++;
}
}
