package seller;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.print.*;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.lang.*;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Deneth A Perera
 */

public class seller_main extends javax.swing.JFrame {

    String[] itemdetail = new String[5];
    Double[] itemcost  = new Double[5];
    
    
  
    
    public seller_main() throws SQLException {
        initComponents();
        show_Products_In_JTable();
        Java_JTable_Style();
        FillCombo();
        
        txt_sId.setText("");
       
        
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
    
    //Check Input Fields
    
    public boolean checkInputs(){
        
              if(  txt_name.getText() == null && txt_sId.getText() == null && txt_itemCode.getText() == null && txt_price.getText() == null
                && txt_addDate.getText() == null)
              {
            return false;
            
        }else{
                try{
                   Float.parseFloat(txt_price.getText());
                   Integer.parseInt(txt_qty.getText());
                   return true;
                }catch(Exception ex){
                    return false;
                }  
              }
    }
 
  
    public ImageIcon ResizeImage(String imagePath, byte[] pic)
    {
        ImageIcon myImage = null;
        
        if(imagePath != null){
            myImage = new ImageIcon(imagePath); 
        }else{
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(lbl_img.getWidth(), lbl_img.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
    
    
    
    
    //
    ////////////////////////////////////////////////////////////Display Data in JTable
    
        // 1 - Fill Array List with the Data
    
    public ArrayList<product> getProductList() throws SQLException
    {
        ArrayList<product> productList= new ArrayList<product>();
            Connection con = getConnection();
            
            String query ="SELECT * FROM products";
            
            Statement st;
            ResultSet rs;
        
        try {
            
            st = (Statement) con.createStatement();
            rs = st.executeQuery(query);
            product pro;
            
            while(rs.next())
            {
               
               pro = new product(rs.getInt("id"),rs.getString("sId"),rs.getString("itemCode"),rs.getString("p_name"),Float.parseFloat(rs.getString("unit_price")),rs.getString("add_date"),Integer.parseInt(rs.getString("qty")),rs.getBytes("image"));
               productList.add(pro);
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return productList;     
    }
    
    
    
    
        // 2 - Populate the JTable
    
    public void show_Products_In_JTable() throws SQLException
    {
       ArrayList<product> list = getProductList();
       DefaultTableModel model = (DefaultTableModel) JTable_products.getModel();
       
       // Clear jtable content
       model.setRowCount(0);
       Object[] row = new Object[7];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getsId();
           row[2] = list.get(i).getitemCode();
           row[3] = list.get(i).getName();
           row[4] = list.get(i).getPrice();
           row[5] = list.get(i).getAddDate();
           row[6] = list.get(i).getqty();
           
           model.addRow(row);
           
       }
    }
    
    
   
    
    public void ShowItem(int index)
    {
        try {
            txt_id.setText(Integer.toString(getProductList().get(index).getId()));
            txt_sId.setText(getProductList().get(index).getsId());
            txt_itemCode.setText(getProductList().get(index).getitemCode());
            txt_name.setText(getProductList().get(index).getName());
            txt_price.setText(Float.toString(getProductList().get(index).getPrice()));
            txt_addDate.setText(getProductList().get(index).getAddDate());
            txt_qty.setText(Integer.toString(getProductList().get(index).getqty()));
            lbl_img.setIcon(ResizeImage(null, getProductList().get(index).getImage()));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_products = new javax.swing.JTable();
        label1 = new java.awt.Label();
        btn_insert1 = new javax.swing.JButton();
        panel2 = new java.awt.Panel();
        jLabel3 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_price = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_addDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lbl_img = new javax.swing.JLabel();
        choose_image = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_itemCode = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_sId = new javax.swing.JTextField();
        combobox = new javax.swing.JComboBox<>();
        btn_first = new javax.swing.JButton();
        btn_reset = new javax.swing.JButton();
        btn_next = new javax.swing.JButton();
        btn_last = new javax.swing.JButton();
        btn_prev = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_print = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_print = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        btn_tblPrint = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_search = new java.awt.TextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 800));

        btn_insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-plus-30.png"))); // NOI18N
        btn_insert.setText("Insert");
        btn_insert.setIconTextGap(6);
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-restart-30.png"))); // NOI18N
        btn_update.setText("Update");
        btn_update.setIconTextGap(6);
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-delete-30.png"))); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setIconTextGap(6);
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-first-32.png"))); // NOI18N
        jButton5.setText("First");
        jButton5.setIconTextGap(6);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-previous-32.png"))); // NOI18N
        jButton6.setText("Previous");
        jButton6.setIconTextGap(6);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-next-32.png"))); // NOI18N
        jButton7.setText("Next");
        jButton7.setIconTextGap(6);

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-last-32.png"))); // NOI18N
        jButton8.setText("Last");
        jButton8.setIconTextGap(6);

        JTable_products.setBackground(new java.awt.Color(51, 51, 255));
        JTable_products.setForeground(new java.awt.Color(255, 255, 255));
        JTable_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Seller ID", "Item Code", "Name", "Price", "Add Date", "Qty"
            }
        ));
        JTable_products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable_productsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTable_products);

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Selling Items");

        btn_insert1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_insert1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-market-square-96.png"))); // NOI18N
        btn_insert1.setIconTextGap(6);
        btn_insert1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert1ActionPerformed(evt);
            }
        });

        panel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ID            : ");

        txt_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_id.setEnabled(false);
        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Name      : ");

        txt_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Price       : ");

        txt_price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_priceActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Add Date: ");

        txt_addDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addDateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Quantity : ");

        txt_qty.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Image: ");

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        lbl_img.setForeground(new java.awt.Color(255, 255, 255));
        lbl_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-xlarge-icons-100.png"))); // NOI18N

        choose_image.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        choose_image.setText("Choose Image");
        choose_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choose_imageActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Itm Code : ");

        txt_itemCode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_itemCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_itemCodeActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Seller ID  : ");

        txt_sId.setEditable(false);
        txt_sId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_sId.setEnabled(false);
        txt_sId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_sIdActionPerformed(evt);
            }
        });

        combobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(choose_image, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(txt_itemCode)
                                    .addComponent(txt_sId)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(11, 11, 11)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_qty)
                                    .addComponent(txt_price)
                                    .addComponent(txt_addDate))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_sId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_itemCode, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(txt_addDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(lbl_img, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choose_image))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btn_first.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_first.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-first-32.png"))); // NOI18N
        btn_first.setText("First");
        btn_first.setIconTextGap(6);
        btn_first.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_firstActionPerformed(evt);
            }
        });

        btn_reset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-sync-30.png"))); // NOI18N
        btn_reset.setText("Reset");
        btn_reset.setIconTextGap(6);
        btn_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetActionPerformed(evt);
            }
        });

        btn_next.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-next-32.png"))); // NOI18N
        btn_next.setText("Next");
        btn_next.setIconTextGap(6);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        btn_last.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_last.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-last-32.png"))); // NOI18N
        btn_last.setText("Last");
        btn_last.setIconTextGap(6);
        btn_last.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lastActionPerformed(evt);
            }
        });

        btn_prev.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_prev.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-previous-32.png"))); // NOI18N
        btn_prev.setText("Previous");
        btn_prev.setIconTextGap(6);
        btn_prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prevActionPerformed(evt);
            }
        });

        jPanel2.setBorder(null);

        btn_print.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-bill-30.png"))); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        btn_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-close-window-35.png"))); // NOI18N
        btn_exit.setText("EXIT");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        txt_print.setColumns(20);
        txt_print.setRows(5);
        jScrollPane3.setViewportView(txt_print);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_print, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_tblPrint.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_tblPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-print-30.png"))); // NOI18N
        btn_tblPrint.setText("Print");
        btn_tblPrint.setIconTextGap(6);
        btn_tblPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tblPrintActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Search  ");

        txt_search.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setText("SUBMIT YOUR INFO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btn_insert1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(942, 942, 942)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btn_reset)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btn_tblPrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(btn_first)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(btn_prev)))
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_next)
                                                .addGap(18, 18, 18)
                                                .addComponent(btn_last)
                                                .addGap(62, 62, 62))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(64, 64, 64))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_update)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_insert1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(btn_next, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btn_last, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(btn_first, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btn_prev, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_tblPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(209, 209, 209))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 782, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(956, 956, 956)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(395, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        
        if(checkInputs() && txt_id.getText() != null)
        {
            try {
                String UpdateQuery = null;
                PreparedStatement ps = null;
                Connection con = getConnection();
                
                
                //Update without image
                if(ImgPath == null)
                {
                    try {
                        UpdateQuery = "UPDATE products SET sId = ?, itemCode =?, p_name = ?, unit_price = ?"
                                + ", add_date = ? WHERE id = ?";
                        
                        ps = (PreparedStatement) con.prepareStatement(UpdateQuery);
                        ps.setString(1, txt_sId.getText());
                        ps.setString(2, txt_itemCode.getText());
                        ps.setString(3, txt_name.getText());
                        ps.setString(4, txt_price.getText());
                        ps.setString(5, txt_addDate.getText());
                        
                        ps.setInt(6, Integer.parseInt(txt_id.getText()));
                        
                        ps.executeUpdate();
                        show_Products_In_JTable();
                        Recepit_print();
                        JOptionPane.showMessageDialog(null, "Product Updated");
                        
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }
                }
                
                //Update with Image
                else{
                    try{
                        InputStream img = new FileInputStream(new File(ImgPath));
                        
                        UpdateQuery = "UPDATE products SET  itemCode = ?, p_name = ?, unit_price = ?"
                                + ", add_date = ?, image = ? WHERE id = ?";
                        
                        ps = (PreparedStatement) con.prepareStatement(UpdateQuery);
                       
                        ps.setString(1, txt_itemCode.getText());
                        ps.setString(2, txt_name.getText());
                        ps.setString(3, txt_price.getText());
                        ps.setString(4, txt_addDate.getText());
                        
                        ps.setBlob(5, img);
                        
                        ps.setInt(6, Integer.parseInt(txt_id.getText()));
                        
                        ps.executeUpdate();
                        show_Products_In_JTable();
                        Recepit_print();
                        JOptionPane.showMessageDialog(null, "Product Updated");
                        
                    }catch(Exception ex){
                        
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "One or More Fields Are Empty or Wrong");
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    
    
    
    
    
    
    
    private void choose_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choose_imageActionPerformed
        
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images","jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lbl_img.setIcon(ResizeImage(path, null)); 
            ImgPath = path;
        }
        else{
            System.out.println("No File Selected");
        }
        
    }//GEN-LAST:event_choose_imageActionPerformed

    
    
    
    
    
    
    
    
    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed
        
        
        
        String sId = txt_sId.getText();
        String ic = txt_itemCode.getText();
        String name = txt_name.getText();
        String price = txt_price.getText();
        String date = txt_addDate.getText();
        String qty = txt_qty.getText();
            
        if(sId.equals("")&& ic.equals("")&&name.equals("")&&price.equals("")&&date.equals("")&&qty.equals("") && ImgPath==null){
                JOptionPane.showMessageDialog(null, "All the fields are empty");
            }
        else  if(sId.equals("")){
                JOptionPane.showMessageDialog(null, "Please Select your ID");
            }
             else if((ic.equals("")))
              
              {
                JOptionPane.showMessageDialog(null, "Please Enter the Item Code");
              } 
              else if((name.equals("")))
              
              {
                JOptionPane.showMessageDialog(null, "Please provide Your Item Name");
              } 
               
             else if(price.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter the Item Price");
            }
            else if(date.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Date");
            }
            else if(qty.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the Quantity");
            }
             else if(ImgPath == null){
                JOptionPane.showMessageDialog(null, "Please provide Item Image");
            }
        
               
            else{
             
            try {
                Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT INTO products(sId,itemCode,p_name,unit_price,add_date,qty,image)"
            + "values(?,?,?,?,?,?,?)");
                ps.setString(1, txt_sId.getText());
                ps.setString(2, txt_itemCode.getText());
                ps.setString(3, txt_name.getText());
                ps.setString(4, txt_price.getText());
                ps.setString(5, txt_addDate.getText());
                ps.setString(6, txt_qty.getText());
                
                InputStream img = new FileInputStream(new File(ImgPath));
                ps.setBlob(7, img);
                ps.executeUpdate();
                 JOptionPane.showMessageDialog(null, "Data Inserted");
                show_Products_In_JTable();
                Recepit_print();
                
               
                
         txt_id.setText("");
        txt_sId.setText("");
        txt_itemCode.setText("");
        txt_name.setText("");
        txt_price.setText("");
        txt_addDate.setText("");
        txt_qty.setText("");
        
                
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } 
            
            
        }
        
        System.out.println("Name => "+ txt_name.getText());
        System.out.println("Price => "+ txt_price.getText());
        System.out.println("Image => "+ ImgPath);
        
  
    }//GEN-LAST:event_btn_insertActionPerformed

    private void txt_addDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addDateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
        if(!txt_id.getText().equals("")){
            
            try {
                Connection con = getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM products WHERE id = ?");
                int id = Integer.parseInt(txt_id.getText());
                ps.setInt(1, id);
                ps.executeUpdate();
                show_Products_In_JTable();
                JOptionPane.showMessageDialog(null, "Product Deleted");
                
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Product Not Deleted");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Product Not Deleted : No ID to Delete ");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void btn_insert1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert1ActionPerformed

    }//GEN-LAST:event_btn_insert1ActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed

    }//GEN-LAST:event_txt_nameActionPerformed

    private void btn_firstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_firstActionPerformed
        pos = 0;
        ShowItem(pos);
        
    }//GEN-LAST:event_btn_firstActionPerformed

    private void btn_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetActionPerformed
        txt_id.setText("");
        txt_sId.setText("");
        txt_itemCode.setText("");
        txt_name.setText("");
        txt_price.setText("");
        txt_addDate.setText("");
        txt_qty.setText("");
        txt_print.setText("");
        
    }//GEN-LAST:event_btn_resetActionPerformed

    
    
    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        try {
            pos++;
            
            if(pos >= getProductList().size())
            {
                try {
                    pos = getProductList().size()-1;
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            ShowItem(pos);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    
    
    
    private void btn_lastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lastActionPerformed
        try {
            pos = getProductList().size()-1;
            ShowItem(pos);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_lastActionPerformed

    
    
    private void btn_prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prevActionPerformed
        
        pos--;
        
        if(pos < 0)
        {
            pos = 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_prevActionPerformed

    private void JTable_productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTable_productsMouseClicked
        int index = JTable_products.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_JTable_productsMouseClicked

    private void txt_priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_priceActionPerformed

    private void txt_itemCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_itemCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_itemCodeActionPerformed

    private void txt_sIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_sIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sIdActionPerformed

    
    private JFrame frame;
    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        
        frame = new JFrame("Exit");
        
        if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Computer Parts",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    
    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
        try {
            txt_print.print();
        } catch (PrinterException ex) {
            Logger.getLogger(seller_main.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btn_printActionPerformed

    
    
    
    
    private void btn_tblPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tblPrintActionPerformed
        String filePath = "C:\\Users\\Deneth A Perera\\Documents\\NetBeansProjects\\Seller\\src\\reports\\txtfile.txt";
        File file = new File(filePath);
       
        try {  
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i =0; i < JTable_products.getRowCount(); i++){
                for(int j = 0; j < JTable_products.getColumnCount();j++){
                    
                    bw.write(JTable_products.getValueAt(i, j).toString()+"    ");
                }
                
                bw.newLine();
            }
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            Logger.getLogger(seller_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page {0,number,integer}");
        
        try {
            JTable_products.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(seller_main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_tblPrintActionPerformed

     public void filter(String queary){
          // TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
           //JTable_products.setRowSorter(tr);
           
           //tr.setRowFilter(RowFilter.regexFilter(queary));
       }
    
    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
       // String queary = txt_search.getText().toLowerCase();
        
        //filter(queary);
    }//GEN-LAST:event_txt_searchKeyReleased

    private void comboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxActionPerformed
        String value = combobox.getSelectedItem().toString();
        txt_sId.setText(value);
    }//GEN-LAST:event_comboboxActionPerformed

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            SellerForm SellerForm = new SellerForm();
            SellerForm.setVisible(true);
            
          
        } catch (SQLException ex) {
            Logger.getLogger(seller_main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new seller_main().setVisible(true);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(seller_main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    
    
    
    
    
  public void Recepit_print(){
      
    txt_print.setEditable(false);  
    itemdetail[0] = txt_id.getText();
    itemdetail[1] = txt_sId.getText();
    itemdetail[2] = txt_itemCode.getText();
    itemdetail[3] = txt_name.getText();
    itemdetail[4] = txt_addDate.getText();
    itemcost[0] = Double.parseDouble(txt_price.getText());
    itemcost[1] = Double.parseDouble(txt_qty.getText());
    
    itemcost[2] = itemcost[0] * itemcost[1];
    itemcost[3] = (itemcost[0] * itemcost[1])*0.15;
    
    itemcost[4] = itemcost[2] - itemcost[3];
    
    
    //----------
    
    //----------
    int refs = 1325 + (int) (Math.random()*4238);
    
    Calendar timer = Calendar.getInstance();
    timer.getTime();
    SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
    tTime.format(timer.getTime());
    SimpleDateFormat tDate = new SimpleDateFormat("dd :MMM :yyyy");
    tDate.format(timer.getTime());
    
    txt_print.append("  ***   Tech Store Computer Systems\n\n"+
            "Reference:\t\t"+refs +
            "\n=======================================\t "+
            "\nID\t:\t"+itemdetail[0]+
            "\nSeller ID\t:\t"+itemdetail[1]+
            "\nItem Code\t:\t"+itemdetail[2]+
            "\nItem Name\t:\t"+itemdetail[3]+
            "\nPrice\t:\t"+itemcost[0]+
            "\nDate\t:\t"+itemdetail[4]+
            "\nQuantity\t:\t"+itemcost[1]+
            "\n=======================================\t"+
                    "\nTotal\t:\t"+itemcost[2]+
                    "\nTax\t:\t"+itemcost[3]+
                    "\nTotal Income\t:\t"+itemcost[4]+
                    
            "\n=======================================\t \n"+
            "\nDate:  "+tDate.format(timer.getTime())+
            "\tTime:  "+tTime.format(timer.getTime())+
            "\n\n            Thank You for being with us!\n\n");
  }
  
  private void FillCombo() throws SQLException{
      
      Connection con = getConnection();
      
        Statement st;
        ResultSet rs;
      try{
          
          String sql = "select * from seller_info ";
          st = (Statement) con.prepareStatement(sql);
          rs= st.executeQuery(sql);
          
          while(rs.next()){
              String name = rs.getString("nic");
              combobox.addItem(name);
          }
          
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, e);
      }
  }
  
    
    
    /**
     *Creates new form Java_JTable_Style
     */
    public void Java_JTable_Style(){
        
         JTable_products.setRowHeight(15);
        //jTable1.setRowHeight(1, 100);

        JTable_products.setShowGrid(true);
        JTable_products.setGridColor(Color.red);

        JTable_products.setBackground(Color.BLACK);
        JTable_products.setForeground(Color.WHITE);
        
        JTable_products.setSelectionBackground(Color.WHITE);
        JTable_products.setSelectionForeground(Color.BLACK);
        
        JTable_products.setFont(new Font("Arial", Font.ITALIC, 10));
       
        
        JTableHeader Theader = JTable_products.getTableHeader();
        
        Theader.setBackground(Color.blue); // change the Background color
        Theader.setForeground(Color.black); // change the Foreground
        
        Theader.setFont(new Font("Tahome", Font.BOLD, 15)); // font name style size
        ((DefaultTableCellRenderer)Theader.getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER); // center header text
        
        JTable_products.setFont(new Font("Arial", Font.BOLD, 15));
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          
           JTableHeader th  = new JTableHeader();
           th.setVisible( true );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTable_products;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_first;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_insert1;
    private javax.swing.JButton btn_last;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_prev;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_reset;
    private javax.swing.JButton btn_tblPrint;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton choose_image;
    private javax.swing.JComboBox<String> combobox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private javax.swing.JLabel lbl_img;
    private java.awt.Panel panel2;
    private javax.swing.JTextField txt_addDate;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_itemCode;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextArea txt_print;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_sId;
    private java.awt.TextField txt_search;
    // End of variables declaration//GEN-END:variables

    
}


//Set File Paths
//Images
//Reports txt filee
