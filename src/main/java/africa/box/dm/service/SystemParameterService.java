package africa.box.dm.service;

import africa.box.dm.db.CreditCardParameterDao;
import africa.box.dm.db.entities.CreditCardParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SystemParameterService {

    @Autowired
    private CreditCardParameterDao creditCardParameterDao;


    public Long addCreditCard(CreditCardParameter dto) {
        if (dto.getId() != null)
            throw new RuntimeException("Not Allowed");
        creditCardParameterDao.findOneByName(dto.getName())
                .ifPresent(data->{throw new RuntimeException("Cette carte Existe dejà");});
        CreditCardParameter dataSaved = creditCardParameterDao.save(dto);
        return dataSaved.getId();
    }


    public Optional<CreditCardParameter> update(CreditCardParameter dto) {
        creditCardParameterDao.findOneByName(dto.getName())
                .ifPresent(cardParameter -> {
                    if (cardParameter.getId() != dto.getId())
                        throw new RuntimeException("Cette acrte Existe dejà");
                });

        return Optional.of(creditCardParameterDao.findById(dto.getId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(cardParameter->{
                    cardParameter.setAmount(dto.getAmount());
                    cardParameter.setFeatures(dto.getFeatures());
                    cardParameter.setPossibleInsurance(dto.getPossibleInsurance());
                    cardParameter.setName(dto.getName());
                    creditCardParameterDao.save(cardParameter);
                    return cardParameter;
                });
    }

    public void delete(Long id) {
         Optional<CreditCardParameter> mayBe = creditCardParameterDao.findById(id);

         if (mayBe.isPresent())
             creditCardParameterDao.delete(mayBe.get());
    }

    public List<CreditCardParameter> findAll() {

        return creditCardParameterDao.findAll();
    }
}
