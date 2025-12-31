Q.3. Go to the demo directory created in Q.1. Check git status. Create a branch by name UI. Go to the branch and create a file by name ui.html. Git add and commit. Go to the master branch. Create another branch by name dbconn. Go to the branch and create user-reg.html file. Git add and commit. Now go to the master branch. Merge the UI branch first. Then merge the dbconn branch.

# 📘 Git Branching & Merging – Revision Notes (Q.3)

## 🎯 Objective

Learn how to:

- Check repository status
- Create and switch branches
- Work independently on multiple branches
- Merge branches back into `master` (or `main`)

---

## 🧠 Core Git Idea

> **Branches are lightweight pointers to commits.**
> Each branch lets you work in isolation without disturbing others.

---

## 📂 Starting Point

- You already have a Git repository called **demo** (created in Q.1)
- `master` branch exists by default

---

## 1️⃣ Go to demo directory & check status

```bash
cd demo
git status
```

✔ Confirms:

- You are inside a Git repo
- Working tree is clean

---

## 2️⃣ Create `UI` branch and switch to it

```bash
git branch UI
git checkout UI
```

OR (single command):

```bash
git checkout -b UI
```

📌 You are now on branch **UI**

---

## 3️⃣ Create UI file and commit

```bash
echo "<h1>User Interface</h1>" > ui.html
git add ui.html
git commit -m "Added UI page"
```

📌 `UI` branch now has **one extra commit**
📌 `master` branch is unchanged

---

## 4️⃣ Go back to master branch

```bash
git checkout master
```

Think of this as switching timelines.

---

## 5️⃣ Create `dbconn` branch and switch

```bash
git branch dbconn
git checkout dbconn
```

OR:

```bash
git checkout -b dbconn
```

📌 You are now on branch **dbconn**

---

## 6️⃣ Create DB file and commit

```bash
echo "<h1>User Registration</h1>" > user-reg.html
git add user-reg.html
git commit -m "Added DB connection page"
```

📌 `dbconn` branch has its own independent commit

---

## 7️⃣ Go back to master branch

```bash
git checkout master
```

At this moment:

- `master` has **neither ui.html nor user-reg.html**

---

## 🔀 Merging Branches

### 8️⃣ Merge `UI` branch into master

```bash
git merge UI
```

✔ `ui.html` is now part of `master`

---

### 9️⃣ Merge `dbconn` branch into master

```bash
git merge dbconn
```

✔ `user-reg.html` is now part of `master`

---

## 📁 Final State of `master` Branch

Files present:

```
ui.html
user-reg.html
```

Both features successfully merged 🎉

---

## 🧩 Visual Understanding (Mental Model)

```
          UI ------ ui.html
         /
master ----
         \
          dbconn -- user-reg.html
```

After merging:

```
master --> ui.html + user-reg.html
```

---

## ❗ Important Notes (Exam Gold)

- Merging must be done **from the target branch**
- Always checkout `master` before merging
- Order of merge doesn’t matter if files don’t conflict
- Fast-forward merge happens when no divergence exists

---

## 🎤 Interview-Ready Answer

> “I create feature branches for independent work, commit changes there, and then merge them into the master branch. This allows parallel development without conflicts.”
