package Operasi;

import java.util.ArrayList;

/**
 *
 * @author Alfaza
 */
public class ModelTabel {
    private ArrayList<Item> barang;

    public ModelTabel() {
        this.barang = new ArrayList<>();
    }
    
    public Item [] toArray() {
        Item[] barang = new Item[this.barang.size()];
        for(int i=0; i<barang.length; i++){
            barang[i] = this.barang.get(i);
        }
        return barang;
    }
    public void addItem(Item item){
        this.barang.add(item);
    }
    
}
