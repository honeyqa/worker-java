package io.honeyqa.connector;

import java.net.SocketAddress;

public interface ConnectionManager {

    public abstract void ConnectConfig();

    public abstract void ConnectMySQL();

    public abstract void ConnectRedis();


}
