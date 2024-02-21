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
        log.warning("handleCallbackError");
    }

    @Override
    public void onBinaryFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onBinaryFrame");
    }

    @Override
    public void onBinaryMessage(WebSocket webSocket, byte[] bytes) throws Exception {
        log.warning("onBinaryMessage");
    }

    @Override
    public void onCloseFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onCloseFrame");
    }

    @Override
    public void onConnectError(WebSocket webSocket, WebSocketException exception) throws Exception {
        log.warning("onConnectError");
    }

    @Override
    public void onConnected(WebSocket webSocket, Map<String, List<String>> headers) throws Exception {
        log.info("Connected: " + worker.getUuid());
    }

    @Override
    public void onContinuationFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onContinuationFrame");
    }

    @Override
    public void onDisconnected(WebSocket webSocket, WebSocketFrame serverFrame, WebSocketFrame clientFrame, boolean closedByServer) throws Exception {
        log.info("Disconnected: " + worker.getUuid());
        WorkerManager.stopWorker(worker.getUuid());
    }

    @Override
    public void onError(WebSocket webSocket, WebSocketException exception) throws Exception {
        log.warning("onError");
    }

    @Override
    public void onFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onFrame");
    }

    @Override
    public void onFrameError(WebSocket webSocket, WebSocketException exception, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onFrameError");
    }

    @Override
    public void onFrameSent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onFrameSent");
    }

    @Override
    public void onFrameUnsent(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onFrameUnsent");
    }

    @Override
    public void onMessageDecompressionError(WebSocket webSocket, WebSocketException exception, byte[] bytes) throws Exception {
        log.warning("onMessageDecompressionError");
    }

    @Override
    public void onMessageError(WebSocket webSocket, WebSocketException exception, List<WebSocketFrame> webSocketFrames) throws Exception {
        log.warning("onMessageError");
    }

    @Override
    public void onPingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onPingFrame");
    }

    @Override
    public void onPongFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onPongFrame");
    }

    @Override
    public void onSendError(WebSocket webSocket, WebSocketException exception, WebSocketFrame arg2) throws Exception {
        log.warning("onSendError");
    }

    @Override
    public void onSendingFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onSendingFrame");
    }

    @Override
    public void onSendingHandshake(WebSocket webSocket, String request, List<String[]> headers) throws Exception {
        log.warning("onSendingHandshake");
    }

    @Override
    public void onStateChanged(WebSocket webSocket, WebSocketState webSocketFrame) throws Exception {
        log.warning("onStateChanged");
    }

    @Override
    public void onTextFrame(WebSocket webSocket, WebSocketFrame webSocketFrame) throws Exception {
        log.warning("onTextFrame");
    }

    @Override
    public void onTextMessage(WebSocket webSocket, String message) throws Exception {
        DiscordMessage discordMessage = WorkerService.convertToDiscordMessage(message);
        log.info(discordMessage.toString());
        discordMessage.execute(worker, webSocket);
    }

    @Override
    public void onTextMessage(WebSocket webSocket, byte[] bytes) throws Exception {
        log.warning("onTextMessage");
    }

    @Override
    public void onTextMessageError(WebSocket webSocket, WebSocketException exception, byte[] bytes) throws Exception {
        log.warning("onTextMessageError");
    }

    @Override
    public void onThreadCreated(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        log.warning("onThreadCreated");
    }

    @Override
    public void onThreadStarted(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        log.warning("onThreadStarted");
    }

    @Override
    public void onThreadStopping(WebSocket webSocket, ThreadType threadType, Thread thread) throws Exception {
        log.warning("onThreadStopping");
    }

    @Override
    public void onUnexpectedError(WebSocket webSocket, WebSocketException exception) throws Exception {
        log.warning("onUnexpectedError");
    }
    
}
