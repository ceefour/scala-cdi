package com.soluvas.scalacdi
import scala.reflect.BeanProperty

import org.slf4j.LoggerFactory

import javax.annotation.PostConstruct
import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.inject.Named

/**
 * Testing @RequestScoped bean with @Inject @BeanProperty var.
 */
@RequestScoped @Named
class PublicField {
  
  private lazy val log = LoggerFactory.getLogger(classOf[IndexBean])
  @Inject var indexBean: IndexBean = _
  
  @PostConstruct def init(): Unit = {
    log.info("I have public field which is {}", indexBean.getClass())
  }
  
  def getCity() = {
    val func = () => indexBean.city
    func()
  }
  
}