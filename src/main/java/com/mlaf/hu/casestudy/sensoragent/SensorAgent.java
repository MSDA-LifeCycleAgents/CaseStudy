package com.mlaf.hu.casestudy.sensoragent;

import com.mlaf.hu.sensoragent.InvalidSensorException;

public class SensorAgent extends com.mlaf.hu.sensoragent.SensorAgent{
    public SensorAgent() {
        super();
        try {
            addSensor(new TempCPUSensor());
        } catch (InvalidSensorException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected String getInstructionXML() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<instructions>\n" +
                "    <identifier>\n" +
                "        fVTz7OCaD8WFJE5Jvw7K\n" +
                "    </identifier>\n" +
                "    <messaging>\n" +
                "        <directToDecisionAgent>true</directToDecisionAgent>\n" +
                "    </messaging>\n" +
                "    <amountOfMissedDataPackages>5</amountOfMissedDataPackages>\n" +
                "    <sensors>\n" +
                "        <sensor id=\"CPUTEMP\">\n" +
                "            <label>CPU Temperature</label>\n" +
                "            <intervalinseconds>30</intervalinseconds>\n" +
                "            <unit>C</unit>\n" +
                "            <measurements>\n" +
                "                <measurement id=\"temperature\">\n" +
                "                    <min>0</min>\n" +
                "                    <max>100</max>\n" +
                "                    <plans>\n" +
                "                        <plan>\n" +
                "                            <below>0.0</below>\n" +
                "                            <above>0.1</above>\n" +
                "                            <message>Watch out!</message>\n" +
                "                            <via>SlackAgent</via>\n" +
                "                            <to>@thijsgelton</to>\n" +
                "                            <limit>3</limit>\n" +
                "                        </plan>\n" +
                "                        <plan>\n" +
                "                            <below>0.0</below>\n" +
                "                            <above>0.8</above>\n" +
                "                            <message>Panic!</message>\n" +
                "                            <via>MailAgent</via>\n" +
                "                            <to>thijs.gelton@student.hu.nl</to>\n" +
                "                            <limit>3</limit>\n" +
                "                        </plan>\n" +
                "                    </plans>\n" +
                "                </measurement>\n" +
                "            </measurements>\n" +
                "            <amountOfBackupMeasurements>20</amountOfBackupMeasurements>\n" +
                "        </sensor>\n" +
                "    </sensors>\n" +
                "    <fallback>\n" +
                "        <via>SlackAgent</via>\n" +
                "        <to>thijsgelton</to>\n" +
                "    </fallback>\n" +
                "</instructions>";
    }

    @Override
    public void onReceivingRefuseRegistration() {
        doDelete();
    }
}
