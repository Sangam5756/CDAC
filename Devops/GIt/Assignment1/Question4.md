Q.4. Go to GitHub. Create a repository. Create a file by name test.c in it. Commit changes. Now on your computer create a directory by name remote. Go to the directory. Clone the GitHub repository. Now go the new directory created after clone. Create a new file by name demo.c. git add and commit. Then git push . Now go to the GitHub and check if the demo.c file is shown.


Here’s a **clean, revision-friendly README note** for **Q.4 (GitHub remote workflow)**. This is written so you can **revise in 2–3 minutes** and still explain it confidently in lab / viva.

---

# 📘 Git Remote Repository Workflow – Revision Notes (Q.4)

## 🎯 Objective

Understand how to:

* Create a repository on GitHub
* Clone a remote repository to local machine
* Make local commits
* Push changes back to GitHub

---

## 🧠 Core Git Idea (Very Important)

> **Local Git handles versions.
> Remote Git (GitHub) handles sharing.**

Push = send commits from local → remote
Clone = copy remote → local

---

## 🌐 Step 1: Create Repository on GitHub

On GitHub:

1. Click **New Repository**
2. Repository name: (example) `test-repo`
3. Create a file **test.c**
4. Add content:

   ```
   // test file
   ```
5. Commit the file on GitHub

📌 GitHub now has:

```
test.c
```

---

## 💻 Step 2: Create Local Directory & Clone Repo

```bash
mkdir remote
cd remote
git clone <github-repo-url>
```

Example:

```bash
git clone https://github.com/username/test-repo.git
```

📌 After clone, a new directory is created:

```
remote/
 └── test-repo/
     └── test.c
```

---

## 📂 Step 3: Go Inside Cloned Repository

```bash
cd test-repo
```

Check:

```bash
git status
```

✔ Working tree clean
✔ Remote `origin` already configured automatically

---

## 📝 Step 4: Create New File Locally

```bash
echo "// demo file" > demo.c
```

---

## 💾 Step 5: Add and Commit Locally

```bash
git add demo.c
git commit -m "Added demo.c file"
```

📌 This commit exists **only on your computer**, not on GitHub yet.

---

## 🚀 Step 6: Push Changes to GitHub

```bash
git push origin master
```

OR (modern default branch):

```bash
git push origin main
```

✔ Commits are sent to GitHub
✔ Authentication may be required (token/password)

---

## 🌐 Step 7: Verify on GitHub

Go to the GitHub repository page.

You should now see:

```
test.c
demo.c
```

🎉 Remote and local repositories are in sync.

---

## 🔁 Complete Flow (Mental Model)

```
GitHub (remote)
      ↓ clone
Local repo
      ↓ add + commit
Local commits
      ↓ push
GitHub updated
```

---

## ❗ Common Mistakes to Avoid

❌ `git push` without commit
❌ Working outside cloned directory
❌ Forgetting branch name (`main` vs `master`)
❌ Editing files directly on GitHub and expecting local auto-update

---

## 🧩 Key Commands Summary

| Command      | Purpose                   |
| ------------ | ------------------------- |
| `git clone`  | Copy remote repo to local |
| `git add`    | Stage changes             |
| `git commit` | Save snapshot locally     |
| `git push`   | Upload commits to GitHub  |
| `git status` | Check repo state          |

---

## 🎤 Interview-Ready Answer

> “I clone the GitHub repository, make changes locally, commit them, and push the commits to the remote repository so they appear on GitHub.”

---

## 🧠 One-Line Memory Trick

> **Clone → Commit → Push = GitHub update**