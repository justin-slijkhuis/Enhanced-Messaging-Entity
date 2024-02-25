package eme.worker;

import java.util.HashMap;
import java.util.Map;

import eme.modules.PingModule;
import lombok.Data;
import lombok.Setter;

@Data
public abstract class WorkerModule {

    @Setter
    protected String[] disabled;

    public static Map<String, Class<? extends WorkerModule>> getModules() {
        Map<String, Class<? extends WorkerModule>> modules = new HashMap<>();

        modules.put("ping", PingModule.class);

        return modules;
    }

    public abstract String getInput();

    public abstract String getResponse(Worker worker);
}
