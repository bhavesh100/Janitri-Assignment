# 📌 Pregnancy Vitals Tracker

Objective: A Jetpack Compose app that allows users to log and track pregnancy-related vitals with reminders.

## 📂 Features & Requirements

# ✅ Main Screen  
- Displays a list of vitals logs using LazyColumn.  
- Updates automatically when new vitals are added.  

# 📝 Add Vitals Dialog  
- A floating button opens a Jetpack Compose Dialog.  
- The form includes fields for:  
  - Blood Pressure (Sys/Dia)  
  - Heart Rate  
  - Weight  
  - Baby Kicks Count  
- Validation: Prevents empty inputs & accepts only numbers.  
- Saves data in Room Database and auto-updates the list.  

# 🔔 Reminder System (WorkManager)  
- Notification every 5 hours reminding users to log vitals.  
- Clicking the notification opens the logging screen.  
- Notification Details:  
  - Title: "Time to log your vitals!"  
  - Message: "Stay on top of your health. Please update your vitals now!"  

# 🛠 Tech Stack  
- Language: Kotlin  
- UI: Jetpack Compose  
- Architecture: MVVM  
- Database: Room  
- State Management: StateFlow / LiveData  
- Background Work: WorkManager
  
# 📥 APK Download  
🔗 [Download APK](https://1drv.ms/f/s!Arg_CwR6LDe8gV50vI_2DtzM5F42?e=77YMkH)  

## 📦 Setup & Usage  

## 1️⃣ Clone the Repository  
```bash
git clone https://github.com/bhavesh100/Janitri-Assignment
cd PregnancyVitalsTracker
```
## 2️⃣ Open in Android Studio
- Ensure you have Kotlin & Jetpack Compose set up.

## 3️⃣ Build & Run
-Click Run ▶️ in Android Studio.

## 📜 License
-This project is part of an Android Internship Assignment.
