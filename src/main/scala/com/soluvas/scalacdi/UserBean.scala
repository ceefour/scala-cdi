package com.soluvas.scalacdi
import scala.reflect.BeanProperty
import javax.enterprise.context.SessionScoped
import javax.inject.Named
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct

/**
 * Testing @SessionScoped bean.
 */
@Named @SessionScoped
class UserBean extends Serializable {

  private val log = LoggerFactory.getLogger(classOf[UserBean])
  @BeanProperty var name = "Josh Smith"
  
  @PostConstruct def init(): Unit = {
    log.info("Started {}", getClass())
  }


}