package com.ververica.cdc.connectors.postgres.source.handler;

import com.ververica.cdc.connectors.base.relational.handler.SchemaChangeEventHandler;
import io.debezium.schema.SchemaChangeEvent;

import java.util.HashMap;
import java.util.Map;

/** postgressHandler. */
public class PostgresSchemaChangeEventHandler implements SchemaChangeEventHandler {

    @Override
    public Map<String, Object> parseSource(SchemaChangeEvent event) {
        return new HashMap<>();
    }
}
