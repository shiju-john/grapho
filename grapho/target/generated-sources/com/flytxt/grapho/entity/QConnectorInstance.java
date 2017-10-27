package com.flytxt.grapho.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConnectorInstance is a Querydsl query type for ConnectorInstance
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConnectorInstance extends EntityPathBase<ConnectorInstance> {

    private static final long serialVersionUID = 2141679424L;

    public static final QConnectorInstance connectorInstance = new QConnectorInstance("connectorInstance");

    public final NumberPath<Long> connectorRefId = createNumber("connectorRefId", Long.class);

    public final StringPath instanceConfig = createString("instanceConfig");

    public final NumberPath<Long> instanceId = createNumber("instanceId", Long.class);

    public final StringPath instanceName = createString("instanceName");

    public QConnectorInstance(String variable) {
        super(ConnectorInstance.class, forVariable(variable));
    }

    public QConnectorInstance(Path<? extends ConnectorInstance> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConnectorInstance(PathMetadata metadata) {
        super(ConnectorInstance.class, metadata);
    }

}

