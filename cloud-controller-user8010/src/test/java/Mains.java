import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class Mains {

    @Autowired
    static RedisTemplate  redisTemplate;


    public static void main(String[] args) {
       /* Mains mains = new Mains();*/
       /* redisTemplate.delete("18064067924");*/
        System.out.println(redisTemplate);
    }



}
