package com.lowLevelDesign.designPatterns.behavioral.memento.versionControlSystem;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class RepoCaretaker {

    ReentrantLock lock = new ReentrantLock();
    private final List<RepoMemento> history;

    public RepoCaretaker() {
        this.history = new ArrayList<>();;
    }



    public void addMemento(RepoMemento repoMemento){
        history.add(repoMemento);
    }

    public RepoMemento undo() throws Exception {
        lock.lock();
        if(!history.isEmpty()){
            int size = history.size();;
            RepoMemento last = history.get(size-1);
            history.remove(size-1);
            return last;
        }
        throw new Exception("There is not history to be reverted");
    }

}
