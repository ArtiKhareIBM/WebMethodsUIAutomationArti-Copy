package githubAPIs;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

//import org.json.JSONObject;
import org.json.simple.JSONObject;
import com.webMethodsUI.flow.helper.browserConfigurations.config.ObjectReader;


import com.webMethodsUI.flow.utils.BaseRestAutomation;

public class GithubAPI extends BaseRestAutomation {
    String gitUsername = ObjectReader.reader.getGitHubUserName();
    String gitPAT = ObjectReader.reader.getGitHubPAT();
    String gitURL = ObjectReader.reader.getGitHubUrl();
	String acceptHeader = "Accept: application/vnd.github+json";
	String gitHubAPIVersionHeader = "X-GitHub-Api-Version: 2022-11-28";
    public static ConcurrentHashMap<Object, String> gitRepoName = new ConcurrentHashMap<>();


	public void createGitRepo(String repoName, String description, String homepage, boolean repoType) {
		String payload_path = String.join(File.separator, new String[] { System.getProperty("user.dir"), "src", "main",
				"resources", "InputData", "git", "createRepositoryJson.json" });
		JSONObject payloadObject = jsonFileReader(payload_path);
		payloadObject.put("name", repoName);
		payloadObject.put("description", description);
		payloadObject.put("homepage", homepage);
		payloadObject.put("private", repoType);
		setRequestURL(gitURL + "user/repos");
		setRequestHeaders(acceptHeader);
		setRequestHeaders("Authorization: Bearer " + gitPAT);
		setRequestHeaders(gitHubAPIVersionHeader);
		setRequestBody(payloadObject.toString());
		post();
		verifyResponseCode(201);
	}
}
