# **1. `$(document).ready(function(){ ... })`**

This is the first thing you wrote in most files.

Meaning:
Run the code **only after the whole HTML document is loaded by the browser**.

Why important:
If you try to access DOM elements before HTML loads, jQuery won’t find them.
This wrapper guarantees your script runs at the correct time.

Example:

```js
$(document).ready(function() {
    alert("testing jquery");
});
```

This fires the alert only after DOM is available.

---

# **2. jQuery Selectors**

jQuery selectors are like “smart binoculars” for picking HTML elements.

### **Tag Selector**

```js
$('p')
```

Selects all `<p>` tags.

### **ID Selector**

```js
$('#myp')
```

Selects element with ID `myp`.

### **Class Selector**

```js
$('.myclass')
```

### **Group Selector**

```js
$('p, h1, h2')
```

Selects multiple tags at once.

### **Attribute Starts-With Selector**

```js
$('p[class^=my]')
```

Selects `<p>` elements whose class STARTS with “my”.
Example: `myclass`, `myc`, `myparagraph`.

### **First Child Selector**

```js
$('p:first-child')
```

Selects the first `<p>` inside a parent container.

Why all this matters:
Selectors are the core of jQuery — almost everything begins with selecting something.

---

# **3. `.css()` – Apply Styles Dynamically**

```js
$('p').css("background-color", "yellow");
```

Multiple styles:

```js
$('p').css({
    "background-color": "yellow",
    "color": "red"
});
```

Why important:
This is faster and cleaner than manually changing CSS in JavaScript.

---

# **4. `val()` – Read/Write Input Values**

Used heavily in your form validations.

Example:

```js
var v = $('#num1').val();
```

Set value:

```js
$('#result').val(ans);
```

Why important:
`val()` is shorthand for `input.value` and works for textboxes, dropdowns, radio buttons, etc.

---

# **5. `html()` – Set HTML Content**

```js
$('#mydiv').html("addition : " + ans);
```

Why important:
It replaces inner HTML of an element.
Faster and cleaner than `innerHTML`.

---

# **6. Form Validations**

You wrote multiple validation utilities.

### **Check empty / spaces / numeric**

```js
if(num != "" && num.trim().length > 0 && isFinite(num))
```

Meaning:

* `num != ""` → not empty
* `num.trim().length > 0` → not just spaces
* `isFinite(num)` → must be a number

### **Check only alphabets**

```js
if(v != "" && v.trim().length > 0 && isNaN(v))
```

Why important:
Validating input before submission prevents errors and avoids page reload.

---

# **7. `event.preventDefault()`**

Used in registration form:

```js
$('#regfrm').submit(function(event){
    event.preventDefault();
    var flag = validateData();
    return flag;
});
```

Meaning:
Stop default behavior of a form (which reloads the page).

Why important:
This is the backbone of AJAX-driven modern forms.
Lets you validate before sending.

---

# **8. `each()` – Loop Through Elements**

```js
$('p, h1').each(function(index){
    alert(index + " : " + $(this).html());
});
```

Key point:
Inside `each()`, use **function()**, NOT arrow function:

✔ `function(){}` keeps `this`
❌ `()=>{}` breaks `this` binding

Why important:
Lets you loop through all selected elements just like a map/forEach in JavaScript.

---

# **9. `append()` – Add Elements at the End**

```js
$('body').append("<p>This is append paragraph</p>");
```

### **What happens internally?**

jQuery creates a new DOM element and inserts it **after all existing children**.

---

# **10. `prepend()` – Add Elements at the Beginning**

```js
$('body').prepend("<p>This is prepend paragraph</p>");
```

Inserts before all other children.

---

# **11. `remove()` – Delete Elements**

```js
$('p').remove('.p1');
```

Meaning:
Remove only `<p>` tags that satisfy selector `.p1`.

Why important:
Manipulating DOM without refreshing is key to dynamic UIs.

---

# **12. `wrap()` – Wrap Each Element in a Container**

```js
$('p').wrap("<div class='myclass'></div>");
```

Result:

```
<div class="myclass">
   <p>...</p>
</div>

<div class="myclass">
   <p>...</p>
</div>
```

Each `<p>` gets its own wrapper.

---

# **13. `wrapAll()` – Wrap ALL Elements Together**

```js
$('p').wrapAll("<div class='myclass'></div>");
```

Result:

```
<div class="myclass">
   <p>...</p>
   <p>...</p>
   <p>...</p>
</div>
```

All elements share ONE wrapper.

---

# **14. Checkbox Validation**

```js
$('input[name=skill]:checked').each(function(){
    cnt++;
    str += $(this).val();
});
```

Meaning:

* Select only checked checkboxes
* Loop through each
* Count how many are selected

This is a standard jQuery pattern used everywhere.

---

# **15. Radio Button Validation**

```js
var v = $('input[name=gender]:checked').val();
```

If no radio selected, `v` becomes **undefined**.

---

# **16. Dropdown Validation**

```js
if($('#city').val() == 'test')
```

Means user has not selected a real city yet.

---

# **17. File Size Validation**

```js
var size = $('#profile')[0].files[0].size / 1024;
```

Key ideas:

* `$('#id')[0]` → access raw DOM element
* `.files` → list of files
* `.size` → file size in bytes

File size > 10 KB → invalid.

---

# **18. Hidden Fields**

```html
<input type="hidden" id="type" value="student"/>
```

Used to silently send extra form data.

