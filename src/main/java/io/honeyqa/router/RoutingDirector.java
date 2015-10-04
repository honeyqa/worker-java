package io.honeyqa.router;

public interface RoutingDirector {

    public abstract void RoutingControl();

    public abstract void MySQLRouter();

    public abstract void RedisRouter();

    public abstract void WatchAndMonitor();

}