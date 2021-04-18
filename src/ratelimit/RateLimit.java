package ratelimit;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author kaiz
 * @date 上午10:15 2021/4/9.
 */
public interface RateLimit {
	boolean canPass() throws BlockException;
}
