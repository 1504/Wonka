package org.usfirst.frc1504.utils;


public class VisionThreadSingleFrame
{
	private long _last_run_time = 0;
	private Object _lock = new Object();
	/**
	 * Creates a vision thread that runs a {@link VisionPipeline} on request.
	 *
	 * @param visionRunner the runner for a vision pipeline
	 */
	

	/**
	 * Creates a new vision thread that runs the given vision pipeline on request. This is equivalent
	 * to {@code new VisionThreadSingleFrame(new VisionRunner<>(videoSource, pipeline, listener))}.
	 *
	 * @param videoSource the source for images the pipeline should process
	 * @param pipeline    the pipeline to run
	 * @param listener    the listener to copy outputs from the pipeline after it runs
	 * @param <P>         the type of the pipeline
	 */
	
	
	public void processImage()
	{
		synchronized(_lock)
		{
			_lock.notifyAll();
		}
	}
	
	public long lastExecutionTime()
	{
		return _last_run_time;
	}
}