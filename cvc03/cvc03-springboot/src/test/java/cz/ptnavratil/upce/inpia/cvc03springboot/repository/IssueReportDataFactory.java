package cz.ptnavratil.upce.inpia.cvc03springboot.repository;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import cz.ptnavratil.upce.inpia.cvc03springboot.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IssueReportDataFactory {

    @Autowired Creator creator;

    @Autowired
    private IssueReportRepository issueReportRepository;
    @Autowired
    private UserRepository userRepository;


    public void saveIssueReport(String email) {

        User user = (User) creator.save(new User());

        user.setFirstName("Petr");
        user.setLastName("Navratil");
        userRepository.save(user);

        IssueReport entity = new IssueReport();
        entity.setEmail(email);
        entity.setUser(user);
        issueReportRepository.save(entity);
    }

    public void saveIssueReport() {
        saveIssueReport("test@email.cz");
    }
}
