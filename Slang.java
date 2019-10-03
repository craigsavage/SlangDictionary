/**
 * Slang Class is used for creating a new Slang words.
 */
public class Slang {

    private String word;
    private String definition;

    /**
     * Slang() constructor is used to creat a new slang.
     * @param word contains the name of the word.
     * @param definition contains the definition of the word.
     */
    public Slang(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    /**
     * getWord() is used to get the slang word.
     * @return the slang word.
     */
    public String getWord() {
        return this.word;
    }

    /**
     * getDefinition() gets the definition of the slang word.
     * @return the definition of the slang word.
     */
    public String getDefinition() {
        return this.definition;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.word, this.definition);
    }
}
