package isrijan.hackathon.jiraApi.issue;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;




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
	public void addIssue(@RequestBody Object object) {
		System.out.println("Request triggered");
		try {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		com.squareup.okhttp.RequestBody body = com.squareup.okhttp.RequestBody.create(mediaType, "{\n  \"accountId\": \"5d846b7d01e2cb0c3020019a\"\n}");
		Request request = new Request.Builder()
		  .url("https://jirawithdocumentation.atlassian.net/rest/api/3/issue/DB-3/assignee")
		  .put(body)
		  .addHeader("Content-Type", "application/json")
		  .addHeader("Authorization", "Basic ZGhhcmFzbWlsZTE1QGdtYWlsLmNvbTpaZ2c2eFNncG9iTE82MXdycUt5RUJEOUY=")
		  .addHeader("Cache-Control", "no-cache")
		  .addHeader("Postman-Token", "2aebdd48-c4d6-4d13-8fbe-4ef12146cb99")
		  .build();
			System.out.println("Request prepared"+request.toString());
		
		   Response response = client.newCall(request).execute();
		} catch (IOException e) {
			System.out.println("exceptionL::::");
			e.printStackTrace();
			
		}
	}
}