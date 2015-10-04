package io.honeyqa.handler.redis;

import org.junit.Assert;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class RedisStressTest extends Assert {
    protected void assertEquals(List<byte[]> expected, List<byte[]> actual) {
        assertEquals(expected.size(), actual.size());
        for (int n = 0; n < expected.size(); n++) {
            assertArrayEquals(expected.get(n), actual.get(n));
        }
    }

    protected void assertEquals(Set<byte[]> expected, Set<byte[]> actual) {
        assertEquals(expected.size(), actual.size());
        Iterator<byte[]> iterator = expected.iterator();
        Iterator<byte[]> iterator2 = actual.iterator();
        while (iterator.hasNext() || iterator2.hasNext()) {
            assertArrayEquals(iterator.next(), iterator2.next());
        }
    }
}
