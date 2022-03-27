

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Emre özen
 */


public class biletAl extends javax.swing.JFrame {
    File f= new File ("d:\\otobüs_firma\\biletAl");
    int bakiye=0;
    int parapuan = 0;
    DefaultListModel model;
    int ss;
    
    
 abstract class prPuan {
      
      abstract int istanbulAnkarap();
      abstract int istanbulNevsehirp();
      abstract int istanbulKirikkalep();
      abstract int ankaraIstanbulp();
      abstract int ankaraNevsehirp();
      abstract int ankaraKirikkalep();
      abstract int nevsehirIstanbulp();
      abstract int nevsehirAnkarap();
      abstract int nevsehirKirikkalep();
      abstract int kirikkaleIstanbulp();
      abstract int kirikkaleAnkarap();
      abstract int kirikkaleNevsehirp();
      
      
      
 }

 
 class illerPuan extends prPuan{

        @Override
        int istanbulAnkarap() {
            
            return 10;
            
        }

        @Override
        int istanbulNevsehirp() {
            
            return 15;
            
        }

        @Override
        int istanbulKirikkalep() {
            
            return 20;
            
        }

        @Override
        int ankaraIstanbulp() {
           
            return 10;
           
        }

        @Override
        int ankaraNevsehirp() {
            
            return 5;
            
        }

        @Override
        int ankaraKirikkalep() {
           
            return 3;
           
        }

        @Override
        int nevsehirIstanbulp() {
           
            return 15;
           
        }

        @Override
        int nevsehirAnkarap() {
            
            return 5;
            
        }

        @Override
        int nevsehirKirikkalep() {
           
            return 3;
           
        }

        @Override
        int kirikkaleIstanbulp() {
           
            return 20;
           
        }

        @Override
        int kirikkaleAnkarap() {
            
            return 3;
            
        }

        @Override
        int kirikkaleNevsehirp() {
            
            return 2;
            
        }
 
 }

 abstract class zaman {
    abstract double tumZamanlar();
  
 }
 
 class vakitler extends zaman {
        
        @Override
        double tumZamanlar() {
            switch (lstSaat.getSelectedIndex()) {
                case 0 -> {
                    return 10.15;
                }
                case 1 -> {
                    return 14.15;
                }
                case 2 -> {
                    return 18.35;
                }
                case 3 -> {
                    return 22.45; 
                }
            }
            return 0;
            
           
        
    }
 }
            

 
  public interface fiyatDegistir {
    public int istanbulAnkara();
    public int istanbulNevsehir();
    public int istanbulKirikkale();
    public int ankaraIstanbul();
    public int ankaraNevsehir();
    public int ankaraKirikkale();
    public int nevsehirIstanbul();
    public int nevsehirAnkara();
    public int  nevsehirKirikkale();
    public int  kirikkaleIstanbul();
    public int  kirikkaleAnkara();
    public int  kirikkaleNevsehir();
    
    } 
 class Fiyatlar implements biletAl.fiyatDegistir {

        @Override
        public int istanbulAnkara() {
            
            return 450;
            
        }

        @Override
        public int  istanbulNevsehir() {
            
            return 300;
            
        }

        @Override
        public int  istanbulKirikkale() {
           
            return 350;
           
        }

        @Override
        public int  ankaraIstanbul() {
            
            return 250;
            
        }

        @Override
        public int  ankaraNevsehir() {
           return 100;
        }

        @Override
        public int  ankaraKirikkale() {
            return 70;
        }
         @Override
        public int nevsehirIstanbul() {
            return 350;
        }

        @Override
        public int nevsehirAnkara() {
            return 100;
        }

        @Override
        public int  nevsehirKirikkale() {
            return 80;
        }

        @Override
        public int  kirikkaleIstanbul() {
            return 300;
        }
        @Override
        public int  kirikkaleAnkara() {
            return 70;
        }

        @Override
        public int  kirikkaleNevsehir() {
            return 80;
        }

        
 }     
    public biletAl()  {
        initComponents();
        model=new DefaultListModel();
        lstGecmis.setModel(model);
    }
    void dosyaOlustur(){
        if (!f.exists()){
            f.mkdirs();
        }
    }
    void dosyaOku(){
        
        try {
            FileReader fr = new FileReader(f+"\\biletalma.txt");
            System.out.println("Okuma başarılı");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(biletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            FileWriter fw = new FileWriter(f+"\\biletalma.txt");
            System.out.println("Yazma başarılı !");
        } 
        catch (IOException ex) {
            Logger.getLogger(biletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    void faturaOlustur(String fatura) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\biletalma.txt","rw");
            raf.readLine();
            raf.writeBytes("SAYIN YOLCUMUZ FATURA BILGILERINIZ ASAGIDAKI GIBIDIR\r\n");
            raf.writeBytes(fatura+"\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Lutfen hareket saatinden en az 30 dakika önce terminalimizde hazir olarak bulununuz.");
            raf.writeBytes("IYI YOLCULUKLAR DILERIZ");
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(biletAl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(biletAl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    illerPuan ilpuan = new illerPuan();
    Fiyatlar fiyat = new Fiyatlar();
    vakitler vkt = new vakitler();
    
    void FiyatGoster(){
        
        
        if((jlNereye.getSelectedIndex()==1)&(jlNerden.getSelectedIndex()==0)){
            tfFiyat.setText("İstanbul- Ankara:"+fiyat.istanbulAnkara()+"TL"+"----"+"Parapuan :"+ilpuan.istanbulAnkarap()+"----"+vkt.tumZamanlar());
           
        }
        else if ((jlNerden.getSelectedIndex()==0)&(jlNereye.getSelectedIndex()==2)){
            tfFiyat.setText("İstanbul- Nevşehir:"+fiyat.istanbulNevsehir()+"TL"+"----"+"Parapuan"+ilpuan.istanbulNevsehirp()+"----"+vkt.tumZamanlar());
        }
        else if ((jlNerden.getSelectedIndex()==0)&(jlNereye.getSelectedIndex()==3)){
             tfFiyat.setText("İstanbul-Kırıkkale:"+fiyat.istanbulKirikkale()+"TL"+"----"+"Parapuan"+ilpuan.istanbulKirikkalep()+"----"+vkt.tumZamanlar());
        }
         else if((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==0)){
            tfFiyat.setText("Ankara-İstanbul:"+fiyat.ankaraIstanbul()+"TL"+"----"+"Parapuan"+ilpuan.ankaraIstanbulp()+"----"+vkt.tumZamanlar());
         }
        else  if ((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==2)){
            tfFiyat.setText("Ankara-Nevşehir:"+fiyat.ankaraNevsehir()+"TL"+"----"+"Parapuan"+ilpuan.ankaraNevsehirp()+"----"+vkt.tumZamanlar());
        }
        else  if ((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==3)){
            tfFiyat.setText("Ankara-Kırıkkale:"+fiyat.ankaraKirikkale()+"TL"+"----"+"Parapuan"+ilpuan.ankaraKirikkalep()+"----"+vkt.tumZamanlar());
        }
        else if((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==0)){
             tfFiyat.setText("Nevşehir-İstanbul:"+fiyat.nevsehirIstanbul()+"TL"+"----"+"Parapuan"+ilpuan.nevsehirIstanbulp()+"----"+vkt.tumZamanlar());
        }
        else  if ((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==1)){
            tfFiyat.setText("Nevşehir-Ankara:"+fiyat.nevsehirAnkara()+"TL"+"----"+"Parapuan"+ilpuan.nevsehirAnkarap()+"----"+vkt.tumZamanlar());
        }
         else  if ((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==3)){
            tfFiyat.setText("Nevşehir-Kırıkkale:"+fiyat.nevsehirKirikkale()+"TL"+"----"+"Parapuan"+ilpuan.nevsehirKirikkalep()+"----"+vkt.tumZamanlar());
         }
         else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==0)){
            tfFiyat.setText("Kırıkkale-İstanbul"+fiyat.kirikkaleIstanbul()+"TL"+"----"+"Parapuan"+ilpuan.kirikkaleIstanbulp()+"----"+vkt.tumZamanlar());
        }
        else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==1)){
             tfFiyat.setText("Kırıkkale-Ankara:"+fiyat.kirikkaleAnkara()+"TL"+"----"+"Parapuan"+ilpuan.kirikkaleAnkarap()+"----"+vkt.tumZamanlar());
            
           }
        else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==2)){
             tfFiyat.setText("Kırıkkale-Nevşehir:"+fiyat.kirikkaleNevsehir()+"TL"+"----"+"Parapuan"+ilpuan.kirikkaleNevsehirp());
            
         }
        else {
             JOptionPane.showMessageDialog(null, "Hatalı seçim yaptınız !");
         }
        
    }
        
    
    void secim (){
        
        
                
        //istanbul-ankara
        if((jlNereye.getSelectedIndex()==1)&(jlNerden.getSelectedIndex()==0)& (bakiye>=fiyat.istanbulAnkara())){
           
            bakiye=bakiye-fiyat.istanbulAnkara();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.istanbulAnkarap();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.istanbulAnkarap()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
            
           }
        //istanbul-nevşehir
        else if ((jlNerden.getSelectedIndex()==0)&(jlNereye.getSelectedIndex()==2)&bakiye>=fiyat.istanbulNevsehir()){
            
            bakiye=bakiye-fiyat.istanbulNevsehir();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.istanbulNevsehirp();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.istanbulNevsehirp()+"  para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
       //istanbul-kırıkkale 
       else if ((jlNerden.getSelectedIndex()==0)&(jlNereye.getSelectedIndex()==3)&bakiye>=fiyat.istanbulAnkara()){
             
            bakiye=bakiye-fiyat.istanbulKirikkale();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.istanbulKirikkalep();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.istanbulKirikkalep()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
       }
       //ankara-istanbul
       else if((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==0)&bakiye>=fiyat.ankaraIstanbul()){
            
            bakiye=bakiye-fiyat.ankaraIstanbul();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.ankaraIstanbulp();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.ankaraIstanbulp()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
        }
      //ankara-nevşehir
      else  if ((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==2)&bakiye>=fiyat.ankaraNevsehir()){
           
            bakiye=bakiye-fiyat.ankaraNevsehir();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.ankaraNevsehirp();
            praPuan.setText(""+parapuan);
           
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.ankaraNevsehirp()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
      //ankara-kırıkkale
      else  if ((jlNerden.getSelectedIndex()==1)&(jlNereye.getSelectedIndex()==3)&bakiye>=fiyat.ankaraKirikkale()){
           
            bakiye=bakiye-fiyat.ankaraKirikkale();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.ankaraKirikkalep();
            praPuan.setText(""+parapuan);
           
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.ankaraKirikkalep()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
      //nevşehir-istanbul
       else if((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==0)&bakiye>=fiyat.nevsehirAnkara()){
            
           bakiye=bakiye-fiyat.nevsehirIstanbul();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.nevsehirIstanbulp();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.nevsehirIstanbulp()+"para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
        }
       //nevşehir-ankara
      else  if ((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==1)&bakiye>=fiyat.nevsehirAnkara()){
           
            bakiye=bakiye-fiyat.nevsehirAnkara();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.nevsehirAnkarap();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.nevsehirAnkarap()+"para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
      //nevşehir-kırıkkale
       else  if ((jlNerden.getSelectedIndex()==2)&(jlNereye.getSelectedIndex()==3)&bakiye>=fiyat.nevsehirKirikkale()){
            
            bakiye=bakiye-fiyat.nevsehirKirikkale();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.nevsehirKirikkalep();
            praPuan.setText(""+parapuan);
           
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.nevsehirKirikkalep()+"para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
       //kırıkkale-istanbul
       else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==0)&bakiye>=fiyat.kirikkaleIstanbul()){
           
            bakiye=bakiye-fiyat.kirikkaleIstanbul();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.kirikkaleIstanbulp();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.kirikkaleIstanbulp()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
       //kırıkkale-ankara
        else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==1)&bakiye>=fiyat.kirikkaleAnkara()){
            
            bakiye=bakiye-fiyat.kirikkaleAnkara();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.kirikkaleAnkarap();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.kirikkaleAnkarap()+"para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
        //kırıkkale-nevşehir
         else  if ((jlNerden.getSelectedIndex()==3)&(jlNereye.getSelectedIndex()==2)&bakiye>=fiyat.kirikkaleNevsehir()){
            
            bakiye=bakiye-fiyat.kirikkaleNevsehir();
            bkyText.setText(""+bakiye);
            parapuan=parapuan+ilpuan.kirikkaleNevsehirp();
            praPuan.setText(""+parapuan);
            
            JOptionPane.showMessageDialog(null, """
                                                Tebrikler !
                                                """+ilpuan.kirikkaleNevsehirp()+" para puan kazandınız - Hesabım kısmından kontrol edebilirsiniz !");
           }
     
      else {
                JOptionPane.showMessageDialog(null,"Bakiye yetersiz lütfen bakiye yükleyiniz !");
            }
        
        
        }
    void bakiyeYukle(){
       
        int miktar = 2000;
        if (bakiye<=miktar){
            int yukle = Integer.parseInt(bkyYukle.getText());
            bakiye=bakiye+yukle;
            bkyText.setText(""+bakiye);
        }
        else {
            JOptionPane.showMessageDialog(null, "Maximum bakiye yükleme sınırını aştınız !");
        }
    }
    
    void puandanHarca (){
        if ((jlNereye.getSelectedIndex()==1)&(jlNerden.getSelectedIndex()==0)&parapuan>=ilpuan.istanbulAnkarap()){
            parapuan=parapuan-ilpuan.istanbulAnkarap();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==2)&(jlNerden.getSelectedIndex()==0)&parapuan>=ilpuan.istanbulNevsehirp()){
            parapuan=parapuan-ilpuan.istanbulNevsehirp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==3)&(jlNerden.getSelectedIndex()==0)&parapuan>=ilpuan.istanbulKirikkalep()){
            parapuan=parapuan-ilpuan.istanbulKirikkalep();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==0)&(jlNerden.getSelectedIndex()==1)&parapuan>=ilpuan.ankaraIstanbulp()){
            parapuan=parapuan-ilpuan.ankaraIstanbulp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==2)&(jlNerden.getSelectedIndex()==1)&parapuan>=ilpuan.ankaraNevsehirp()){
            parapuan=parapuan-ilpuan.ankaraNevsehirp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==3)&(jlNerden.getSelectedIndex()==1)&parapuan>=ilpuan.ankaraKirikkalep()){
            parapuan=parapuan-ilpuan.ankaraKirikkalep();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==0)&(jlNerden.getSelectedIndex()==2)&parapuan>=ilpuan.nevsehirIstanbulp()){
            parapuan=parapuan-ilpuan.nevsehirIstanbulp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==1)&(jlNerden.getSelectedIndex()==2)&parapuan>=ilpuan.nevsehirAnkarap()){
            parapuan=parapuan-ilpuan.nevsehirAnkarap();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==3)&(jlNerden.getSelectedIndex()==2)&parapuan>=ilpuan.nevsehirKirikkalep()){
            parapuan=parapuan-ilpuan.nevsehirKirikkalep();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==0)&(jlNerden.getSelectedIndex()==3)&parapuan>=ilpuan.kirikkaleIstanbulp()){
            parapuan=parapuan-ilpuan.kirikkaleIstanbulp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==1)&(jlNerden.getSelectedIndex()==3)&parapuan>=ilpuan.kirikkaleAnkarap()){
            parapuan=parapuan-ilpuan.kirikkaleAnkarap();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else if ((jlNereye.getSelectedIndex()==2)&(jlNerden.getSelectedIndex()==3)&parapuan>=ilpuan.kirikkaleNevsehirp()){
            parapuan=parapuan-ilpuan.kirikkaleNevsehirp();
            praPuan.setText(""+parapuan);
            JOptionPane.showMessageDialog(null, "Tebrikler parapuanla biletiniz aldınız !");
        }
        else {
            JOptionPane.showMessageDialog(null, "Para puanınız yetersiz");
        }
      
  }
   
 
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneller = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jlNerden = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jlNereye = new javax.swing.JList<>();
        txNereye = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblOk = new javax.swing.JLabel();
        btnFiyatAl = new javax.swing.JButton();
        tfFiyat = new javax.swing.JLabel();
        btnBiletAl = new javax.swing.JButton();
        btnFatura = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSaat = new javax.swing.JList<>();
        lblOk1 = new javax.swing.JLabel();
        txNereye1 = new javax.swing.JLabel();
        btnParaPuan = new javax.swing.JButton();
        jp2 = new javax.swing.JPanel();
        bkyText = new javax.swing.JTextField();
        bky = new javax.swing.JLabel();
        krtI = new javax.swing.JLabel();
        praPuan = new javax.swing.JTextField();
        bky2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstGecmis = new javax.swing.JList<>();
        btnBkyYukle = new javax.swing.JButton();
        bkyYukle = new javax.swing.JTextField();
        bky4 = new javax.swing.JLabel();
        cbSecenek = new javax.swing.JComboBox<>();
        tfKNo = new javax.swing.JTextField();
        tfAd = new javax.swing.JTextField();
        cmbTarih = new javax.swing.JComboBox<>();
        lblCvc = new javax.swing.JLabel();
        tfCvc = new javax.swing.JTextField();
        krtN = new javax.swing.JLabel();
        bky5 = new javax.swing.JLabel();
        menuler = new javax.swing.JMenuBar();
        hesabimMenu = new javax.swing.JMenu();
        seferlerMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jp1.setBackground(new java.awt.Color(102, 255, 102));

        jlNerden.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jlNerden.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ISTANBUL", "ANKARA ", "NEVSEHIR ", "KIRIKKALE ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jlNerden);

        jlNereye.setFont(new java.awt.Font("Tw Cen MT Condensed", 0, 18)); // NOI18N
        jlNereye.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "ISTANBUL", "ANKARA ", "NEVSEHIR ", "KIRIKKALE ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jlNereye);

        txNereye.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        txNereye.setText("SAAT");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel2.setText("NEREDEN");

        lblOk.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblOk.setText("→");

        btnFiyatAl.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        btnFiyatAl.setText("FIYAT AL");
        btnFiyatAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiyatAlActionPerformed(evt);
            }
        });

        tfFiyat.setFont(new java.awt.Font("Oswald", 0, 18)); // NOI18N

        btnBiletAl.setFont(new java.awt.Font("Tw Cen MT", 0, 24)); // NOI18N
        btnBiletAl.setText("BILET AL");
        btnBiletAl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiletAlActionPerformed(evt);
            }
        });

        btnFatura.setText("Fatura Görüntüle");
        btnFatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturaActionPerformed(evt);
            }
        });

        lstSaat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lstSaat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "10.35", "14:15", "18:35", "22:45", " ", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(lstSaat);

        lblOk1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblOk1.setText("→");

        txNereye1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        txNereye1.setText("NEREYE");

        btnParaPuan.setText("Para Puanla Bilet Al");
        btnParaPuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaPuanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp1Layout = new javax.swing.GroupLayout(jp1);
        jp1.setLayout(jp1Layout);
        jp1Layout.setHorizontalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addGap(0, 727, Short.MAX_VALUE)
                .addComponent(btnFatura)
                .addGap(117, 117, 117))
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txNereye1)
                .addGap(214, 214, 214)
                .addComponent(txNereye)
                .addGap(235, 235, 235))
            .addGroup(jp1Layout.createSequentialGroup()
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(422, 422, 422)
                        .addComponent(btnFiyatAl))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(lblOk1))
                            .addComponent(btnParaPuan))
                        .addGap(33, 33, 33)
                        .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBiletAl, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jp1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblOk)
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
        );
        jp1Layout.setVerticalGroup(
            jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(txNereye1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(txNereye)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(lblOk, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addComponent(lblOk1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(18, 18, 18)
                .addComponent(btnFiyatAl)
                .addGroup(jp1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBiletAl, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnFatura)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                        .addComponent(btnParaPuan)
                        .addGap(22, 22, 22))))
        );

        jp2.setBackground(new java.awt.Color(0, 51, 51));

        bkyText.setEditable(false);
        bkyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkyTextActionPerformed(evt);
            }
        });

        bky.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        bky.setForeground(new java.awt.Color(255, 255, 255));
        bky.setText("Para Puanım:");

        krtI.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        krtI.setForeground(new java.awt.Color(255, 255, 255));
        krtI.setText("Kart isim:");

        praPuan.setEditable(false);

        bky2.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        bky2.setForeground(new java.awt.Color(255, 255, 255));
        bky2.setText("GEÇMIS YOLCULUKLARIM");

        jScrollPane1.setViewportView(lstGecmis);

        btnBkyYukle.setText("Bakiye Yükle");
        btnBkyYukle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBkyYukleActionPerformed(evt);
            }
        });

        bky4.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        bky4.setForeground(new java.awt.Color(255, 255, 255));
        bky4.setText("Yüklenecek miktarı giriniz:");

        cbSecenek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ödeme Yöntemi", "Kredi Kartı" }));
        cbSecenek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSecenekActionPerformed(evt);
            }
        });

        cmbTarih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01/2022", "02/2022", "03/2022", "04/2022", "05/2022", "06/2022", "07/2022", "08/2022", "09/2022", "10/2022", "11/2022", "12/2022", "01/2023", "02/2023" }));

        lblCvc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCvc.setForeground(new java.awt.Color(255, 255, 255));
        lblCvc.setText("CVC:");

        tfCvc.setEditable(false);
        tfCvc.setBackground(new java.awt.Color(255, 255, 255));

        krtN.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        krtN.setForeground(new java.awt.Color(255, 255, 255));
        krtN.setText("Kart numarası:");

        bky5.setFont(new java.awt.Font("Tw Cen MT", 0, 18)); // NOI18N
        bky5.setForeground(new java.awt.Color(255, 255, 255));
        bky5.setText("Bakiyem:");

        javax.swing.GroupLayout jp2Layout = new javax.swing.GroupLayout(jp2);
        jp2.setLayout(jp2Layout);
        jp2Layout.setHorizontalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bky4)
                    .addComponent(bky5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addComponent(bkyText, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(krtI)
                        .addGap(18, 18, 18))
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addComponent(bkyYukle, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(krtN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfAd, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfKNo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                            .addComponent(cmbTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblCvc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfCvc, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(178, 178, 178))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bky2)
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jp2Layout.createSequentialGroup()
                                .addComponent(bky)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jp2Layout.createSequentialGroup()
                                .addComponent(cbSecenek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)))
                        .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(praPuan, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBkyYukle, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(388, 388, 388))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(326, 326, 326))
        );
        jp2Layout.setVerticalGroup(
            jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bkyText)
                    .addComponent(tfAd)
                    .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(krtI)
                        .addComponent(bky5)))
                .addGap(18, 18, 18)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bky4)
                    .addComponent(bkyYukle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfKNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(krtN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCvc)
                    .addComponent(cmbTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2Layout.createSequentialGroup()
                        .addComponent(btnBkyYukle, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addGroup(jp2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bky)
                            .addComponent(praPuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(bky2))
                    .addComponent(cbSecenek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout panellerLayout = new javax.swing.GroupLayout(paneller);
        paneller.setLayout(panellerLayout);
        panellerLayout.setHorizontalGroup(
            panellerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panellerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panellerLayout.setVerticalGroup(
            panellerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panellerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hesabimMenu.setText("Hesabım ");
        hesabimMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        hesabimMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hesabimMenuMouseClicked(evt);
            }
        });
        menuler.add(hesabimMenu);

        seferlerMenu.setText("Seferleri Göster");
        seferlerMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        seferlerMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seferlerMenuMouseClicked(evt);
            }
        });
        menuler.add(seferlerMenu);

        setJMenuBar(menuler);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paneller, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bkyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkyTextActionPerformed
        
    }//GEN-LAST:event_bkyTextActionPerformed

    private void btnFiyatAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiyatAlActionPerformed
        FiyatGoster();
        vakitler vkt = new vakitler();
        vkt.tumZamanlar();
        
    }//GEN-LAST:event_btnFiyatAlActionPerformed

    private void hesabimMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hesabimMenuMouseClicked
       jp2.setVisible(true);
       jp1.setVisible(false);
       bkyText.setVisible(true);
       praPuan.setVisible(true);
       
       
    }//GEN-LAST:event_hesabimMenuMouseClicked

    private void seferlerMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seferlerMenuMouseClicked
       jp2.setVisible(false);
       jp1.setVisible(true);
       bkyText.setVisible(false);
       praPuan.setVisible(false);
       
    }//GEN-LAST:event_seferlerMenuMouseClicked

    private void btnBiletAlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiletAlActionPerformed
       secim();
       if(bakiye>0){
       model.addElement(tfFiyat.getText());
       }
       
    }//GEN-LAST:event_btnBiletAlActionPerformed

    private void btnFaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturaActionPerformed
        dosyaOlustur();
        dosyaOku();
        faturaOlustur(tfFiyat.getText());
        JOptionPane.showMessageDialog(null, "Faturanız D diskinize kaydedilmiştir ! ");
       
    }//GEN-LAST:event_btnFaturaActionPerformed

    private void btnBkyYukleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBkyYukleActionPerformed
        bakiyeYukle();
    }//GEN-LAST:event_btnBkyYukleActionPerformed

    private void btnParaPuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaPuanActionPerformed
        if(parapuan>0){
       model.addElement(tfFiyat.getText());
       }
        puandanHarca();
        
    }//GEN-LAST:event_btnParaPuanActionPerformed

    private void cbSecenekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSecenekActionPerformed
        switch (cbSecenek.getSelectedIndex()) {
            case 0 -> { 
                krtI.setVisible(false);
                krtN.setVisible(false);
                tfAd.setVisible(false);
                tfCvc.setVisible(false);
                tfKNo.setVisible(false);
                cmbTarih.setVisible(false);
                lblCvc.setVisible(false);
               
            }
            case 1 -> {
                krtI.setVisible(true);
                krtN.setVisible(true);
                tfAd.setVisible(true);
                tfCvc.setVisible(true);
                tfKNo.setVisible(true);
                cmbTarih.setVisible(true);
                lblCvc.setVisible(true);
            }
            default -> {
                    krtI.setVisible(false);
                    krtN.setVisible(false);
                    tfAd.setVisible(false);
                    tfCvc.setVisible(false);
                    tfKNo.setVisible(false);
                    cmbTarih.setVisible(false);
                    lblCvc.setVisible(false);
            }
        }
    }//GEN-LAST:event_cbSecenekActionPerformed

    public static void main(String args[]) {
       
  
        java.awt.EventQueue.invokeLater(() -> {
            new biletAl().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bky;
    private javax.swing.JLabel bky2;
    private javax.swing.JLabel bky4;
    private javax.swing.JLabel bky5;
    private javax.swing.JTextField bkyText;
    private javax.swing.JTextField bkyYukle;
    private javax.swing.JButton btnBiletAl;
    private javax.swing.JButton btnBkyYukle;
    private javax.swing.JButton btnFatura;
    private javax.swing.JButton btnFiyatAl;
    private javax.swing.JButton btnParaPuan;
    private javax.swing.JComboBox<String> cbSecenek;
    private javax.swing.JComboBox<String> cmbTarih;
    private javax.swing.JMenu hesabimMenu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<String> jlNerden;
    private javax.swing.JList<String> jlNereye;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JLabel krtI;
    private javax.swing.JLabel krtN;
    private javax.swing.JLabel lblCvc;
    private javax.swing.JLabel lblOk;
    private javax.swing.JLabel lblOk1;
    private javax.swing.JList<String> lstGecmis;
    private javax.swing.JList<String> lstSaat;
    private javax.swing.JMenuBar menuler;
    private javax.swing.JPanel paneller;
    private javax.swing.JTextField praPuan;
    private javax.swing.JMenu seferlerMenu;
    private javax.swing.JTextField tfAd;
    private javax.swing.JTextField tfCvc;
    private javax.swing.JLabel tfFiyat;
    private javax.swing.JTextField tfKNo;
    private javax.swing.JLabel txNereye;
    private javax.swing.JLabel txNereye1;
    // End of variables declaration//GEN-END:variables
    }
