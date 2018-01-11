package com.ljm.server.config;

import com.ljm.server.io.connector.Connector;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李佳明 https://github.com/pkpk1234
 * @date 2018-01-2018/1/5
 */
public class ServerConfig {
    public static final int DEFAULT_PORT = 18080;
    private Set<Connector> connectors;

    private ServerConfig(Builder builder) {
        connectors = builder.connectors;
    }

    public Set<Connector> getConnectors() {
        return connectors;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private Set<Connector> connectors;

        private Builder() {
            connectors = new HashSet<>(16);
        }

        public Builder withConnectors(Set<Connector> connectors) {
            this.connectors = connectors;
            return this;
        }

        public Builder addConnector(Connector connector) {
            this.connectors.add(connector);
            return this;
        }

        public ServerConfig build() {
            return new ServerConfig(this);
        }
    }
}
