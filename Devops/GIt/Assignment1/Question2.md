Q.2. Create a directory by name project1 on your Windows machine. Initialize it as a git repository. Create a file by name file1.c in it. Type “Welcome to git!!!” in the file. Git add and git commit. Modify the file1.c again and add second line “Welcome to DevOPS!!!”. Git add and git commit. Modify the file1.c again and add Third line “Welcome to Jenkins!!!”. Git add and git commit. Now try to get back the file1.c with one line “Welcome to git!!!” from commit.

# 📘 Git Revision Notes – File History & Checkout

## 🎯 Objective

Understand how to:

* Initialize a Git repository
* Track file changes using commits
* Restore a file from an **older commit** (time travel without deleting history)

---

## 🧠 Core Git Idea (Must Remember)

> **Git does not store changes. Git stores snapshots.**
> Each commit is a complete picture of the project at that moment.

---

## 🗂️ Scenario Overview

We perform **3 commits** on the same file:

### File: `file1.c`

**Commit 1**

```
Welcome to git!!!
```

**Commit 2**

```
Welcome to git!!!
Welcome to DevOPS!!!
```

**Commit 3**

```
Welcome to git!!!
Welcome to DevOPS!!!
Welcome to Jenkins!!!
```

Goal:
➡️ Restore `file1.c` back to **Commit 1 content only**.

---

## 🛠️ Commands Used (Step-by-Step)

### 1️⃣ Create project and initialize Git

```bash
mkdir project1
cd project1
git init
```

---

### 2️⃣ First commit

```bash
echo Welcome to git!!! > file1.c
git add file1.c
git commit -m "Added first line"
```

---

### 3️⃣ Second commit

```bash
echo Welcome to DevOPS!!! >> file1.c
git add file1.c
git commit -m "Added second line"
```

---

### 4️⃣ Third commit

```bash
echo Welcome to Jenkins!!! >> file1.c
git add file1.c
git commit -m "Added third line"
```

---

## 🔍 Viewing Commit History (VERY IMPORTANT)

```bash
git log --oneline
```

Example output:

```
c3d9e21 Added third line
b7a91f4 Added second line
a12f0bc Added first line
```

➡️ **Oldest commit = first version of file**

---

## ⏪ Restoring File from Old Commit

### ✅ Correct & Safe Method

```bash
git checkout a12f0bc -- file1.c
```

OR (modern command):

```bash
git restore --source=a12f0bc file1.c
```

📌 Result in working directory:

```
Welcome to git!!!
```

✔ Commit history remains untouched
✔ Only the file is restored
✔ File is marked as modified

---

## 💾 Save the Restored Version (Optional but Professional)

```bash
git add file1.c
git commit -m "Reverted file1.c to first version"
```

This is how **real teams revert files**.

---

## ❌ Common Mistakes to Avoid

❌ `git checkout --firstlinehas`
❌ `git restore` (without commit ID or file name)

Git always needs:

* **Which commit**
* **Which file**

---

## 🧩 Quick Comparison (Exam Favorite)

| Command                                | Purpose                                 |
| -------------------------------------- | --------------------------------------- |
| `git checkout <commit> -- <file>`      | Restore file from old commit            |
| `git restore --source=<commit> <file>` | Same (new syntax)                       |
| `git reset`                            | Move HEAD / rewrite history             |
| `git revert`                           | Create a new commit that undoes changes |

---

## 🧠 One-Line Memory Trick

> **Checkout / restore = bring an old snapshot into the present**

---

## 🎤 Interview-Ready Answer

> “To restore a file from an earlier commit, I use
> `git checkout <commit-id> -- <file>` or
> `git restore --source=<commit-id> <file>`,
> which restores the file without deleting commit history.”


