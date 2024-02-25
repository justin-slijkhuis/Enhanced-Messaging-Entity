package eme.worker;

import lombok.Data;

@Data
public class WorkerSettingsMessageLine {
    
    private String input;

    private String response;

    private boolean self = false;

    private boolean caseSensitive = false;

    private boolean guild = false;
}
