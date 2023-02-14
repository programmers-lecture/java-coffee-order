package domain.coupon;

public class Coupon {
    private final String phoneNumber;

    public Coupon(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String otherPhoneNumber = obj.toString();
        return this.phoneNumber.equals(otherPhoneNumber);
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
