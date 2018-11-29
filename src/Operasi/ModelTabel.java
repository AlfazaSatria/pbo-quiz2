package Operasi;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Alfaza
 */
public class ModelTabel extends DefaultTableModel{
    private String[] columns;
    
    public ModelTabel(){
        this.columns = new String []{
            "Nama", "Harga", "Jumlah"
        };
    }
        public String[] getColumnName(){
            return this.columns;
        }
    }