using System;
using Day003.FACTORYSRP.Notifications;

namespace Day003.FACTORYSRP.Factory
{
    class NotificationFactory
    {


        // now will do the by using DI

        public INotifier GetNotifier(int choice)
        {
            if (choice == 1)
            {
                return new EmailNotification();
            }
            else if (choice == 2)
            {
                return new SmsNotification();
            }
            else
            {
                return new PushNotification();
            }

        }
        //emd

    }

}