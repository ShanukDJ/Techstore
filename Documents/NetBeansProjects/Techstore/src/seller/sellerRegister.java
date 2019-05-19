

package seller;

/**
 *
 * @author Deneth A Perera
 */
public class sellerRegister {
    
    private int id;
    private String fname;
    private String lname;
    private String nic;
    private String phoneno;
    private String phoneno2;
    private byte[] picture;
    
    
    public sellerRegister(int pid,String pfname,String plname, String pnic,String pphone,String pphone2,byte[] pimg){
        
        this.id = pid;
        this.fname = pfname;
        this.lname = plname;
        this.nic = pnic;
        this.phoneno = pphone;
        this.phoneno2 = pphone2;
        this.picture = pimg;
        
        
    }

  

  

    

   
    
    public int getId(){
        
        return id;
    }
    
    public String getfname(){
        
        return fname;
    }
    
    public String getlname(){
        
        return lname;
    }
    
    public String getNic(){
        
        return nic;
    }
    
    public String getPhone(){
        
        return phoneno;
    }
    
    public String getPhone2(){
        
        return phoneno2;
    }
    
    public byte[] getImage(){
        
        return picture;
    }
}














