/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roulette;

/**
 *
 * @author Spinver
 */
public class Betting {
    private int ammount;
    private String bet;
    private int payout; // this number to 1
    public Betting next;
    
    public Betting(int amt, String betting, int pay) {
        ammount = amt;
        bet = betting;
        payout = pay;
        next = null;
    }
    public String getBet() {
        return bet;
    }
    public int getPayout() {
        return payout;
    }
    public int getWager() {
        return ammount;
    }
    /**
     * 0 = 0 / 35 to 1
     * 1 = 1 / 35 to 1
     * 00 = 37 / 35 to 1
     * even = 38 / 1 - 1
     * odd = 39 / 1 - 1
     * red = 40 / 1 - 1
     * black = 41 / 1-1
     * 1-18 (low) = 42 / 1-1
     * 19-36 (high) = 43 / 1-1
     * dozen 1 = 44 / 2-1
     * dozen 2 = 45 / 2-1
     * dozen 3 = 46 / 2-1
     * column 1 = 47 / 2-1
     * column 2 = 48 / 2-1
     * column 3 = 49 / 2-1
     */
}
