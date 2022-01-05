package exceptionmulticatch.converter;

public class AnswerStat {

    private final BinaryStringConverter converter;

    public AnswerStat(BinaryStringConverter converter) {
        this.converter = converter;
    }

    public boolean[] convert(String binaryLine) {
        try {
            return converter.binaryStringToBooleanArray(binaryLine);
        } catch (NullPointerException | IllegalArgumentException ex) {
            throw new InvalidBinaryStringException(ex);
        }
    }

    public int answerTruePercent(String answers) {
        boolean[] boolArray = convert(answers);
        int numberOfTrue = 0;
        for (boolean element : boolArray) {
            if (element) {
                numberOfTrue++;
            }
        }
        return (int) Math.round(100. * numberOfTrue / boolArray.length);
    }

}
