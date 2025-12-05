## 🚀 **Case Study: Build a Notification System Using IoC + Factory Pattern**

### **Background (Industry Story)**

You’re working as a backend engineer at a SaaS company.
Your platform needs to send notifications to users.
Different customers prefer different channels:

* Email
* SMS
* Push Notification

The application editor (similar to your `Editor` class) should not care *how* the notification is sent.
It should just ask the system to “Send Notification.”

You must design a system where the notification channel is decided at runtime based on the admin’s choice, using:

* **An interface (`INotifier`)**
* **Different concrete notifier classes**
* **A factory to produce the correct notifier**
* **Constructor injection (dependency injection)**

---

## 🎯 **Your Task / Problem Statement**

### **Build a notification module with the following requirements:**

1. When the program starts, show:

   ```
   1: Email, 2: SMS, 3: Push
   ```
2. Based on the user’s selection, the system should fetch the correct notifier using a **NotifierFactory**.
3. The `NotificationManager` class should:

   * Accept an `INotifier` through constructor injection.
   * Have a method `Send(string message)` which uses the injected notifier.
4. Classes needed:

   * `INotifier` interface with a `Notify(string message)` method.
   * `EmailNotifier` class implementing `INotifier`.
   * `SMSNotifier` class implementing `INotifier`.
   * `PushNotifier` class implementing `INotifier`.
   * `NotifierFactory` to return the correct notifier.
   * `NotificationManager` similar to your `Editor` class.
5. The console must print different outputs:

   * Email → `"Email sent: <message>"`
   * SMS → `"SMS delivered: <message>"`
   * Push → `"Push notification sent: <message>"`

