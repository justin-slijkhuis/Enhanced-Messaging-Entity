package eme.worker;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import eme.api.json.message.sub.DiscordOp0;
import eme.utils.Urls;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Worker {
    
    private final String token;
    private final String uuid;
    private final WorkerSettings settings;

    private WebSocket webSocket;

    @Setter
    private DiscordOp0 workerInfo;

    public void start() {
        try {
            webSocket = new WebSocketFactory().createSocket(Urls.getGatewayUrl());

            webSocket.addListener(new WorkerListener(this));

            webSocket.connect();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Failed to connect to gateway", e);
        }
    }

    public void stop() {
        webSocket.disconnect();
    }
}
