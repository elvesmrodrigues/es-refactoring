import java.util.Enumeration;

public class HtmlStatement extends Statement {
    private String headerStatement(Customer aCustomer) {
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    } 

    private String bodyStatement(Rental aRental) {
        return aRental.getMovie().getTitle() + ": " + String.valueOf(aRental.getCharge()) + "<BR>\n";
    }

    private String footerStatement(Customer aCustomer) {
        String result = "<P>You owe <EM>" + String.valueOf(aCustomer.getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(aCustomer.getTotalFrequentRenterPoints()) + "</EM> frequent renter points<P>";
        return result;
    }

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();
        String result = this.headerStatement(aCustomer);
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += this.bodyStatement(each);
        }
        // add footer lines
        result += this.footerStatement(aCustomer);
        return result;
    }
}