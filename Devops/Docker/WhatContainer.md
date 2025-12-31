Perfect. Let’s compress everything into **clean, exam-ready + interview-ready notes**.
No fluff, just the mental models that actually matter.

---

## 🧠 Docker Container – Core Notes

---

### 1️⃣ What a Docker container really is

A **Docker container is NOT a virtual machine**.

A container is:

* A **Linux process**
* Running in **isolation**
* Using:

  * **Namespaces** → isolation (PID, Network, FS, User)
  * **cgroups** → resource limits (CPU, memory)

No separate OS kernel.
All containers share the **host kernel**.

---

### 2️⃣ Container lifecycle rule (MOST IMPORTANT)

> **A container lives as long as its main process (PID 1) is alive.**

* If PID 1 stops → container stops
* Terminal presence does **not** decide container life
* Process life decides container life

---

### 3️⃣ What happens with `docker run -it ubuntu`

```bash
docker run -it ubuntu
```

Docker:

* Creates container
* Starts `/bin/bash` as **PID 1**
* Attaches your terminal to it

Effect:

* Keyboard → container stdin
* Screen ← container stdout

When you type:

```bash
exit
```

* `/bin/bash` exits
* PID 1 dies
* Container stops

---

### 4️⃣ What detached mode (`-d`) actually means

```bash
docker run -dit ubuntu
```

Meaning:

* `-d` → run in background (no terminal attached)
* `-i` → keep stdin open
* `-t` → allocate pseudo-terminal

Reality:

* `/bin/bash` still runs as PID 1
* No keyboard, no screen
* Process runs independently

Detached ≠ stopped
Detached = **running without terminal**

---

### 5️⃣ Why containers sometimes exit immediately

Example:

```bash
docker run -d ubuntu
```

What happens:

* `/bin/bash` starts
* No stdin
* Nothing to do
* Bash exits
* Container stops immediately

👉 A container **must have a long-running main process**.

---

### 6️⃣ `docker attach` – dangerous but educational

```bash
docker attach ub1
```

Attach means:

* Reconnect to **main process (PID 1)**
* Share original stdin/stdout

If you type:

```bash
exit
```

You kill:

* the main process
* the container

**Attach is fragile**.

---

### 7️⃣ `docker exec` – the correct way

```bash
docker exec -it ub1 bash
```

What happens:

* Docker starts a **new process**
* This process runs **inside the container**
* PID 1 remains untouched

When you exit:

* Child process ends
* Container keeps running

**Professionals use `exec`, not `attach`.**

---

### 8️⃣ Container filesystem persistence

* Files inside container persist:

  * across `stop` and `start`
* Files are lost when:

  * container is **deleted**

```bash
docker rm ub1
```

Deletes:

* container metadata
* writable filesystem layer

---

### 9️⃣ Important commands summary

| Command         | Meaning                          |
| --------------- | -------------------------------- |
| `docker run`    | Create + start container         |
| `docker start`  | Start existing container         |
| `docker stop`   | Graceful stop                    |
| `docker rm`     | Delete container                 |
| `docker attach` | Attach to main process           |
| `docker exec`   | Run new process inside container |
| `docker ps`     | Running containers               |
| `docker ps -a`  | All containers                   |

---

### 🔑 One-line golden rule (memorize)

> **Container lifecycle = PID 1 lifecycle. Terminals are optional.**

---

### 10️⃣ Interview-level explanation (ready to speak)

> Docker containers are isolated Linux processes. The container runs as long as its main process runs. Detached mode simply runs the process without attaching a terminal. `docker attach` connects to the main process, so exiting stops the container, while `docker exec` creates a new process, so exiting does not affect the container lifecycle.

