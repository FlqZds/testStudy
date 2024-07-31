import com.ddjc.cms.entity.Content;
import com.ddjc.cms.mapper.ContentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//配置测试的启动类时候,包名需要和src下保持一致
//不然找不到启动类
//要么就配置一下class
//找不到启动类,就也无法自动装配
@SpringBootTest(classes = com.ddjc.cms.cmsSpringbootApplication.class)
public class SpringbootTest {

    @Autowired
    ContentMapper contentMapper;

    @Test
    public void contextLoads() {
        Content content =
                contentMapper.selectByPrimaryKey(1);
        System.out.println(content);
    }
}
