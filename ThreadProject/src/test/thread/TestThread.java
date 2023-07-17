package test.thread;

import java.util.Iterator;

/**
 * Thread Program
 * (process ���� ���)
 * 1. data - Object
 * 2. code - run()  - Runnable
 * 3. cpu - thread - Thread
 * 
 * 1-1. int count; -> class Counter
 * 2-1. count++; -> class Counter::inc() �Լ� ����
 * 3-1. new Thread;
 * 
 * 
 * @author user04
 *
 */
public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		Counter data = new Counter();
		Runnable code = new Runner(data); 	// Counter �ȿ� inc()�� �����ϱ� ���� monitor ����
		Thread cpu1 = new Thread(code);		// cpu ���忡�� ���� code�� ���� �����ؾ��� ����, target
		Thread cpu2 = new Thread(code);
		Thread cpu3 = new Thread(code);
		cpu1.start();		// start() �޼ҵ� ȣ���ϸ� �ڵ����� run() �޼ҵ� ȣ����
		cpu2.start();
		cpu3.start();
		cpu1.join();		// �����尡 ���� �� ������ ��ٸ�(run() ���� ������ ��ٸ�)
		cpu2.join();
		cpu3.join();
//		Thread.yield();		// ���� �켱������ ���������� cpu�� �纸�Ѵ�. (cpu�� ���� ������ ��ΰ� ���� ���µ� �� �ڽĺ��� ���� ���� �Ǵ� ��� 0�� ����)
		Thread.sleep(50);
		System.out.println(Thread.currentThread() + "::" + data.count);
	}

}

class Counter{	// �ϳ��� �ڹ� ���Ͽ��� �ϳ��� public class �� ���� �� ����
	// 1-1. int count; -> class Counter
	int count;
	
	// 2-1. count++; -> class Counter::inc() �Լ� ����
	void inc() {
		count++;
	}
}

class Runner implements Runnable {	
	Counter monitor;
	
	public Runner(Counter monitor) {
		this.monitor = monitor;
	}
	
	@Override
	public void run() {
		int i = 0;
		for (; i < 100000000; i++) {
			monitor.inc();
		}
//		System.out.println(Thread.currentThread() + "::" + monitor.count);
		System.out.println(Thread.currentThread() + ":inc()Ƚ��=" + i + ":���=" + monitor.count);
	}
}

// 0�� ������ ����?
// main thread start ���� ��Ű�� print ����ϰ� ���ߴٰ� ����
// ������ cpu thread�� ���Ƽ� inc() ���� ��Ű�� �ִ°���

// main�� cpu thread �� �������� thread �� ����
// �׷��� main ���������� �����ϰ� ����


