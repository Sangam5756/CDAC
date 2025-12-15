

namespace MVC.Logger
{
    public class FileLogger
    {
        private static FileLogger logger = new FileLogger();
        private FileLogger()
        {
        }

        public static FileLogger CurrentLogger
        {
            get { return logger; }
        }
        public void Log(string message)
        {
            FileStream stream = null;
            string filePath = "D:\\log.txt";

            if (File.Exists(filePath))
            {

                stream = new FileStream(filePath, FileMode.Append, FileAccess.Write);
            }
            else
            {
                stream = new FileStream(filePath, FileMode.Create, FileAccess.Write);
            }


            string messageData = "Logged at " + DateTime.Now.ToString() + " - " + message;

            StreamWriter writer = new StreamWriter(stream);

            writer.WriteLine(messageData);

            writer.Close();
            stream.Close();
        }
    }

}
