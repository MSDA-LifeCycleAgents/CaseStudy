package com.mlaf.hu.casestudy.sensoragent;

import com.mlaf.hu.sensoragent.InvalidSensorException;

public class SensorAgent extends com.mlaf.hu.sensoragent.SensorAgent{
    public SensorAgent() {
        super();
        try {
            addSensor(new TempCPUSensor());
            addSensor(new DHTSensor(21, 10000));
        } catch (InvalidSensorException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String getInstructionXML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "                <instructions>\n" +
                "                    <identifier>\n" +
                "                        jdk83012XKJlauehjHHs9q\n" +
                "                    </identifier>\n" +
                "                    <messaging>\n" +
                "                        <directToDecisionAgent>true</directToDecisionAgent>\n" +
                "                    </messaging>\n" +
                "                    <amountOfMissedDataPackages>5</amountOfMissedDataPackages>\n" +
                "                    <sensors>\n" +
                "                        <sensor id=\"CPUTEMP\">\n" +
                "                            <label>CPU Temperature</label>\n" +
                "                            <intervalinseconds>30</intervalinseconds>\n" +
                "                            <unit>C</unit>\n" +
                "                            <measurements>\n" +
                "                                <measurement id=\"temperature\">\n" +
                "                                    <min>0</min>\n" +
                "                                    <max>100</max>\n" +
                "                                    <plans>\n" +
                "                                        <plan>\n" +
                "                                            <above>0.5</above>\n" +
                "                                            <message>Watch out!</message>\n" +
                "                                            <via>SlackAgent</via>\n" +
                "                                            <to>@auke</to>\n" +
                "                                            <limit>3</limit>\n" +
                "                                        </plan>\n" +
                "                                        <plan>\n" +
                "                                            <below>0.0</below>\n" +
                "                                            <above>1.0</above>\n" +
                "                                            <message>Panic!</message>\n" +
                "                                            <via>SlackAgent</via>\n" +
                "                                            <to>spam@aacoba.net</to>\n" +
                "                                            <limit>3</limit>\n" +
                "                                        </plan>\n" +
                "                                    </plans>\n" +
                "                                </measurement>\n" +
                "                            </measurements>\n" +
                "                      " +
                "      <amountOfBackupMeasurements>20</amountOfBackupMeasurements>\n" +
                "                        </sensor>\n" +
                "                        <sensor id=\"DHT11\">\n" +
                "                            <label>DHT11</label>\n" +
                "                            <intervalinseconds>30</intervalinseconds>\n" +
                "                            <unit>C</unit>\n" +
                "                            <measurements>\n" +
                "                                <measurement id=\"temperature\">\n" +
                "                                    <min>0</min>\n" +
                "                                    <max>100</max>\n" +
                "                                    <plans>\n" +
                "                                        <plan>\n" +
                "                                            <above>0.5</above>\n" +
                "                                            <message>Watch out!</message>\n" +
                "                                            <via>SlackAgent</via>\n" +
                "                                            <to>@auke</to>\n" +
                "                                            <limit>3</limit>\n" +
                "                                        </plan>\n" +
                "                                        <plan>\n" +
                "                                            <above>0.6</above>\n" +
                "                                            <message>Panic!</message>\n" +
                "                                            <via>SlackAgent</via>\n" +
                "                                            <to>@auke</to>\n" +
                "                                            <limit>3</limit>\n" +
                "                                        </plan>\n" +
                "                                    </plans>\n" +
                "                                </measurement>\n" +
                "                                <measurement id=\"humidity\">\n" +
                "                                    <min>0</min>\n" +
                "                                    <max>100</max>\n" +
                "                                    <plans>\n" +
//                "                                        <plan>\n" +
//                "                                            <below>1.0</below>\n" +
//                "                                            <message>Watch out!</message>\n" +
//                "                                            <via>SlackAgent</via>\n" +
//                "                                            <to>@auke</to>\n" +
//                "                                            <limit>3</limit>\n" +
//                "                                        </plan>\n" +
//                "                                        <plan>\n" +
//                "                                            <below>0.0</below>\n" +
//                "                                            <above>1.0</above>\n" +
//                "                                            <message>Panic!</message>\n" +
//                "                                            <via>MailAgent</via>\n" +
//                "                                            <to>spam@aacoba.net</to>\n" +
//                "                                            <limit>3</limit>\n" +
//                "                                        </plan>\n" +
                "                                    </plans>\n" +
                "                                </measurement>\n" +
                "                            </measurements>\n" +
                "                            <amountOfBackupMeasurements>20</amountOfBackupMeasurements>\n" +
                "                        </sensor>\n" +
                "                    </sensors>\n" +
                "                    <fallback>\n" +
                "                        <via>SlackAgent</via>\n" +
                "                        <to>@auke</to>\n" +
                "                    </fallback>\n" +
                "                </instructions> ";
    }

    @Override
    public void onReceivingRefuseRegistration() {
        doDelete();
    }
}
