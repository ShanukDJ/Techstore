
package seller;
/**
 *
 * @author Deneth A Perera
 */

public class product {
    
    private int id;
    private String sId;
    private String itemCode;
    private String name;
    private float price;
    private String addDate;
    private int qty;
    private byte[] picture;
    
    
    public product(int pid,String psId,String pitemCode, String pname,float pprice,String pAddDate,int pqty,byte[] pimg){
        
        this.id = pid;
        this.sId = psId;
        this.itemCode = pitemCode;
        this.name = pname;
        this.price = pprice;
        this.addDate = pAddDate;
        this.qty = pqty;
        this.picture = pimg;
        
        
    }

    product(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
    public int getId(){
        
        return id;
    }
    
    public String getsId(){
        
        return sId;
    }
    
    public String getitemCode(){
        
        return itemCode;
    }
    
    public String getName(){
        
        return name;
    }
    
    public float getPrice(){
        
        return price;
    }
    
    public String getAddDate(){
        
        return addDate;
    }
    
    public int getqty(){
        
        return qty;
    }
    
    public byte[] getImage(){
        
        return picture;
    }
}






