# **1. AJAX Demo**

📄 File: *AJAXdemo14.html* 

### **What is used?**

### ✔ `$.ajax()`

Used to send an HTTP request to an API.

Reason:
You want to fetch data from `"https://jsonplaceholder.typicode.com/posts"` (dummy API).

### ✔ `success:` callback

Executes only when the API request succeeds.

Reason:
To display the fetched data inside your UI (dropdown + div).

### ✔ `displaydropdown(arr)`

Creates a `<select>` with IDs of posts.

Reason:
So the user can choose one post and fetch details.

### ✔ `displayData(result)`

Prints selected post's id, userId, title, body.

Reason:
To show result in HTML instead of console.

### ✔ `.change()` event

Runs when dropdown value changes.

Reason:
To automatically fetch post by ID when user selects something.

### ✔ `#getdata.click()`

Loads ALL posts first, then fills dropdown.

---

# **2. Animate Demo**

📄 File: *animatedemo13.html* 

### **What is used?**

### ✔ `.animate({width, height}, duration, callback)`

Reason:
To create smooth UI animation by changing CSS gradually.

You animate:

```js
$('#mydiv').animate({"width":"200px", height:"200px"},2000)
```

This expands the div from current size → 200px in 2 seconds.

### ✔ Callback

The third argument:

```js
function(){ console.log("animation done") }
```

Reason:
Executes only AFTER animation finishes.

---

# **3. Event Handling Demo**

📄 File: *eventhandlingdemo8.html* 

### **What is used?**

### ✔ `.one("click", fn)`

Runs **only once**.

Reason:
Good for one-time alerts, one-time setup, etc.

---

### ✔ `.on("click", fn)`

The modern event binding method.

Reason:
Supports dynamic elements (future elements added in DOM).

---

### ✔ `.off("click")`

Removes event handler.

Reason:
To STOP creating new textboxes when button is pressed.

---

### ✔ `.clone()`

Creates duplicate of the original textbox.

Reason:
To dynamically add new input fields.

---

### ✔ `.delegate(selector, event, fn)`

Old but powerful method for event delegation.

Used as:

```js
$('body').delegate('input[id^=nm]', "focus", ...)
```

Reason:
Even dynamically created inputs:

```
id = nm1, nm2, nm3...
```

Will still receive focus & blur events.

---

# **4. Fade In / Fade Out Demo**

📄 File: *fadeinfadeoutdemo12.html* 

### **What is used?**

### ✔ `.fadeIn()`

Makes element gradually visible.

### ✔ `.fadeOut()`

Gradually hides element.

### ✔ `.fadeToggle()`

If hidden → fadeIn
If visible → fadeOut

### ✔ `.fadeTo(duration, opacity)`

Change transparency without hiding.

Example:

```js
$('#mydiv1').fadeTo(2000,0.3)
```

Reason:
Smooth transitions for UI animations.

---

# **5. Hover Demo**

📄 File: *hoverdemo9.html* 

### **What is used?**

### ✔ `.hover(fn1, fn2)`

Two functions:

* `fn1` → mouse enters
* `fn2` → mouse leaves

Reason:
To change colors and show hidden div on hover.

---

### ✔ `.addClass()` / `.removeClass()`

Used to switch between two CSS styles:

```css
.myclass
.myc
```

Reason:
To change UI design dynamically when hovered.

---

### ✔ `.toggleClass()` (commented version)

Would automatically switch classes each hover.

---

### ✔ `.clsshow` / `.clshidden`

display:block, display:none classes.

Reason:
Simple show/hide using CSS.

---

# **6. Show / Hide Demo**

📄 File: *showhidedemo.html* 

### **What is used?**

### ✔ `.show()`

Instant or animated display.

### ✔ `.hide()`

Hides element.

### ✔ `.toggle()`

Switch between show + hide.

Used with animation duration:

```js
$('#mydiv1').show(2000)
```

Reason:
Basic visibility control animations.

---

# **7. Slide Up / Slide Down Demo**

📄 File: *slideupslidedowndemo10.html* 

### **What is used?**

### ✔ `.slideUp()`

Collapses element upward.

### ✔ `.slideDown()`

Expands downward.

### ✔ `.slideToggle()`

If hidden → slideDown
If visible → slideUp

Reason:
Used for accordion menus, FAQ sections, etc.

---

# **8. Student Information Demo (Form + Dynamic + Validation)**

📄 File: *studentinformationdemo9.html* 

### **What is used?**

### ✔ `validatetextbox()`

Checks:

* Not empty
* Not spaces

Reason:
Basic input validation.

---

### ✔ `.is(":checked")`

To detect if checkbox is selected.

Reason:
If “Show Details” checkbox is ticked → show form section.

---

### ✔ `.addClass("clsshow")` / `.removeClass("clshidden")`

Used for show/hide.

Reason:
Switch between display:none and display:block.

---

### ✔ `.clone()`

Clone subject textbox.

Reason:
Allow adding multiple subject inputs.

---

### ✔ `.off("click")`

Stops adding new textboxes once “Show Info” is clicked.

---

### ✔ Collecting radio & text data

Using:

```js
$("input[name=course]:checked").val()
```

and

```js
$("input[name=subject]").each(...)
```

Reason:
Display complete student information summary.

---

# ✅ FINAL SUPER-QUICK REVISION SUMMARY (what & why)

| Feature                                   | Why Used                          | Where                |
| ----------------------------------------- | --------------------------------- | -------------------- |
| `$.ajax()`                                | Fetch API data                    | AJAX demo            |
| `.animate()`                              | Smooth CSS transitions            | Animate demo         |
| `.one()`                                  | Event runs once only              | Event demo           |
| `.on()`                                   | Attach event to dynamic elements  | Event demo           |
| `.off()`                                  | Remove event                      | Event + Student demo |
| `.delegate()`                             | Handle events of dynamic elements | Event demo           |
| `.fadeIn / fadeOut / fadeToggle / fadeTo` | Fade animation                    | Fade demo            |
| `.hover()`                                | Mouseover/mouseout logic          | Hover demo           |
| `.show / hide / toggle`                   | Simple visibility                 | Show/Hide demo       |
| `.slideUp/slideDown/slideToggle`          | Accordion-style animation         | Slide demo           |
| `.clone()`                                | Duplicate inputs dynamically      | Event + Student demo |
| `.addClass/removeClass/toggleClass`       | Change styles dynamically         | Hover + Student demo |
| `.is(":checked")`                         | Check checkbox status             | Student info demo    |
| `.each()`                                 | Loop jQuery elements              | Many places          |
| `.val()`                                  | Get/set input fields              | All form demos       |
