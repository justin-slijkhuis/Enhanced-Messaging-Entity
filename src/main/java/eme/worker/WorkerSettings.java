package eme.worker;

import eme.worker.WorkerSettings;
import lombok.Data;

@Data
public class WorkerSettings {
    
    private int typingDelay = 500;

    private String commandStart = "!";

    private WorkerSettingsMessageLine[] messages = null;

    private WorkerSettingsModuleLine[] modules = null;
}
