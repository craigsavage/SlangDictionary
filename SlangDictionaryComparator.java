import java.util.Comparator;

public class SlangDictionaryComparator implements Comparator<Slang> {

    @Override
    public int compare(Slang slang1, Slang slang2) {
        return slang1.getWord().compareToIgnoreCase(slang2.getWord());
    }
}
