package com.soluvas.scalacdi
import javax.enterprise.context.RequestScoped
import javax.inject.Named
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct
import scala.reflect.BeanProperty
import javax.cache.annotation.CacheResult

/**
 * Testing @Dependent bean.
 */
@Named
class NormalBean {
  
  private val log = LoggerFactory.getLogger(classOf[NormalBean])
  @BeanProperty var plant = "Fungi"
  
  @PostConstruct def init(): Unit = {
    log.info("NormalBean started {}", getClass())
  }
  
  @CacheResult def getLeaf() = "Greenlight"

}