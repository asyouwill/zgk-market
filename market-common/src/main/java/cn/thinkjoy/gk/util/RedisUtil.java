package cn.thinkjoy.gk.util;

import cn.thinkjoy.cloudstack.cache.RedisRepository;

/**
 * Created by clei on 15/1/15.
 */
public class RedisUtil {
    private static RedisRepository redisRepository;
    public static final RedisRepository getInstance(){
        return redisRepository;
    }
    public RedisRepository getRedisRepository() {
        return redisRepository;
    }
    public void setRedisRepository(RedisRepository redisRepository) {
        this.redisRepository = redisRepository;
    }
}
