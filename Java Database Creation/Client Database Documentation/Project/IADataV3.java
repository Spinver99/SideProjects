/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ia.data.v3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Spinver
 */
public class IADataV3 {
    /**
     * @param args the command line arguments
     */
    public static String Divider() {
        return "----------------------------------------"; //returns a divider used in gui and save file
    }
    public static Node AddFile(Node head) {
        Node temp = head;
        IBIO out = null;
        while (temp.next!= null) {
            temp = temp.next; //moves to end
        }
        out.output(Divider());
        temp.next = new Node("","","","",-1,"","",-1,-1,"","","", temp); //blank node at next
        temp = temp.next; //moves to next (blank node)
        temp.Buyer = out.input("Please enter the buyer's name:");
        temp.Seller = out.input("Please enter the seller's name:");
        temp.Date = out.input("Please enter the date:");
        temp.Address = out.input("Please enter the address:");
        out.output("    1)Buyer");
        out.output("    2)Seller");
        out.output("    3)Bank");
        out.output("    4)Bank and Seller");
        temp.Representing = out.inputInt("Please enter who you are representing:");
        temp.Email = out.input("Please enter the email:");
        temp.Phone = out.input("Please enter the phone:");
        temp.SocialBuyer = out.inputInt("Please enter the buyer's social:");
        temp.SocialSeller = out.inputInt("Please enter the seller's social:");
        temp.Location = out.input("Please enter the file location:");
        temp.Lawyer = out.input("Please enter the lawyer's name:"); //gets info and asigns it to the blank node
        if (temp.Representing > 2) { //if rep bank gets loan officer
          temp.LoanOfficer = out.input("Please enter the loan officer's name:");  
        }
        return head;
    }
    public static Node Start() throws FileNotFoundException, IOException {
        File file = new File("Database.txt");
        FileReader reader = new FileReader(file);
        BufferedReader read = new BufferedReader(reader); //variables
        Node head = new Node("","","","",-1,"","",-1,-1,"","","", null);
        Node temp = head;
        IBIO in = null;
        String s; //variables
        if (read.readLine() != null) { //if there is something
            do {
                temp.next = new Node("","","","",-1,"","",-1,-1,"","","", temp); //blank node created
                temp = temp.next;
                temp.Buyer = read.readLine();
                temp.Seller = read.readLine();
                temp.Date = read.readLine();
                temp.Address = read.readLine();
                temp.Representing = Integer.parseInt(read.readLine());
                temp.Email = read.readLine();
                temp.Phone = read.readLine();
                temp.SocialBuyer = Integer.parseInt(read.readLine());
                temp.SocialSeller = Integer.parseInt(read.readLine());
                temp.Location = read.readLine();
                temp.Lawyer = read.readLine(); //sets each variable to the nodes parts
                if (temp.Representing > 2) { //if representing the bank
                    temp.LoanOfficer = read.readLine(); //gets loan officer
                }
            } while (read.readLine().compareTo("~~~~~~~~~~~~~~~~~~~~") != 0); //if its the end marker it stops, if it is the ---- marker it is just in between files
        } else { //if it is empty
            in.output("It seems there are no files in the database, please enter a file!"); //says it needs to add one
            head = AddFile(head); //forces you to add a file
        }
        head = head.next; //moves head along as head is blank
        head.prev = null; //deletes old head (as it is blank)
        return head;
    }
    public static void Out(Node file) {
        IBIO o = null;
        int i = 1;
        o.output(Divider());
        do { //while not null (the end)
            o.output(i + ":"); //outputs a number corresponding to the file, changes when sorted and searched
            o.output("    Buyer: " + file.Buyer);
            o.output("    Seller: " + file.Seller); //shows the buyer and seller
            i += 1; //adds one to the counter
            file = file.next; //moves along
        } while (file != null);
    }
    public static void Save(Node Head) throws IOException {
        File file = new File("Database.txt");
        FileWriter write = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(write); //variables
        do { //while its not at the end
            writer.write(Divider()); //divider
            writer.newLine(); //then all the things in the node
            writer.write(Head.Buyer);
            writer.newLine();
            writer.write(Head.Seller);
            writer.newLine();
            writer.write(Head.Date);
            writer.newLine();
            writer.write(Head.Address);
            writer.newLine();
            writer.write(Integer.toString(Head.Representing));
            writer.newLine();
            writer.write(Head.Email);
            writer.newLine();
            writer.write(Head.Phone);
            writer.newLine();
            writer.write(Integer.toString(Head.SocialBuyer));
            writer.newLine();
            writer.write(Integer.toString(Head.SocialSeller));
            writer.newLine();
            writer.write(Head.Location);
            writer.newLine();
            writer.write(Head.Lawyer);
            writer.newLine();
            if (Head.Representing > 2) { //if representing the bank saves the loan officer aswell
                writer.write(Head.LoanOfficer);
                writer.newLine();
            }
            Head = Head.next; //next node
        } while (Head != null);
        writer.write("~~~~~~~~~~~~~~~~~~~~"); //end line
        writer.close(); //closes file
    }
    public static void SeeAll(Node node, int in) {
        IBIO out = null;
        for (int i = 1; i < in; i++) {
            node = node.next; //goes untill the correct node as inputed by the user
        }
        out.output(Divider());
        out.output("Buyer: " + node.Buyer);
        out.output("Seller: " + node.Seller);
        out.output("Date: " + node.Date);
        out.output("Address: " + node.Address); 
        switch (node.Representing) { //switch for the representing as this is saved as a number, but a number makes no sense to the user.
            case 1: //1
                out.output("Representing: Buyer");
                break;
            case 2: //2
                out.output("Representing: Seller");
                break;
            case 3://3
                out.output("Representing: Bank");
                break;
            case 4://4
                out.output("Representing: Bank and Seller");
                break;
        }
        out.output("Email: " + node.Email);
        out.output("Phone: " + node.Phone);
        out.output("Buyer's Social: " + node.SocialBuyer);
        out.output("Seller's Social: " + node.SocialSeller);
        out.output("Location: " + node.Location);
        out.output("Lawyer: " + node.Lawyer); //outputs all
        if (node.Representing > 2) {
            out.output("Loan Officer:" + node.LoanOfficer); //if representing the bank, shows the loan officer
        }
    }
    public static void Edit(Node node, int file) {
        IBIO ib = null;
        for (int i = 1; i < file; i++) {
            node = node.next;
        }
        do {
            ib.output(Divider());
            ib.output("Menu 2:");
            ib.output("    1)Buyer");
            ib.output("    2)Seller");
            ib.output("    3)Date");
            ib.output("    4)Address");
            ib.output("    5)Representing");
            ib.output("    6)Email");
            ib.output("    7)Phone");
            ib.output("    8)Buyers Social");
            ib.output("    9)Sellers Social");
            ib.output("    10)File Location");
            ib.output("    11)Lawyer");
            if (node.Representing > 2) {
                ib.output("    12)Loan Officer");
            }
            ib.output("    0)Return to Menu 1");
            file = ib.inputInt("What would you like to edit:"); //gets what they want to redi
            int number = -1;
            String New = "";
            if (file == 8 || file == 9) { //if it is a social
                number = ib.inputInt("What would you like to change it to:"); //gets what to change it to
            } else if (file == 5) { //if it is a representing
                ib.output("    1)Buyer");
                ib.output("    2)Seller");
                ib.output("    3)Bank");
                ib.output("    4)Bank and Seller");
                number = ib.inputInt("What would you like to change it to:"); //just for who is represented
            } else if (file == 0) {
                //does nothing, as 0 requires nothing
            } else { //if it is anything else
                New = ib.inputString("What would you like to change it to:");
            }
            switch (file) { //choice to change
                case 1: //buyer
                    node.Buyer = New; //changesthe node to the new input
                    break;
                case 2: //seller
                    node.Seller = New;
                    break;
                case 3: //date
                    node.Date = New;
                    break;
                case 4: //address
                    node.Address = New;
                    break;
                case 5: //representing
                    node.Representing = number;
                    break;
                case 6://email
                    node.Email = New;
                    break;
                case 7: //phone
                    node.Phone = New;
                    break;
                case 8: //social buyer
                    node.SocialBuyer = number;
                    break;
                case 9: //social of seller
                    node.SocialSeller = number;
                    break;
                case 10: //file location
                    node.Location = New;
                    break;
                case 11: //lawyers name
                    node.Lawyer = New;
                    break;
                case 12: //loan officer
                    node.LoanOfficer = New;
                    break;
            }
        } while (file != 0);//if its not 0, continues to edit untill 0 is inputed
        
    }
    public static Node Search(Node head, String b, String s, String d, String a, String e, String p, String local, String law, int rep, int bs, int ss) {
        boolean used = false;
        do {
            if (b.compareTo("") != 0 && b.compareTo(head.Buyer) != 0) {
                if (head.prev != null) {
                    head.prev.next = head.next;
                    head.next.prev = head.prev;
                    head = head.next;
                } else {
                    head = head.next;
                    head.prev = null;
                }
                used = true;
            }
            if (head != null) {
                if (s.compareTo("") != 0 && s.compareTo(head.Seller) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (d.compareTo("") != 0 && d.compareTo(head.Date) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }used = true;
                    used = true;
                }
            }
            if (head != null) {
                if (a.compareTo("") != 0 && a.compareTo(head.Address) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (e.compareTo("") != 0 && e.compareTo(head.Email) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (p.compareTo("") != 0 && p.compareTo(head.Phone) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (local.compareTo("") != 0 && local.compareTo(head.Location) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (law.compareTo("") != 0 && law.compareTo(head.Lawyer) != 0) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            
            if (head != null) {
                if (rep != -1 && head.Representing != rep) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (bs != -1 && head.SocialBuyer != bs) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (head != null) {
                if (ss != -1 && head.SocialSeller != ss) {
                    if (head.prev != null) {
                        head.prev.next = head.next;
                    } else {
                        head = head.next;
                        head.prev = null;
                    }
                    if (head.next != null) {
                        head.next.prev = head.prev;
                    }
                    used = true;
                }
            }
            if (used == false) {
                head = head.next;
            } else {
                used = false;
            }
            
        } while (head.next != null);

        if (b.compareTo("") != 0 && b.compareTo(head.Buyer) != 0) {
            if (head.prev != null) {
                head.prev.next = null;
            } else {
                head = null;
            }
            
        }
        if (head != null && head.prev != null) {
            do  {
                head = head.prev;
            } while (head.prev != null);
        }
        
        return head;
    }
    public static Node Sort(Node head, int how) {
        Node sort = head;
        Node temp = new Node("","","","",-1,"","",-1,-1,"","","", null); //makes a new blank node
	        boolean swapDone = true; //boolean
	        while (swapDone) { 
	            
	        	swapDone = false; //sets it to false
	            while (sort != null) { //while the node is not null
	                
	            	switch (how) { //switch for how they want to sort
                            case 1: //buyer
                                if (sort.next != null && sort.Buyer.compareTo(sort.next.Buyer) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer; //sets the temp (blank)to the current node
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address; //resets each of the nodes to the temp node
                                    swapDone = true; //is true
                                }
                                break;
                            case 2: //seller
                                if (sort.next != null && sort.Seller.compareTo(sort.next.Seller) > 0) { //same as above but for seller, same for below
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 3: //date
                                if (sort.next != null && sort.Date.compareTo(sort.next.Date) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 4: //address
                                if (sort.next != null && sort.Address.compareTo(sort.next.Address) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 5: //representing
                                if (sort.next != null && sort.Representing > sort.next.Representing) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 6: //email
                                if (sort.next != null && sort.Email.compareTo(sort.next.Email) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 7: //phone
                                if (sort.next != null && sort.Phone.compareTo(sort.next.Phone) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 8: //buyers social
                                if (sort.next != null && sort.SocialBuyer > sort.next.SocialBuyer) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 9: //sellers social
                                if (sort.next != null && sort.SocialSeller > sort.next.SocialSeller) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 10: //file location
                                if (sort.next != null && sort.Location.compareTo(sort.next.Location) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                            case 11: //lawyer
                                if (sort.next != null && sort.Lawyer.compareTo(sort.next.Lawyer) > 0) {
                                    temp.Buyer = sort.Buyer;
                                    temp.Seller = sort.Seller;
                                    temp.Date = sort.Date;
                                    temp.Address = sort.Address;
                                    temp.Representing = sort.Representing;
                                    temp.Email = sort.Email;
                                    temp.Phone = sort.Phone;
                                    temp.SocialBuyer = sort.SocialBuyer;
                                    temp.SocialSeller= sort.SocialSeller;
                                    temp.Location= sort.Location;
                                    temp.Lawyer = sort.Lawyer;
                                    temp.LoanOfficer = sort.LoanOfficer;
                                    
                                    sort.Buyer = sort.next.Buyer;
                                    sort.next.Buyer = temp.Buyer;
                                    sort.Seller = sort.next.Seller;
                                    sort.next.Seller = temp.Seller;
                                    sort.Date = sort.next.Date;
                                    sort.next.Date = temp.Date;
                                    sort.Representing = sort.next.Representing;
                                    sort.next.Representing = temp.Representing;
                                    sort.Email = sort.next.Email;
                                    sort.next.Email = temp.Email;
                                    sort.Phone = sort.next.Phone;
                                    sort.next.Phone = temp.Phone;
                                    sort.SocialBuyer = sort.next.SocialBuyer;
                                    sort.next.SocialBuyer = temp.SocialBuyer;
                                    sort.SocialSeller = sort.next.SocialSeller;
                                    sort.next.SocialSeller = temp.SocialSeller;
                                    sort.Location = sort.next.Location;
                                    sort.next.Location = temp.Location;
                                    sort.Lawyer = sort.next.Lawyer;
                                    sort.next.Lawyer = temp.Lawyer;
                                    sort.LoanOfficer = sort.next.LoanOfficer;
                                    sort.next.LoanOfficer = temp.LoanOfficer;
                                    sort.Address = sort.next.Address;
                                    sort.next.Address = temp.Address;
                                    swapDone = true;
                                }
                                break;
                        }
	                sort = sort.next; //goes to the next node
	            }
	            sort = head; //resets the node back to the head
	        } 
        return head; //returns the head node
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String b,s,d,a,e,p,local,law;
        b = "";
        s = "";
        d = "";
        a = "";
        e = "";
        p = "";
        local = "";
        law = "";
        int rep,bs,ss; //used for searching
        rep = -1;
        bs = -1;
        ss = -1;
        Node head = Start();
        Node temp = head;
        Node searched;
        int input;
        IBIO ib = null; //variables
        do { //while input != 7
            Out(head);
            ib.output(Divider()); //outputs the divider (--------------------------)
            ib.output("Menu 1:");
            ib.output("    1)Add a File");
            ib.output("    2)See all the categories of one file");
            ib.output("    3)Sort");
            ib.output("    4)Search");
            ib.output("    5)Edit a file");
            ib.output("    6)Delete a file");
            ib.output("    7)Save and quit");
            input = ib.inputInt("Choice:"); //gets choice
            
            switch (input) { //switch for user choice from menu one
                case 1: //add
                    AddFile(head); //calls addFile method and sends node head
                    break;
                case 2: //see all
                    input = ib.inputInt("Please enter the file number you want to see all of:"); //gets file number
                    SeeAll(head, input); //sends the node head and what file number
                    ib.input("Press enter to continue:"); //pauses
                    input = -1; //resets input (incase it is 7 and it would stop loop)
                    break;
                case 3: //sort
                    ib.output(Divider());
                    ib.output("Menu 2:");
                    ib.output("    1)Buyer");
                    ib.output("    2)Seller");
                    ib.output("    3)Date");
                    ib.output("    4)Address");
                    ib.output("    5)Representing");
                    ib.output("    6)Email");
                    ib.output("    7)Phone");
                    ib.output("    8)Buyers Social");
                    ib.output("    9)Sellers Social");
                    ib.output("    10)File Location");
                    ib.output("    11)Lawyer"); //outputs menu
                    input = ib.inputInt("What would you like to sort by:"); //gets how user wants to sort
                    head = Sort(head, input); //calls sort method and sends head and input (input = how user wants to sort)
                    input = -1; //resets input
                    break;
                case 4: //search
                    ib.output(Divider());
                    ib.output("Menu 2:");
                    ib.output("    1)Buyer");
                    ib.output("    2)Seller");
                    ib.output("    3)Date");
                    ib.output("    4)Address");
                    ib.output("    5)Representing");
                    ib.output("    6)Email");
                    ib.output("    7)Phone");
                    ib.output("    8)Buyers Social");
                    ib.output("    9)Sellers Social");
                    ib.output("    10)File Location");
                    ib.output("    11)Lawyer");
                    input = ib.inputInt("What would you like to search:"); //gets new input from user on what to search by
                    switch (input) { //using input
                        case 1: //buyer
                            b = ib.input("Please enter what you want to search:"); //resets the string b, representing buyer
                            break;
                        case 2: //seller
                            s = ib.input("Please enter what you want to search:"); //see buyer for all that is below
                            break;
                        case 3: //date
                            d = ib.input("Please enter what you want to search:");
                            break;
                        case 4: //address
                            a = ib.input("Please enter what you want to search:");
                            break;
                        case 5: //represnting
                            rep = ib.inputInt("Please enter what you want to search:");
                            break;
                        case 6: //email
                            e = ib.input("Please enter what you want to search:");
                            break;
                        case 7: //phone
                            p = ib.input("Please enter what you want to search:");
                            break;
                        case 8: //buyers social
                            bs = ib.inputInt("Please enter what you want to search:");
                            break;
                        case 9: //sellers social
                            ss = ib.inputInt("Please enter what you want to search:");
                            break;
                        case 10: //location
                            local = ib.input("Please enter what you want to search:");
                            break;
                        case 11: //lawyer
                            law = ib.input("Please enter what you want to search:");
                            break;
                    }
                    searched = Search(head,b,s,d,a,e,p,local,law,rep,bs,ss); //calls search method, sends head and all strings
                    if (searched != null) {
                        Out(searched); //outputs using searched node
                    } else {
                        ib.output(Divider());
                        ib.output("Nothing!");
                        ib.output(Divider());
                    }
//                    ib.output(Divider());
//                    Out(head);
//                    Out(searched);
                    ib.input("Press enter to continue"); //pauses
                    input = -1; //resets input
                    break;
                case 5: //edit
                    input = ib.inputInt("Please enter the file number to edit:"); //gets file number
                    SeeAll(head, input); //shows all parts of the file
                    Edit(head, input); //calls edit method sending head and file number
                    input = -1; //resets input
                    break;
                case 6: //delete
                    input = ib.inputInt("Enter the file number to delete:"); //gets file number
                    temp = head; //declares temp as head
                    for (int i = 1; i < input; i++) {
                        temp = temp.next; //moves temp to file to be deleted
                    }
                    if (temp.prev != null) { //if its not the head
                        temp.prev.next = temp.next; //deletes by making prev.next next
                    } else { //if it is the head
                        head = head.next; //moves head to head.next
                        head.prev = null; //deletes the original head
                    }
                    if (temp.next != null) { //if it is not the end
                        temp.next.prev = temp.prev; //deletes it again
                    }
                    temp = head; //resets temp
                    input = -1; //resets input
                    break;
                case 7: //save/quit
                    Save(head); //calls save method, sends head
                    break;
            }
        } while (input != 7); //if input is 7 ends
    }
    
}
