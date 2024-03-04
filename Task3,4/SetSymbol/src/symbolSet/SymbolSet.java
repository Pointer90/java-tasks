package symbolSet;

import java.util.Set;
import java.util.HashSet;

public class SymbolSet {
    private Set<Character> set = new HashSet<>();

    public SymbolSet(){}


    public SymbolSet(char... symbols)
    {
        for (char symbol : symbols)
            set.add(symbol);
    }


    public Set<Character> getSet()
    {
        return this.set;
    }


    public void addSymbol(char symbol)
    {
        set.add(symbol);
    }


    public void removeSymbol(char symbol)
    {
        set.remove(symbol);
    }


    public boolean containsSymbol(char symbol)
    {
        return set.contains(symbol);
    }


    public void intersect(SymbolSet set)
    {
        this.set.retainAll(set.getSet());
    }


    public void union(SymbolSet set)
    {
        this.set.addAll(set.getSet());
    }


    public void subtract(SymbolSet set)
    {
        this.set.removeAll(set.getSet());
    }

    @Override
    public String toString() {
        String res = "( ";

        for (char elem : set)
            res += elem + " ";
        return res + ")";
    }
}
