package com.ververica.cdc.connectors.base.relational.handler;

import io.debezium.schema.SchemaChangeEvent;

import java.util.Map;

/** SchemaChangeEvent Handler. */
public interface SchemaChangeEventHandler {
    Map<String, Object> parseSource(SchemaChangeEvent event);
}
