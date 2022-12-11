import java.util.ArrayList;

public class CarQueue
{
	ArrayList<Integer> queue = new ArrayList<Integer>();
	CarQueue()
	{
		queue.add(0);
		queue.add(3);
		queue.add(1);
		queue.add(2);
		queue.add(0);
		queue.add(3);
	}

	public void addToQueue()
	{
		class CarThread implements Runnable
		{

			@Override
			public void run() {	
				try {
					for (int i=0; i<6; i++)
					{
						queue.add(3);
						queue.add(0);
						queue.add(1);
						queue.add(0);
						queue.add(2);
						queue.add(0);
					}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		CarThread r = new CarThread();
		Thread t = new Thread(r);
		t.start();
	}
	
	public int deleteQueue()
	{
		return queue.remove(0);
	}
}