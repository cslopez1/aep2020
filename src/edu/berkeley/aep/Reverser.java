package edu.berkeley.aep;

// Understands how to reverse a string.
public class Reverser {
    private final String string;
    private String reverse;

    public Reverser(String string) {
        this.string = string;
        this.reverse = string;
    }

    public String reverse() {
        if (this.reverse.isEmpty())
            return this.reverse;

        char zero = this.reverse.charAt(0);
        this.reverse = this.reverse.substring(1);
        return reverse() + zero;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Reverser)) return false;
        return this.string.equals(((Reverser) other).string);
    }

}
