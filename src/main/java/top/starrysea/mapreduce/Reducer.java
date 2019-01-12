package top.starrysea.mapreduce;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public abstract class Reducer<T> implements Callable<T> {

	protected String inputPath;
	protected String outputPath;
	protected String fileName;
	private CountDownLatch countDownLatch;

	@Override
	public T call() {
		T result = reduce();
		countDownLatch.countDown();
		return result;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}

	public String getOutputPath() {
		return outputPath;
	}

	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	protected abstract T reduce();
}
