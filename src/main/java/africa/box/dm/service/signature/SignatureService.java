package africa.box.dm.service.signature;

import africa.box.dm.config.BusinessConstants;
import africa.box.dm.config.DecisionConfig;
import africa.box.dm.db.entities.*;
import africa.box.dm.service.CompteService;
import africa.box.dm.service.MyAppException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class SignatureService {

    @Autowired(required=true)
    CompteService compteService;


    public interface JnaLibrary extends Library {


        SignatureService.JnaLibrary INSTANCE = Native.load("FP430S", SignatureService.JnaLibrary.class);
        int USB_Open();
        int USB_Close();
        int Lib_GetSignature(int encryptType,byte c[], int timeout);
    }

    static JFrame window;
    static JButton open;
    static JButton signature;
    static JButton close;
    Image myImage;
    static ImageIcon icon=new ImageIcon();
    static JButton button = new JButton();


    static void Demo() {


        window=new JFrame("签名�?");
        window.setLayout(null);
        window.setSize(1000,800);//设置大小 window.setLocationRelativeTo(null);//设置居中
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);//设置窗口不可拉伸改变大小 //设置按钮

        open=new JButton("open");
        open.setBounds(150, 50, 100, 50);
        signature=new JButton("signature");
        signature.setBounds(250, 50, 100, 50);
        close=new JButton("close");
        close.setBounds(350, 50, 100, 50);

        window.add(open);
        window.add(signature);
        window.add(close);

        open.addActionListener(new SignatureService.openListener());
        signature.addActionListener(new SignatureService.displayListener());
        close.addActionListener(new SignatureService.closeListener());

        window.setVisible(true);//设置面板可见
    }


//    public Resource loadAsResource(String businessKey, String fileId) {
//        Optional<CompteDocument> compteDocumentOptional = this.dao.findById(fileId);
//        if(!compteDocumentOptional.isPresent()){
//            throw new MyAppException("Cannot find file id.");
//        }
//        String upProvider = appConfig.getUploadProvider();
////        String upBasePath = appConfig.getUploadBasePath();
//        if(StringUtils.isEmpty(upProvider)){
//            upProvider = BusinessConstants.UPLOAD_PROVIDERS.LOCAL;
//        }
//        CompteDocument doc= compteDocumentOptional.get();
//        Date d = doc.getCreatedAt();
//
//        // Convert java.util.Date to java.time.LocalDate
//        LocalDate localDate = d.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//
//        String chemin= appConfig.getUploadBasePath() + File.separator + localDate.getYear() +
//                File.separator + localDate.getMonth()+
//                File.separator + businessKey + File.separator + doc.getDocPath();
//
//        switch(upProvider){
//            case "local":
//                return new FileSystemResource(new File(chemin));
//            default: throw new MyAppException("NO impleted yet: "+upProvider);
//        }
//    }
//
//

//    public Resource loadSignatureResource(String businessKey) {
//
//        Optional<Compte> compte = compteService.getCompte(businessKey);
//        Compte cmpt=null;
//        cmpt=compte.get();
////    File file=new File(path+"/"+filename);
//        Date d = cmpt.getSignatureDate();
//        // Convert java.util.Date to java.time.LocalDate
//        LocalDate localDate = d.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//
//        String filename="signature_client"+businessKey+".png";
//
//        String path = "C:\\DEMATER" + File.separator + localDate.getYear() +
//                File.separator + localDate.getMonth()+
//                File.separator + businessKey+ File.separator +"signature";
//
//        String chemin= path+"/"+filename;
//
//        return new FileSystemResource(new File(chemin));
//    }




    public Resource getSignatureImage(String businessKey) {
        Optional<Compte> compte = compteService.getCompte(businessKey);
        Compte cmpt=null;
        cmpt=compte.get();
//    File file=new File(path+"/"+filename);
        Date d = cmpt.getSignatureDate();
        // Convert java.util.Date to java.time.LocalDate
        LocalDate localDate = d.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        String filename="signature_client"+businessKey+".png";

        String path = "C:\\DEMATER" + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey+ File.separator +"signature";

        String chemin= path+File.separator+filename;
        System.out.println("chemin============"+chemin);
        return new FileSystemResource(new File(chemin));

    }



    public String  createSignature(String businessKey) {
        System.out.println("DEBUT BACK SIGNATURE "+businessKey);
// --------------------       avant-------------------------------
//        String writePath="C:\\DEMATER\\signature\\signatures";



        String upBasePath = "C:\\DEMATER"+ File.separator+"AppDM";
        LocalDate localDate = LocalDate.now() ;
        String path = upBasePath + File.separator + localDate.getYear() +
                File.separator + localDate.getMonth()+
                File.separator + businessKey+ File.separator;

// --------------------       avant-------------------------------
//        String writePath="C:\\DEMATER\\signature\\signatures";
        String writePath=path;
        String fileName="signature_client" + businessKey + ".png";
        String signatureUrl=writePath+fileName;

        Optional<Compte> compte = compteService.getCompte(businessKey);
        Compte cmpt=null;
        if(compte.isPresent()) {
            cmpt=compte.get();

            //------------------image----------------------

            byte c[] = new byte[2048000];
            int i = SignatureService.JnaLibrary.INSTANCE.Lib_GetSignature(0,c,60000);

            if(i==0) {
                //System.out.println("signature"+i+Arrays.toString(c));
                int a1=(int) c[0]*256*256+(int) c[1]*256+(int) c[2];
                int a2=(int) c[3]*256*256+(int) c[4]*256+(int) c[5];
                byte b[] = new byte[2048000];
                System.arraycopy(c,a1+6,b,0,a2);


                createFile(writePath,fileName);
                FileOutputStream fos;
                byte2image(b,signatureUrl);

    // +++++++++++++++++++ Sauvegarder une note ++++++++++++++++++++++++
                Notes notes = new Notes();
                notes.setBusinessKey(businessKey);
                notes.setDate(new Date());
                notes.setType(NoteTypes.INFORMATION);
                notes.setNote("contrat signé avec succès");
                notes.setSla("INPROCESS");

                cmpt.setSignatureUrl(signatureUrl);
                cmpt.setSignatureDate(new Date());
//                cmpt.setSignitureEffectue(true);
                cmpt= compteService.updateCompte(cmpt,notes);

                System.out.println("signature"+i+"---"+a1+"---"+a2);

            }


            Image image=Toolkit.getDefaultToolkit().getImage(signatureUrl);
//            new FileSystemResource(new File(signatureUrl));
            icon.setImage(image);
//            return new FileSystemResource(new File(signatureUrl));


        } else{
            throw new MyAppException("Le Compte n'existe pas");
        }

//        throw new MyAppException("Le Compte n'existe pas");
        return "signature effectué";
    }

    static class openListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = SignatureService.JnaLibrary.INSTANCE.USB_Open();

            System.out.println("open"+i);

        }
    }
    static class displayListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            new SignatureService.PrintThread().start();

            //System.out.println("signature"+i);


        }
    }
    static class closeListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {


            int i = SignatureService.JnaLibrary.INSTANCE.USB_Close();
            System.out.println("close"+i);
        }
    }



    public static void createFile(String path,String filename){

        File file=new File(path+filename);
        file.mkdirs();

        if(!file.exists())
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        else {
            try {
                file.delete();
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;//Déterminer si l'octet d'entrée est vide
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);//将byte写入硬盘
            imageOutput.close();
            System.out.println("image effectué avec succès, veuillez trouver l'image dans"+path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }

    static  class PrintThread extends Thread {
        public void run() {
            byte c[] = new byte[2048000];
            int i = SignatureService.JnaLibrary.INSTANCE.Lib_GetSignature(0,c,60000);

            if(i==0) {
                //System.out.println("signature"+i+Arrays.toString(c));
                int a1=(int) c[0]*256*256+(int) c[1]*256+(int) c[2];
                int a2=(int) c[3]*256*256+(int) c[4]*256+(int) c[5];
                byte b[] = new byte[2048000];
                System.arraycopy(c,a1+6,b,0,a2);

                String writePath="C:\\DEMATER\\signature";
                createFile(writePath,"test3.png");
                FileOutputStream fos;
                byte2image(b,writePath+"\\test3.png");


                System.out.println("signature"+i+"---"+a1+"---"+a2);

            }

            Image image=Toolkit.getDefaultToolkit().getImage("C:\\DEMATER\\signature\\test3.png");
            icon.setImage(image);

//            button.setIcon(icon);
//            button.setBounds(150, 100, 480, 217);
//            window.getContentPane().add(button);
//
//            window.setVisible(true);//设置面板可见
        }
    }


}
