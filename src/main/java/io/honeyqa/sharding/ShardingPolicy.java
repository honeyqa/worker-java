package io.honeyqa.sharding;

/**
 * Created by swm on 9/23/15.
 */
public interface ShardingPolicy {

    public abstract void HorizontalSharding();

    public abstract void VerticalSharding();


}
