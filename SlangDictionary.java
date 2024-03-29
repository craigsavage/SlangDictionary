import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Collections;

public class SlangDictionary {

    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    // Initialize an ArrayList for storing new slang
    ArrayList<Slang> slangDictionary = new ArrayList<>();

    /**
     * SlangDictionary() constructor is used to initialize the slang dictionary with some phrases.
     */
    public SlangDictionary(){

        // Add the new slang to the dictionary (Manually to start populating dictionary)
        slangDictionary.add(new Slang("Facts", "used to say that something is true."));
        slangDictionary.add(new Slang("Habib", "A good friend, a sweet person."));
        slangDictionary.add(new Slang("Hubby", "the man that will eventually be your future husband."));
        slangDictionary.add(new Slang("NSFW", "content that is not safe to open at your work due to it being inapporpriate."));
        slangDictionary.add(new Slang("Roadman", "a young adult boy that deals drugs, smokes weed, does robberies, etc... "));
        slangDictionary.add(new Slang("Whack", "something that is boring/unappealing."));
        slangDictionary.add(new Slang("Wifey", "the girl that you can see being your future wife."));
        slangDictionary.add(new Slang("Zuckerberg", "to steal an idea from someone who trusts you."));
    }
    
    /**
     * getRandomSlang() is used to get a random word from the Slang Dictionary.
     * @return a random slang from the slang dictionary.
     */
    public String getRandomSlang() {

        // Stores a random number
        int num = rand.nextInt(slangDictionary.size());

        // Returns a random slang dictionary
        return "Random Slang:|" + slangDictionary.get(num).toString();
    }

    /**
     * findSlang() is used to search the slang dictionary for a word.
     * @param wordToFind contains the user inputted word to search for.
     * @return a string containing the word if found or a string stating that the word was not found.
     */
    public String findSlang(String wordToFind) {
        
        // Searches the dictionary for that word
        for (Slang slang : slangDictionary) {

            // If the word is found then return the word
            if (slang.getWord().compareToIgnoreCase(wordToFind) == 0) {
                return "Found:|" + slang.toString();
            }
        }
        return wordToFind + " not found.";
    }

    /**
     * addItem() is used to add a new slang to the slang dictionary.
     * @param wordToAdd contains the slang word to be added.
     * @param definitionToAdd contains the defnition of the slang word to be added.
     * @return the word that was added to the dictionary.
     */
    public String addItem(String wordToAdd, String definitionToAdd) {
        
        // Searches the dictionary for that word
        for (Slang slang : slangDictionary) {

            // If the word is found then inform the user that the word already exists
            if (slang.getWord().compareToIgnoreCase(wordToAdd) == 0) {
                return wordToAdd + " is already in the slang dictionary.";
            }
        }

        // Capitalizes the first letter of the word
        wordToAdd = wordToAdd.substring(0, 1).toUpperCase() + wordToAdd.substring(1).toLowerCase();
        definitionToAdd = definitionToAdd.substring(0, 1).toUpperCase() + definitionToAdd.substring(1).toLowerCase();

        // Adds the word with it's definition to the slang dictionary
        slangDictionary.add(new Slang(wordToAdd, definitionToAdd));

        // Contains the slang that was just added
        String word = slangDictionary.get(slangDictionary.size() - 1).toString();

        // Sort the slang dictionary
        Collections.sort(slangDictionary, new SlangDictionaryComparator());
        return "Added: |" + word;
    }

    /**
     * removeSlang() is used to remove a slang word from the dictionary.
     * @param wordToRemove contains the word to be removed.
     * @return the removed slang or a string stating that the word was not found.
     */
    public String removeSlang(String wordToRemove) {

        // Searches the dictionary for that word
        for (Slang slang : slangDictionary) {

            // If the word is found then remove it from the dictionary
            if (slang.getWord().compareToIgnoreCase(wordToRemove) == 0) {
                slangDictionary.remove(slang);
                return "Removed:|" + slang.toString();
            }
        }
        return wordToRemove + " not found.";
    }

    /**
     * getSlangDictionary() is used to get a string of the entire slang dictionary, separated by pipes.
     * @return a string of the entire slang dictionary.
     */
    public String getSlangDictionary() {
        
        // An empty string to hold all slangs
        String entireSlangDictionary = "";
        
        // Cycle through all slangs in the dictionary
        for (Slang slang : slangDictionary) {
            
            // Append each slang from the loop along with a | to the string
            entireSlangDictionary += slang.toString() + "|";
        }  
       return entireSlangDictionary;
    }
}