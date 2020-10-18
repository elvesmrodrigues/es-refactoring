public class TextStatement extends Statement {
    public String headerStatement(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    public String bodyStatement(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
    }

    public String footerStatement(Customer aCustomer) {
        String result = "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }
}