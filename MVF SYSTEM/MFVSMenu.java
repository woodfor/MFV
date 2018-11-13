/**
 *Text genereted by Simple GUI Extension for BlueJ
 */
import java.util.ArrayList;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public  class MFVSMenu  {
    private JMenuBar menuBar; //Menubar
    private JPanel loginPanel; //Login panel
    private MFVSController MFVSController; //The controller of MFVS

    /**
     * Constructor of Class MFVSMenu,generate Controller and run loginPage.
     */
    public MFVSMenu(){
        MFVSController = new MFVSController();
        loginPage();
    }

    /**
     * The method that owner donate the products to charity.
     */
    private void addToCharityPage(String id)
    {
        JButton button1;
        JButton button2;
        JLabel label1;
        JLabel label2;
        JPanel panel1;
        JTextField textfield1;
        JTextField textfield2;
        JFrame frame = new JFrame("Charity"); //Create a new Jframe of charity.
        frame.setSize(500,400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        label1 = new JLabel(); // Create the Jlabel for showing the charity name 
        label1.setBounds(31,48,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Charity Name:");
        label1.setVisible(true);

        label2 = new JLabel(); // Create the Jlabel for showing the charity address 
        label2.setBounds(31,121,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Charity Address:");
        label2.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(131,66,252,259);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        textfield1 = new JTextField(); //Create the text field for inputting the charity name
        textfield1.setBounds(141,47,90,35);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setText("");
        textfield1.setVisible(true);

        textfield2 = new JTextField(); //Create the text field for inputting the charity address
        textfield2.setBounds(141,120,90,35);
        textfield2.setBackground(new Color(255,255,255));
        textfield2.setForeground(new Color(0,0,0));
        textfield2.setEnabled(true);
        textfield2.setFont(new Font("sansserif",0,12));
        textfield2.setText("");
        textfield2.setVisible(true);

        button1 = new JButton(); //Create the button which can confirm the charity information 
        button1.setBounds(24,190,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("OK");
        button1.setVisible(true);
        //The listener of clicking the button.It contains the validation of confirming the charity information
        button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if(textfield1.getText().trim().isEmpty()||textfield2.getText().trim().isEmpty())
                    {
                        warningMessage("Please fullfill the information");
                    }
                    else
                    {

                        MFVSController.addCharity(textfield1.getText().trim(), textfield2.getText().trim(), id);
                        warningMessage("Congratulations","Added to charity");
                        frame.dispose();

                    }

                }
            });

        button2 = new JButton(); //Create the button wchich can cancel current donating.
        button2.setBounds(141,190,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Cancel");
        button2.setVisible(true);
        //The listener of the cancel button.
        button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose();
                }
            });

        //add the buttons and labels in the Jpanel.
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(label1);
        panel1.add(label2);
        contentPane.add(panel1);
        panel1.add(textfield1);
        panel1.add(textfield2);

        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The method that owner creates the porducts and input the information of products
     */
    private void productsCreatePage(String ID,String b)
    {

        JCheckBox m_d_Checkbox;
        JTextField m_c_pp;
        JTextField m_c_pn;
        JTextField m_c_pq;
        JTextField m_c_mdate;
        JTextField m_c_expdate;
        JTextField m_c_dis;
        JComboBox combobox1;
        JFrame frame = new JFrame(b);
        JPanel panel_create;
        JButton button1;
        JButton button2;
        JLabel label1;
        JLabel label2;
        JLabel label3;
        JLabel label4;
        JLabel label5;
        JLabel typelabel;
        JLabel sourceLabel;
        JTextField type;
        JTextField source;

        frame.setSize(600, 700);
        JPanel contentPane = new JPanel(null); //Create the Jpanel of products 
        contentPane.setPreferredSize(new Dimension(600,700));
        contentPane.setBackground(new Color(192,192,192));
        button1 = new JButton(); //Create the button to confirm the information
        button1.setBounds(62,500,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText(b);
        button1.setVisible(true);

        button2 = new JButton(); //Create the button to cancel the creating process
        button2.setBounds(185,500,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Cancel");
        button2.setVisible(true);

        //The listener of clicking cancel button
        button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose();
                }
            });

        m_d_Checkbox = new JCheckBox();
        m_d_Checkbox.setBounds(213,430,90,35);
        m_d_Checkbox.setBackground(new Color(214,217,223));
        m_d_Checkbox.setForeground(new Color(0,0,0));
        m_d_Checkbox.setEnabled(true);
        m_d_Checkbox.setFont(new Font("sansserif",0,12));
        m_d_Checkbox.setSelected(false);
        m_d_Checkbox.setVisible(true);

        label1 = new JLabel(); //The label of product name
        label1.setBounds(48,30,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Product Name:");
        label1.setVisible(true);

        label2 = new JLabel(); //The label of product quantity
        label2.setBounds(48,80,111,32);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Product Quantity:");
        label2.setVisible(true);

        label3 = new JLabel(); //The label of product expire date
        label3.setBounds(48,230,92,38);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("sansserif",0,12));
        label3.setText("Exp. Date:");
        label3.setVisible(true);

        label4 = new JLabel(); //The label of product shelf date
        label4.setBounds(48,180,90,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("sansserif",0,12));
        label4.setText("Shelf Date:");
        label4.setVisible(true);

        JLabel label7 = new JLabel();
        label7.setBounds(300,280,90,35);
        label7.setBackground(new Color(214,217,223));
        label7.setForeground(new Color(0,0,0));
        label7.setEnabled(true);
        label7.setFont(new Font("sansserif",0,12));
        label7.setText("%");
        label7.setVisible(true);

        JLabel dis = new JLabel(); //The label of product discount
        dis = new JLabel();
        dis.setBounds(48,280,90,38);
        dis.setBackground(new Color(214,217,223));
        dis.setForeground(new Color(0,0,0));
        dis.setEnabled(true);
        dis.setFont(new Font("sansserif",0,12));
        dis.setText("Discount:");
        dis.setVisible(true);

        JLabel label8 = new JLabel(); //The label of monetary unit
        label8.setBounds(300,130,90,35);
        label8.setBackground(new Color(214,217,223));
        label8.setForeground(new Color(0,0,0));
        label8.setEnabled(true);
        label8.setFont(new Font("sansserif",0,12));
        label8.setText("AUD");
        label8.setVisible(true);

        JLabel price = new JLabel();  //The label of product price
        price = new JLabel();
        price.setBounds(48,130,90,38);
        price.setBackground(new Color(214,217,223));
        price.setForeground(new Color(0,0,0));
        price.setEnabled(true);
        price.setFont(new Font("sansserif",0,12));
        price.setText("Price:");
        price.setVisible(true);

        typelabel = new JLabel(); //The label of product type
        typelabel.setBounds(48,330,90,38);
        typelabel.setBackground(new Color(214,217,223));
        typelabel.setForeground(new Color(0,0,0));
        typelabel.setEnabled(true);
        typelabel.setFont(new Font("sansserif",0,12));
        typelabel.setText("Type:");
        typelabel.setVisible(true);

        type = new JTextField(); //The text field of product type
        type.setBounds(180,330,90,38);
        type.setBackground(new Color(255,255,255));
        type.setForeground(new Color(0,0,0));
        type.setEnabled(true);
        type.setFont(new Font("sansserif",0,12));
        type.setText("");
        type.setVisible(true);

        sourceLabel= new JLabel(); //The label of product source
        sourceLabel.setBounds(48,380,90,38);
        sourceLabel.setBackground(new Color(214,217,223));
        sourceLabel.setForeground(new Color(0,0,0));
        sourceLabel.setEnabled(true);
        sourceLabel.setFont(new Font("sansserif",0,12));
        sourceLabel.setText("Source:");
        sourceLabel.setVisible(true);

        source = new JTextField(); //The text field of product source
        source.setBounds(180,380,90,38);
        source.setBackground(new Color(255,255,255));
        source.setForeground(new Color(0,0,0));
        source.setEnabled(true);
        source.setFont(new Font("sansserif",0,12));
        source.setText("");
        source.setVisible(true);

        label5 = new JLabel(); //The label of Donate to Charity
        label5.setBounds(48,430,108,31);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("Donate to Charity");
        label5.setVisible(true);

        panel_create = new JPanel(null);
        panel_create.setBorder(BorderFactory.createEtchedBorder(1));
        panel_create.setBounds(85,26,400,700);
        panel_create.setBackground(new Color(214,217,223));
        panel_create.setForeground(new Color(0,0,0));
        panel_create.setEnabled(true);
        panel_create.setFont(new Font("sansserif",0,12));
        panel_create.setVisible(true);

        m_c_pn = new JTextField(); //The text field of product name
        m_c_pn.setBounds(180,30,104,34);
        m_c_pn.setBackground(new Color(255,255,255));
        m_c_pn.setForeground(new Color(0,0,0));
        m_c_pn.setEnabled(true);
        m_c_pn.setFont(new Font("sansserif",0,12));
        m_c_pn.setText("");
        m_c_pn.setVisible(true);

        m_c_pq = new JTextField(); //The text field of product quantiy
        m_c_pq.setBounds(180,80,104,34);
        m_c_pq.setBackground(new Color(255,255,255));
        m_c_pq.setForeground(new Color(0,0,0));
        m_c_pq.setEnabled(true);
        m_c_pq.setFont(new Font("SansSerif",0,12));
        m_c_pq.setText("");
        m_c_pq.setVisible(true);

        combobox1 = new JComboBox(); //Set the unit menu of product quantity
        combobox1.setBounds(300,80,90,35);
        combobox1.setBackground(new Color(214,217,223));
        combobox1.setForeground(new Color(0,0,0));
        combobox1.setEnabled(true);
        combobox1.setFont(new Font("sansserif",0,12));
        combobox1.setVisible(true);
        combobox1.addItem("Unit");
        combobox1.addItem("KG");
        combobox1.addItem("Celery");

        m_c_pp = new JTextField(); //The text field of product price
        m_c_pp.setBounds(180,130,104,34);
        m_c_pp.setBackground(new Color(255,255,255));
        m_c_pp.setForeground(new Color(0,0,0));
        m_c_pp.setEnabled(true);
        m_c_pp.setFont(new Font("SansSerif",0,12));
        m_c_pp.setText("");
        m_c_pp.setVisible(true);

        m_c_mdate = new JTextField(); //The text field of shelf date
        m_c_mdate.setBounds(180,180,104,34);
        m_c_mdate.setBackground(new Color(255,255,255));
        m_c_mdate.setForeground(new Color(0,0,0));
        m_c_mdate.setEnabled(true);
        m_c_mdate.setFont(new Font("sansserif",0,12));
        m_c_mdate.setText("");
        m_c_mdate.setVisible(true);

        m_c_expdate = new JTextField();//The text field of expire date
        m_c_expdate.setBounds(180,230,104,34);
        m_c_expdate.setBackground(new Color(255,255,255));
        m_c_expdate.setForeground(new Color(0,0,0));
        m_c_expdate.setEnabled(true);
        m_c_expdate.setFont(new Font("sansserif",0,12));
        m_c_expdate.setText("");
        m_c_expdate.setVisible(true);

        m_c_dis = new JTextField(); //The text field of product discount
        m_c_dis.setBounds(180,280,104,34);
        m_c_dis.setBackground(new Color(255,255,255));
        m_c_dis.setForeground(new Color(0,0,0));
        m_c_dis.setEnabled(true);
        m_c_dis.setFont(new Font("sansserif",0,12));
        m_c_dis.setText("");
        m_c_dis.setVisible(true);

        if(!ID.isEmpty())
        {
            String[] check = MFVSController.returnProductInfo(ID).split("/");
            m_c_pn.setText(check[0]);
            m_c_pq.setText(check[1]);
            m_c_pp.setText(check[2]);
            m_c_mdate.setText(check[3]);
            m_c_expdate.setText(check[4]);
            m_c_dis.setText(check[5]);
            source.setText(check[6]);
            type.setText(check[7]);
            if(check[8].equals("false"))
                m_d_Checkbox.setSelected(false);
            else
                m_d_Checkbox.setSelected(true);

        }
        //The listener of confirming creating product button and all the validations
        button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) 
                {
                    if(!m_c_pn.getText().trim().isEmpty())
                    {
                        if(MFVSController.isInteger(m_c_pq.getText().trim()))
                        {
                            if(MFVSController.isValidDate(m_c_mdate.getText().trim()) && MFVSController.isValidDate(m_c_expdate.getText().trim()))
                            {
                                if(MFVSController.compareDate(m_c_mdate.getText().trim(),m_c_expdate.getText().trim()))
                                {
                                    if(MFVSController.isInteger(m_c_dis.getText().trim()))
                                    {
                                        if(MFVSController.isDouble(m_c_pp.getText().trim()))
                                        {
                                            String checkbox;
                                            if(m_d_Checkbox.isSelected())
                                            {
                                                checkbox="true";
                                            }
                                            else
                                            {
                                                checkbox="false";
                                            }
                                            String a = m_c_pn.getText().trim()+"/"+m_c_pq.getText().trim()+
                                                "/"+ m_c_pp.getText().trim() + "/" + m_c_mdate.getText().trim()+"/"+m_c_expdate.getText().trim()+"/"+checkbox+"/"+
                                                m_c_dis.getText().trim()+"/"+type.getText().trim()+"/"+source.getText().trim()+"/"+combobox1.getSelectedItem();
                                            String tmp = MFVSController.containProduct(a);
                                            if(b.equals("Create"))
                                            {

                                                if(!(tmp==null))
                                                {

                                                    int result = JOptionPane.showConfirmDialog(null, "Item contained, Edit quantity?",
                                                            "Edit?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE); 
                                                    if(result == JOptionPane.OK_OPTION)
                                                    {
                                                        editQuantity(1,tmp);

                                                    }

                                                }
                                                else
                                                {
                                                    MFVSController.createproduct(a);
                                                    warningMessage(a);
                                                }
                                            }
                                            else
                                            {
                                                MFVSController.editProductDetail(ID,a);//mark
                                                warningMessage(a);
                                                frame.dispose();

                                            }
                                        }
                                        else
                                            warningMessage("Price issues");
                                    }
                                    else
                                    {
                                        warningMessage("Discount issues");
                                    }

                                }
                                else
                                    warningMessage("Make Date after produce Date");
                            }
                            else
                            {
                                warningMessage("Date issues, Please input format like dd-mm-yyyy");
                            }
                        }
                        else
                        {
                            warningMessage("Quantity issues");
                        }

                    }
                    else
                        warningMessage("Input name");

                }
            });

        //adding components to contentPane panel
        panel_create.add(button1);
        panel_create.add(button2);
        panel_create.add(m_d_Checkbox);
        panel_create.add(label1);
        panel_create.add(label2);
        panel_create.add(label3);
        panel_create.add(label4);
        panel_create.add(label5);
        panel_create.add(price);
        panel_create.add(dis);
        panel_create.add(m_c_pn);
        panel_create.add(m_c_pq);
        panel_create.add(m_c_pp);
        panel_create.add(m_c_mdate);
        panel_create.add(m_c_expdate);
        panel_create.add(m_c_dis);
        panel_create.add(label7);
        panel_create.add(label8);
        panel_create.add(combobox1);
        panel_create.add(typelabel);
        panel_create.add(sourceLabel);
        panel_create.add(type);
        panel_create.add(source);

        contentPane.add(panel_create);

        frame.add(contentPane);        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Owner can edit the porducts by clicking the products.
     */
    private void productsEditPage(String a)
    {
        JFrame frame = new JFrame(a); //Create Jframe of editing products
        JButton back;
        JList m_e_list;
        JTextField textfield6;
        JPanel panel_Edit;
        JLabel label6 = new JLabel();
        frame.setSize(600, 600);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600,600));
        contentPane.setBackground(new Color(192,192,192));
        back = new JButton(); //Create the button which owner can go back to the previous menu
        back.setBounds(200,350,90,35);
        back.setBackground(new Color(214,217,223));
        back.setForeground(new Color(0,0,0));
        back.setEnabled(true);
        back.setFont(new Font("sansserif",0,12));
        back.setText("Back");
        back.setVisible(true);
        back.addMouseListener(new MouseAdapter() { //The listener of the back button
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose();
                    if(a.equals("MA"))
                        ownerHomePage();
                }
            });

        label6.setBounds(130,85,90,35); //The label of search
        label6.setBackground(new Color(214,217,223));
        label6.setForeground(new Color(0,0,0));
        label6.setEnabled(true);
        label6.setFont(new Font("sansserif",0,12));
        label6.setText("Search:");
        label6.setVisible(true);

        m_e_list = new JList(); //Create a list which can show all products
        m_e_list.setBounds(47,156,461,164);
        m_e_list.setBackground(new Color(255,255,255));
        m_e_list.setForeground(new Color(0,0,0));
        m_e_list.setEnabled(true);
        m_e_list.setFont(new Font("sansserif",0,12));
        m_e_list.setVisible(true);

        panel_Edit = new JPanel(null);
        panel_Edit.setBorder(BorderFactory.createEtchedBorder(1));
        panel_Edit.setBounds(28,129,550,391);
        panel_Edit.setBackground(new Color(214,217,223));
        panel_Edit.setForeground(new Color(0,0,0));
        panel_Edit.setEnabled(true);
        panel_Edit.setFont(new Font("sansserif",0,12));
        panel_Edit.setVisible(true);

        textfield6 = new JTextField(); //The text field of search
        textfield6.setBounds(255,85,160,37);
        textfield6.setBackground(new Color(255,255,255));
        textfield6.setForeground(new Color(0,0,0));
        textfield6.setEnabled(true);
        textfield6.setFont(new Font("sansserif",0,12));
        textfield6.setText("");
        textfield6.setVisible(true);

        ArrayList<String> searchID = new ArrayList<String>(); 
        DefaultListModel<String> model = new DefaultListModel<>();

        if(a.equals("Edit")||a.equals("Remove")||a.equals("SP"))
        {
            searchID.clear();
            model.clear();
            m_e_list.setModel(model);
            MFVSController.returnProductList(model, searchID, textfield6.getText().trim());
            m_e_list.setModel(model);                    
        }

        if(a.equals("Manage Dispose"))
        {
            searchID.clear();
            model.clear();
            m_e_list.setModel(model);
            MFVSController.returnDisposeList(model, searchID, textfield6.getText().trim());
            m_e_list.setModel(model);     

        }

        if(a.equals("UserSearch"))
        {
            searchID.clear();
            model.clear();
            m_e_list.setModel(model);
            MFVSController.returnUserProduct(model, searchID,  textfield6.getText().trim());
            m_e_list.setModel(model);                     
        }

        if(a.equals("UserOrder"))
        {
            searchID.clear();
            model.clear();
            m_e_list.setModel(model);
            MFVSController.returnOrderList(model, searchID,  textfield6.getText().trim());                
            m_e_list.setModel(model);

        }
        if(a.equals("ViewCart"))
        {

            searchID.clear();
            model.clear();
            m_e_list.setModel(model);
            MFVSController.returnShopCart(model, searchID,  textfield6.getText().trim());
            m_e_list.setModel(model);

        }
	
        textfield6.addCaretListener(new CaretListener() {
                public void caretUpdate(CaretEvent ce)
                {
                    if(a.equals("Edit")||a.equals("Remove")||a.equals("SP"))
                    {
                        searchID.clear();
                        model.clear();
                        m_e_list.setModel(model);
                        MFVSController.returnProductList(model, searchID, textfield6.getText().trim());
                        m_e_list.setModel(model);                    
                    }
                    if(a.equals("Manage Dispose"))
                    {
                        searchID.clear();
                        model.clear();
                        m_e_list.setModel(model);
                        MFVSController.returnDisposeList(model, searchID, textfield6.getText().trim());
                        m_e_list.setModel(model);     

                    }
                    if(a.equals("MA"))
                    {
                        model.clear();
                        m_e_list.setModel(model);
                        ArrayList<String> temp = new ArrayList<String>();
                        if(textfield6.getText().trim().isEmpty())
                        {
                        }
                        else{
                            temp = MFVSController.containAccount(textfield6.getText().trim());                                        
                            for(String item : temp)
                            {
                                if(model.contains(item))
                                {}
                                else
                                    model.addElement(item);
                            }
                            m_e_list.setModel(model);

                        }
                    }

                    if(a.equals("UserSearch"))
                    {
                        searchID.clear();
                        model.clear();
                        m_e_list.setModel(model);
                        MFVSController.returnUserProduct(model, searchID,  textfield6.getText().trim());
                        m_e_list.setModel(model);                   
                    }

                    if(a.equals("UserOrder"))
                    {
                        searchID.clear();
                        model.clear();
                        m_e_list.setModel(model);
                        MFVSController.returnOrderList(model, searchID,  textfield6.getText().trim());                
                        m_e_list.setModel(model);

                    }
                    if(a.equals("ViewCart"))
                    {

                        searchID.clear();
                        model.clear();
                        m_e_list.setModel(model);
                        MFVSController.returnShopCart(model, searchID,  textfield6.getText().trim());
                        m_e_list.setModel(model);                                                

                    }

                }
            });

	    
        m_e_list.addMouseListener(new MouseAdapter()
            {

                public void mouseClicked(MouseEvent e)
                {

                    if(m_e_list.getSelectedIndex()!=-1)
                    {
                        if(e.getClickCount()==2)
                        {
                            String tmpac="";
                            String tmp="";
                            if(a.equals("MA"))
                            {
                                tmpac= m_e_list.getSelectedValue().toString();
                            }
                            else
                            {
                                tmp = searchID.get(m_e_list.getSelectedIndex());
                            }

                            if(a.equals("Edit"))
                            {                               
                                productsCreatePage(tmp,"Edit");
                            }
                            if(a.equals("Manage Dispose"))
                            {
                                Object[] options = {"Donate","Delete","Cancel"};
                                int result = JOptionPane.showOptionDialog(null, "Donate or Delete?",
                                        "Donate or delete", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
                                if(result == 0)
                                {
                                    if(MFVSController.whetherDonated(tmp))
                                    {

                                        if(functionalMessage("Have dontated, sure Edit","Edit") == JOptionPane.OK_OPTION)
                                        {
                                            addToCharityPage(tmp);

                                        }
                                    }
                                    else
                                        addToCharityPage(tmp);

                                }
                                if(result == 1)
                                {

                                    if(functionalMessage("Sure delete?","delete?") == JOptionPane.OK_OPTION)
                                    {
                                        MFVSController.removeDisposeProduct(tmp);

                                    }

                                }
                                if(result == 2)
                                {

                                }
                            }
                            if(a.equals("Remove"))
                            {

                                if(functionalMessage("Sure remove?","remove?") == JOptionPane.OK_OPTION)
                                {
                                    MFVSController.removeproduct(tmp);

                                }

                            }
                            if(a.equals("MA"))
                            {

                                if(functionalMessage("Sure remove?","remove?") == JOptionPane.OK_OPTION)
                                {
                                    MFVSController.removeAC(tmpac);

                                }
                            }
                            if(a.equals("UserSearch"))
                            {

                                purchaseQuantitySelection(tmp);
                            }
                            if(a.equals("ViewCart"))
                            {

                                int tmpquant =MFVSController.getQuantity(tmp) + MFVSController.findExactTemp(tmp).getQuantity();
                                String tmpid = tmp+"/"+tmpquant;
                                //purchaseQuantitySelection(check[0], Integer.toString(tmpquant), check[2], check[3], check[4] ,"",check[5]);
                                editQuantity(2, tmpid);
                            }

                            if(a.equals("UserOrder"))
                            {
                                if(MFVSController.orderPaid(tmp)==true)
                                {

                                    if(functionalMessage("Order been paid, remove?","remove?") == JOptionPane.OK_OPTION)
                                    {
                                        MFVSController.deleteOrder(tmp);

                                    }
                                }
                                else
                                {
                                    Object[] options = {"Purchase","Delete","Cancel"};
                                    int result = JOptionPane.showOptionDialog(null, "Purchase or Delete?",
                                            "Purchase or delete", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]); 
                                    if(result == 0)
                                    {

                                        if(functionalMessage("Sure Purchase?","purchase?") == JOptionPane.OK_OPTION)
                                        {
                                            MFVSController.purchase(tmp);

                                        }

                                    }
                                    if(result == 1)
                                    {

                                        if(functionalMessage("Sure delete?","delete?") == JOptionPane.OK_OPTION)
                                        {
                                            MFVSController.deleteOrder(tmp);

                                        }

                                    }
                                    if(result == 2)
                                    {

                                    }
                                }

                            }
                            model.clear();
                            m_e_list.setModel(model);

                        }

                    }
                }
            });
	
	    
        JButton createOrder;
        createOrder = new JButton();
        createOrder.setBounds(30,350,140,35);
        createOrder.setBackground(new Color(214,217,223));
        createOrder.setForeground(new Color(0,0,0));
        createOrder.setEnabled(true);
        createOrder.setFont(new Font("sansserif",0,12));
        createOrder.setText("Create Order");
        createOrder.setVisible(false);
        createOrder.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if(MFVSController.addPListToOrder())
                    {
                        warningMessage("Congratulations","Order added");
                        frame.dispose();
                    }
                    else
                    {
                        warningMessage("Order list is empty");
                    }
                }
            });
        if(a.equals("ViewCart"))
            createOrder.setVisible(true);
        JScrollPane scrollPane = new JScrollPane(m_e_list);
        scrollPane.setHorizontalScrollBarPolicy( 
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
        scrollPane.setVerticalScrollBarPolicy( 
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

        scrollPane.setBounds(47,156,461,164);
        panel_Edit.add(label6);
        //panel_Edit.add(m_e_list);
        panel_Edit.add(textfield6);
        panel_Edit.add(back);
        panel_Edit.add(createOrder);
        panel_Edit.add(scrollPane);
        contentPane.add(panel_Edit);
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Owner can edit the Quantiy of products
     */
    public void editQuantity(int a,String ID)
    {
        JFrame frame = new JFrame("Edit Quantity");
        JLabel Quantity;
        JButton button1;
        JButton button2;
        JLabel label2;
        JPanel panel1;
        JTextField textfield1;
        frame.setSize(500,400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));

        Quantity = new JLabel();
        Quantity.setBounds(72,78,90,35);
        Quantity.setBackground(new Color(214,217,223));
        Quantity.setForeground(new Color(0,0,0));
        Quantity.setEnabled(true);
        Quantity.setFont(new Font("SansSerif",0,12));
        Quantity.setText("Quantity:");
        Quantity.setVisible(true);

        button1 = new JButton();
        button1.setBounds(39,161,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Confirm");
        button1.setVisible(true);
        //Set methods for mouse events
        //Call defined methods

        button2 = new JButton();
        button2.setBounds(181,161,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Cancel");
        button2.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose();
                }
            });

        label2 = new JLabel();
        label2.setBounds(14,12,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Edit Quantity");
        label2.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(98,78,323,233);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        textfield1 = new JTextField();
        textfield1.setBounds(180,75,100,35);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setText("");
        textfield1.setVisible(true);

        JLabel availQuant= new JLabel();
        availQuant.setBounds(100,50,140,35);
        availQuant.setVisible(false);
        availQuant.setBackground(new Color(255,255,255));
        availQuant.setForeground(new Color(0,0,0));
        availQuant.setEnabled(true);
        availQuant.setFont(new Font("sansserif",0,12));
        if(a==2)
        {
            String[] check =ID.split("/");
            availQuant.setText("Total available: "+check[1]);
            availQuant.setVisible(true);
        }
        panel1.add(availQuant);

        button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if(a==1)
                    {
                        if(MFVSController.isInteger(textfield1.getText().trim()))
                        {
                            MFVSController.EditProduct(ID,Integer.parseInt(textfield1.getText().trim()));
                            frame.dispose();
                        }
                        else
                        {
                            warningMessage("Input number please");

                        }
                    }
                    if(a==2)
                    {

                        String[] check =ID.split("/");

                        if(MFVSController.isInteger(textfield1.getText().trim()))
                        {
                            if(Integer.parseInt(textfield1.getText().trim())==0)
                            {
                                int result = JOptionPane.showConfirmDialog(null, "Remove product?",
                                        "Remove?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE); 
                                if(result == JOptionPane.OK_OPTION)
                                {
                                    MFVSController.removeTmpproduct(check[0]);
                                    frame.dispose();

                                }
                            }
                            else
                            if(Integer.parseInt(textfield1.getText().trim())<=Integer.parseInt(check[1]))
                            {
                                MFVSController.editTmpProduct(check[0],textfield1.getText().trim());
                                MFVSController.EditProduct(check[0], (Integer.parseInt(check[1])-Integer.parseInt(textfield1.getText().trim())));
                                availQuant.setVisible(false);
                                warningMessage("Congratulations","Quantity changed");
                                frame.dispose();
                            }

                            else
                                warningMessage("More than available");

                        }
                        else
                        {
                            warningMessage("Input number please");

                        }
                    }

                }
            });

        //adding components to contentPane panel
        panel1.add(Quantity);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(label2);
        contentPane.add(panel1);
        panel1.add(textfield1);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * The methods which deliver the messages when the button listener works
     */
    private int functionalMessage(String title, String content)
    {
        int result;
        return result = JOptionPane.showConfirmDialog(null, title,
            content, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Create and set attributes of the menu bar
     */
    private void setMenuBar(){
        menuBar = new JMenuBar();

        JMenu about = new JMenu("About");

        JMenuItem verson = new JMenuItem("Verson   ");
        JMenuItem help = new JMenuItem("Help   ");
        JMenuItem exit = new JMenuItem("Exit   ");

        about.add(verson);
        about.add(help);
        about.add(exit);

        menuBar.add(about);
    }

    /**
     * User and owner can log in via inputting the account and password. 
     * Customers also can register to be a user.
     * and also exit thhe system.
     */
    private void loginPage()
    {
        JTextField Account_input;
        JButton Exit;
        JButton Login;

        JButton Register;
        JLabel label_Acc;
        JLabel label_Password;
        JButton Owner_reg;
        JButton User_reg;
        JPasswordField passwordfield_main;
        JButton Owner_OK;

	    
        JLabel label_own_reg;

        JFrame frame = new JFrame("MFVSMenu");//Create a new Jframe.
        frame.setSize(1000,1000);
        //menu generate method
        setMenuBar();
        frame.setJMenuBar(menuBar);

        JPanel contentPane = new JPanel(null); //pane with null layout
        contentPane.setPreferredSize(new Dimension(600,600));
        contentPane.setBackground(new Color(192,192,192));

        Account_input = new JTextField(); //The text field of inputting account name.
        Account_input.setBounds(150,37,125,30);
        Account_input.setBackground(new Color(255,255,255));
        Account_input.setForeground(new Color(0,0,0));
        Account_input.setEnabled(true);
        Account_input.setFont(new Font("sansserif",0,12));
        Account_input.setText("");
        Account_input.setVisible(true);

        Exit = new JButton();//The button of exit.
        Exit.setBounds(231,125,90,35);
        Exit.setBackground(new Color(214,217,223));
        Exit.setForeground(new Color(0,0,0));
        Exit.setEnabled(true);
        Exit.setFont(new Font("sansserif",0,12));
        Exit.setText("Exit");
        Exit.setVisible(true);
        //Set the mouse events for exittig button.
        //Call defined methods
        Exit.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    System.exit(0);
                }
            });

        Login = new JButton();//The button of login.
        Login.setBounds(12,128,90,35);
        Login.setBackground(new Color(214,217,223));
        Login.setForeground(new Color(0,0,0));
        Login.setEnabled(true);
        Login.setFont(new Font("sansserif",0,12));
        Login.setText("Login");
        Login.setVisible(true);
        passwordfield_main = new JPasswordField();//The text field of inputting password in main menu.
        passwordfield_main.setBounds(150,81,126,30);
        passwordfield_main.setBackground(new Color(214,217,223));
        passwordfield_main.setForeground(new Color(0,0,0));
        passwordfield_main.setEnabled(true);
        passwordfield_main.setFont(new Font("sansserif",0,12));
        passwordfield_main.setVisible(true);
        //Set the mouse events for password button and validations.
        Login.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    if (Account_input.getText().trim().equals("")
                    || Account_input.getText().length()==0 || String.valueOf( passwordfield_main.getPassword()).equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Input something", "Warning",
                            JOptionPane.INFORMATION_MESSAGE);
                        Account_input.requestFocus();
                        return;
                    }
                    else
                    {
                        String whole = Account_input.getText().trim() + "/" + String.valueOf(passwordfield_main.getPassword());
                        //System.out.println(whole);
                        if(whole.equals("a/a"))
                        {
                            JOptionPane.showMessageDialog(null,  "Welcome login in", "Owner Admin",
                                JOptionPane.INFORMATION_MESSAGE);

                            ownerHomePage();
                            frame.dispose();

                        }
                        else
                        if(MFVSController.login_validation(whole))
                        {
                            JOptionPane.showMessageDialog(null, Account_input.getText().trim() + " Welcome login in", "Hello",
                                JOptionPane.INFORMATION_MESSAGE);
                            userHomePage();
                            frame.dispose();
                        }
                        else
                        {
                            warningMessage("Check your account information");
                        }

                    }
                }
            });

        loginPanel = new JPanel(null);
        loginPanel.setBorder(BorderFactory.createEtchedBorder(1));
        loginPanel.setBounds(98,117,326,180);
        loginPanel.setBackground(new Color(214,217,223));
        loginPanel.setForeground(new Color(0,0,0));
        loginPanel.setEnabled(true);
        loginPanel.setFont(new Font("sansserif",0,12));
        loginPanel.setVisible(true);

        Register = new JButton();
        Register.setBounds(121,127,90,35);
        Register.setBackground(new Color(214,217,223));
        Register.setForeground(new Color(0,0,0));
        Register.setEnabled(true);
        Register.setFont(new Font("sansserif",0,12));
        Register.setText("Register");
        Register.setVisible(true);
        //Set methods for mouse events
        //Call defined methods

        label_Acc = new JLabel();
        label_Acc.setBounds(52,38,90,35);
        label_Acc.setBackground(new Color(214,217,223));
        label_Acc.setForeground(new Color(0,0,0));
        label_Acc.setEnabled(true);
        label_Acc.setFont(new Font("sansserif",0,12));
        label_Acc.setText("Account:");
        label_Acc.setVisible(true);

        label_Password = new JLabel();
        label_Password.setBounds(52,77,90,35);
        label_Password.setBackground(new Color(214,217,223));
        label_Password.setForeground(new Color(0,0,0));
        label_Password.setEnabled(true);
        label_Password.setFont(new Font("sansserif",0,12));
        label_Password.setText("Password:");
        label_Password.setVisible(true);

        //adding components to contentPane panel
        loginPanel.add(Account_input);
        loginPanel.add(Exit);
        loginPanel.add(Login);

        loginPanel.add(Register);
        loginPanel.add(label_Acc);
        loginPanel.add(label_Password);
        loginPanel.add(passwordfield_main);

        Owner_reg = new JButton();
        Owner_reg.setBounds(13,72,90,35);
        Owner_reg.setBackground(new Color(214,217,223));
        Owner_reg.setForeground(new Color(0,0,0));
        Owner_reg.setEnabled(true);
        Owner_reg.setFont(new Font("sansserif",0,12));
        Owner_reg.setText("Owner");
        Owner_reg.setVisible(true);

	
        label_own_reg = new JLabel();
        label_own_reg.setBounds(11,13,90,35);
        label_own_reg.setBackground(new Color(214,217,223));
        label_own_reg.setForeground(new Color(0,0,0));
        label_own_reg.setEnabled(true);
        label_own_reg.setFont(new Font("sansserif",0,12));
        label_own_reg.setText("User Register");
        label_own_reg.setVisible(true);
        Register.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    registerPage("");
                }
            });
        contentPane.add(loginPanel);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     *Owner can manage the product and customers account
     *and also log out the system
     */
    private void ownerHomePage()
    {
        JButton button1;
        JButton button2;
        JButton button3;
        JPanel panel1;
        JFrame frame = new JFrame("ownerHomePage");
        frame.setSize(500,400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));
        button1 = new JButton();
        button1.setBounds(93,32,132,32);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Manage Product");
        button1.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button1.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt)
                {
                    productMangePage();
                    frame.dispose();
                }
            });

        button2 = new JButton();
        button2.setBounds(93,91,132,32);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Manage Account");
        button2.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button2.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt)
                {
                    productsEditPage("MA");
                    frame.dispose();
                }
            });

        button3 = new JButton();
        button3.setBounds(93,155,132,32);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Logout");
        button3.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button3.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt)
                {

                    loginPage();
                    frame.dispose();

                }
            });

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(95,102,326,215);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        //adding components to contentPane panel
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        contentPane.add(panel1);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Owner can manage the products
     * the fuction contains create products, edit products, remove products
     * dispose products and back to the previous menu.
     */
    private void productMangePage()
    {
        JPanel panel1;
        JButton button1;
        JButton button2;
        JButton button3;
        JButton button4;
        JButton manageDispose;
        JLabel label1;

        JFrame frame = new JFrame("Manage");
        frame.setSize(600,600);
        JPanel contentPane = new JPanel(null);

        button1 = new JButton();
        button1.setBounds(69,62,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Create");
        button1.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsCreatePage("", "Create");
                }
            });

        button2 = new JButton();
        button2.setBounds(69,117,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Edit");
        button2.setVisible(true);
        //Set methods for mouse events
        //edit
        button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsEditPage("Edit");

                }
            });

        button3 = new JButton();
        button3.setBounds(69,170,90,35);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Remove");
        button3.setVisible(true);
        //Set methods for mouse events
        //remove
        button3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsEditPage("Remove");

                }
            });

        manageDispose = new JButton();
        manageDispose.setBounds(69,220,90,35);
        manageDispose.setBackground(new Color(214,217,223));
        manageDispose.setForeground(new Color(0,0,0));
        manageDispose.setEnabled(true);
        manageDispose.setFont(new Font("sansserif",0,12));
        manageDispose.setText("Dispose");
        manageDispose.setVisible(true);
        //Set methods for mouse events
        //remove
        manageDispose.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {

                    productsEditPage("Manage Dispose");
                    MFVSController.findDispose();

                }
            });

        button4 = new JButton();
        button4.setBounds(69,270,90,35);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(0,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("sansserif",0,12));
        button4.setText("Back");
        button4.setVisible(true);
        button4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {                    
                    ownerHomePage();
                    frame.dispose();
                }
            });

        label1 = new JLabel();
        label1.setBounds(13,18,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Manage Menu");
        label1.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(123,68,227,400);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        contentPane.setPreferredSize(new Dimension(600,600));
        contentPane.setBackground(new Color(192,192,192));        
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(label1);
        panel1.add(manageDispose);
        contentPane.add(panel1);
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        //adding panel to JFrame and seting of window position and close operation

    }

    /**
     * Customer can register as a user by inputting the individual information
     */
    private void registerPage(String identify)
    {
        JFrame frame = new JFrame(identify);
        frame.setSize(600,600);

        JButton Owner_Back;
        JLabel Owner_label1;
        JLabel Owner_label2;
        JButton User_OK;
        JTextField Owner_Pass;
        JTextField Owner_account;
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600,600));
        contentPane.setBackground(new Color(192,192,192));
        Owner_Back = new JButton();
        Owner_Back.setBounds(179,230,90,35);
        Owner_Back.setBackground(new Color(214,217,223));
        Owner_Back.setForeground(new Color(0,0,0));
        Owner_Back.setEnabled(true);
        Owner_Back.setFont(new Font("sansserif",0,12));
        Owner_Back.setText("Cancel");
        Owner_Back.setVisible(true);
        Owner_Back.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose(); 
                }
            });

        User_OK = new JButton();
        User_OK.setBounds(58,230,90,35);
        User_OK.setBackground(new Color(214,217,223));
        User_OK.setForeground(new Color(0,0,0));
        User_OK.setEnabled(true);
        User_OK.setFont(new Font("sansserif",0,12));
        User_OK.setText("OK");
        User_OK.setVisible(true);
        Owner_Pass = new JTextField();
        Owner_Pass.setBounds(156,80,123,33);
        Owner_Pass.setBackground(new Color(255,255,255));
        Owner_Pass.setForeground(new Color(0,0,0));
        Owner_Pass.setEnabled(true);
        Owner_Pass.setFont(new Font("sansserif",0,12));
        Owner_Pass.setText("");
        Owner_Pass.setVisible(true);

        Owner_account = new JTextField();
        Owner_account.setBounds(156,30,124,32);
        Owner_account.setBackground(new Color(255,255,255));
        Owner_account.setForeground(new Color(0,0,0));
        Owner_account.setEnabled(true);
        Owner_account.setFont(new Font("sansserif",0,12));
        Owner_account.setText("");
        Owner_account.setVisible(true);

        JTextField address = new JTextField();       
        address.setBounds(156,130,123,33);
        address.setBackground(new Color(255,255,255));
        address.setForeground(new Color(0,0,0));
        address.setEnabled(true);
        address.setFont(new Font("sansserif",0,12));
        address.setText("");
        address.setVisible(true);

        JTextField payment = new JTextField();
        payment.setBounds(156,180,124,32);
        payment.setBackground(new Color(255,255,255));
        payment.setForeground(new Color(0,0,0));
        payment.setEnabled(true);
        payment.setFont(new Font("sansserif",0,12));
        payment.setText("");
        payment.setVisible(true);

        User_OK.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    String a = Owner_account.getText().trim();
                    String b = Owner_Pass.getText().trim();
                    String c = address.getText().trim();
                    String d = payment.getText().trim();
                    if (a.isEmpty()||b.isEmpty()||c.isEmpty()||d.isEmpty())    
                    {
                        warningMessage("Input something");
                        Owner_account.requestFocus();         
                    }
                    else
                    {
                        if (a.charAt(0) == '-' || a.charAt(a.length()-1) == '-' || a.length() > 15 || a.length() < 2)
                        { warningMessage("No '-' in head and tail and 2 <= length < 15 characters");

                            Owner_account.requestFocus();
                        }
                        else
                        {
                            if(b.length() > 15)
                            {
                                warningMessage("Password length < 15");
                            }
                            else
                            {
                                if(identify.equals("Edit profile"))
                                {
                                    MFVSController.editAccount(a, b, c, d);
                                    warningMessage("Congratulations","Account modified");

                                }
                                else
                                {
                                    if(MFVSController.addCustomerList(a+"/"+b+"/"+c+"/"+"d"))
                                    {
                                        JOptionPane.showMessageDialog(null, "User account registered", "Congratulations",
                                            JOptionPane.INFORMATION_MESSAGE);
                                        frame.dispose();    

                                    }
                                    else
                                    {
                                        warningMessage("Account been taken");
                                    }
                                }

                            }
                        }
                    }
                }
            });

        Owner_label1 = new JLabel();
        Owner_label1.setBounds(56,30,90,35);
        Owner_label1.setBackground(new Color(214,217,223));
        Owner_label1.setForeground(new Color(0,0,0));
        Owner_label1.setEnabled(true);
        Owner_label1.setFont(new Font("sansserif",0,12));
        Owner_label1.setText("Account:");
        Owner_label1.setVisible(true);

        Owner_label2 = new JLabel();
        Owner_label2.setBounds(56,80,90,35);
        Owner_label2.setBackground(new Color(214,217,223));
        Owner_label2.setForeground(new Color(0,0,0));
        Owner_label2.setEnabled(true);
        Owner_label2.setFont(new Font("sansserif",0,12));
        Owner_label2.setText("Password");
        Owner_label2.setVisible(true);

        JLabel addlabel = new JLabel();
        addlabel.setBounds(56,130,90,35);
        addlabel.setBackground(new Color(214,217,223));
        addlabel.setForeground(new Color(0,0,0));
        addlabel.setEnabled(true);
        addlabel.setFont(new Font("sansserif",0,12));
        addlabel.setText("Address");
        addlabel.setVisible(true);

        JLabel paylabel = new JLabel();
        paylabel.setBounds(56,180,90,35);
        paylabel.setBackground(new Color(214,217,223));
        paylabel.setForeground(new Color(0,0,0));
        paylabel.setEnabled(true);
        paylabel.setFont(new Font("sansserif",0,12));
        paylabel.setText("payment");
        paylabel.setVisible(true);

        JPanel panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(28,129,550,391);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        //adding components to contentPane panel
        panel1.add(Owner_Back);
        panel1.add(Owner_label1);
        panel1.add(paylabel);
        panel1.add(addlabel);
        panel1.add(Owner_label2);
        panel1.add(User_OK);
        panel1.add(Owner_Pass);
        panel1.add(Owner_account);
        panel1.add(payment);
        panel1.add(address);

        contentPane.add(panel1);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * User can search the products, edit the individual information, 
     * view the shopping cart, view the order and log out
     */
    private void userHomePage()
    {
        JButton button1;
        JButton button2;
        JButton button4;
        JButton button5;
        JButton button3;
        JButton unregister;
        JLabel label1;
        JPanel panel1;

        JFrame frame = new JFrame("User Menu");
        frame.setSize(600, 400);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(192,192,192));
        button1 = new JButton();
        button1.setBounds(13,69,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Search");
        button1.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button1.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsEditPage("UserSearch");
                }
            });

        button4 = new JButton();
        button4.setBounds(13,140,90,35);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(0,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("sansserif",0,12));
        button4.setText("View cart");
        button4.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button4.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsEditPage("ViewCart");
                }
            });

        button5 = new JButton();
        button5.setBounds(126,69,90,35);
        button5.setBackground(new Color(214,217,223));
        button5.setForeground(new Color(0,0,0));
        button5.setEnabled(true);
        button5.setFont(new Font("sansserif",0,12));
        button5.setText("Edit Profile");
        button5.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button5.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    registerPage("Edit profile");
                }
            });

        button2 = new JButton();
        button2.setBounds(126,140,100,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("View order");
        button2.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button2.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    productsEditPage("UserOrder");
                }
            });

        button3 = new JButton();
        button3.setBounds(237,69,90,35);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Logout");
        button3.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        button3.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    frame.dispose();
                    loginPage();
                }
            });
        
        unregister = new JButton();
        unregister.setBounds(237,140,90,35);
        unregister.setBackground(new Color(214,217,223));
        unregister.setForeground(new Color(0,0,0));
        unregister.setEnabled(true);
        unregister.setFont(new Font("sansserif",0,12));
        unregister.setText("Unregister");
        unregister.setVisible(true);
        //Set methods for mouse events
        //Call defined methods
        unregister.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                	if(functionalMessage("Sure unregister", "Unregister?") == JOptionPane.OK_OPTION)
                    {
                        MFVSController.unregister();
                        frame.dispose();
                        loginPage();
                    }
                	
                }
            });

	
        label1 = new JLabel();
        label1.setBounds(16,8,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("User");
        label1.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(74,93,400,200);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        //adding components to contentPane panel
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel1.add(button4);
        panel1.add(button5);
        panel1.add(unregister);
        panel1.add(label1);
        contentPane.add(panel1);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * When user clicks the product he wants to buy, a menu will be shown. User
     * can eidt the quantity of the products
     */
    private void purchaseQuantitySelection(String ID)
    {
        String[] check = MFVSController.returnProductInfo(ID).split("/");

        JButton Cancel;
        JLabel Dis;
        JLabel ExprD;
        JLabel MD;
        JLabel Name;
        JLabel Q;
        JTextField QS;
        JLabel label1;
        JLabel label11;
        JLabel label2;
        JLabel label3;
        JLabel label4;
        JLabel label5;
        JLabel label13;
        JLabel price;
        JPanel panel1;
        JButton purchase;
        JLabel total;
        JFrame frame = new JFrame("Select Quantity");
        frame.setSize(600, 600);
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(600,600));
        contentPane.setBackground(new Color(192,192,192));

        Cancel = new JButton();
        Cancel.setBounds(171,338,90,35);
        Cancel.setBackground(new Color(214,217,223));
        Cancel.setForeground(new Color(0,0,0));
        Cancel.setEnabled(true);
        Cancel.setFont(new Font("sansserif",0,12));
        Cancel.setText("Cancel");
        Cancel.setVisible(true);

        Dis = new JLabel();
        Dis.setBounds(191,180,90,35);
        Dis.setBackground(new Color(214,217,223));
        Dis.setForeground(new Color(0,0,0));
        Dis.setEnabled(true);
        Dis.setFont(new Font("sansserif",0,12));
        Dis.setText(check[5]+" %");
        Dis.setVisible(true);

        ExprD = new JLabel();
        ExprD.setBounds(191,140,90,35);
        ExprD.setBackground(new Color(214,217,223));
        ExprD.setForeground(new Color(0,0,0));
        ExprD.setEnabled(true);
        ExprD.setFont(new Font("sansserif",0,12));
        ExprD.setText(check[4]);
        ExprD.setVisible(true);

        MD = new JLabel();
        MD.setBounds(191,100,90,35);
        MD.setBackground(new Color(214,217,223));
        MD.setForeground(new Color(0,0,0));
        MD.setEnabled(true);
        MD.setFont(new Font("sansserif",0,12));
        MD.setText(check[3]);
        MD.setVisible(true);

        Name = new JLabel();
        Name.setBounds(191,20,90,35);
        Name.setBackground(new Color(214,217,223));
        Name.setForeground(new Color(0,0,0));
        Name.setEnabled(true);
        Name.setFont(new Font("sansserif",0,12));
        Name.setText(check[0]);
        Name.setVisible(true);

        Q = new JLabel();
        Q.setBounds(191,60,90,35);
        Q.setBackground(new Color(214,217,223));
        Q.setForeground(new Color(0,0,0));
        Q.setEnabled(true);
        Q.setFont(new Font("sansserif",0,12));
        Q.setText(check[1]);
        Q.setVisible(true);

        QS = new JTextField();
        QS.setBounds(168,254,90,35);
        QS.setBackground(new Color(255,255,255));
        QS.setForeground(new Color(0,0,0));
        QS.setEnabled(true);
        QS.setFont(new Font("sansserif",0,12));
        QS.setText("");
        QS.setVisible(true);

        label1 = new JLabel();
        label1.setBounds(62,20,90,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("Product Name:");
        label1.setVisible(true);

        label11 = new JLabel();
        label11.setBounds(40,254,107,34);
        label11.setBackground(new Color(214,217,223));
        label11.setForeground(new Color(0,0,0));
        label11.setEnabled(true);
        label11.setFont(new Font("sansserif",0,12));
        label11.setText("Quantity Selection");
        label11.setVisible(true);

        label13 = new JLabel();
        label13.setBounds(63,214,90,35);
        label13.setBackground(new Color(214,217,223));
        label13.setForeground(new Color(0,0,0));
        label13.setEnabled(true);
        label13.setFont(new Font("sansserif",0,12));
        label13.setText("Price:");
        label13.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(62,59,109,33);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("sansserif",0,12));
        label2.setText("Quantity available:");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(62,100,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("sansserif",0,12));
        label3.setText("Make Date:");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(62,140,90,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("sansserif",0,12));
        label4.setText("Expr Date:");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(62,180,90,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("Discount:");
        label5.setVisible(true);

        panel1 = new JPanel(null);
        panel1.setBorder(BorderFactory.createEtchedBorder(1));
        panel1.setBounds(95,27,297,409);
        panel1.setBackground(new Color(214,217,223));
        panel1.setForeground(new Color(0,0,0));
        panel1.setEnabled(true);
        panel1.setFont(new Font("sansserif",0,12));
        panel1.setVisible(true);

        price = new JLabel();
        price.setBounds(191,215,90,35);
        price.setBackground(new Color(214,217,223));
        price.setForeground(new Color(0,0,0));
        price.setEnabled(true);
        price.setFont(new Font("sansserif",0,12));
        price.setText(check[2]+"");
        price.setVisible(true);

        purchase = new JButton();
        purchase.setBounds(16,338,120,35);
        purchase.setBackground(new Color(214,217,223));
        purchase.setForeground(new Color(0,0,0));
        purchase.setEnabled(true);
        purchase.setFont(new Font("sansserif",0,12));
        purchase.setText("Add to cart");
        purchase.setVisible(true);	//create order

        total = new JLabel();
        total.setBounds(108,291,150,35);
        total.setBackground(new Color(214,217,223));
        total.setForeground(new Color(0,0,0));
        total.setEnabled(true);
        total.setFont(new Font("sansserif",0,12));
        total.setText("Total:");
        total.setVisible(true);

		
        purchase.addMouseListener(new MouseAdapter() {

                public void mousePressed(MouseEvent evt)
                {

                    int result = JOptionPane.showConfirmDialog(null, "Want to buy " + QS.getText().trim() +" "+ check[0] + " (s)",
                            "Add to cart", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE); 
                    if(result == JOptionPane.OK_OPTION)
                    {

                        int tmpa=0;
                        int tmpb=0;
                        String quant="";
                        boolean tmpflag=false;
                        try
                        {

                            tmpa = Integer.parseInt(check[1]);
                            tmpb = Integer.parseInt(QS.getText().trim());

                            tmpflag= true;               		                 	               		 

                        }
                        catch(Exception e)
                        {
                            tmpflag = false;
                            warningMessage("Input Number");
                        }
                        if(tmpflag)
                        {
                            if((tmpa-tmpb) >=0 )
                            { 
                                MFVSController.addProductToOrder(ID, QS.getText().trim());
                                MFVSController.EditProduct(ID, tmpa-tmpb);
                                warningMessage("Congratulations","Product added");
                                frame.dispose();
                            }
                            else
                                warningMessage("Out of Maxium");
                        }

                    }
                }
            });

        Cancel.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent evt){
                    frame.dispose();
                }
            });

        QS.addCaretListener(new CaretListener() {
                public void caretUpdate(CaretEvent ce)
                {
                    total.setText("total:");
                    try
                    {

                        if(Integer.parseInt(QS.getText().trim()) <= Integer.parseInt(check[1]))
                            total.setText("total: " + Integer.parseInt(QS.getText().trim())
                                *0.01
                                *Double.parseDouble(check[2]) * Integer.parseInt(check[5])
                                + " AUD");
                        else
                            total.setText("Out of Maxium");
                    }
                    catch(Exception e)
                    {

                    }

                }
            });

		
        //adding components to contentPane panel
        panel1.add(Cancel);
        panel1.add(Dis);
        panel1.add(ExprD);
        panel1.add(MD);
        panel1.add(Name);
        panel1.add(Q);
        panel1.add(QS);
        panel1.add(label1);
        panel1.add(label11);
        panel1.add(label13);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        contentPane.add(panel1);
        panel1.add(price);
        panel1.add(purchase);
        panel1.add(total);

        //adding components to contentPane panel
        panel1.add(Cancel);
        panel1.add(Dis);
        panel1.add(ExprD);
        panel1.add(MD);
        panel1.add(Name);
        panel1.add(Q);
        panel1.add(QS);
        panel1.add(label1);
        panel1.add(label11);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        panel1.add(label5);
        contentPane.add(panel1);
        panel1.add(purchase);
        panel1.add(total);

        //adding panel to JFrame and seting of window position and close operation
        frame.add(contentPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private void warningMessage(String content)
    {
        JOptionPane.showMessageDialog(null, content, "Warning",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void warningMessage(String title, String content)
    {
        JOptionPane.showMessageDialog(null, content, title,
            JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new MFVSMenu();
                }
            });
    }

}