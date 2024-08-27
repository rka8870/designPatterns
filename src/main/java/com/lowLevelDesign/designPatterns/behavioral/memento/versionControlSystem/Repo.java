package com.lowLevelDesign.designPatterns.behavioral.memento.versionControlSystem;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Repo {
    private String commitMessage;
    private String commitId;
    private String file;
}
