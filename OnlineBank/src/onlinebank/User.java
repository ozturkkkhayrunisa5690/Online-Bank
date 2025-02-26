
package onlinebank;

import java.util.ArrayList;

/**
 *
 * @author hayrunisa
 */
public class User {


    private String name;
    private String surname;
    private String email;
    private String citizenNumber;
    private String password;
    private ArrayList <CreditCard> creditCards;
    private ArrayList <Account> accounts;

    public User(String name, String surname, String email, String citizenNumber, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.citizenNumber = citizenNumber;
        this.password = password;
        this.creditCards = new ArrayList<CreditCard>();
        this.accounts = new ArrayList<Account>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCitizenNumber() {
        return citizenNumber;
    }

    public void setCitizenNumber(String citizenNumber) {
        this.citizenNumber = citizenNumber;
    }
    public void addCreditCard(CreditCard c){
        this.creditCards.add(c);
    }
    public void addAccount(Account a){
        this.accounts.add(a);
    }
    public CreditCard getCreditCardByIndex(int index){
        return this.creditCards.get(index);
    }
    public Account getAccountByIndex(int index){
        return this.accounts.get(index);
    }
    public void payToCreditCard(int ccIndex,int accIndex, double amount){
        Account a = accounts.get(accIndex);
        CreditCard c = creditCards.get(ccIndex);
        boolean success = a.sendToCreditCard(c, amount);
        if(success){
            System.out.println("Success");
        }
        else{
            System.out.println("Balance is not enough!");
        }
    }
    public void payWithCreditCard(int ccIndex, Account a, double amount){
        CreditCard c = creditCards.get(ccIndex);
        boolean success = c.pay(a, amount);
        if(success){
            System.out.println("Success");
        }
        else{
            System.out.println(" Current limit is not enough!");
        }
    }
    public  void makeEFT(int accIndex, Account receiver, double amount){
        Account sender = accounts.get(accIndex);
        boolean success = sender.sendEFT(receiver,amount);
         if(success){
            System.out.println("Success");
        }
        else{
            System.out.println("Balance is not enough!");
        }
    }
    public void pushNotification(User owner, double amount){
        System.out.println(owner.getName()+" send "+amount+" dollar.");
    }
    
    
}
