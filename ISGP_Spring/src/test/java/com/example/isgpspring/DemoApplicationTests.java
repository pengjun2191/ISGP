package com.example.isgpspring;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	ApplicationContext ioc;

	//@Resource(name="druid")
	@Qualifier("druid")
	@Autowired
	DataSource datasource;

	Logger logger= LoggerFactory.getLogger(getClass());

	@Test
	public void testDruidService(){
		boolean b= ioc.containsBean("druid");
		logger.trace("是否增加了组件Druid:"+b);
	}
	@Test
	void contextLoads() throws SQLException {
		logger.debug("数据源>>>>>>" +datasource.getClass());
		Connection connection= datasource.getConnection();
		logger.debug("连接>>>>>>" +connection);
		logger.info("连接地址>>>>>>"+connection.getMetaData().getURL());
		DruidDataSource druidDataSource = (DruidDataSource) datasource;
		logger.info("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
		logger.info("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());
		connection.close();
	}

}
