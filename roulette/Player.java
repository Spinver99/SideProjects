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
public class Player {
    private int chips = 100;
    private Betting headbet = new Betting(0,"null",0);
    private Betting bets = headbet;
    
    public void placeBet(int amt, String bet, int pay) {
        bets.next = new Betting(amt,bet,pay);
        bets = bets.next;
        chips = chips - amt;
    }
    public int won(Pocket winner) {
        bets = headbet.next;
        int ammountwon = 0;
        do {
            if (winner.getNumber().compareTo(bets.getBet()) == 0) { //straight number
                ammountwon += (bets.getWager() * bets.getPayout()) + bets.getWager();
            }
            if (winner.getRealOdd().toUpperCase().compareTo(bets.getBet()) == 0) { //even or odd
                ammountwon += (bets.getWager() * bets.getPayout()) + bets.getWager();
            }
            if (winner.getColor().toUpperCase().compareTo(bets.getBet()) == 0) { //color
                ammountwon += (bets.getWager() * bets.getPayout()) + bets.getWager();
            }
            bets = bets.next;
        } while (bets != null);
        bets = headbet;
        bets.next = null;
        return ammountwon;
    }
}
