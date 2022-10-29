package coffee.order.dto.customer.wallet;

public class CouponDto {

    private final Integer quantity;
    private final Integer usedCount;

    public CouponDto(Integer quantity, Integer usedCount) {
        this.quantity = quantity;
        this.usedCount = usedCount;
    }

    public String getUsedCount() {
        return String.valueOf(usedCount.intValue());
    }
}
