package isrijan.hackathon.jiraApi.issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
	
	@Autowired
	IssueRepository issueRepository;

	public List<Issue> getAllIssues() {
		List<Issue> issues = new ArrayList<>();
		issueRepository.findAll().forEach(issues::add);
		return issues;
	}

	public Optional<Issue> getIssue(int id) {
		return issueRepository.findById(id);
	}

	public void addIssue(Issue issue) {
		issueRepository.save(issue);
		
	}

}
