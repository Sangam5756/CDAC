Q.5. Go to the GitHub. Create a new blank repository by dac-proj name.
Create a directory by name demo1 on your Windows machine. Initialize it as a git repository. Create a file by name index.html in it. Git add and git commit. Create a new file by name product.html. git add and git commit. Check with git log and git status. Now link this local repository to the GitHub repository using remote add origin command. Then git push. Go to GitHub repository and check if the local files are shown.


# 📘 Git Local → Remote Linking (Blank GitHub Repo) – Revision Notes (Q.5)

## 🎯 Objective

Learn how to:

* Create a **blank repository** on GitHub
* Create a **local Git repository**
* Commit multiple files locally
* Link local repo to GitHub using `remote add origin`
* Push local commits to GitHub

---

## 🧠 Core Git Idea (Very Important)

> **A blank GitHub repository has no history.
> Local repository has commits.
> Link them, then push history upward.**

---

## 🌐 Step 1: Create Blank Repository on GitHub

On GitHub:

1. Click **New Repository**
2. Repository name: `dac-proj`
3. ❌ Do **NOT** add README / .gitignore
4. Click **Create Repository**

📌 Repository is **empty (no commits)**

---

## 💻 Step 2: Create Local Directory and Initialize Git

```bash
mkdir demo1
cd demo1
git init
```

✔ Creates an empty local Git repository
✔ Default branch: `master` or `main`

---

## 📝 Step 3: Create `index.html` and Commit

```bash
echo "<h1>Home Page</h1>" > index.html
git add index.html
git commit -m "Added index.html"
```

📌 First snapshot created

---

## 📝 Step 4: Create `product.html` and Commit

```bash
echo "<h1>Product Page</h1>" > product.html
git add product.html
git commit -m "Added product.html"
```

📌 Second snapshot created

---

## 🔍 Step 5: Check Git Status and History

```bash
git status
```

✔ Working tree clean

```bash
git log --oneline
```

Example:

```
b82e9f3 Added product.html
a91c7d2 Added index.html
```

📌 Local repo has **2 commits**

---

## 🔗 Step 6: Link Local Repo to GitHub (Remote Add)

```bash
git remote add origin https://github.com/username/dac-proj.git
```

Check:

```bash
git remote -v
```

✔ Confirms remote connection

---

## 🚀 Step 7: Push Local Commits to GitHub

If branch is `master`:

```bash
git push origin master
```

If branch is `main`:

```bash
git push origin main
```

✔ Local commits uploaded to GitHub
✔ Authentication required (token)

---

## 🌐 Step 8: Verify on GitHub

Refresh GitHub repository page.

You should see:

```
index.html
product.html
```


🎉 Local → Remote sync successful.

---

## 🔁 Complete Flow (Mental Model)

```
Local commits
     ↓
Remote added (origin)
     ↓
git push
     ↓
GitHub updated
```

---

## ❗ Common Mistakes (Exam Traps)

❌ Adding remote before commits (allowed but confusing)
❌ Forgetting branch name during push
❌ Creating README on GitHub for this question
❌ Using wrong repository URL

---

## 🧩 Command Summary Table

| Command                 | Purpose               |
| ----------------------- | --------------------- |
| `git init`              | Initialize local repo |
| `git add`               | Stage files           |
| `git commit`            | Save snapshot         |
| `git log`               | View commit history   |
| `git remote add origin` | Link GitHub repo      |
| `git push`              | Upload commits        |

---

## 🎤 Interview-Ready Answer

> “I created a local Git repository, committed files, linked it to a blank GitHub repository using `git remote add origin`, and pushed the commits so the files appeared on GitHub.”

---

## 🧠 One-Line Memory Trick

> **Init → Commit → Remote Add → Push**