import org.javacream.training.java10.jigsaw.publisher.StringSubscriber;
import org.javacream.training.java10.jigsaw.subscriber1.SimpleSubscriber1;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java10.jigsaw.subscriber1 {
	requires org.javacream.training.java10.jigsaw.publisher;
	provides StringSubscriber with SimpleSubscriber1;
}