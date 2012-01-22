package com.soluvas.scalacdi
import javax.enterprise.context.RequestScoped
import javax.inject.Named
import org.slf4j.LoggerFactory
import javax.annotation.PostConstruct
import scala.reflect.BeanProperty
import javax.cache.annotation.CacheResult
import java.util.concurrent.Executor
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * Testing @RequestScoped bean.
 */
@RequestScoped @Named
class IndexBean {
  
  private lazy val log = LoggerFactory.getLogger(classOf[IndexBean])
  @BeanProperty var city = "New York"
  
  @PostConstruct def init(): Unit = {
    log.info("IndexBean started at {}", getClass())
  }
  
  @CacheResult def getAddress() = "5015 Elm Street"

  def getKind(gender: String) = {
    List("a", "b", "c").foreach { println(_) }
    gender match {
      case "male" => "Rock solid"
      case "female" => "Warm and soft"
    }
  }
  
  def testExecutor() = {
    val executor = Executors.newFixedThreadPool(4);
    // this avoids 'log' becoming 'final' like:
    //     private org.slf4j.Logger com$soluvas$scalacdi$IndexBean$$log;
    //     public final org.slf4j.Logger com$soluvas$scalacdi$IndexBean$$log();
//    val log = this.log; 
    executor.submit(new Runnable() { override def run(): Unit = log.debug("Executor is running") })
  }

}