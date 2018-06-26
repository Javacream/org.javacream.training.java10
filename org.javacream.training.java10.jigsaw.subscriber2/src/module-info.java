import org.javacream.training.java10.jigsaw.publisher.StringSubscriber;
import org.javacream.training.java10.jigsaw.subscriber2.SimpleSubscriber2;

/**
 * 
 */
/**
 * @author Administrator
 *
 */
module org.javacream.training.java10.jigsaw.subscriber2 {
	requires org.javacream.training.java10.jigsaw.publisher;
	provides StringSubscriber with SimpleSubscriber2;
}