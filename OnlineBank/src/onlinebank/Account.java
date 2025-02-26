/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinebank;

/**
 *
 * @author hayrunisa
 */
public class Account {

    
    private String iban;
    private double balance;
    private double minimmumBalance;
    private User owner;

    public Account(String iban, double balance, double minimmumBalance, User owner) {
        this.iban = iban;
        this.balance = balance;
        this.minimmumBalance = minimmumBalance;
        this.owner = owner;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimmumBalance() {
        return minimmumBalance;
    }

    public void setMinimmumBalance(double minimmumBalance) {
        this.minimmumBalance = minimmumBalance;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
    public boolean sendEFT(Account receiver, double amount){
        if(this.minimmumBalance>=(this.balance - amount)){
           this.balance -=amount;
           receiver.receiveEFT(this,amount);
           return true;
        }
        return false;
    }
    public void receiveEFT(Account sender, double amount){
        this.balance += amount;
        System.out.println("EFT was sent by:"+sender.getOwner().getName());
        owner.pushNotification(sender.owner, amount);
    }
    public boolean sendToCreditCard(CreditCard c, double amount){
        if((balance -amount)>=this.minimmumBalance){
            balance-=amount;
            c.receive(this, amount);
            return true;
        }
        return false;
    }
}
