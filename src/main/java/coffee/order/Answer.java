package coffee.order;

public enum Answer {
    YES("1"),
    NO("2");

    private final String answerNumber;

    Answer(String answerNumber) {
        this.answerNumber = answerNumber;
    }

    public String getAnswerNumber() {
        return answerNumber;
    }
}
