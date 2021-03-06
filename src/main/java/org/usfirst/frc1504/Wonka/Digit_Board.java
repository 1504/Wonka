package org.usfirst.frc1504.Wonka;

import org.usfirst.frc1504.Wonka.DigitBoard;
//import edu.wpi.first.wpilibj.DriverStation;

public class Digit_Board
{
	//private DriverStation _ds;	
	private DigitBoard _board;
	
	private long _thread_sleep_delay = 100;
	//private int _thread_sleep_counter;
	
	//private double _last_pot;
	
	//private boolean _a;
	//private boolean _b;

	
	//Setting up a separate thread for the Digit Board
	private static class Board_Task implements Runnable
	{
		private Digit_Board _b;

		Board_Task(Digit_Board b)
		{
			_b = b;
		}

		public void run()
		{
			_b.board_task();
		}
	}


	private Thread _task_thread;
	private boolean _run = false;

	protected Digit_Board()
	{
		_task_thread = new Thread(new Board_Task(this), "1504_Display_Board");
		_task_thread.setPriority((Thread.NORM_PRIORITY + Thread.MAX_PRIORITY) / 2);

		//_ds = DriverStation.getInstance(); 
		_board = DigitBoard.getInstance();
		
		start();

		System.out.println("1504 Digit Board is getting really Digit Bored...");
	}
	public void start()
	{
		if(_run)
			return;
		_run = true;
		_task_thread = new Thread(new Board_Task(this));
		_task_thread.start();
	}
	public void stop()
	{
		_run = false;
	}
	
	//getInstance() is a function used when instantiating the Digit_Board class in other project classes.
	private static Digit_Board instance = new Digit_Board();
	
	public static Digit_Board getInstance()
	{
		return Digit_Board.instance;
	}
	public static void initialize()
	{
		getInstance();
	}
	//Updates the values used for the display.
	public void update()
	{
		//_a = _board.getAOnRisingEdge();
		//_b = _board.getBOnRisingEdge();
	}
	
	public void write(String digits)
	{
		_board.writeDigits(digits);
	}

	//Writes the values to the digit board.
	public void write()
	{
		/*
		if(_current_pot < 0.5)
		{
			_board.writeDigits(Double.toString(_voltage).substring(0, 4) + "V");
		}
		else
		{
			byte[][] buffer = {{0,0},{0,0},{0,0},{(byte)0b00111111, (byte)0b00100100}};

			_board.writeRaw(buffer);
		}*/
		//_last_pot = _current_pot;

		_board.writeDigits(Double.toString(Wheels.put_on_speedo()).substring(0, 4) + "%");
	}
	
	//The loop for the separate thread, where all functions are called.
	private void board_task()
	{	

		while (_run)
		{	
			update();
			write();
			try
			{
				Thread.sleep(_thread_sleep_delay); // wait a while because people can't read that fast
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
