# 📘 Assignment 2 – Git

## Local ↔ Remote Sync with Parallel Changes

---

## 🎯 Objective

Learn how to:

* Create a local Git repository
* Push it to a **blank GitHub repository**
* Rename branch from `master` → `main`
* Make **changes on GitHub and locally**
* Handle push rejection correctly
* End with **same final code in both places**

---

## 🧠 Core Git Rule (MOST IMPORTANT)

> **If GitHub has new commits and your local repo doesn’t,
> you must PULL before you PUSH.**

This assignment is designed to test exactly this.

---

## 🗂️ Step 1: Create Local Project and Initialize Git

```bash
mkdir calc
cd calc
git init
```

✔ Local Git repository created

---

## 🧑‍💻 Step 2: Create Program (Addition Only)

### Example (Java)

```java
import java.util.Scanner;

class Calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Addition = " + (a + b));
    }
}
```

OR (Python)

```python
a = int(input())
b = int(input())
print("Addition =", a + b)
```

---

## 💾 Step 3: Add and Commit Locally

```bash
git add .
git commit -m "Added program for addition"
```

---

## 🌐 Step 4: Create Blank Repository on GitHub

On GitHub:

* Repository name: **calc**
* ❌ Do NOT add README / files
* Create repository

📌 GitHub repo is **empty**

---

## 🔁 Step 5: Rename Local Branch to `main`

```bash
git branch -m master main
```

Check:

```bash
git branch
```

✔ `main` branch confirmed

---

## 🔗 Step 6: Link Local Repo to GitHub

```bash
git remote add origin https://github.com/username/calc.git
```

Verify:

```bash
git remote -v
```

---

## 🚀 Step 7: Push Local Code to GitHub

```bash
git push origin main
```

✔ Program with **addition** now exists on GitHub

---

## ✏️ Step 8: Modify File on GitHub (Multiplication)

On GitHub editor:

* Edit same file
* Add multiplication logic

Example (Java):

```java
System.out.println("Multiplication = " + (a * b));
```

Example (Python):

```python
print("Multiplication =", a * b)
```

✔ Commit directly on GitHub

📌 Now GitHub has **1 extra commit**
📌 Local repo is **behind**

---

## 🧑‍💻 Step 9: Modify Program Locally (Subtraction)

Local machine:

```java
System.out.println("Subtraction = " + (a - b));
```

OR

```python
print("Subtraction =", a - b)
```

Commit locally:

```bash
git add .
git commit -m "Added subtraction logic"
```

---

## 🚫 Step 10: Try `git push` (Expected to FAIL)

```bash
git push origin main
```

❌ Error (expected):

```
rejected – fetch first
```

✔ This means Git is protecting history

---

## 🔄 Step 11: Pull First, Then Push

```bash
git pull origin main
```

✔ Git merges **multiplication (GitHub)** + **subtraction (local)**

If no conflict → auto merge
(Usually no conflict since different lines)

---

## 🚀 Step 12: Push Again

```bash
git push origin main
```

✔ Success 🎉

---

## ✅ Final State (Both Local & GitHub)

Program displays:

* ✅ Addition
* ✅ Subtraction
* ✅ Multiplication

Both repositories are **fully synchronized**

---

## 🔁 Final Flow (Mental Model)

```
Local commit (addition)
        ↓ push
GitHub edit (multiplication)
        ↓ pull
Local commit (subtraction)
        ↓ pull → merge → push
GitHub + Local same
```

---

## ❗ Common Mistakes (Exam Traps)

❌ Forgetting to rename `master` → `main`
❌ Trying to push without pulling
❌ Creating README on GitHub initially
❌ Editing different files instead of same file

---

## 🎤 Interview-Ready Explanation

> “Since GitHub had a new commit, my local push was rejected. I pulled the remote changes first, merged them with my local commit, and then pushed successfully.”

