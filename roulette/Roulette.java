/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;

import java.util.Scanner;

/**
 *
 * @author Spinver
 */
public class Roulette {

    /**
     * @param args the command line arguments
     */
    public static Pocket start() {
        Pocket zero;
        Pocket temp;
        
        zero = new Pocket("0", 3, false);
        temp = zero;
        temp.next = new Pocket("2", 1, false);
        temp = temp.next;
        temp.next = new Pocket("14", 0, false);
        temp = temp.next;
        temp.next = new Pocket("35", 1, true);
        temp = temp.next;
        temp.next = new Pocket("23", 0, true);
        temp = temp.next;
        temp.next = new Pocket("4", 1, false);
        temp = temp.next;
        temp.next = new Pocket("16", 0, false);
        temp = temp.next;
        temp.next = new Pocket("33", 1, true);
        temp = temp.next;
        temp.next = new Pocket("21", 0, true);
        temp = temp.next;
        temp.next = new Pocket("6", 1, false);
        temp = temp.next;
        temp.next = new Pocket("18", 0, false);
        temp = temp.next;
        temp.next = new Pocket("31", 1, true);
        temp = temp.next;
        temp.next = new Pocket("19", 0, true);
        temp = temp.next; 
        temp.next = new Pocket("8", 1, false);
        temp = temp.next;
        temp.next = new Pocket("12", 0, false);
        temp = temp.next;
        temp.next = new Pocket("29", 1, true);
        temp = temp.next;
        temp.next = new Pocket("25", 0, true);
        temp = temp.next;
        temp.next = new Pocket("10", 1, false);
        temp = temp.next;
        temp.next = new Pocket("27", 0, true);
        temp = temp.next;
        temp.next = new Pocket("00", 3, false);
        temp = temp.next;
        temp.next = new Pocket("1", 0, true);
        temp = temp.next;
        temp.next = new Pocket("13", 1, true);
        temp = temp.next;
        temp.next = new Pocket("36", 0, false);
        temp = temp.next;
        temp.next = new Pocket("24", 1, false);
        temp = temp.next;
        temp.next = new Pocket("3", 0, true);
        temp = temp.next;
        temp.next = new Pocket("15", 1, true);
        temp = temp.next;
        temp.next = new Pocket("34", 0, false);
        temp = temp.next;
        temp.next = new Pocket("22", 1, false);
        temp = temp.next;
        temp.next = new Pocket("5", 0, true);
        temp = temp.next;
        temp.next = new Pocket("17", 1, true);
        temp = temp.next;
        temp.next = new Pocket("32", 0, false);
        temp = temp.next;
        temp.next = new Pocket("20", 1, false);
        temp = temp.next;
        temp.next = new Pocket("7", 0, true);
        temp = temp.next;
        temp.next = new Pocket("11", 1, true);
        temp = temp.next;
        temp.next = new Pocket("30", 0, false);
        temp = temp.next;
        temp.next = new Pocket("26", 1, false);
        temp = temp.next;
        temp.next = new Pocket("9", 0, true);
        temp = temp.next;
        temp.next = new Pocket("28", 1, false);
        temp = temp.next;
        temp.next = zero;
        
        return zero;
    }
    public static int findPayout(String bet) {
        if (bet.length() > 3) {
            if (bet.substring(0,3).compareTo("ROW") == 0) {
                return 11;
            }
        }
        if (bet.length() > 6) {
            if (bet.substring(0,6).compareTo("COLUMN") == 0) {
                return 2;
            }
        }
        switch (bet) {
            case "ODD":
                return 1;
            case "EVEN":
                return 1;
            case "RED":
                return 1;
            case "BLACK":
                return 1;
            case "LOW":
                return 1;
            case "HIGH":
                return 1;
            case "FIRST THIRD":
                return 2;
            case "SECOND THIRD":
                return 2;
            case "THIRD THIRD":
                return 2;
            default:
                return 35;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Pocket wheel = start();
        Scanner input = new Scanner (System.in);
        int temp = 0;
        Player player1 = new Player();
        int money = 100;
        boolean bool = false;
        
        System.out.println("       _    _");
        System.out.println("      / \\  / \\");
        System.out.println("     /   \\/   \\");
        System.out.println(" ___| 0  |  00 |");
        System.out.println("|1/2|1| 1| 2| 3|");
        System.out.println("|___|/| 4| 5| 6|");
        System.out.println("|E  |3| 7| 8| 9|");
        System.out.println("|___|_|10|11|12|");
        System.out.println("|Red|2|13|14|15|");
        System.out.println("|___|/|16|17|18|");
        System.out.println("|B  |3|19|20|21|");
        System.out.println("|___|_|22|23|24|");
        System.out.println("|Odd|3|27|26|25|");
        System.out.println("|___|/|28|29|30|");
        System.out.println("|2/2|3|31|32|33|");
        System.out.println("|___|_|34|35|36|");
        
        System.out.println("How to bet:");
        System.out.println("1)To bet on a single number just enter the number");
        System.out.println("2)To bet even, odd, black, or red simply type it");
        System.out.println("3)To bet on the first half enter \"low\"");
        System.out.println("4)To bet on the second half enter \"high\"");
        System.out.println("5)To bet on a third, simply type \"____ third\" (blank being first, second, third)");
        System.out.println("6)To bet on a column simply type \"column _\" where the blank is the number at the top of the column (excluding the 0 and 00)");
        System.out.println("7)To bet on a row simply type \"Row _\" where the blank is the lowest number in the row");
        System.out.println("8)To bet on two numbers simply type \"Two\" followed by two numbers:\"Two 2 3\" or \"Two 2 5\"");
        
        System.out.println("After entering a bet, type in the ammount of money to bet");
        System.out.println("Type \"stop\" to stop betting and roll the wheel!");
        
        wheel = wheel.next; //REMOVE THIS  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        String bet = "";
        int wager = 0;
        int totalwager = 0;
        do {
            boolean fix = false;
            do {
                System.out.print("Enter bet:");
                bet = input.nextLine();
                if (fix == true) {
                    bet = input.nextLine();
                }
                fix = true;
                bet = bet.toUpperCase();
                if (bet.compareTo("STOP") != 0) { //if they did not enter stop
                    System.out.print("Wager:"); 
                    wager = input.nextInt(); //gets wager
                    totalwager += wager;
                    if (bet.length() > 6) { //if its bigger than six (to stop errors for occuring)
                        if (bet.substring(0,6).compareTo("COLUMN") == 0) { //sees if it is a column bet
                            bet = bet.substring(7); //removes "column " leaving just the column number
                            if (bet.compareTo("1") == 0) { //if its column 1
                                for (int i = 1; i < 35; i= i + 3) { //places a bet (of 2 to 1) for all numbers in that column
                                    player1.placeBet(wager, String.valueOf(i), 2);
                                }
                            } else if (bet.compareTo("2") == 0) { //if it is column 2, follows column 1
                                for (int i = 2; i < 36; i= i + 3) {
                                    player1.placeBet(wager, String.valueOf(i), 2);
                                }
                            } else if (bet.compareTo("3") == 0) { //if it is column 3, follows column 1
                                for (int i = 3; i < 36; i= i + 3) {
                                    player1.placeBet(wager, String.valueOf(i), 2);
                                }
                            }
                        }  else if (bet.compareTo("FIRST THIRD") == 0) {
                            for (int i = 1; i < 13; i++) {
                                player1.placeBet(wager, String.valueOf(i), 2); //places a bet for all the low numbers
                            }
                        } else if (bet.compareTo("SECOND THIRD") == 0) {
                            for (int i = 13; i < 25; i++) {
                                player1.placeBet(wager, String.valueOf(i), 2); //places a bet for all the low numbers
                            }
                        } else if (bet.compareTo("FIRST THIRD") == 0) {
                            for (int i = 25; i < 36; i++) {
                                player1.placeBet(wager, String.valueOf(i), 2); //places a bet for all the low numbers
                            }
                        } else if (bet.substring(0,3).compareTo("TWO") == 0) {
                            bet = bet.substring(4);
                            int space = bet.indexOf(" ");
                            if (Math.abs(Integer.valueOf(bet.substring(0,space)) - Integer.valueOf(bet.substring(space + 1))) == 1) {
                                bool = false;
                                for (int i = 2; i < 36; i = i+3) {
                                    if (Integer.valueOf(bet.substring(0,space)) == i) {
                                        bool = true;
                                    } else if ((Integer.valueOf(bet.substring(space + 1)) == i)) {
                                        bool = true;
                                    }
                                }
                                if (bool == true) {
                                    player1.placeBet(wager, bet.substring(0,space), 17);
                                    player1.placeBet(wager, bet.substring(space + 1), 17);
                                } else {
                                    System.out.println("These numbers are not together on the board, invalid bet!");
                                    totalwager -= wager;
                                }
                            } else if (Math.abs(Integer.valueOf(bet.substring(0,space)) - Integer.valueOf(bet.substring(space + 1))) == 3) {
                                player1.placeBet(wager, bet.substring(0,space), 17);
                                player1.placeBet(wager, bet.substring(space + 1), 17);
                            } else {
                                System.out.println("These numbers are not together on the board, invalid bet!");
                                totalwager -= wager;
                            }
                        }
                    } else if (bet.length() > 3) { //if it is bigger than 3 (again, to stop errors from occuring)
                        if (bet.substring(0,3).compareTo("ROW") == 0) { //if it is a row
                            bet = bet.substring(4); //removes "row "
                            switch (bet) { //the switch is just to check if the row is a valid row (meaning they entered the first number in the row)
                                case "1":
                                    player1.placeBet(wager, "1", 11); 
                                    player1.placeBet(wager, "2", 11);
                                    player1.placeBet(wager, "3", 11); //places a bet (at 11 to 1) at all three numbers in the row, repeats for all real rows;
                                    break;
                                case "4":
                                    player1.placeBet(wager, "4", 11); 
                                    player1.placeBet(wager, "5", 11);
                                    player1.placeBet(wager, "6", 11);
                                    break;
                                case "7":
                                    player1.placeBet(wager, "7", 11); 
                                    player1.placeBet(wager, "8", 11);
                                    player1.placeBet(wager, "9", 11);
                                    break;
                                case "10":
                                    player1.placeBet(wager, "10", 11); 
                                    player1.placeBet(wager, "11", 11);
                                    player1.placeBet(wager, "12", 11);
                                    break;
                                case "13":
                                    player1.placeBet(wager, "13", 11); 
                                    player1.placeBet(wager, "14", 11);
                                    player1.placeBet(wager, "15", 11);
                                    break;
                                case "16":
                                    player1.placeBet(wager, "16", 11); 
                                    player1.placeBet(wager, "17", 11);
                                    player1.placeBet(wager, "18", 11);
                                    break;
                                case "19":
                                    player1.placeBet(wager, "19", 11); 
                                    player1.placeBet(wager, "20", 11);
                                    player1.placeBet(wager, "21", 11);
                                    break;
                                case "22":
                                    player1.placeBet(wager, "22", 11); 
                                    player1.placeBet(wager, "23", 11);
                                    player1.placeBet(wager, "24", 11);
                                    break;
                                case "25":
                                    player1.placeBet(wager, "25", 11); 
                                    player1.placeBet(wager, "26", 11);
                                    player1.placeBet(wager, "27", 11);
                                    break;
                                case "28":
                                    player1.placeBet(wager, "28", 11); 
                                    player1.placeBet(wager, "29", 11);
                                    player1.placeBet(wager, "30", 11);
                                    break;
                                case "31":
                                    player1.placeBet(wager, "31", 11); 
                                    player1.placeBet(wager, "32", 11);
                                    player1.placeBet(wager, "33", 11);
                                    break;
                                case "34":
                                    player1.placeBet(wager, "34", 11); 
                                    player1.placeBet(wager, "35", 11);
                                    player1.placeBet(wager, "36", 11);
                                    break;
                                default: //if it is not a valid row
                                    System.out.println("Please enter a valid row, try entering the first number in the row!");
                                    totalwager -= wager; //removes the wager from total wager (it adds the wager to total wager before in order to make it all done at once, however if this was not here it would be as if the user bet this when he didnt)
                            }
                            player1.placeBet(wager, bet, 11); 
                                player1.placeBet(wager, String.valueOf(Integer.valueOf(bet) + 1), 11);
                                player1.placeBet(wager, String.valueOf(Integer.valueOf(bet) + 2), 11); //places a bet (at 11 to 1) at all three numbers in the row
                        } else if (bet.compareTo("BLACK") == 0) { //if the user bets black
                            player1.placeBet(wager, bet, findPayout(bet)); //places bet
                        } else if (bet.compareTo("EVEN") == 0) { //if the user bets even
                            player1.placeBet(wager, bet, findPayout(bet)); //places bet
                        } else if (bet.compareTo("HIGH") == 0) { //if the user bets high (last 1/2 of the numbers)
                            for (int i = 19; i < 36; i++) {
                                player1.placeBet(wager, String.valueOf(i), 1); //places a bet for all of these numbers
                            }
                        }
                    } else if (bet.compareTo("LOW") == 0) { //if the user bets low (1-19)
                        for (int i = 1; i < 19; i++) {
                            player1.placeBet(wager, String.valueOf(i), 2); //places a bet for all the low numbers
                        }
                    } else { //if they just bet one number
                        player1.placeBet(wager, bet, findPayout(bet)); //places a bet
                    }
                } else {
                    if (totalwager < 5) {
                        System.out.println("You did not meet the minimum bet requirement of 5!");
                        bet = "";
                    }
                }
            } while (bet.compareTo("STOP") != 0);
            System.out.println("Spinning now!");
//            for (int i = 0; i < ((int)(Math.random()*114)); i++) {
//                wheel = wheel.next; //randomizer for the wheel, makes the wheel "spin" a random number of numbers
//            }
            System.out.println("The number is " + wheel.getNumber() + " and it is a " + wheel.getColor() + " number!");
            System.out.println(player1.won(wheel));
        } while (wager != 10000); //infinite loop
    }
    
}
