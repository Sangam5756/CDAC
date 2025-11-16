# ⭐ 1. Three Types of CSS

## **1) Inline CSS**

Useful for applying style to **one specific tag only**.

```html
<p style="background-color: yellow;">This is p</p>
```

### **When to use**

* Quick testing
* Overriding something urgently
* Email templates (because many clients allow only inline CSS)

---

## **2) Internal / Embedded CSS**

CSS inside `<style>` inside **one HTML file**.

```html
<head>
<style>
   p {
      background-color: yellow;
   }
</style>
</head>
```

### **When to use**

* Styling only one particular page
* Small projects
* Situations where you don’t want an extra CSS file

---

## **3) External CSS**

Separate `.css` file linked in multiple HTML files.

`mycss.css`

```css
p {
   background-color: yellow;
}
```

HTML:

```html
<link rel="stylesheet" href="./mycss.css">
```

### **When to use**

* Real projects
* Multiple pages sharing same theme
* Clean separation of structure (HTML) and design (CSS)

---

# ⭐ 2. CSS Rule Structure

```css
selector {
   property: value;
   property: value;
}
```

Selector chooses *what* to style.
Properties define *how* to style.

---

# ⭐ 3. CSS Selectors (Very Important for Exams)

Selectors are how CSS finds elements.

### 🎯 **Universal Selector**

```css
* { margin: 0; padding: 0; }
```

Applies to **everything**.

---

### 🎯 **ID Selector**

```css
#myid { color: red; }
```

Use when styling **one unique element**.

---

### 🎯 **Class Selector**

```css
.myclass { font-size: 20px; }
```

Use for **multiple occurrences of same style**.

---

### 🎯 **Tag Selector**

```css
p { color: blue; }
div { border: 1px solid red; }
```

---

### 🎯 **Descendant (Ancestor → Any level child)**

```css
div p { color: green; }
```

Affects **p inside div at ANY level**.

---

### 🎯 **Child Selector (Parent → Direct Child)**

```css
div > p { color: purple; }
```

Only affects **direct children**.

---

### 🎯 **General Sibling Selector**

```css
div ~ p { color: orange; }
```

All `<p>` after the `<div>` on same level.

---

### 🎯 **Adjacent Sibling Selector**

```css
div + p { color: brown; }
```

Only **first** `<p>` coming right after `<div>`.

---

### 🎯 **Attribute Selector**

```css
input[type=text] { border: 2px solid blue; }
p[name] { color: red; }
```

---

# ⭐ 4. Pseudo Classes (Based on *state*)

### **Link states**

```css
a:link { color: blue; }       /* Not visited */
a:visited { color: purple; }  /* Already clicked */
a:active { color: red; }      /* While being clicked */
```

### **Hover**

```css
p:hover { background: yellow; }
```

### **Focus**

```css
input:focus { outline: 2px solid green; }
```

### **Nth-child**

```css
p:first-child { }
p:last-child { }
p:nth-child(3) { }
```

---

# ⭐ 5. Pseudo Elements (Part of an element)

```css
p::first-letter { font-size: 50px; }
p::first-line { font-weight: bold; }
```

---

# ⭐ 6. Common CSS Properties (You MUST know these)

### **Background**

```css
background-color: cyan;
```

### **Border**

```css
border: 2px solid red;
```

Short-hand for

* border-width
* border-style
* border-color

---

### **Shadow**

```css
box-shadow: 2px 3px 4px red;
text-shadow: 2px 2px 3px blue;
```

---

### **Spacing**

* `margin:` → space **outside** border
* `padding:` → space **inside** border

```css
margin: 20px;
padding: 20px;
```

---

### **Size**

```css
width: 200px;
height: 200px;
```

---

# ⭐ 7. Hiding elements

### **1. `visibility: hidden`**

Element is hidden but **space remains**.

### **2. `display: none`**

Element removed completely from layout (no space).

---

# ⭐ 8. Display Property

| Value          | Meaning                                        |
| -------------- | ---------------------------------------------- |
| `block`        | Occupies full width, starts on new line        |
| `inline`       | No newline, no margin/padding allowed properly |
| `inline-block` | Like inline + allows margin and padding        |

---

# ⭐ 9. Position Property

### ⭐ `position: static`

Default. Ignores `top`, `left`, `right`, `bottom`.

### ⭐ `position: relative`

Moves element **relative to its normal position**.

```css
div {
  position: relative;
  top: 10px;
}
```

### ⭐ `position: absolute`

Positioned **relative to nearest positioned ancestor**.

### ⭐ `position: fixed`

Sticks to screen even on scroll (like navbar).

### ⭐ `position: sticky`

Normal → becomes fixed **after scrolling threshold**.

---

# ⭐ 10. DOM + CSS (Quick Note)

CSS can target any HTML element that appears in DOM because browser parses HTML → creates DOM Tree → CSS applies rules to that tree.

