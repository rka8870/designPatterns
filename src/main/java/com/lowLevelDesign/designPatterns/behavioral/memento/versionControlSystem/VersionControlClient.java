package com.lowLevelDesign.designPatterns.behavioral.memento.versionControlSystem;

public class VersionControlClient {

    public static void main(String[] args) throws Exception {
        Repo commit1 = Repo.builder().commitId("123").commitMessage("Initial Commit").file("Start of the project").build();
        Repo commit2 = Repo.builder().commitId("124").commitMessage("Added new functionality").file("Caretaker Logic").build();
        Repo commit3 = Repo.builder().commitId("125").commitMessage("Final Commit").file("Memento Pattern Test Cases").build();
        RepoOriginator originator = new RepoOriginator(commit1);
        System.out.println(originator.getRepo());
        RepoMemento snapShot1 = originator.createMemento();
        RepoCaretaker caretaker = new RepoCaretaker();
        caretaker.addMemento(snapShot1);
        originator.setRepo(commit2);
        RepoMemento snapShot2 = originator.createMemento();
        caretaker.addMemento(snapShot2);
        System.out.println(originator.getRepo());
        originator.setRepo(commit3);
        System.out.println(originator.getRepo());
        RepoMemento revertedCommit = caretaker.undo();
        originator.restoreMemento(revertedCommit);
        System.out.println(originator.getRepo());
    }

}
