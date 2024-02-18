package eme.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import eme.api.data.StartWorkerDTO;
import eme.api.data.WorkerIdDTO;
import eme.api.service.WorkerService;

import org.springframework.http.HttpStatus;

import lombok.Setter;

@RestController
@Setter( onMethod_ = { @Autowired } )
public class WorkerController {

    private WorkerService workerService;

    @PostMapping("/start")
    @ResponseStatus(HttpStatus.OK)
    public String start(@RequestBody StartWorkerDTO startWorkerDTO) {
        return workerService.start(startWorkerDTO);
    }

    @PostMapping("/start/{twoFactorAuth}")
    @ResponseStatus(HttpStatus.OK)
    public String start(@RequestBody StartWorkerDTO startWorkerDTO, @PathVariable String twoFactorAuth) {
        return workerService.start(startWorkerDTO, twoFactorAuth);
    }

    @PostMapping("/stop")
    @ResponseStatus(HttpStatus.OK)
    public String stop(@RequestBody WorkerIdDTO stopWorkerDTO) {
        return workerService.stop(stopWorkerDTO);
    }
    
    @GetMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public String status(@RequestBody WorkerIdDTO statusWorkerDTO) {
        return workerService.status(statusWorkerDTO);
    }
}
