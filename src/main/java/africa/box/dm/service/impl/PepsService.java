package africa.box.dm.service.impl;

import africa.box.dm.consumer.peps.DataSpikeConsumer;
import africa.box.dm.db.ApplicantPepsDao;
import africa.box.dm.db.entities.ApplicantPeps;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Transactional
@Service
public class PepsService {
    private DataSpikeConsumer dataSpikeConsumer;
    private ApplicantPepsDao applicantPepsDao;

    public PepsService(DataSpikeConsumer dataSpikeConsumer,
                       ApplicantPepsDao applicantPepsDao){
        this.dataSpikeConsumer = dataSpikeConsumer;
        this.applicantPepsDao = applicantPepsDao;
    }

    public Map<String, Object> processVerfication(String businessKey, String name, LocalDate birthDay, String country){
        Map<String, Object> result = dataSpikeConsumer.searchPerson(name,birthDay,country);
        ApplicantPeps applicantPeps = null;
        Optional<ApplicantPeps> optionalApplicantPeps = applicantPepsDao.findFirstByBusinessKey(businessKey);
        if(optionalApplicantPeps.isPresent()){
            applicantPeps = optionalApplicantPeps.get();
        }else {
            applicantPeps = new ApplicantPeps();
            applicantPeps.setBusinessKey(businessKey);
        }
        applicantPeps.setFullName(name);
        applicantPeps.setDateOfBirth(birthDay);
        applicantPeps.setIsoCountrieCode(country);
        applicantPeps.setLastUpdatedDate(Instant.now());
        applicantPeps.setResult(result);
        applicantPepsDao.save(applicantPeps);

        return result;
    }

    public Map<String, Object> processVerficationSandBox(String businessKey, String name, LocalDate birthDay, String country){
        Map<String, Object> result = dataSpikeConsumer.searchPersonInSanbox(name,birthDay,country);

        ApplicantPeps applicantPeps = null;
        Optional<ApplicantPeps> optionalApplicantPeps = applicantPepsDao.findFirstByBusinessKey(businessKey);
        if(optionalApplicantPeps.isPresent()){
            applicantPeps = optionalApplicantPeps.get();
            applicantPeps.setLastUpdatedDate(Instant.now());
        }else {
            applicantPeps = new ApplicantPeps();
            applicantPeps.setBusinessKey(businessKey);
        }

        applicantPeps.setFullName(name);
        applicantPeps.setDateOfBirth(birthDay);
        applicantPeps.setIsoCountrieCode(country);
        applicantPeps.setResult(result);
        applicantPepsDao.save(applicantPeps);

        return result;
    }

    public Optional<Map<String, Object>> getVerificationResult(String businessKey){
        return Optional.of(applicantPepsDao.findFirstByBusinessKey(businessKey))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(applicantPeps -> { return applicantPeps.getResult();});
    }
}
