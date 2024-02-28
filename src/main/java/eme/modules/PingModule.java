package eme.modules;

import eme.worker.Worker;
import eme.worker.WorkerModule;
import eme.worker.WorkerSettingsModuleLine;

public class PingModule extends WorkerModule {

    @Override
    public String getInput(Worker worker, String sender) {
        return "ping";
    }

    @Override
    public String getResponse(Worker worker, WorkerSettingsModuleLine moduleLine) {
        return "Pong!";
    }
    
}
