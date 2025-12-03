
using Day003.FACTORYSRP.Notifications;

namespace Day003.FACTORYSRP.Manager
{

    public class NotificationManager
    {

        private readonly INotifier Notify;
        public NotificationManager(INotifier notify)
        {
            Notify = notify;

        }

        public void sendMessage()
        {
            Notify.Send();
        }
    }

}