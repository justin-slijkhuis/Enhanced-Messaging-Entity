package eme.worker;

import lombok.Data;

@Data
public class WorkerSettingsModuleLine {
    
    private String name;

    private String[] disabled = {};
}
