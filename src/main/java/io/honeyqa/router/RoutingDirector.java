package io.honeyqa.router;

import java.net.SocketAddress;

public interface RoutingDirector {

    public abstract void RoutingControl();

    public abstract void MySQLRouter();

    public abstract void RedisRouter();

}