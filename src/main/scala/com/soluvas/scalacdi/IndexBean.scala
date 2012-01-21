package com.soluvas.scalacdi
import javax.enterprise.context.RequestScoped
import javax.inject.Named
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct
import scala.reflect.BeanProperty

@RequestScoped @Named
class IndexBean {
  
  private val log = LoggerFactory.getLogger(classOf[IndexBean])
  @BeanProperty var name = "Josh Smith"
  
  @PostConstruct def init(): Unit = {
    log.info("IndexBean started")
  }

}