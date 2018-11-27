package Operasi;

/**
 *
 * @author Alfaza
 */
import java.util.ArrayList;

public class ModelCombo {
    private ArrayList<Item> barang;

    public ModelCombo() {
        this.barang = new ArrayList<>();
    }
    
    public Item[] toArray(){
    Item [] barang = new Item [this.barang.size()];
        for (int i=0; i<barang.length; i++){
            barang[i] = this.barang.get(i);
        }
        return barang;
}
    
    
}
