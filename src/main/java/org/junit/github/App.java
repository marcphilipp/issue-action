package org.junit.github;

import org.kohsuke.github.GitHub;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Args:");
        System.out.println(Arrays.toString(args));
        System.out.println();

        System.out.println("Env vars:");
        System.getenv().keySet().forEach(System.out::println);

        var token = System.getenv("INPUT_REPO-TOKEN");
        if (token == null) {
            throw new IllegalArgumentException("INPUT_REPO-TOKEN is not set");
        }

        GitHub github = GitHub.connectUsingOAuth(token);
        var repo = github.getRepository(System.getenv("GITHUB_REPOSITORY"));
        System.out.println("description = " + repo.getDescription());
        var openIssueCount = repo.getOpenIssueCount();
        System.out.println("openIssueCount = " + openIssueCount);
        System.out.println();

        System.out.println("Labels:");
        repo.listLabels().forEach(label -> System.out.printf("- %s%n", label.getName()));
    }
}
