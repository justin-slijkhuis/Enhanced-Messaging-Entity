package eme.worker;

import java.util.ArrayList;
import java.util.List;

public class WorkerManager {

    private WorkerManager() {}

    private static final List<Worker> workers = new ArrayList<>();
        
    public static void startWorker(String token, String uuid, WorkerSettings settings) {
        Worker worker = new Worker(token, uuid, settings);
        worker.start();
        workers.add(worker);
    }

    public static void stopWorker(String uuid) {
        Worker worker = workers.stream().filter(w -> w.getUuid().equals(uuid)).findFirst().orElse(null);
        
        if (worker != null) {
            worker.stop();
            workers.remove(worker);
        }
    }

    public static boolean getWorkerStatus(String uuid) {
        Worker worker = workers.stream().filter(w -> w.getUuid().equals(uuid)).findFirst().orElse(null);
        
        if (worker != null) {
            return worker.getWebSocket().isOpen();
        }
        
        return false;
    }
}
