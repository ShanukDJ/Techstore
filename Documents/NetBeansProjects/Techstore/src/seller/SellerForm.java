/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seller;


//import java.sql.Statement;
//import java.sql.PreparedStatement;


import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Deneth A Perera
 */
public class SellerForm extends javax.swing.JFrame {

    /**
     * Creates new form SellerForm
     */
    
    
    public SellerForm() throws SQLException {
        initComponents();
         show_Products_In_JTable2();
         Java_JTable_Style();
    }
    
    
    
    
    
     String ImgPath = null;
    int pos = 0;
    
    public Connection getConnection() throws SQLException{
        Connection con = null;
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/seller_db","root","");
       
        return con;
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Not Connected");
            return null;
            
        }
    }
    
    
    public boolean checkInputs(){
        
              if(  fname.getText() == null
                || lname.getText() == null
                || nicno.getText() == null
                || phoneno1.getText() == null
                      || phoneno2.getText() == null
                ){
            return false;
            
        }else{
                try{
                   return true;
                }catch(Exception ex){
                    return false;
                }  
              }
    }
    
     //Resize image
    
    public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
        ImageIcon myImage = null;
        
        if(imagePath != null){
            myImage = new ImageIcon(imagePath); 
        }else{
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(picimg.getWidth(),picimg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    
     //Display Data in JTable
    
        // 1 - Fill Array List with the Data
    
    public ArrayList<sellerRegister> getProductList() throws SQLException
    {
        ArrayList<sellerRegister> sellerList= new ArrayList<sellerRegister>();
            Connection con = getConnection();
            
            String query ="SELECT * FROM seller_info";
            
            Statement st;
            ResultSet rs;
        
        try {
            
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
            sellerRegister sell;
            
            while(rs.next())
            {
               
                sell = new  sellerRegister(rs.getInt("id"),rs.getString("fname"),rs.getString("lname"),rs.getString("nic"),rs.getString("phone"),rs.getString("phone2"),rs.getBytes("image"));
                sellerList.add(sell);
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return sellerList;     
    }
    
    
    // 2 - Populate the JTable
    
    public void show_Products_In_JTable2() throws SQLException
    {
       ArrayList<sellerRegister> list = getProductList();
       DefaultTableModel model = (DefaultTableModel) JTable_seller.getModel();
       
       // Clear jtable content
       model.setRowCount(0);
       Object[] row = new Object[6];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getfname();
           row[2] = list.get(i).getlname();
           row[3] = list.get(i).getNic();
           row[4] = list.get(i).getPhone();
           row[5] = list.get(i).getPhone2();
          
           
           model.addRow(row);
           
       }
    }
    
    
   
    
    public void ShowItem(int index)
    {
        try {
            id2.setText(Integer.toString(getProductList().get(index).getId()));
            fname.setText(getProductList().get(index).getfname());
            lname.setText(getProductList().get(index).getlname());
            nicno.setText(getProductList().get(index).getNic());
            phoneno1.setText(getProductList().get(index).getPhone());
            phoneno2.setText(getProductList().get(index).getPhone());
            picimg.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_seller = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        picimg = new javax.swing.JLabel();
        btn_img = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        nicno = new javax.swing.JTextField();
        phoneno2 = new javax.swing.JTextField();
        btn_submit1 = new javax.swing.JButton();
        btn_submit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        phoneno1 = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        id2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 204, 0));
        jLabel2.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel2.setText("Sellers");

        JTable_seller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "NIC", "Phone No 1", "Phone No 2"
            }
        ));
        JTable_seller.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JTable_sellerMouseDragged(evt);
            }
        });
        JTable_seller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_sellerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_seller);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("First Name :");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Last Name :");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone No 1 :");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NIC No       :");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Image :");

        picimg.setBackground(new java.awt.Color(255, 255, 255));
        picimg.setForeground(new java.awt.Color(255, 255, 255));
        picimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-xlarge-icons-100.png"))); // NOI18N

        btn_img.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_img.setText("Choose Image");
        btn_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_imgActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btn_delete.setIconTextGap(6);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        fname.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        lname.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        nicno.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        phoneno2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        btn_submit1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_submit1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-restart-30.png"))); // NOI18N
        btn_submit1.setIconTextGap(6);
        btn_submit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submit1ActionPerformed(evt);
            }
        });

        btn_submit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_submit.setText("SUBMIT");
        btn_submit.setIconTextGap(6);
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Phone No 2 :");

        phoneno1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        back.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        back.setText("BACK");
        back.setIconTextGap(6);
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lname))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(picimg, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_img, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nicno)
                            .addComponent(phoneno1, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(btn_submit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_submit1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneno2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneno1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneno2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(picimg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_img)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_submit, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btn_submit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        id2.setBackground(new java.awt.Color(0, 0, 0));
        id2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(id2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_imgActionPerformed
 JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            picimg.setIcon(ResizeImage(path, null)); 
            ImgPath = path;
        }
        else{
            System.out.println("No File Selected");
        }
       
    }//GEN-LAST:event_btn_imgActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
             if(!id2.getText().equals("")){
            
            try {
                Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM seller_info WHERE id = ?");
                int id = Integer.parseInt(id2.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                show_Products_In_JTable2();
                JOptionPane.showMessageDialog(null, "Product Deleted");
                
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product Not Deleted");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Product Not Deleted : No ID to Delete ");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_submit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submit1ActionPerformed
          fname.setText("");
        lname.setText("");
        nicno.setText("");
        phoneno1.setText("");
        phoneno2.setText("");
        
    }//GEN-LAST:event_btn_submit1ActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        
        String fn = fname.getText();
        String ln = lname.getText();
        String nic = nicno.getText();
        String pn1 = phoneno1.getText();
        String pn2 = phoneno2.getText();
        
        
        
       if(fn.equals("")&& ln.equals("")&&nic.equals("")&&pn1.equals("")&&pn2.equals("")&& ImgPath==null){
                JOptionPane.showMessageDialog(null, "All the fields are empty");
            }
        else  if(fn.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter your Firstname");
            }
             else if((ln.equals("")))
              
              {
                JOptionPane.showMessageDialog(null, "Please Enter your Lastname");
              } 
              else if((nic.equals("")))
              
              {
                JOptionPane.showMessageDialog(null, "Please Enter your NIC no");
              } 
               
             else if(pn1.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter your Business Phone Number 1");
            }
            else if(pn2.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your Business Phone Number 2");
            }
            else if((!nic.matches("^[0-9]{9}+V")))
              {
                JOptionPane.showMessageDialog(null, "Please enter a valid NIC Number", "Error", JOptionPane.ERROR_MESSAGE);
                
              }
                else if((!pn1.matches("^[0-9]{10}"))){
                       JOptionPane.showMessageDialog(null, "Please Enter a valid phone number *1", "Error", JOptionPane.ERROR_MESSAGE);
                }
                 else if((!pn2.matches("^[0-9]{10}"))){
                       JOptionPane.showMessageDialog(null, "Please Enter a valid phone number *2", "Error", JOptionPane.ERROR_MESSAGE);
                }
                 else if(ImgPath == null){
                JOptionPane.showMessageDialog(null, "Please provide Seller Image");
            }
             
            else{
             
             
            try {
                Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO seller_info(fname,lname,nic,phone,phone2,image)"
            + "values(?,?,?,?,?,?)");
                ps.setString(1, fname.getText());
                ps.setString(2, lname.getText());
                ps.setString(3, nicno.getText());
                ps.setString(4, phoneno1.getText());
                 ps.setString(5, phoneno2.getText());
                
                
                InputStream picimg = new FileInputStream(new File(ImgPath));
                ps.setBlob(6, picimg);
                ps.executeUpdate();
                show_Products_In_JTable2();
               
                
                JOptionPane.showMessageDialog(null, "Data Inserted");
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } 
            
            
        }
        
        System.out.println("Fname => "+ fname.getText());
        System.out.println("Lname => "+ lname.getText());
        System.out.println("NIC => "+ nicno.getText());
        System.out.println("Phone1 => "+ phoneno1.getText());
        System.out.println("Phone2 => "+ phoneno2.getText());
        System.out.println("Image => "+ ImgPath);
        

    }//GEN-LAST:event_btn_submitActionPerformed

    private void JTable_sellerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_sellerMouseDragged
       
    }//GEN-LAST:event_JTable_sellerMouseDragged

    private void JTable_sellerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_sellerMouseClicked
        int index = JTable_seller.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_sellerMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        try {
            
            SellerForm SellerForm = new SellerForm();
            SellerForm.setVisible(false);
            
            seller_main seller_main = new  seller_main();
            seller_main.setVisible(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SellerForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SellerForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SellerForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
      public void Java_JTable_Style(){
        
       JTable_seller.setRowHeight(22);
        //jTable1.setRowHeight(1, 100);

        JTable_seller.setShowGrid(true);
        JTable_seller.setGridColor(Color.red);

        JTable_seller.setBackground(Color.BLACK);
        JTable_seller.setForeground(Color.WHITE);
        
        JTable_seller.setSelectionBackground(Color.WHITE);
        JTable_seller.setSelectionForeground(Color.BLACK);
        
        JTable_seller.setFont(new Font("Arial", Font.ITALIC, 10));
       
        
        JTableHeader Theader = JTable_seller.getTableHeader();
        
        Theader.setBackground(Color.blue); // change the Background color
        Theader.setForeground(Color.black); // change the Foreground
        
        Theader.setFont(new Font("Tahome", Font.BOLD, 15)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        
       JTable_seller.setFont(new Font("Arial", Font.BOLD, 15));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
           JTableHeader th  = new JTableHeader();
           th.setVisible( true );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_seller;
    private javax.swing.JButton back;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_img;
    private javax.swing.JButton btn_submit;
    private javax.swing.JButton btn_submit1;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField id2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField nicno;
    private javax.swing.JTextField phoneno1;
    private javax.swing.JTextField phoneno2;
    private javax.swing.JLabel picimg;
    // End of variables declaration//GEN-END:variables
}

