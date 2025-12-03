
// will do the notepad functionality
using System;
using Day002.FACTORYSRP.Manager;
using Day002.FACTORYSRP.Factory;
using Day002.FACTORYSRP.Notifications;

class Program
{

    public static void Main(string[] args)
    {

        Console.WriteLine("1. EMAIL");
        Console.WriteLine("2. SMS");
        Console.WriteLine("3. PUSH");

        // int choice = Convert.ToInt32(Console.ReadLine());
        // NotificationFactory nt = new NotificationFactory();
        // INotifier notify = nt.GetNotifier(choice);
        // notify.Send();

        NotificationManager mgr = new NotificationManager(new SmsNotification());
        mgr.sendMessage();
    }


}


