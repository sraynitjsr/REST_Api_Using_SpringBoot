import redis.clients.jedis.Jedis;
     
public class JedisClientImpl {     

  public static Jedis getRedisClient() throws Exception {

    Jedis jedis = new Jedis("http://localhost:", 8080);
    jedis.auth("dummyPassword");    
    System.out.println("Connected to Redis");
    
    jedis.set("foo", "bar");
    String value = jedis.get("foo");
    System.out.println(value);
    
    return jedis;
  }
}
