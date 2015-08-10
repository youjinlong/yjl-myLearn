package com.tuch.server;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 
 * @author jlyou
 * @date 2015年6月9日 下午4:43:57
 * @version <b>1.0.0</b>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring.xml"})
public abstract class AbstractSpringContextTests extends AbstractJUnit4SpringContextTests {

}
