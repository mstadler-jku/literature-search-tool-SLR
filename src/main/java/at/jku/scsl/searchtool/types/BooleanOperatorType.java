package at.jku.scsl.searchtool.types;

public enum BooleanOperatorType {
    OR(5),
    AND(6);

    public final int charLength;

    BooleanOperatorType(int charLength) {
        this.charLength = charLength;
    }
}
