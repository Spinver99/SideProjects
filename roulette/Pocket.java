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
public class Pocket {
    private String number;
    Pocket next;
    private int color; //0 == red, 1 == black, 3 == green (for 0 and 00)
    private boolean odd; //true means it is odd, false means it is even

    public Pocket(String n, int c, boolean o) {
        number = n;
        color = c;
        odd = o;
        next = null;
    }
    
    public int getIntColor() {
        return color;
    }
    public String getColor() {
        switch (color) {
                case 1:
                    return "black";
                case 0:
                    return "red";
                default:
                    return "green";
        }
    }
    public String getNumber() {
        return number;
    }
    public String getRealOdd() {
        if (odd == false) {
            return "Even";
        } else {
            return "Odd";
        }
    }
    public boolean getOdd() {
        return odd;
    }
}
