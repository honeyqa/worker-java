package io.honeyqa.handler.rabbit;


import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;

class RedisHandler {

    private final Jedis jedis = new Jedis("127.0.0.1", 0);

    public boolean crashExist(final String uid) {
        return (boolean) jedis.exists(uid);
    }

    public String initInserCrash(final String id, final String crashID, final int crashCount) {
        final Map<String, String> userProperties = new HashMap<String, String>();
        userProperties.put("crashID", crashID);
        userProperties.put("crashCount", String.valueOf(crashCount));

        return jedis.hmset(id, userProperties);
    }

    public Information getCrash(final String id) {
        final Information result = new Information();
        final Map<String, String> userProperties = jedis.hgetAll(id);

        result.setId(id);
        result.setCrashID(userProperties.get("crashID"));
        result.setCrashCount(Integer.parseInt(userProperties.get("crashCount")));

        return result;
    }

    public long incrementCount(String id) {
        return updateHashMap(id, "crashCount");
    }

    private long updateHashMap(final String id, final String crashID) {
        return jedis.hincrBy(id, crashID, 1);
    }

    public long removeCount(final String key) {
        return jedis.del(key);
    }

    private class Information {

        private String id;
        private String crashID;
        private int crashCount;

        public String getID() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCrashID() {
            return crashID;
        }


        public void setCrashID(String crashID) {
            this.crashID = crashID;
        }

        public int getCrashCount() {
            return crashCount;
        }

        public void setCrashCount(int crashCount) {
            this.crashCount = crashCount;
        }

        @Override
        public String toString() {
            return "crash Information [id=" + id + ", crashID=" + crashID + ", crashCount=" + crashCount + "]";
        }
    }

}

