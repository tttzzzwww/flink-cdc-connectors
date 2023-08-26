package com.ververica.cdc.connectors.sqlserver.source.handler;

import com.ververica.cdc.connectors.base.relational.handler.SchemaChangeEventHandler;
import io.debezium.schema.SchemaChangeEvent;
import org.apache.kafka.connect.data.Struct;

import java.util.HashMap;
import java.util.Map;

import static io.debezium.connector.sqlserver.SourceInfo.CHANGE_LSN_KEY;
import static io.debezium.connector.sqlserver.SourceInfo.COMMIT_LSN_KEY;
import static io.debezium.connector.sqlserver.SourceInfo.EVENT_SERIAL_NO_KEY;

/** sqlServerHandler. */
public class SqlServerSchemaChangeEventHandler implements SchemaChangeEventHandler {

    @Override
    public Map<String, Object> parseSource(SchemaChangeEvent event) {
        Map<String, Object> source = new HashMap<>();
        Struct sourceInfo = event.getSource();
        String changeLsn = sourceInfo.getString(CHANGE_LSN_KEY);
        String commitLsn = sourceInfo.getString(COMMIT_LSN_KEY);
        String eventSerialNo = sourceInfo.getString(EVENT_SERIAL_NO_KEY);
        source.put(CHANGE_LSN_KEY, changeLsn);
        source.put(COMMIT_LSN_KEY, commitLsn);
        source.put(EVENT_SERIAL_NO_KEY, eventSerialNo);
        return source;
    }
}
