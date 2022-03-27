
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class otobusFirmasi extends javax.swing.JFrame  {

   File f = new File("d:\\otobüs_firma\\kullanicikaydi");
   int ss;
    public otobusFirmasi() {
        initComponents();
    }
    void dosyaOlustur(){
        if(!f.exists()){
            f.mkdirs();
        }
    } 
    
    void dosyaOku (){
       try {
           FileReader fr  = new FileReader(f+"\\yenikayit.txt");
           System.out.println("İşlem başarılı !");
       } catch (FileNotFoundException ex) {
           try {
              FileWriter fw = new FileWriter(f+"\\yenikayit.txt");
               System.out.println("Dosya oluşturuldu");
                       } 
           catch (IOException ex1) {
               Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex1);
           }
       }
    }
    
    void yeniData(String k_Adi, String sfre,String e_Mail){
       try {
           RandomAccessFile raf = new RandomAccessFile(f+"\\yenikayit.txt","rw");
           for(int i=0;i<ss;i++){
               raf.readLine();
           }
           if(ss>0){
           raf.writeBytes("\r\n");
           raf.writeBytes("\r\n");
           }
           raf.writeBytes("Kullanici Adi:"+k_Adi+"\r\n");
           raf.writeBytes("Sifre:"+sfre+"\r\n");
           raf.writeBytes("Email:"+e_Mail);
           
           
           
       } catch (FileNotFoundException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    
    void satirSayisi(){
       try {
           ss=0;
           RandomAccessFile raf= new RandomAccessFile(f+"\\yenikayit.txt","rw");
           for(int i =0;raf.readLine()!=null;i++){
              ss++;
           }
           System.out.println("Satır sayısı:"+ss);
       } catch (FileNotFoundException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
    void kontrolEt(String k_Adi, String sfre){
        try {
           RandomAccessFile raf= new RandomAccessFile(f+"\\yenikayit.txt","rw");
           for(int i=0; i<ss;i+=4){
               System.out.println("count"+i);
               String forKullanici= raf.readLine().substring(14);
               String forSifre= raf.readLine().substring(6);
               if (k_Adi.equals(forKullanici)& sfre.equals(forSifre)){
                  
                   JOptionPane.showMessageDialog(null, "Giriş Yapılıyor..");
                   biletAl biletal=new biletAl();
                   biletal.setVisible(true);
        
                   
                     break;
               }
               else if(i==(ss-3)){
                   JOptionPane.showMessageDialog(null, "Kullanıcı adınız veya şifreniz yanlış !");
                   
               }
               
               for (int k=1;k<=2;k++){
                   raf.readLine();
               }
               
           }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(otobusFirmasi.class.getName()).log(Level.SEVERE, null, ex);
       }
        
            
    }
       
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGrsYap = new javax.swing.JLabel();
        lblHosgeldiniz = new javax.swing.JLabel();
        lblSifretxt = new javax.swing.JLabel();
        lblKullanicitxt = new javax.swing.JLabel();
        grsYap = new javax.swing.JTextField();
        btnCks = new javax.swing.JButton();
        btnGrs = new javax.swing.JButton();
        pnlYesil = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btnKyt = new javax.swing.JButton();
        btnSifirla = new javax.swing.JButton();
        lblEposta = new javax.swing.JLabel();
        tfEposta1 = new javax.swing.JTextField();
        sfreGir = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Otobüs Firmasi");
        setBackground(new java.awt.Color(153, 255, 153));
        setResizable(false);

        lblGrsYap.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        lblGrsYap.setText("GİRİŞ YAP");
        lblGrsYap.setToolTipText("");

        lblHosgeldiniz.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        lblHosgeldiniz.setText("Sistemimize Hoşgeldiniz");

        lblSifretxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSifretxt.setText("Şifre:");

        lblKullanicitxt.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblKullanicitxt.setText("Kullanıcı adı:");

        grsYap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnCks.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnCks.setText("ÇIKIŞ YAP");
        btnCks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCksActionPerformed(evt);
            }
        });

        btnGrs.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnGrs.setText("GIRIS");
        btnGrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrsActionPerformed(evt);
            }
        });

        pnlYesil.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pnlYesilLayout = new javax.swing.GroupLayout(pnlYesil);
        pnlYesil.setLayout(pnlYesilLayout);
        pnlYesilLayout.setHorizontalGroup(
            pnlYesilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        pnlYesilLayout.setVerticalGroup(
            pnlYesilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );

        btnKyt.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnKyt.setText("KAYIT OL");
        btnKyt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKytActionPerformed(evt);
            }
        });

        btnSifirla.setText("Sıfırla");
        btnSifirla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSifirlaActionPerformed(evt);
            }
        });

        lblEposta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEposta.setText("E-Posta:");

        tfEposta1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlYesil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblKullanicitxt)
                                    .addComponent(lblSifretxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(grsYap, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                    .addComponent(sfreGir)))
                            .addComponent(btnSifirla)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEposta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfEposta1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHosgeldiniz)
                            .addComponent(lblLogo)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnKyt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnGrs, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCks, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblGrsYap)
                                .addGap(80, 80, 80)))))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlYesil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lblHosgeldiniz, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGrsYap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grsYap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKullanicitxt))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sfreGir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSifretxt))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfEposta1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEposta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSifirla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGrs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKyt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(btnCks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCksActionPerformed
        System.exit(JFrame.EXIT_ON_CLOSE);  
    }//GEN-LAST:event_btnCksActionPerformed

    @SuppressWarnings("empty-statement")
    private void btnGrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrsActionPerformed
        dosyaOlustur();
        dosyaOku();
        satirSayisi();
        kontrolEt(grsYap.getText(), sfreGir.getText());
        
        
        
        
    
      
    }//GEN-LAST:event_btnGrsActionPerformed

    private void btnKytActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKytActionPerformed
        dosyaOlustur();
        dosyaOku();
        satirSayisi();
        yeniData(grsYap.getText(), sfreGir.getText(),tfEposta1.getText());
        
        JOptionPane.showMessageDialog(null,"Kaydınız oluşturuldu !");
        
        
    }//GEN-LAST:event_btnKytActionPerformed

    private void btnSifirlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSifirlaActionPerformed
    grsYap.setText("");     
    sfreGir.setText("");
    tfEposta1.setText("");
    }//GEN-LAST:event_btnSifirlaActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(otobusFirmasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       //</editor-fold>
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new otobusFirmasi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCks;
    private javax.swing.JButton btnGrs;
    private javax.swing.JButton btnKyt;
    private javax.swing.JButton btnSifirla;
    private javax.swing.JTextField grsYap;
    private javax.swing.JLabel lblEposta;
    private javax.swing.JLabel lblGrsYap;
    private javax.swing.JLabel lblHosgeldiniz;
    private javax.swing.JLabel lblKullanicitxt;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblSifretxt;
    private javax.swing.JPanel pnlYesil;
    private javax.swing.JPasswordField sfreGir;
    private javax.swing.JTextField tfEposta1;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        
    }
}
