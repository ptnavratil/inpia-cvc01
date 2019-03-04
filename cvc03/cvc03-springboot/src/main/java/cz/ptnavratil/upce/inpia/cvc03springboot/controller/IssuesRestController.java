package cz.ptnavratil.upce.inpia.cvc03springboot.controller;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    public class IssuesRestController {

        @Autowired
        IssueRepository issueRepository;

        @GetMapping("/api/issue/list")
        public List<IssueReport> issueReport() {
            return issueRepository.findAll();
        }

}
