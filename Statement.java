import java.util.Enumeration;

public abstract class Statement {
    public abstract String headerStatement(Customer aCustomer);
    public abstract String bodyStatement(Rental aRental);
    public abstract String footerStatement(Customer aCustomer);

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
