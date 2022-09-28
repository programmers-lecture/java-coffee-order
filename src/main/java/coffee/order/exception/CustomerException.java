package coffee.order.exception;

public enum CustomerException {

    NOT_ENOUGH_MONEY(new IllegalArgumentException("고객님의 현금이 부족합니다.")),;

    private final RuntimeException exception;

    CustomerException(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException throwMyException() {
        return this.exception;
    }

}
