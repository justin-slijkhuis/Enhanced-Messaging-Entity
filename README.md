# Enhanced Messaging Entity

EME is a Discord worker that lets you automate certain processes like responding to messages and changing your status. It is still a massive work in progress which hasn't reached version 1.0.0 yet.

## I am not reliable for anyone getting banned using EME

A while ago I contacted Discord support to ask whether automated Discord actions are allowed and as a response I got: "Find out yourself, here you got some links". So I am not sure whether this does count as selfbotting which is bannable in Discord or whether you can freely use EME. Use this at your own risk of losing your account!

## How to use EME

Run the command: "java -jar target/EME-1.0.0.jar" in console to start the Spring Boot application.

Once the application is started, you can send a request to localhost:8080/start to start a new worker. This endpoint must have a body with at least the login and password key so we can authenticate into your account. To start a worker with 2FA enabled, send the 6 digit code as the last parameter of the URL resulting in localhost:8080/start/{6-digit-code}.

To customize the worker you can pass the settings key as a body to the start request. There you can enable modules, specify custom messages and change the commandStart. More info about these options will be given in the future.

To stop the worker, you can pass the UUID that was given to you when starting the worker to localhost:8080/stop. All you need to do is call the localhost:8080/stop endpoint with a body that has the id key with the UUID as the value.
