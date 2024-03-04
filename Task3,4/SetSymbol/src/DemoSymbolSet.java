import symbolSet.SymbolSet;

public class DemoSymbolSet {
    public static void main(String[] args) throws Exception {
        SymbolSet s = new SymbolSet('a', '1', '!', 'o', 'R', '%', '2');
        SymbolSet intersect = new SymbolSet('1', '!', 'o', 'R', '%', '2');
        SymbolSet union = new SymbolSet('a');
        SymbolSet subtract = new SymbolSet('R', '%', '2');
        s.addSymbol('b');
        s.removeSymbol('b');
        s.intersect(intersect);
        s.union(union);
        s.subtract(subtract);
        System.out.println(s);
    }
}
