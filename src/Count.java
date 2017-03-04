public class Count
{

    private void countUp()
    {
        count++;
    }

    private void countDown()
    {
        count--;
    }

    private int count = 0;

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
        t2.start();
    }

}
