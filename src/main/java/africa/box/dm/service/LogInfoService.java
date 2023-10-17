/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package africa.box.dm.service;

import africa.box.dm.db.LogInfoDao;
import africa.box.dm.db.entities.LogInfo;
import africa.box.dm.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LogInfoService {

    @Autowired
    LogInfoDao logInfoDao;

    String LOG ="log";
    String NOTIFICATION ="notification";

    public void addLog(String text,String iddossier,String parent){
        LogInfo logInfo = new LogInfo();
        logInfo.setStatus("active");
        logInfo.setType(LOG);
        logInfo.setText(text);
        logInfo.setParent(parent);
        logInfo.setIddossier(iddossier);
        DmInitiationServices services = new DmInitiationServices();
        User user = services.getUser();
        logInfo.setFullname(user.getFullName());
        logInfo.setDestinatairemail(user.getEmail());
        logInfoDao.save(logInfo);
    }

    public void addNotificationUser(String text,String userMail,String iddossier){
        LogInfo logInfo = new LogInfo();
        logInfo.setStatus("active");
        logInfo.setType(NOTIFICATION);
        logInfo.setText(text);
        logInfo.setIddossier(iddossier);
        logInfo.setDestinatairemail(userMail);

        logInfoDao.save(logInfo);
    }

    public void deleteNotification(LogInfo logInfo){
        logInfoDao.delete(logInfo);
    }

    public void readNotification(LogInfo logInfo){
        Optional<LogInfo> logInfo1 = logInfoDao.findById(logInfo.getId());
        if (logInfo1.isPresent()){
            logInfo = logInfo1.get();
            logInfo.setStatus("read");
            logInfoDao.save(logInfo);
        }
    }

    public List<LogInfo> getNotificationOfUser(String userMail){
        List<LogInfo> expiredNotif = logInfoDao.findByTypeAndDestinatairemail(NOTIFICATION,userMail);
        List<LogInfo> delLogInfos = new ArrayList<>();

        int NB_JR_MAXI =10;

        // ++++++++++ Toutes les notifications vues de plus de NB_JR_MAXI jours seront supprimées ++++++++++
        expiredNotif.forEach(logInfo -> {
            Date currentDate = new Date();
            if (logInfo.getStatus().equals("read") &&
                    daysBetween(logInfo.getCreatedAt(),currentDate)>NB_JR_MAXI) {
                delLogInfos.add(logInfo);
            }
//            System.out.println(logInfo.getId()+" =>"+daysBetween(logInfo.getCreatedAt(),currentDate));
        });
        logInfoDao.deleteAll(delLogInfos);
        // ++++++++++ ++++++++++ ++++++++++ ++++++++++ ++++++++++ ++++++++++ ++++++++++ ++++++++++

        return logInfoDao.findByTypeAndDestinatairemail(NOTIFICATION,userMail);
    }

    public int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public List<LogInfo> getLogOfUser(String userMail){
        return logInfoDao.findByTypeAndDestinatairemail(LOG,userMail);
    }
    public List<LogInfo> getLogOfDossier(String idDossier){
        return logInfoDao.findByTypeAndIddossier(LOG,idDossier);
    }
    public List<LogInfo> getLogOfDossierByStep(String idDossier,String step){
        return logInfoDao.findByTypeAndIddossierAndText(LOG,idDossier, step);
    }


}
