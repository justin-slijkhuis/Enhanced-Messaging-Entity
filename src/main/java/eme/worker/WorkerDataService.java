package eme.worker;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class WorkerDataService {
    
    private final Worker worker;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    private static final String DATA_PATH = "src/main/java/eme/data/";
    private static final String DATA_EXTENSION = ".json";

    public boolean validateFile() {
        File file = new File(DATA_PATH + worker.getDiscordId() + DATA_EXTENSION);
        WorkerData workerData = new WorkerData();

        if (!file.exists()) {
            try {
                OBJECT_MAPPER.writeValue(file, workerData);
                return file.createNewFile();
            } catch (Exception e) {
                log.severe("Failed to create data file for id: " + worker.getDiscordId());
            }
        }

        return true;
    }

    public WorkerData readFile() {
        File file = new File(DATA_PATH + worker.getDiscordId() + DATA_EXTENSION);

        try {
            return OBJECT_MAPPER.readValue(file, WorkerData.class);
        } catch (Exception e) {
            log.severe("Failed to read data file for id: " + worker.getDiscordId());
            return null;
        }
    }

    public boolean writeFile(WorkerData workerData) {
        File file = new File(DATA_PATH + worker.getDiscordId() + DATA_EXTENSION);

        try {
            OBJECT_MAPPER.writeValue(file, workerData);
            return true;
        } catch (Exception e) {
            log.severe("Failed to write data file for id: " + worker.getDiscordId());
            return false;
        }
    }
}
