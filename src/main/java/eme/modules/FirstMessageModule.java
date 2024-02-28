package eme.modules;

import java.util.Arrays;

import eme.worker.Worker;
import eme.worker.WorkerData;
import eme.worker.WorkerModule;
import eme.worker.WorkerSettingsModuleLine;

public class FirstMessageModule extends WorkerModule {

    @Override
    public String getInput(Worker worker, String sender) {
        WorkerData workerData = worker.getWorkerDataService().readFile();

        boolean senderIsInFirstMessages = Arrays.asList(workerData.getFirstMessages()).contains(sender);

        if (!senderIsInFirstMessages) {
            workerData.addFirstMessage(sender);
            worker.getWorkerDataService().writeFile(workerData);

            return "FORCE";
        }

        return null;
    }

    @Override
    public String getResponse(Worker worker, WorkerSettingsModuleLine moduleLine) {
        return moduleLine.getOutput() != null ? moduleLine.getOutput() : "This is your first message since EME was activated on this account!";
    }
    
}
