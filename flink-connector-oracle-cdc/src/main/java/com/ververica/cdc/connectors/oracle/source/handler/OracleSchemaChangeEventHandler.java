package com.ververica.cdc.connectors.oracle.source.handler;

import com.ververica.cdc.connectors.base.relational.handler.SchemaChangeEventHandler;
import io.debezium.schema.SchemaChangeEvent;
import org.apache.kafka.connect.data.Struct;

import java.util.HashMap;
import java.util.Map;

import static io.debezium.connector.oracle.SourceInfo.SCN_KEY;

/** OracleHandler. */
public class OracleSchemaChangeEventHandler implements SchemaChangeEventHandler {

    @Override
    public Map<String, Object> parseSource(SchemaChangeEvent event) {
        Map<String, Object> source = new HashMap<>();
        Struct sourceInfo = event.getSource();
        String scn = sourceInfo.getString(SCN_KEY);
        source.put(SCN_KEY, scn);
        return source;
    }
}
