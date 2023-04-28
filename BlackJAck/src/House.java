public class House {
    
    private int balance;
    
    private House() {
        balance = 1000000;
    }
    
    public void setBalance(int x) {
        this.balance = this.balance - x;
    }
    
    public int getBalance() {
        return this.balance;
    }
}