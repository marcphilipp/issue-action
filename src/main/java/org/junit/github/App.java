package org.junit.github;

import org.kohsuke.github.GitHub;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Env vars:");
        System.getenv().keySet().forEach(System.out::println);

        var token = System.getenv("GITHUB_TOKEN");
        if (token == null) {
            throw new IllegalArgumentException("GITHUB_TOKEN is not set");
        }

        GitHub github = GitHub.connectUsingOAuth(token);
        var repo = github.getRepository(System.getenv("GITHUB_REPOSITORY"));
        System.out.println("description = " + repo.getDescription());
        var openIssueCount = repo.getOpenIssueCount();
        System.out.println("openIssueCount = " + openIssueCount);
        System.out.println();

        System.out.println("Labels:");
        repo.listLabels().forEach(System.out::println);
    }
}
