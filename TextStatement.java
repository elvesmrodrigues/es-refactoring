import java.util.Enumeration;

public class TextStatement extends Statement {
    private String headerStatement(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    private String bodyStatement(Rental aRental) {
        return "\t" + aRental.getMovie().getTitle() + "\t" + String.valueOf(aRental.getCharge()) + "\n";
    }

    private String footerStatement(Customer aCustomer) {
        String result = "Amount owed is " + String.valueOf(aCustomer.getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = this.headerStatement(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for this rental
            result += this.bodyStatement(each);
        }
        // add footer lines
        result += this.footerStatement(aCustomer);
        return result;
    }
}