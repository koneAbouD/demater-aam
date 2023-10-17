package africa.box.dm.config;

import com.google.gson.Gson;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app.configuration")
public class MyAppConfig {
    private String rabbitMqExchange;
    private String selfProcessKey;

    private String uploadProvider;
    private String uploadBasePath;
    private String defaultUploadExtension;
    private String hostUrOfDmInitiate;
    private String docCodeUrl;
    private String startProcessOnFileCreation;
    private String roleWhoCanUpdateDmFile;
    private String selfProcessQueue;
    private String selfProcessQueueRoutingKey;
    private String historyQueue;
    private String historQueueRoutingKeys;
    private String hostUrOfVerifyCredit;
    public static final String mailSys="dmserver@box.africa";
    public static final String agence="Riviera 3";


    public String getHostUrOfVerifyCredit() {
        return hostUrOfVerifyCredit;
    }

    public void setHostUrOfVerifyCredit(String hostUrOfVerifyCredit) {
        this.hostUrOfVerifyCredit = hostUrOfVerifyCredit;
    }

    public String getDocCodeUrl() {
        return docCodeUrl;
    }

    public void setDocCodeUrl(String docCodeUrl) {
        this.docCodeUrl = docCodeUrl;
    }

    public String getStartProcessOnFileCreation() {
        return startProcessOnFileCreation;
    }

    public void setStartProcessOnFileCreation(String startProcessOnFileCreation) {
        this.startProcessOnFileCreation = startProcessOnFileCreation;
    }

    public String getRoleWhoCanUpdateDmFile() {
        return roleWhoCanUpdateDmFile;
    }

    public void setRoleWhoCanUpdateDmFile(String roleWhoCanUpdateDmFile) {
        this.roleWhoCanUpdateDmFile = roleWhoCanUpdateDmFile;
    }

    public String getSelfProcessQueue() {
        return selfProcessQueue;
    }

    public void setSelfProcessQueue(String selfProcessQueue) {
        this.selfProcessQueue = selfProcessQueue;
    }

    public String getSelfProcessQueueRoutingKey() {
        return selfProcessQueueRoutingKey;
    }

    public void setSelfProcessQueueRoutingKey(String selfProcessQueueRoutingKey) {
        this.selfProcessQueueRoutingKey = selfProcessQueueRoutingKey;
    }

    public String getHistoryQueue() {
        return historyQueue;
    }

    public void setHistoryQueue(String historyQueue) {
        this.historyQueue = historyQueue;
    }

    public String getHistorQueueRoutingKeys() {
        return historQueueRoutingKeys;
    }

    public void setHistorQueueRoutingKeys(String historQueueRoutingKeys) {
        this.historQueueRoutingKeys = historQueueRoutingKeys;
    }

    public String getSelfProcessKey() {
        return selfProcessKey;
    }

    public void setSelfProcessKey(String selfProcessKey) {
        this.selfProcessKey = selfProcessKey;
    }

    public String getRabbitMqExchange() {
        return rabbitMqExchange;
    }

    public void setRabbitMqExchange(String rabbitMqExchange) {
        this.rabbitMqExchange = rabbitMqExchange;
    }

    public String getUploadProvider() {
        return uploadProvider;
    }

    public void setUploadProvider(String uploadProvider) {
        this.uploadProvider = uploadProvider;
    }

    public String getUploadBasePath() {
        return uploadBasePath;
    }

    public void setUploadBasePath(String uploadBasePath) {
        this.uploadBasePath = uploadBasePath;
    }

    public String getDefaultUploadExtension() {
        return defaultUploadExtension;
    }

    public void setDefaultUploadExtension(String defaultUploadExtension) {
        this.defaultUploadExtension = defaultUploadExtension;
    }

    public String getHostUrOfDmInitiate() {
        return hostUrOfDmInitiate;
    }

    public void setHostUrOfDmInitiate(String hostUrOfDmInitiate) {
        this.hostUrOfDmInitiate = hostUrOfDmInitiate;
    }


    @Bean
    public HttpClient httpClientFactory(){
        return HttpClients.createDefault();
    }

    @Bean
    public Gson gsonFactory(){
        return new Gson();
    }
}
