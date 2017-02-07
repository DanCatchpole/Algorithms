package me.dcatcher.algorithms;

public class Tuple<A, B> {
    private A first;
    private B second;

    /**
     * Creates a new Tuple with values for the first and second values
     * @param first the first item in the tuple
     * @param second the second item in the tuple
     */
    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returns the first value in the tuple
     * @return first val.
     */
    public A getFirst() {
        return first;
    }

    /**
     * Returns the second value in the tuple
     * @return second val.
     */
    public B getSecond() {
        return second;
    }

    /**
     * Allocate a new value to the first element in the Tuple
     * @param newFirst the new first value
     */
    public void setFirst(A newFirst) {
        this.first = newFirst;
    }

    /**
     * Allocate a new value for the second element in the Tuple
     * @param newSecond the new second value
     */
    public void setSecond(B newSecond) {
        this.second = newSecond;
    }

    @Override
    public String toString() {
        return "{" + this.getFirst() + ", " + this.getSecond() + "}";
    }
}
