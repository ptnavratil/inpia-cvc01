package cz.ptnavratil.upce.inpia.cvc03springboot.controller;

import cz.ptnavratil.upce.inpia.cvc03springboot.dao.IssueReport;
import cz.ptnavratil.upce.inpia.cvc03springboot.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class IssueController {

    @Autowired
    IssueRepository issueRepository;

    @GetMapping("/issuereport")
    public String issueReport(Model model) {
        model.addAttribute("issueReport",new IssueReport());
        return "issues/issuereport_form";

    }

    @PostMapping("/issuereport")
    public String issueReportSubmit(IssueReport issueReport){

        System.out.println("Submited: IssueReport{description: " + issueReport.getDescription() + ", url: "  + issueReport.getUrl() +"}");
        issueRepository.save(issueReport);
        return "issues/issuereport_form";
    }

    @GetMapping("/issues")
    public String getIssues(Model model) {

        List<IssueReport> listOfIssueReports = issueRepository.findAll();
        System.out.println("pocet dat v DB:" + listOfIssueReports.size());


        //ModelAndView mv = new ModelAndView("issues/issuereport_list","listOfIssueReports",listOfIssueReports);
        model.addAttribute("listOfIssueReports",listOfIssueReports);
        return "issues/issuereport_list";
    }

}
