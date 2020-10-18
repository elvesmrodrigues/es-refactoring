public abstract class Price {
    public abstract int getPriceCode();
    
    public abstract double getCharge(int daysRented);
    
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}