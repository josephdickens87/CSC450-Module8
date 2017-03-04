public class Count
{

    private int count = 0;

    private void countUp()
    {
        count++;
    }

    private void countDown()
    {
        count--;
    }

    public void doWork()
    {
        Thread t1 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20; i++)
                {
                    countUp();
                    System.out.println(count);
                }
            }
        });

        Thread t2 = new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                for (int i = 0; i < 20; i++)
                {
                    countDown();
                    System.out.println(count);
                }
            }
        });

        t1.start();

        try
        {
            t1.join();
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        t2.start();
    }

}
