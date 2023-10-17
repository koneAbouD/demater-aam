package africa.box.dm.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Service
public class ScheduledTasks {

    @Autowired
    ExternalEndPointService externalEndPointService;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public void scheduleTaskForUpdateDossier() {}

    public void scheduleTaskForSendMail() {

    }

//    @Scheduled(fixedRate = 1800000) // 1800000= 30min
    public void scheduleTaskTest() {
        System.out.println("+++++++++++++++ START TASK ++++++++++++++++");
        JSONObject params = new JSONObject();
        params.put("date",null);
        String response = externalEndPointService.saveExternalCompteInitiate(params,true);
        System.out.println("+++++++++++++++ END TASK ++++++++++++++++");
    }

    public void scheduleTaskWithFixedDelay() {}

    public void scheduleTaskWithInitialDelay() {}

    public void scheduleTaskWithCronExpression() {}

}
