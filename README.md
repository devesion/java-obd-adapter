# java-obd-adapter
java-obd-adapter - OBD-II Java Adapter API

### Requisites
* Java 7
* Maven 3

### Supported Commands

AT Commands
* AT Z - AT Reset
* AT SP - AT Select Protocol
* AT D - AT Defaults
* AT E - AT Set Echo On/Off
* AT H - AT Set Headers On/Off
* AT L - AT Set Linefeed On/Off
* AT M - AT Set Memory On/Off
* AT S - AT Set Spaces On/Off

Diagnostic Commands
* 01 04 - ENGINE_LOAD
* 01 05 - ENGINE_COOLANT_TEMPERATURE
* 01 0C - ENGINE_RPM
* 01 0D - VEHICLE_SPEED
* 01 0F - INTAKE_AIR_TEMPERATURE
* 01 10 - MASS_AIR_FLOW
* 01 11 - THROTTLE_POSITION_PERCENTAGE
* 01 1F - ENGINE_RUN_TIME
* 01 2F - FUEL_LEVEL
* 01 46 - AMBIENT_AIR_TEMPERATURE
* 01 51 - FUEL_TYPE
* 01 5E - FUEL_CONSUMPTION_1
* 01 5F - FUEL_CONSUMPTION_2

### Usage
```
<dependency>
  <groupId>com.devesion.commons.obd</groupId>
  <artifactId>obd-adapter</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

```
    private void invokeInitialCommands() {
        invokeCommandQuietly(new ResetCommand());
        invokeCommand(new SetEchoCommand(false));
        invokeCommand(new SetLineFeedCommand(false));
        invokeCommand(new SetHeadersCommand(false));
        invokeCommand(new SetSpacesCommand(false));
        invokeCommand(new AdaptiveTimeoutProtocolCommand());
        invokeCommand(new SelectProtocolCommand());
    }

    private int readEngineRpm() {
        EngineRpmCommand engineRpmCommand = new EngineRpmCommand();
        invokeCommand(engineRpmCommand);
        return engineRpmCommand.getValue().getIntValue();
    }

    private int readVehicleSpeed() {
        SpeedCommand speedCommand = new SpeedCommand();
        invokeCommand(speedCommand);
        return speedCommand.getValue().getIntValue();
    }

    private float readThrottlePositionPercentage() {
        ThrottlePositionCommand throttlePositionCommand = new ThrottlePositionCommand();
        invokeCommand(throttlePositionCommand);
        return throttlePositionCommand.getValue().getIntValue();
    }

    private double readMassAirFlow() {
        MassAirFlowCommand massAirFlowObdCommand = new MassAirFlowCommand();
        invokeCommand(massAirFlowObdCommand);
        return massAirFlowObdCommand.getValue().getFloatValue();
    }

    private void invokeCommand(ObdCommand command) {
        try {
            CommandInvoker commandInvoker = createCommandInvoker();
            log.info("invoking command {}", command);
            commandInvoker.invoke(command);
        } catch (Exception e) {
            throw new DiagnosticStatusReadException(e);
        }
    }

    private void invokeCommandQuietly(ObdCommand command) {
        CommandInvoker commandInvoker = createCommandInvoker();
        log.info("invoking command {}", command);
        commandInvoker.invokeQuietly(command);
    }

    private CommandInvoker createCommandInvoker(InputStream inputStream, OutputStream outputStream) {
        ObdLink obdLink = new ElmLink(inputStream, outputStream);
        return new CommandInvoker(obdLink);
    }
```


[![Bitdeli Badge](https://d2weczhvl823v0.cloudfront.net/devesion/java-obd-adapter/trend.png)](https://bitdeli.com/free "Bitdeli Badge")

