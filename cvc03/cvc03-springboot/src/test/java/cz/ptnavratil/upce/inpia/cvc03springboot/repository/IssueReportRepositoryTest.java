package cz.ptnavratil.upce.inpia.cvc03springboot.repository;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import cz.ptnavratil.upce.inpia.cvc03springboot.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Import({IssueReportDataFactory.class,Creator.class})
@DataJpaTest
public class IssueReportRepositoryTest {

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

        IssueReport entity = new IssueReport();
        entity.setEmail("e1");
        creator.save(entity);

        issueReportDataFactory.saveIssueReport("e2");
        issueReportDataFactory.saveIssueReport("e1");

        assertEquals(2,issueReportRepository.findAllByEmail("e1").size());
        //assertEquals(1,issueReportRepository.findAllByEmail("e2").size());
    }

}