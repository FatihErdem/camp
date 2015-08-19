package tr.org.lkd.lyk2015.camp.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional // Diger Mocklarda transactional olmayacak. cunku blacklist kendi db'mizde olacak.
public class MockBlackListValidationService implements BlackListValidationService {

    @Override
    public boolean validate(String name, String surname, Long tckn, String email) {

        if (tckn.equals(22222222222L)) {
            return false;
        }

        return true;
    }
}
