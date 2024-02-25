package eme.worker;

import java.util.List;
import java.util.Map;

import com.neovisionaries.ws.client.ThreadType;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;
import com.neovisionaries.ws.client.WebSocketListener;
import com.neovisionaries.ws.client.WebSocketState;

import eme.api.json.message.receive.DiscordMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
public class WorkerListener implements WebSocketListener {

    private final Worker worker;

    @Override
    public void handleCallbackError(WebSocket webSocket, Throwable throwable) throws Exception {
        // Not needed
    }

    @Override
    public void onBinaryFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onBinaryMessage(WebSocket webSocket, byte[] bytes) throws Exception {
        // Not needed
    }

    @Override
    public void onCloseFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onConnectError(WebSocket webSocket, WebSocketException exception) throws Exception {
        // Not needed
    }

    @Override
    public void onConnected(WebSocket webSocket, Map<String, List<String>> headers) throws Exception {
        log.info("Connected: " + worker.getUuid());
    }

    @Override
    public void onContinuationFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onDisconnected(WebSocket webSocket, WebSocketFrame serverFrame, WebSocketFrame clientFrame, boolean closedByServer) throws Exception {
        log.info("Disconnected: " + worker.getUuid());
        WorkerManager.stopWorker(worker.getUuid());
    }

    @Override
    public void onError(WebSocket webSocket, WebSocketException exception) throws Exception {
        // Not needed
    }

    @Override
    public void onFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onFrameError(WebSocket webSocket, WebSocketException exception, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onFrameSent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onFrameUnsent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onMessageDecompressionError(WebSocket webSocket, WebSocketException exception, byte[] bytes) throws Exception {
        // Not needed
    }

    @Override
    public void onMessageError(WebSocket webSocket, WebSocketException exception, List<WebSocketFrame> webSocketFrames) throws Exception {
        // Not needed
    }

    @Override
    public void onPingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onPongFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onSendError(WebSocket webSocket, WebSocketException exception, WebSocketFrame arg2) throws Exception {
        // Not needed
    }

    @Override
    public void onSendingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onSendingHandshake(WebSocket webSocket, String request, List<String[]> headers) throws Exception {
        // Not needed
    }

    @Override
    public void onStateChanged(WebSocket webSocket, WebSocketState webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onTextFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        // Not needed
    }

    @Override
    public void onTextMessage(WebSocket webSocket, String message) throws Exception {
        log.info(message);
        DiscordMessage discordMessage = worker.getWorkerService().convertToDiscordMessage(message);
        discordMessage.execute(worker, webSocket);
    }

    @Override
    public void onTextMessage(WebSocket webSocket, byte[] bytes) throws Exception {
        // Not needed
    }

    @Override
    public void onTextMessageError(WebSocket webSocket, WebSocketException exception, byte[] bytes) throws Exception {
        // Not needed
    }

    @Override
    public void onThreadCreated(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        // Not needed
    }

    @Override
    public void onThreadStarted(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        // Not needed
    }

    @Override
    public void onThreadStopping(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        // Not needed
    }

    @Override
    public void onUnexpectedError(WebSocket webSocket, WebSocketException exception) throws Exception {
        // Not needed
    }
    
}
