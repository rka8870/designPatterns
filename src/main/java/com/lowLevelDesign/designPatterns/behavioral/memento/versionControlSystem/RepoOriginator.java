package com.lowLevelDesign.designPatterns.behavioral.memento.versionControlSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RepoOriginator {

    private Repo repo;


    public RepoMemento createMemento(){
        return new RepoMemento(this.repo);
    }

    public void restoreMemento(RepoMemento repoMemento){
        this.repo  = repoMemento.getRepo();
    }


}
