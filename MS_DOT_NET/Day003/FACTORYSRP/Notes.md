# 📘 **README — Notification System using Factory Pattern + Interface + Dependency Injection**

This project is a small but powerful example showing real industry concepts:

* **Interface (Abstraction)**
* **Factory Design Pattern**
* **Dependency Injection (DI)**
* **Single Responsibility Principle (SRP)**
* **Folder-based Clean Architecture**

Even though the project is small, it teaches how large software systems are built.

---

# 🎯 **Goal of the Project**

We built a system that sends different types of notifications:

* Email
* SMS
* Push

The user selects a number, and the system automatically picks the correct notification type and sends a message.

This simple idea teaches BIG concepts in software architecture.

---

# 🧠 **Concept 1: Interface (INotifier)**

### What it is:

An **interface** defines a rule / contract.
Any class that implements the interface must follow the rule.

### We created:

```csharp
public interface INotifier
{
    void Send();
}
```

Email, SMS, Push ALL follow this rule.

### Why we need it:

* Removes tight coupling
* Makes code flexible
* Allows adding new types easily
* Helps in Dependency Injection
* Used in ALL real enterprise systems

### Easy example:

Think of a **charger plug**.
You don’t care if it's Samsung, iPhone, or OnePlus.
If it fits the socket interface, it works.

---

# 🧠 **Concept 2: Factory Pattern**

### What it is:

A **Factory** creates objects so the main program does NOT create them manually.

### Our Factory:

```csharp
public INotifier GetNotifier(int choice)
{
    if (choice == 1) return new EmailNotification();
    else if (choice == 2) return new SmsNotification();
    else return new PushNotification();
}
```

### Why we need it:

* Central control of object creation
* Cleaner Program.cs
* Avoids huge `if-else` in business logic
* Easy to add new notification types
* Reduces code duplication

### Easy example:

Think of a **hotel kitchen**.
You order "Pizza" → Kitchen decides which cook prepares it.
You don’t talk directly to the cook.

---

# 🧠 **Concept 3: Dependency Injection (DI)**

### What it is:

We **inject** the dependency (INotifier) into another class instead of creating it inside the class.

### Our code:

```csharp
public NotificationManager(INotifier notifier)
{
    _notifier = notifier;
}
```

Main program:

```csharp
var manager = new NotificationManager(notifier);
manager.Notify();
```

### Why we need it:

* Class does NOT create its own object → more flexible
* Easy to unit test
* Follows Inversion of Control (IoC)
* Works exactly like ASP.NET Core DI container
* Makes systems maintainable and extendable

### Easy example:

You don’t cook your own food in a hotel room.
Food gets **injected** into your room from the kitchen.

---

# 🧠 **Concept 4: SRP — Single Responsibility Principle**

Every class has ONE responsibility:

* Notification classes → sending message
* Factory → creating objects
* Manager → business logic (notify user)
* Program → user input + calling manager

### Why we need SRP:

* Avoids “God classes”
* Easier to debug
* Easier to extend without breaking
* Clear separation of responsibilities

---

# 🧠 **Concept 5: Folder Structure**

We arranged files like this:

```
Day002
 ├── Program.cs
 ├── Notifications
 │      ├── INotifier.cs
 │      ├── EmailNotification.cs
 │      ├── SmsNotification.cs
 │      └── PushNotification.cs
 ├── Factory
 │      └── NotificationFactory.cs
 └── Manager
        └── NotificationManager.cs
```

### Why we need it:

* Clean, readable architecture
* Easy navigation
* Standard used in all companies
* Prepares you for MVC / Clean Architecture / Hexagonal Architecture

### Easy example:

Like arranging shoes, clothes, utensils in separate almirahs.
Everything becomes easy to find.

---

# 🧩 **Complete Flow Summary**

### 1. User selects type (Email / SMS / Push)

### 2. Program sends this number to Factory

### 3. Factory returns correct object (EmailNotification / SmsNotification / PushNotification)

### 4. Factory output is injected into NotificationManager

### 5. Manager calls `.Send()`

### 6. Console prints success message

---

# 📘 **What You Learned**

### ✔ Interface removes dependency

### ✔ Factory controls object creation

### ✔ DI gives flexibility and testability

### ✔ SRP keeps code clean

### ✔ Folder structure organizes project

### ✔ Real industry coding mindset

