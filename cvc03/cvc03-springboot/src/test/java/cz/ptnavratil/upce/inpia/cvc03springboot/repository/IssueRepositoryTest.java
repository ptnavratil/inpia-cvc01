package cz.ptnavratil.upce.inpia.cvc03springboot.repository;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IssueRepositoryTest {

    @Autowired
    IssueRepository issueRepository;

    @Test
    @Transactional
    public void testSave(){
        IssueReport report = new IssueReport();
        report.setDescription("test");
        report.setUrl("url");
        issueRepository.save(report);

        Long id = report.getId();
        assertNotNull(id);

        Optional<IssueReport> fromDb = issueRepository.findById(id);
        assertEquals(fromDb.get().getDescription(),"test");

    }

}