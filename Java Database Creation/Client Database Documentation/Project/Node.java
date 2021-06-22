/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.data.v3;

/**
 *
 * @author Spinver
 */
public class Node {
    IBIO Input;
    String Buyer;
    String Seller;
    String Date;
    String Address;
    int Representing;
    /**
     * 1 = Buyer
     * 2 = Seller
     * 3 = Bank
     * 4 = Bank and Seller
     */
    String Email;
    String Phone;
    int SocialBuyer;
    int SocialSeller;
    String Location;
    String Lawyer;
    Boolean OfficerNeeded = false; //True is needed, False is not. Only needed if representing bank.
    String LoanOfficer = "";
    Node prev;
    Node next = null;
    public Node (String b, String s, String d, String a, int r, String e, String p, int bs, int ss, String local, String Law, String Loan, Node pr) {
        Buyer = b;
        Seller = s;
        Date = d;
        Address = a;
        Representing = r;
        Email = e;
        Phone = p;
        SocialBuyer = bs;
        SocialSeller = ss;
        Location = local;
        Lawyer = Law;
        if (Representing > 2) {
            OfficerNeeded = true;
        }
        if (OfficerNeeded == true) {
            LoanOfficer = Input.inputString("Please enter the loan officer's name:");
        }
        prev = pr;
    }
}
