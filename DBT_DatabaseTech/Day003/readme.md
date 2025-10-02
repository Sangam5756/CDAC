lpad function used to add the spaces to the left if certain condition doesnt match
SELECT LPAD(ename, 15, ' '), job
FROM emp;

### 📌 Date & Time Formula Notes

**First / Last Day Formulas**

* First day of month **N months back** →
  `DATE_SUB(DATE_SUB(CURDATE(), INTERVAL N MONTH), INTERVAL DAY(CURDATE())-1 DAY)`
  *(step back N months → reset to day 1)*

* Last day of month **N months back** →
  `LAST_DAY(DATE_SUB(CURDATE(), INTERVAL N MONTH))`
  *(step back N months → jump to month end)*

* First day of current year →
  `MAKEDATE(YEAR(CURDATE()), 1)`
  *(construct Jan 1 from current year)*

* Last day of current year →
  `STR_TO_DATE(CONCAT(YEAR(CURDATE()), '-12-31'), '%Y-%m-%d')`
  *(build Dec 31 for the year)*

---

**Extraction Formulas**

* Year → `YEAR(date)`
* Month number → `MONTH(date)`
* Month name → `MONTHNAME(date)`
* Weekday name → `DATE_FORMAT(date, '%W')`
* Day number → `DAY(date)`

---

**Difference Formulas**

* Age / experience in years → `TIMESTAMPDIFF(YEAR, start_date, CURDATE())`
* Simple difference in years → `YEAR(CURDATE()) - YEAR(date)` (approx, not exact)

---

**Formatting Formulas (DATE_FORMAT codes)**

* `%W` → weekday (Thursday)
* `%M` → full month (September)
* `%b` → short month (Sep)
* `%d` → day of month (04)
* `%Y` → 4-digit year (2014)
* `%y` → 2-digit year (14)
* `%T` → 24hr time (00:00:00)
* `%r` → 12hr time with AM/PM (12:00 AM)

---

**Aggregation with Dates**

* Group employees by year joined → `GROUP BY YEAR(hiredate)`
* Group by dept + year → `GROUP BY deptno, YEAR(hiredate)`
* Filter groups → `HAVING COUNT(*) > N`

---

### 🧠 Mental Hooks

* **`DATE_SUB` / `DATE_ADD`** = your time machine.
* **`LAST_DAY` / `MAKEDATE`** = snap to edges (start or end).
* **`DATE_FORMAT`** = change date to human-readable string.
* **`YEAR()` / `MONTH()`** = pluck parts.
* **`TIMESTAMPDIFF`** = accurate age/experience.
* **`GROUP BY + HAVING`** = when you’re counting people across years/departments.

