import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author bobo.
 * @date 11/29/2017
 * @email ruantianbo@163.com
 */
public class AdminApplication extends WebMvcConfigurerAdapter implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(AdminApplication.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info("成功开启Admin 服务");
    }
}
