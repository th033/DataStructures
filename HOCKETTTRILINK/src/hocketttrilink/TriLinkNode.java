/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hocketttrilink;

/**
     * Class Name: TriLinkNode
     * Class Author: Tyler Hockett
     * **************************
     * Purpose of the Class
     * to hold values inserted into the 
     * trilinktree
     * **************************
     * Date: 12/7/2017 USA
     * **************************
     * Date Changed:
     * **************************
     * Look At This!
     * 
     * **************************
     */
public class TriLinkNode 
{
    public int v1, v2;
    public TriLinkNode up, left, down, right;
    public boolean d1, d2,i1,i2;
    
    public TriLinkNode()
    {
        d1=false;
        d2=false;
        i1=false;
        i2=false;
    }
}
