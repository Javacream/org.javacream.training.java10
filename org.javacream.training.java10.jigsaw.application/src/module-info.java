import org.javacream.training.java10.jigsaw.publisher.StringSubscriber;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java10.jigsaw.application {
	requires org.javacream.training.java10.jigsaw.publisher;
	uses StringSubscriber;
}