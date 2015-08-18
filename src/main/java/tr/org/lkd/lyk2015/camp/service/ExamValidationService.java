package tr.org.lkd.lyk2015.camp.service;

public interface ExamValidationService {

    public abstract boolean validate(String email, Long tckn);
}
