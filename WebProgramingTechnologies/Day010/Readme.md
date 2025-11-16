
## 🎯 **1. `fs.createWriteStream()` — Write Large or Continuous Data Efficiently**

### **Why do we need write streams?**

When writing **large files**, you never want to load the entire data in memory. A write stream writes data **piece by piece**, efficiently.

### **Syntax**

```js
const fs = require("fs");
const ws = fs.createWriteStream("output.txt", "utf8");
```

### **Usage**

```js
ws.write("Hello World\n");
ws.write("Writing again...\n");
ws.end("Final line.");
```

### **When to use?**

* Writing logs continuously
* Writing large files
* Writing data coming from network requests
* Creating pipelines (source → destination)

---

## 🎯 **2. `source.pipe(destination)` — Automatically Sync Read + Write Streams**

### **Why use `pipe()`?**

Because manually handling `data`, `end`, `error` events is boring.
`pipe()` automatically:

* Reads data in chunks
* Writes data in correct order
* Handles stream speed difference
* Prevents memory overflow

### **Example: Copy one file to another**

```js
const fs = require("fs");
fs.createReadStream("input.txt").pipe(fs.createWriteStream("copy.txt"));
```

### **When to use?**

* File copy
* Streaming audio/video
* Sending file to client in an HTTP response

---

## 🎯 **3. `fs.exists(filename, callback)` — Check if File Exists**

### ⚠️ *Note*: `fs.exists` is deprecated (but still used in teaching).

Better use `fs.access`.

### **Example**

```js
fs.exists("mydata.txt", (flag) => {
  console.log(flag ? "File exists" : "File not found");
});
```

### **When to use?**

* Before reading a file
* Before overwriting a file
* Before deleting a file

---

## 🎯 **4. `fs.stat(filename, callback)` — Get File Information**

### **What info does it give you?**

* File size
* Last modified time
* File type (file/directory)
* Permissions

### **Example**

```js
fs.stat("test.txt", (err, info) => {
  console.log("Size:", info.size);
  console.log("Modified:", info.mtime);
});
```

### **When to use?**

* Show file properties
* Validate file before upload
* Check if user sent a directory instead of file

---

## 🎯 **5. `fs.open()` and `fs.close()` — Low-Level File Handling**

### **Why use them?**

These give **file descriptors** (numeric handles used by OS).
Not common in normal JS but used when building low-level tools.

### **Example**

```js
fs.open("abc.txt", "r", (err, fd) => {
  console.log("File descriptor:", fd);
  fs.close(fd, () => console.log("Closed"));
});
```

### **When to use?**

* When building your own file reading/writing logic
* When modifying specific bytes in a file

---

## 🎯 **6. `readline` — Read a File Line-By-Line (Best for Logs)**

### **Why?**

Reading entire file at once wastes memory.
`readline` reads **one line at a time** — ideal for:

* Large logs
* CSV processing
* Counting lines

### **Example**

```js
const readline = require("readline");
const fs = require("fs");

let count = 0;
const rl = readline.createInterface({
  input: fs.createReadStream("test.txt")
});

rl.on("line", (line) => {
  count++;
  console.log(count + ": " + line);
});

rl.on("close", () => {
  console.log("Total lines:", count);
});
```

### **When to use?**

* Reading big log files
* Searching specific lines
* Streaming data line by line

---

# ⭐ **7. `http` Module — Core of Node Web Servers**

## **Why use `http` module?**

This is Node’s built-in web server capability.

### **Very simple server**

```js
const http = require("http");

http.createServer((req, res) => {
  res.write("Welcome to NodeJS");
  res.end();
}).listen(5000);
```

### **Key points**

* Asynchronous
* Handles unlimited requests (event-loop based)
* No external dependency

### **When to use?**

* Building custom backend
* Handling APIs
* Sending HTML, JSON, files

For larger apps, we use **Express** (same concepts, less code).

---

# ⭐ **8. `package.json` — Project Metadata + Dependency Manager**

## **Why is it important?**

* Stores **project name**, **version**, **scripts**, **dependencies**
* Ensures **same versions** installed on every machine
* Used in every Node project

### **Create it**

```
npm init
```

### **Sample**

```json
{
  "name": "myapp",
  "version": "1.0.0",
  "type": "commonjs",
  "main": "index.js",
  "dependencies": {
    "express": "^4.18.2"
  }
}
```

### **When to use?**

* Every Node.js project
* When deploying
* When sharing with classmates/team

---

# ⭐ FINAL QUICK REVISION TABLE

| Concept               | Why Needed           | When Used            | Example         |
| --------------------- | -------------------- | -------------------- | --------------- |
| `createWriteStream()` | Efficient writing    | Logs, large files    | Writing streams |
| `pipe()`              | Auto sync read→write | File copy, streaming | `rs.pipe(ws)`   |
| `exists()`            | Check file presence  | Before read/delete   | `fs.exists()`   |
| `stat()`              | Get file properties  | Show size/date       | `fs.stat()`     |
| `open/close`          | Low-level file ops   | Byte-level ops       | `fs.open()`     |
| `readline`            | Read line-by-line    | Logs, CSV            | `rl.on("line")` |
| `http.createServer()` | Create server        | API, web apps        | Port 5000       |
| `package.json`        | Manage deps          | Any project          | `npm init`      |

