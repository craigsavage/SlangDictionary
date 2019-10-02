package SlangDictionary;

/**
 * Slang Class is used for creating a new Slang words.
 */
public class Slang {

    private String word;
    private String definition;

    public Slang(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    // Gets the word
    public String getWord() {
        return this.word;
    }

    // Gets the definition
    public String getDefinition() {
        return this.definition;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.word, this.definition);
    }
}
