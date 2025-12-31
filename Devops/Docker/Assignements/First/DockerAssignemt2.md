
# Copying a File into Apache Docker Container

## Method 1: `docker cp`

## Method 2: Dockerfile + `COPY`

---

## Prerequisites

* Docker installed and running
* Working directory contains:

  * `index.html`
  * `Dockerfile` (for Method 2)

```bash
ls
index.html  dockerfile
```

---

# METHOD 1 — Using `docker cp` (Runtime Copy)

### Concept

Copy a file **into an already running container**.

---

## Step 1: Pull Apache Image

```bash
docker pull httpd
```

---

## Step 2: Run Apache Container

```bash
docker run --name web1 -d -p 8080:80 httpd
```

### What this does

* `--name web1` → container name
* `-d` → detached (background)
* `-p 8080:80` → map host port 8080 to container port 80
* `httpd` → Apache image

---

## Step 3: Verify Container Is Running

```bash
docker ps
```

Expected output:

```
CONTAINER ID   IMAGE   PORTS                  NAMES
xxxxxx         httpd   0.0.0.0:8080->80/tcp   web1
```

---

## Step 4: Copy File into Running Container

```bash
docker cp index.html web1:/usr/local/apache2/htdocs/index.html
```

### Important path

Apache document root inside container:

```
/usr/local/apache2/htdocs/
```

---

## Step 5: Access Website

Open browser:

```
http://localhost:8080
```

✔️ Your `index.html` is displayed.

---

## Step 6: Stop Container

```bash
docker stop web1
```

---

## Step 7: Remove Container (Optional)

```bash
docker rm web1
```

---

### Key Observation (Very Important)

* File exists **only in this container**
* If container is deleted → file is gone
* Image remains unchanged

---

# METHOD 2 — Using Dockerfile + `COPY` (Build-Time Copy)

### Concept

Bake the file **inside the image itself**.

---

## Step 1: Create Dockerfile

File name **must be exactly** `Dockerfile` (no extension).

```dockerfile
FROM httpd:latest
COPY index.html /usr/local/apache2/htdocs/
```

---

## Step 2: Verify Files

```bash
ls
```

Expected:

```
Dockerfile  index.html
```

---

## Step 3: Build Custom Image

```bash
docker build -t app .
```

### What this does

* `-t app` → image name
* `.` → current directory as build context

---

## Step 4: Verify Image Creation

```bash
docker images
```

Expected:

```
REPOSITORY   TAG      IMAGE ID       SIZE
app          latest   xxxxxx         175MB
httpd        latest   xxxxxx         175MB
```

---

## Step 5: Run Container from Custom Image

```bash
docker run --name web2 -d -p 8080:80 app
```

---

## Step 6: Verify Running Container

```bash
docker ps
```

Expected:

```
CONTAINER ID   IMAGE   PORTS                  NAMES
xxxxxx         app     0.0.0.0:8080->80/tcp   web2
```

---

## Step 7: Access Website

Open browser:

```
http://localhost:8080
```

✔️ `index.html` loads automatically.

---

## Step 8: Stop & Delete Container

```bash
docker stop web2
docker rm web2
```

---

## Step 9: Run Again (Proof of Permanence)

```bash
docker run -d -p 8080:80 app
```

✔️ Website still works — **without copying again**

---

## Visual Mental Model

![Image](https://www.docker.com/app/uploads/2024/08/2400x1260_diagram_understanding-the-differences-between-add-and-copy-instructions-in-dockerfiles.png)

![Image](https://miro.medium.com/0%2AHhURteVLNxudDuEt)

![Image](https://miro.medium.com/1%2AuuZ-h5EH76LOtJ614z-qDA.png)
