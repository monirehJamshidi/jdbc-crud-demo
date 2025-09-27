# Java Record Demo


[🇬🇧 English](./README.md) 

این پروژه یک مثال ساده از مدیریت اطلاعات (CRUD) با استفاده از JDBC خالص است.
در اینجا هیچ ORM یا Hibernate استفاده نشده و همه‌ی عملیات‌ها به صورت SQL مستقیم نوشته شده‌اند.
---

##🔹 ساختار پروژه
- org.j2os.common.JDBC → مدیریت اتصال به دیتابیس (Connection Pool با Apache DBCP)

- org.j2os.entity.Person → کلاس موجودیت معادل جدول person

- org.j2os.repository.PersonDA → لایه دسترسی به داده (DAO) شامل کوئری‌های SQL

- org.j2os.service.PersonService → لایه سرویس (Business Logic)

- org.j2os.Main → نقطه شروع برنامه (برای تست CRUD)

---

## 📌 مثال🔹 قابلیت‌ها
- اضافه کردن شخص جدید

- بروزرسانی اطلاعات شخص

- حذف شخص بر اساس شناسه (ID)

- نمایش همه اشخاص

## ✨ توضیحات🔹 تکنولوژی‌ها
- جاوا 8 یا بالاتر

- دیتابیس Oracle XE

- کتابخانه Apache Commons DBCP2 برای Connection Pool



## نکته

این پروژه عمداً بدون Hibernate نوشته شده تا الگوی DAO با JDBC خالص را نشان دهد.
نسخه‌ی مشابه با Hibernate در پروژه‌ی hibernate-crud-demo قابل مقایسه خواهد بود.