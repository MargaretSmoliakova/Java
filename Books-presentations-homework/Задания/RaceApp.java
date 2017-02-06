import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class RaceApp extends JFrame implements Runnable,Suspendable
{
  private Racer racers[];
  private short racerCount = 0;
  private Thread threads[];
  private Thread monitorThread;
  private boolean threadSuspended = false;
  public void initGUI()
  {
 
    if (racerCount <= 0)
      racerCount = 2;
    if (racerCount > Thread.MAX_PRIORITY - Thread.MIN_PRIORITY + 1)
      racerCount = (short)(Thread.MAX_PRIORITY - Thread.MIN_PRIORITY +1);

    // »меетс€ единственный столбец, с одной строкой дл€ каждого потока
    setLayout(new GridLayout(racerCount, 1));

    // »нициализаци€ массивов fRacers и fThreads
    racers = new Racer[racerCount];
    threads = new Thread[racerCount];

    for (short i=0; i<racerCount; i++)
    {
      racers[i] = new Racer("Racer# " + i, this);

      // ¬ыравнивание рисунка дл€ размещени€ всех потоков-участников
      racers[i].setSize(getSize().width,
                         getSize().height/racerCount);
      add(racers[i]);
    }
    
  }

  public void start()
  {
    // —оздание собственного потока "монитора"
    monitorThread = new Thread(null, this,
                                "Monitor Thread");
    monitorThread.start();
  }

  public void run()
  {
    if (monitorThread == Thread.currentThread())
    {
      TMouseAdapter mouseAdapter = new TMouseAdapter();
      for (short i=0; i<racerCount; i++)
      {
        // ƒл€ выбранной версии конструктора класса Thread
        // задаетс€ целевой объект Runnable 
        threads[i] = new Thread(racers[i]);

        // “ребуетс€ гарантировать, что победит поток с большим номером
        threads[i].setPriority(Thread.MIN_PRIORITY+i);
        threads[i].start();
        racers[i].addMouseListener(mouseAdapter);
      }
      synchronized (monitorThread)
      {
        monitorThread.notify();
      }
    }

    // ¬се потоки-участники уже запущены
    while (monitorThread == Thread.currentThread())
    try
    {
      monitorThread.sleep(100);
      synchronized(monitorThread)
      {
        while (threadSuspended)
        {
          monitorThread.wait();
        }
        synchronized(this)
        {
          notifyAll();
        }
      }
    } catch (InterruptedException e)
    {
      System.err.println("The monitor thread was interrupted while sleeping.");
      System.exit(1);
    }
  }

  public boolean isSuspended()
  {
    return threadSuspended;
  }

  public static void main(String argv[])
  {
	  short count=27;
	  // ќпределение числа участников, заданного в командной строке
	    if (argv.length>0)
	    try {
	      count = Short.parseShort(argv[0]);
	    } catch (NumberFormatException e)
	    {
	      count = 5;
	    }
	RaceApp app = new RaceApp("Racing Threads",count);
	app.setSize(800, 400);
	app.setVisible(true);

  }
  
  public RaceApp(String capt,short count)
  {
	  super(capt);
	  this.racerCount = count;
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  initGUI();
     start();

  }

   
  class TMouseAdapter extends MouseAdapter
  {
    public synchronized void mousePressed(MouseEvent anEvent)
    {
      threadSuspended = !threadSuspended;
      if (!threadSuspended)
        synchronized (monitorThread)
        {
          monitorThread.notifyAll();
        }
    }
  }
}


class Racer extends Canvas implements Runnable
{
  private short position = 0;
  private String name;
  static private final short NUMBER_OF_STEPS = 1000;
  Suspendable ancestor;

  public Racer(String theName, Suspendable theAncestor)
  {
    name = new String(theName);
    ancestor = theAncestor;
  }

  public synchronized void paint(Graphics g)
  {
    g.setColor(Color.BLACK);
    g.drawLine(0,getSize().height/2, getSize().width, getSize().height/2);
    g.setColor(Color.RED);
    g.fillOval(position*getSize().width/NUMBER_OF_STEPS, 0, 15, getSize().height);
  }

  public void run()
  {
    while (position < NUMBER_OF_STEPS)
    {
      position++;
      repaint();
      try
      {
        Thread.sleep(10) ;
        if (ancestor != null)
        {

          synchronized (ancestor)
          {
            if (ancestor.isSuspended())
              ancestor.wait();
          }
        }
      } catch (InterruptedException e)
      {
        System.err.println("ѕоток " + name + " прерван.");
        System.exit(1);
      }
    }
    System.out.println("ѕоток " + name + " завершил свое выполнение.") ;
  }
}

interface Suspendable
{
  public boolean isSuspended();
}
