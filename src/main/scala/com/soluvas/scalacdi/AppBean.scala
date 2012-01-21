package com.soluvas.scalacdi
import scala.collection.JavaConversions.seqAsJavaList
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct
import javax.cache.annotation.CacheResult
import javax.enterprise.context.ApplicationScoped
import javax.inject.Named
import javax.servlet.ServletContext
import javax.enterprise.event.Observes

/**
 * Testing @ApplicationScoped bean.
 */
@ApplicationScoped @Named
class AppBean {
  
  private val log = LoggerFactory.getLogger(classOf[AppBean])
  private val _car = "Toyota"
  private val _animals = List("Bird", "Mammoth", "Elephant", "Giraffe", "Tiger")
  
  def servletStarted(@Observes context: ServletContext) = {
    log.info("Servlet {} started", context.getContextPath())
  }
  
  @PostConstruct def init(): Unit = {
    log.info("Started {}", getClass())
  }
  
  def getCar() = _car
  
  @CacheResult def getAnimals(): java.util.List[String] = {
    log.info("Loading animals")
    _animals
  }

}