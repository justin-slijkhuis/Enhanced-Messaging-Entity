package eme.api.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import eme.api.data.StartWorkerDTO;
import eme.api.data.WorkerIdDTO;
import eme.api.json.Discord2FAInput;
import eme.api.json.Discord2FAResponse;
import eme.api.json.DiscordLoginResponse;
import eme.utils.Request;
import eme.utils.Urls;
import eme.worker.WorkerManager;
import eme.worker.WorkerSettings;

@Service
public class WorkerService {
    
    public String start(StartWorkerDTO startWorkerDTO) {
        DiscordLoginResponse response = Request.sendPostRequest(Urls.getLoginUrl(), startWorkerDTO, DiscordLoginResponse.class);

        return handleStartResponse(response, startWorkerDTO.getSettings());
    }

    public String start(StartWorkerDTO startWorkerDTO, String twoFactorAuth) {
        Discord2FAResponse twoFactorResponse = Request.sendPostRequest(Urls.getLoginUrl(), startWorkerDTO, Discord2FAResponse.class);
        Discord2FAInput twoFactorInput = new Discord2FAInput(twoFactorAuth, twoFactorResponse.getTicket());
        DiscordLoginResponse response = Request.sendPostRequest(Urls.get2FAUrl(), twoFactorInput, DiscordLoginResponse.class);

        return handleStartResponse(response, startWorkerDTO.getSettings());
    }

    public String stop(WorkerIdDTO stopWorkerDTO) {
        WorkerManager.stopWorker(stopWorkerDTO.getId());

        return "Worker has stopped";
    }

    public String status(WorkerIdDTO statusWorkerDTO) {
        boolean status = WorkerManager.getWorkerStatus(statusWorkerDTO.getId());

        if (!status) {
            return "Worker is not running";
        }

        return "Worker is running";
    }

    private String handleStartResponse(DiscordLoginResponse response, WorkerSettings settings) {
        String token = response.getToken();

        String uuid = UUID.randomUUID().toString();

        WorkerManager.startWorker(token, uuid, settings);

        return "Worker has started with id: " + uuid;
    }
}
