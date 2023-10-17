package africa.box.dm.controllers;
import africa.box.dm.db.entities.LogInfo;
import africa.box.dm.dto.StatusDto;
import africa.box.dm.dto.User;
import africa.box.dm.service.DmInitiationServices;
import africa.box.dm.service.LogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/userloginfo")
@CrossOrigin(value = "*", origins = "*")
public class LogInfoControlleur {
    @Autowired
    private LogInfoService logInfoService;

    @GetMapping("/notification")
    @ResponseBody
    public List<LogInfo> getNotification(){
        DmInitiationServices services = new DmInitiationServices();
        User user = services.getUser();
       return logInfoService.getNotificationOfUser(user.getEmail());
    }

    @GetMapping("/log")
    @ResponseBody
    public List<LogInfo> getLog(){
        DmInitiationServices services = new DmInitiationServices();
        User user = services.getUser();
        return logInfoService.getLogOfUser(user.getEmail());
    }

    @GetMapping("/log/{businessKey}")
    @ResponseBody
    public List<LogInfo> getLogOfDossier(@PathVariable("businessKey") String businessKey){
        return logInfoService.getLogOfDossier(businessKey);
    }

    @DeleteMapping("/notification")
    @ResponseBody
    public StatusDto deleteNotification(@RequestBody LogInfo logInfo){
        logInfoService.deleteNotification(logInfo);
        return StatusDto.ofSuccess("Opération de suppression reussie");
    }

    @PostMapping("/notification")
    @ResponseBody
    public StatusDto readNotification(@RequestBody LogInfo logInfo){
        logInfoService.readNotification(logInfo);
        return StatusDto.ofSuccess("Opération reussie");
    }
}
