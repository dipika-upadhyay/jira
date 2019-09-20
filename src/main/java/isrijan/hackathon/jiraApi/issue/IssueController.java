package isrijan.hackathon.jiraApi.issue;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IssueController {
	
	@Autowired
	IssueService issueService;
	
	@RequestMapping("/issues")
	public List<Issue> getAllIssues(){
		return issueService.getAllIssues();
	}
	
	@RequestMapping("/issues/{id}")
	public Optional<Issue> getIssue(@PathVariable int id) {
		return issueService.getIssue(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/issues")
	public void addIssue(@RequestBody Issue issue) {
		issueService.addIssue(issue);
	}
}