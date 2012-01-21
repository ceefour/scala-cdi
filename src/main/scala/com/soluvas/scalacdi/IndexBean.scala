package com.soluvas.scalacdi
import javax.enterprise.context.RequestScoped
import javax.inject.Named
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct
import scala.reflect.BeanProperty

/**
 * Testing @RequestScoped bean.
 */
@RequestScoped @Named
class IndexBean {
  
  private val log = LoggerFactory.getLogger(classOf[IndexBean])
  @BeanProperty var city = "New York"
  
  @PostConstruct def init(): Unit = {
    log.info("IndexBean started at {}", getClass())
  }

}