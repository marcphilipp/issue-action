package org.junit.github;

import org.kohsuke.github.GitHub;

public class App {
    public static void main(String[] args) throws Exception {
        var token = System.getenv("GITHUB_TOKEN");
        if (token == null) {
            throw new IllegalArgumentException("GITHUB_TOKEN is not set");
        }

        GitHub github = GitHub.connectUsingOAuth(token);
        var repo = github.getRepository(System.getenv("GITHUB_REPOSITORY"));
        System.out.println("description = " + repo.getDescription());
        var openIssueCount = repo.getOpenIssueCount();
        System.out.println("openIssueCount = " + openIssueCount);
    }
}
