package cz.ptnavratil.upce.inpia.cvc03springboot.repository

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport
import cz.ptnavratil.upce.inpia.cvc03springboot.dao.User;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.Creator;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.IssueReportDataFactory;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.IssueReportRepository;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@Import([IssueReportDataFactory.class, Creator.class])
@DataJpaTest
public class IssueReportRepositoryGroovyTest {

    @Autowired Creator creator;

    @Autowired
    IssueReportDataFactory issueReportDataFactory;

    @Autowired
    IssueReportRepository issueReportRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void testSave(){
        IssueReport report = new IssueReport();
        report.setDescription("test");
        report.setUrl("url");
        issueReportRepository.save(report);

        Long id = report.getId();
        assertNotNull(id);

        Optional<IssueReport> fromDb = issueReportRepository.findById(id);
        assertEquals(fromDb.get().getDescription(),"test");

    }

    @Test
    public void test(){
        assertEquals(issueReportRepository.findAll().size(),0);
        issueReportDataFactory.saveIssueReport("dss");
        assertEquals(issueReportRepository.findAll().size(),1);
    }

    @Test
    public void testFindAllByEmail(){

        creator.save(new IssueReport(email: "e1"));
        creator.save(new IssueReport(email: "e2",
                                    user: creator.save(new User(surname: "Navratil"))
        ));
        creator.save(new IssueReport(email: "e1"));

        assertEquals(2,issueReportRepository.findAllByEmail("e1").size());
        assertEquals(1,issueReportRepository.findAllByEmail("e2").size());
    }

}