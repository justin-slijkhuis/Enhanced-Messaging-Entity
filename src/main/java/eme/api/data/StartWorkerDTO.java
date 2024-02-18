package eme.api.data;

import eme.worker.WorkerSettings;
import lombok.Data;

@Data
public class StartWorkerDTO {
    
    private String login;

    private String password;

    private WorkerSettings settings;
}
