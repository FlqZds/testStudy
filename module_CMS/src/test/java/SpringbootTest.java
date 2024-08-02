import com.ddjc.cms.entity.Content;
import com.ddjc.cms.mapper.ContentMapper;
import com.ddjc.cms.service.CMSservice;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Optional;

//配置测试的启动类时候,包名需要和src下保持一致
//不然找不到启动类
//要么就配置一下class
//找不到启动类,就也无法自动装配
@SpringBootTest(classes = com.ddjc.cms.cmsSpringbootApplication.class)
public class SpringbootTest {

    @Autowired
    ContentMapper contentMapper;

    @Autowired
    CMSservice cmsService;

    @Test
    public void contextLoads() {
//        Optional<List<Content>> contents = cmsService.showContent(1);
//
//
//        System.out.println(contents);
//
//
//        jsonRedisTemplate.opsForValue().set("test",contents.get());
    }

    @Autowired
    private RedisTemplate jsonRedisTemplate;


    @Test
    public void testContentMapper() {
        Content content = Content.builder().type(1).imageurl("img9").title("title9").linkurl("link9").build();

        Integer integer = cmsService.addContent(content);
        System.out.println(integer);

//        jsonRedisTemplate.opsForValue().set("test",contents );
    }
}
