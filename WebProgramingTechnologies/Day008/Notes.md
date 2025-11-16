# **1. What is jQuery?**

jQuery is a **JavaScript library** that makes DOM manipulation, event handling, animations, and form handling easier with **less code**.

### Why invented?

Because raw JavaScript (before ES6) was verbose and inconsistent across browsers.

---

# **2. Meaning of `$` and `jQuery`**

In jQuery:

```js
$ == jQuery
```

Both are same.

If another library also uses `$` (like Prototype, PHP), you can switch to:

```js
jQuery(document).ready(...)
```

📌 **Memory trick:**
`$` is just a shortcut nickname for jQuery.

---

# **3. Why Use `$(document).ready()`?**

jQuery code must run **after the DOM is fully loaded**, otherwise selectors won’t find elements.

```js
$(document).ready(function(){
    // safe to access HTML
});
```

Arrow function version:

```js
$(document).ready(()=>{});
```

📌 **Revision line:**
“Ready = DOM is fully loaded.”

---

# **4. Adding jQuery Library**

### **A. Local file**

```html
<script src="./jquery.js"></script>
```

### **B. CDN**

```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
```

**CDN Pros:**
✔ no download
✔ always latest
✔ fast
**Con:** needs internet

---

# **5. Test jQuery**

```js
$(document).ready(()=>{
    alert("hello");
});
```

If alert works → jQuery loaded.

---

# **6. jQuery Selectors (Most Important)**

### **Basic**

```js
$('p')           // tag
$('#id')         // id
$('.class')      // class
$('p,h1,div')    // group
```

### **Attribute Selectors**

```js
div[name]          → div with name attribute
div[name=mydiv]    → name="mydiv"
div[name^=my]      → starts with my
div[name$=my]      → ends with my
div[name*=my]      → contains my
```

### **Child Selectors**

```js
div p:first-child
div p:last-child
div p:nth-child(3)
div p:odd           // 1,3,5
div p:even          // 0,2,4
```

### **Content Selector**

```js
div:contains('KLFS')
```

📌 **Revision tip:**
"CSS selectors + some bonus magic."

---

# **7. Why jQuery Is Popular**

1. Less code
2. Works same in all browsers
3. UI plugins
4. Easy animations
5. Easy selectors

---

# **8. Most Important jQuery Functions**

---

## **8.1 `.css()`**

### Set one CSS property:

```js
$('p').css("color","red");
```

### Set multiple properties:

```js
$('p').css({
  color: "red",
  "background-color": "yellow"
});
```

📌 **Revision:** `.css()` = style() shortcut.

---

## **8.2 `.val()` — For Input Values**

Get:

```js
var x = $('#name').val();
```

Set:

```js
$('#name').val("Sangam");
```

---

## **8.3 `.html()` — Inner HTML**

Get:

```js
var x = $('#box').html();
```

Set:

```js
$('#box').html("<b>Updated</b>");
```

📌 Used for: printing messages, results, replaced data.

---

## **8.4 `.each()` — Loop**

```js
$('p').each(function(index){
    console.log(index, $(this).html());
});
```

📌 Must use `function(){}` because arrow function breaks `this`.

---

## **8.5 `.append()` & `.prepend()`**

Add at **bottom**:

```js
$('body').append("<p>New</p>");
```

Add at **top**:

```js
$('body').prepend("<p>New</p>");
```

---

## **8.6 `.remove()`**

```js
$('p').remove();       // remove all
$('p').remove('.x');   // remove only class="x"
```

---

## **8.7 `.wrap()` & `.wrapAll()`**

Wrap EACH element:

```js
$('p').wrap("<div class='box'></div>");
```

Wrap ALL into ONE wrapper:

```js
$('p').wrapAll("<div class='outer'></div>");
```

📌 **Memory:** wrap = parent tag added around elements.

---

## **8.8 Event: `.hover()`**

Two functions:

```js
$('#box').hover(
  function(){ console.log("mouseover"); }, 
  function(){ console.log("mouseout"); }
);
```

One function:

```js
$('#box').hover(()=>{ console.log("runs twice"); });
```

---

## **8.9 Classes**

Add class:

```js
$('p').addClass("x");
```

Remove:

```js
$('p').removeClass("x");
```

Toggle:

```js
$('p').toggleClass("x");
```

Check:

```js
$('p').hasClass("x");
```

---

## **8.10 Attributes (`attr()`)**

One attribute:

```js
$('img').attr('src','logo.png');
```

Multiple:

```js
$('a').attr({
  href: "https://google.com",
  target: "_blank"
});
```

---

# **9. Form Validation Patterns**

### **Textbox (not empty + not spaces + not number)**

```js
if(v!="" && v.trim().length>0 && isNaN(v)){
    valid
}
```

### **Number validation**

```js
if(v!="" && v.trim().length>0 && isFinite(v)){
    valid
}
```

### **Radio button**

```js
var v = $('input[name=gender]:checked').val();
return v !== undefined;
```

### **Checkboxes**

```js
var cnt = 0;
$('input[name=skill]:checked').each(()=> cnt++);
return cnt >= 2;
```

### **Dropdown**

```js
var v = $('#city option:selected').val();
return v !== "test";
```

### **File size validation**

```js
var size = $('#profile')[0].files[0].size / 1024;
if(size <= 10){ valid }
```

---

# **10. jQuery vs JavaScript QUICK REVISION**

### Selecting:

JS:

```js
document.getElementById("id")
```

jQuery:

```js
$('#id')
```

### Looping:

JS:

```js
for(x of arr){}
```

jQuery:

```js
$('p').each(...)
```

### Style:

JS:

```js
p.style.color = "red";
```

jQuery:

```js
$('p').css("color","red");
```

### Checkbox:

JS:

```js
for(p of arr){ if(p.checked){} }
```

jQuery:

```js
$('input[name=x]:checked')
```

---

# **11. ONE-PAGE ULTRA SHORT REVISION (Memorize This)**

* `$ = jQuery`
* `ready()` → DOM loaded
* CSS: `.css()`
* HTML: `.html()`
* Value: `.val()`
* Loop: `.each()`
* Add: `.append() / .prepend()`
* Remove: `.remove()`
* Wrap: `.wrap() / .wrapAll()`
* Class: `.addClass() / removeClass() / toggleClass()`
* Events: `.hover(), click(), change(), submit()`
* Form validation → use selectors + `.val()`
* Checkbox: `$('input[name=x]:checked')`
* Dropdown: `$('#city option:selected').val()`
* File: `$('#file')[0].files[0]`
