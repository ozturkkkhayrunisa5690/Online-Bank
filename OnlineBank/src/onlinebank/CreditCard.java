
package onlinebank;

/**
 *
 * @author hayrunisa
 */
public class CreditCard {


    private String cCNumber;
    private User owner;
    private double limit;
    private double debt;
    private double minimmumDebtRatio;
    private double currentLimit;
    

    public CreditCard(String cCNumber, User owner, double limit, double debt, double minimmumDebtRatio, double currentLimit) {
        this.cCNumber = cCNumber;
        this.owner = owner;
        this.limit = limit;
        this.debt = debt;
        this.minimmumDebtRatio = minimmumDebtRatio;
        this.currentLimit = currentLimit;
    }

    public String getcCNumber() {
        return cCNumber;
    }

    public void setcCNumber(String cCNumber) {
        this.cCNumber = cCNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getMinimmumDebtRatio() {
        return minimmumDebtRatio;
    }

    public void setMinimmumDebtRatio(double minimmumDebt) {
        this.minimmumDebtRatio = minimmumDebt;
    }

    public double getCurrentLimit() {
        return currentLimit;
    }

    public void setCurrentLimit(double currentLimit) {
        this.currentLimit = currentLimit;
    }
    public boolean pay(Account receiver, double amount){
        if((this.debt + amount)<=this.limit){
            this.debt +=amount;
            this.currentLimit-=amount;
            receiver.setBalance(receiver.getBalance()+amount);
            return true;
        }
        return false;
    }
    public void receive(Account sender, double amount){
        this.debt -=amount;
        this.currentLimit +=amount;
        User accOwner = sender.getOwner();
        System.out.println("Debt was paid by:"+accOwner.getName());
    }
    
}
