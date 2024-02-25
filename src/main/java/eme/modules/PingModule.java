package eme.modules;

import eme.worker.Worker;
import eme.worker.WorkerModule;

public class PingModule extends WorkerModule {

    @Override
    public String getInput() {
        return "ping";
    }

    @Override
    public String getResponse(Worker worker) {
        return "Pong!";
    }
    
}
